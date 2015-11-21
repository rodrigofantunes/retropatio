package br.com.retropatio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.entity.Saida;
import br.com.retropatio.session.UsuarioLogado;

public class SaidaDao extends Logger{
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioLogado usuarioLogado;
	
	private final EntityManager em;
	public SaidaDao() {
		this(null);
	}
	@Inject
	public SaidaDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirSaida(Saida saida) throws IllegalArgumentException, NoSuchFieldException, SecurityException{
		try {
			persistSaida(saida, em);
			gravaLogAcao(CADASTRAR_SAIDA,saida, em);
		} catch (NoResultException e) {
			
		}
	}
	
	public Saida buscarSaidaPorId(Long id) {
		return em.find(Saida.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Saida> getListaCincoUltimasSaidas(){
		List<Saida> listaSaida = new ArrayList<Saida>();
		listaSaida = montaQry("from " + Saida.class.getSimpleName())
				.append("where empresa_id = ?")
				.append("order by id desc")
				.parametro(usuarioLogado.getIdEmpresa())
				.maximoResultado(5)
				.retornoLista(em);
		return listaSaida;
		
	}
}