package br.com.retropatio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.entity.Motorista;

public class MotoristaDao extends Logger{
	private static final long serialVersionUID = 1L;
	
	private final EntityManager em;
	@Inject private FailureDao failureDao;
	
	public MotoristaDao() {
		this(null);
	}
	
	@Inject
	public MotoristaDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirMotorista(Motorista motorista) throws Exception{
		try {
			persistMotorista(motorista,em);
			gravaLogAcao(CADASTRAR_MOTORISTA,motorista,em);
		}
		catch (Exception e){
			failureDao.gravarFalhaException(this,e);
		}
	}
	
	public Motorista buscarMotoristaPorId(Long id) {
		return em.find(Motorista.class, id);
	}
	
	public void alterarMotorista(Motorista motorista) throws Exception {
		try { em.merge(motorista);} 
		catch (Exception e){}
		gravaLogAcao(ALTERAR_MOTORISTA,motorista, em);
	}
	
	public void deletarMotorista(Motorista motorista) throws Exception {
		try {
			em.remove(em.merge(motorista));
			gravaLogAcao(DELETAR_MOTORISTA,motorista, em);
		}
		catch (Exception e) {
			failureDao.gravarFalhaException(this,e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Motorista> getListaMotoristas() throws Exception {
		List<Motorista> lista = new ArrayList<Motorista>();
		try{
			lista = montaQry("From " + Motorista.class.getSimpleName())
				.append(" where empresa_id = ? ")
				.parametro(usuarioLogado.getIdEmpresa())
				.retornoLista(em);
		}catch(Exception e){ 
			failureDao.gravarFalhaException(this,e);
		}
		return lista;
	}
	
}