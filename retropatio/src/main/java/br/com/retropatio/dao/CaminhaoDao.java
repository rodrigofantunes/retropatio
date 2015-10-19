package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Logs;
import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Caminhao;
import br.com.retropatio.session.UsuarioLogado;

public class CaminhaoDao extends Querys{
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
			Logs.gravaLogAcao(Logs.CADASTRAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	public Caminhao buscarCaminhaoPorId(Long id) {
		return em.find(Caminhao.class, id);
	}
	
	public void alterarCaminhao(Caminhao caminhao) {
		try {
			em.merge(caminhao);
			Logs.gravaLogAcao(Logs.ALTERAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	public void deletarCaminhao(Caminhao caminhao) {
		try {
			em.remove(em.merge(caminhao));
			Logs.gravaLogAcao(Logs.DELETAR_CAMINHAO,caminhao);
		} catch (NoResultException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Caminhao> listarUltimosCaminhoes(){
		return montaQry("from " + Caminhao.class.getName())
				.append("where empresa = ?")
				.parametro(usuarioLogado.getIdEmpresa())
				.maximoResultado(10)
				.retornoLista(em);
		
	}
}