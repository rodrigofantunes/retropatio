package br.com.retropatio.architecture;

import java.io.Serializable;
import java.lang.reflect.Field;

import javax.inject.Inject;

import br.com.retropatio.dao.LogsDao;
import br.com.retropatio.model.Log;
import br.com.retropatio.session.UsuarioLogado;
import br.com.retropatio.utilities.Utilities;


public class Logs extends Utilities implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject private static LogsDao logsDao;
	@Inject private static UsuarioLogado usuarioLogado;
	
	public static final String CADASTRAR_CAMINHAO 	= getMessage("label.cadastrar.caminhao");
	public static final String CADASTRAR_CONTAINER 	= getMessage("label.cadastrar.container");
	public static final String CADASTRAR_MOTORISTA 	= getMessage("label.cadastrar.motorista");
	public static final String ALTERAR_CAMINHAO 	= getMessage("label.alterar.caminhao");
	public static final String ALTERAR_CONTAINER 	= getMessage("label.alterar.container");
	public static final String ALTERAR_MOTORISTA 	= getMessage("label.alterar.motorista");
	public static final String DELETAR_CAMINHAO 	= getMessage("label.deletar.caminhao");
	public static final String DELETAR_CONTAINER 	= getMessage("label.deletar.container");
	public static final String DELETAR_MOTORISTA 	= getMessage("label.deletar.motorista");
	
	public static void gravaLogAcao(String tipo, Object classe) {
		String modulo, id;
		try {
			modulo = classe.getClass().getSimpleName();
			id = getValueField(classe);
			logsDao.gravarLog(preparaLog(tipo, modulo, id));
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	private static Log preparaLog(String tipo, String modulo, String id){
		Log log = new Log();
		log.setEmpresa(usuarioLogado.getEmpresa());
		log.setUsuario(usuarioLogado.getUsuario());
		log.setDataAcao(Utilities.getDataAtual());
		log.setTipoAcao(tipo);
		log.setModulo(modulo);
		log.setIdModulo(id);
		return log;
	}
	
	private static String getValueField(Object classe) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
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
	
}
