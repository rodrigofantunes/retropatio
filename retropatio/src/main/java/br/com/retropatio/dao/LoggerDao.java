package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Logs;

public class LoggerDao extends Querys {

	private static final long serialVersionUID = 1L;
	private final EntityManager em;
	public LoggerDao() {
		this(null);
	}
	@Inject
	public LoggerDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void gravarLog(Logs logs){
		try {
			em.persist(logs);
		} catch (NoResultException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Logs> listarLog(){
		return montaQry("from " + Logs.class.getSimpleName()).retornoLista(em);
		
	}
}