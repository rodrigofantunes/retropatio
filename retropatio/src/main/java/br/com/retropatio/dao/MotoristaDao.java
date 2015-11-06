package br.com.retropatio.dao;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Motorista;

public class MotoristaDao extends Querys{
	private static final long serialVersionUID = 1L;

	
	private final EntityManager em;
	public MotoristaDao() {
		this(null);
	}
	@Inject
	public MotoristaDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirMotorista(Motorista motorista){
		try {
			em.persist(motorista);
			gravaLogAcao(CADASTRAR_MOTORISTA,motorista);
		} catch (NoResultException e) {
			
		}
	}
	
	public Motorista buscarMotoristaPorId(Long id) {
		return em.find(Motorista.class, id);
	}
	
	public void alterarMotorista(Motorista motorista) {
		try {
			em.merge(motorista);
			gravaLogAcao(ALTERAR_MOTORISTA,motorista);
		} catch (NoResultException e) {
			
		}
	}
	
	public void deletarMotorista(Motorista motorista) {
		try {
			em.remove(em.merge(motorista));
			gravaLogAcao(DELETAR_MOTORISTA,motorista);
		} catch (NoResultException e) {
			
		}
	}
	
}