package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Log;

public class LogsDao extends Querys{
	private static final long serialVersionUID = 1L;

	private final EntityManager em;
	public LogsDao() {
		this(null);
	}
	@Inject
	public LogsDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void gravarLog(Log log){
		try {
			em.persist(log);
		} catch (NoResultException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Log> listarLog(){
		return montaQry("from " + Log.class.getName()).retornoLista(em);
		
	}
}