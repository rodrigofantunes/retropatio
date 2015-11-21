package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.entity.Caminhao;
import br.com.retropatio.session.UsuarioLogado;

public class CaminhaoDao extends Logger{
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioLogado usuarioLogado;
	@Inject private FailureDao failureDao;
	
	private final EntityManager em;
	public CaminhaoDao() {
		this(null);
	}
	@Inject
	public CaminhaoDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	
	public void inserirCaminhao(Caminhao caminhao) throws Exception{
		try {
			persistCaminhao(caminhao,em);
			gravaLogAcao(CADASTRAR_MOTORISTA,caminhao,em);
		}
		catch (Exception e){
			failureDao.gravarFalhaException(this,e);
		}
	}
	
	public Caminhao buscarCaminhaoPorId(Long id) {
		return em.find(Caminhao.class, id);
	}
	
	public void alterarCaminhao(Caminhao caminhao) throws Exception {
		try { em.merge(caminhao);} 
		catch (Exception e){}
		gravaLogAcao(ALTERAR_MOTORISTA,caminhao, em);
	}
	
	public void deletarCaminhao(Caminhao caminhao) throws Exception {
		try {
			em.remove(em.merge(caminhao));
			gravaLogAcao(DELETAR_MOTORISTA,caminhao, em);
		}
		catch (Exception e) {
			failureDao.gravarFalhaException(this,e);
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