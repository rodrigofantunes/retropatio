package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Persistences;
import br.com.retropatio.model.Caminhao;
import br.com.retropatio.session.UsuarioLogado;

public class CaminhaoDao extends Persistences{
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioLogado usuarioLogado;
	
	private final EntityManager em;
	public CaminhaoDao() {
		this(null);
	}
	@Inject
	public CaminhaoDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirCaminhao(Caminhao caminhao){
		try {
			em.persist(caminhao);
			gravaLogAcao(CADASTRAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	public Caminhao buscarCaminhaoPorId(Long id) {
		return em.find(Caminhao.class, id);
	}
	
	public void alterarCaminhao(Caminhao caminhao) {
		try {
			em.merge(caminhao);
			gravaLogAcao(ALTERAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	public void deletarCaminhao(Caminhao caminhao) {
		try {
			em.remove(em.merge(caminhao));
			gravaLogAcao(DELETAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Caminhao> listarUltimosCaminhoes(){
		return montaQry("from " + Caminhao.class.getSimpleName())
				.append("where empresa = ?")
				.parametro(usuarioLogado.getIdEmpresa())
				.maximoResultado(10)
				.retornoLista(em);
		
	}
}