package br.com.retropatio.dao;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Logs;
import br.com.retropatio.model.Usuario;

public class LoggerDao extends Querys{

	private static final long serialVersionUID = 1L;
	private final EntityManager em;
	@Inject private FailureDao failure;
	Logs log = null;
	public LoggerDao() {
		this(null);
	}
	@Inject
	public LoggerDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void gravarLog(Logs logs, EntityManager em){
		try {
			em.persist(logs);
			em.getTransaction().commit();
		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Logs> listarLog(){
		return montaQry("from " + Logs.class.getSimpleName()).retornoLista(em);
		
	}
	
	public void gravaLogAcaoLogin(String tipo, Usuario userLogin, Object classe) throws ParseException, IllegalArgumentException, IllegalAccessException{
		getDadosLoginPadrao(tipo);
		if(tipo.equals(TENTATIVA_LOGIN)){
			log.setInformacoes("Login: " + userLogin.getLogin() + ", Senha: " + userLogin.getSenha());
		}
		else {
			log.setInformacoes(userLogin.getPessoa().getNome() + " - " + userLogin.getPerfil().getNome());
			log.setIdModulo(userLogin.getId().toString());
		}
		log.setModulo(classe.getClass().getSimpleName());
		log.setModulo(log.getModulo().replace("$Proxy$_$$_WeldSubclass", ""));
		try {
			if(!tipo.equals(TENTATIVA_LOGIN)){
				gravarLog(log, em);
			}else{
				failure.gravarFalha(log);
			}
			log = null;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void gravaLogAcaoLogOff(String tipo, Usuario userLogin, Object classe){
		getDadosLoginPadrao(tipo);
		log.setTipoAcao(tipo);
		log.setModulo("LogOff");
		log.setIdModulo(userLogin.getId().toString());
		log.setInformacoes(userLogin.getPessoa().getNome() + " - " + userLogin.getPerfil().getNome());
		try {
			gravarLog(log, em);
			log = null;
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
	public void gravaLogAcao(String tipo, Object classe, EntityManager em) {
		String modulo, id;
		try {
			modulo = classe.getClass().getSimpleName();
			id = getValueField(classe);
			preparaLog(tipo, modulo, id);
			log.setInformacoes(getInformacoes(classe));
			gravarLog(log, em);
			log = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void preparaLog(String tipo, String modulo, String id){
		getDadosLoginPadrao(tipo);
		log.setTipoAcao(tipo);
		log.setModulo(modulo);
		log.setIdModulo(id);
		
	}
	
	private String getValueField(Object classe) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	    Field[] fields = classe.getClass().getDeclaredFields();
	    for (Field field : fields) {
	    	field.setAccessible(true);
	    	String fieldValue = field.getName() == "id" ? field.get(classe).toString() : "";
	    	if(fieldValue != null){
	    		return fieldValue.toString();
	    	}
		}
	    return "";
	}
	
	private void getDadosLoginPadrao(String tipo){
		log = new Logs();
		if(!tipo.equals(TENTATIVA_LOGIN)){ 
			log.setIdEmpresa(usuarioLogado.getEmpresa().getId());
			log.setIdUsuario(usuarioLogado.getUsuarioLogado().getId());
		}else{
			log.setIdUsuario(null);
			log.setIdEmpresa(null);
		}
		log.setDataAcao(getDataAtual());
		log.setTipoAcao(tipo);
	}
	
	
}