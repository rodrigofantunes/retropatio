package br.com.retropatio.dao;

import java.text.ParseException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Failure;
import br.com.retropatio.architecture.Querys;

public class FailureDao extends Querys{

	private static final long serialVersionUID = 1L;
	private final EntityManager em;
	private Failure falha;

	public FailureDao() {
		this(null);
	}
	@Inject
	public FailureDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void gravarFalha(Object obj) throws IllegalArgumentException, IllegalAccessException, ParseException{
		try {
			falha = preparaFalha(obj);
			em.persist(falha);
			em.getTransaction().commit();
		} catch (NoResultException e) {
		}
	}
	
	private Failure preparaFalha(Object obj) throws IllegalArgumentException, IllegalAccessException, ParseException{
		falha = new Failure();
		falha.setInformacoes(getInformacoes(obj));
		falha.setAcao(FALHA);
		falha.setDataOcorrido(getDataAtual());
		return falha;
	}
	public void gravarFalhaException(Object classe, Exception ex) throws IllegalArgumentException, IllegalAccessException, ParseException {
		falha = new Failure();
		falha.setInformacoes(getInformacoes(classe) + " - Erro: " + ex.getCause() + " - Mensagem: " + ex.getMessage());
		falha.setAcao(FALHA_CRITICA);
		falha.setDataOcorrido(getDataAtual());
		
	}
	
}