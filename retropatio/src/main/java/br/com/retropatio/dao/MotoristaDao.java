package br.com.retropatio.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.model.Motorista;

public class MotoristaDao extends Logger{
	private static final long serialVersionUID = 1L;
	
	private final EntityManager em;
	public MotoristaDao() {
		this(null);
	}
	@Inject
	public MotoristaDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirMotorista(Motorista motorista) throws IllegalArgumentException, NoSuchFieldException, SecurityException{
		try {persistMotorista(motorista,em);}
		catch (NoResultException e){}
		gravaLogAcao(CADASTRAR_MOTORISTA,motorista,em);
	}
	
	public Motorista buscarMotoristaPorId(Long id) {
		return em.find(Motorista.class, id);
	}
	
	public void alterarMotorista(Motorista motorista) throws IllegalArgumentException, NoSuchFieldException, SecurityException {
		try { em.merge(motorista);} 
		catch (NoResultException e){}
		gravaLogAcao(ALTERAR_MOTORISTA,motorista, em);
	}
	
	public void deletarMotorista(Motorista motorista) throws IllegalArgumentException, NoSuchFieldException, SecurityException {
		try {em.remove(em.merge(motorista));}
		catch (NoResultException e) {}
		gravaLogAcao(DELETAR_MOTORISTA,motorista, em);
	}
	
}