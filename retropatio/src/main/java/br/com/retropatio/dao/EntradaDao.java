package br.com.retropatio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.model.Entrada;
import br.com.retropatio.session.UsuarioLogado;

public class EntradaDao extends Logger{
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioLogado usuarioLogado;
	
	private final EntityManager em;
	public EntradaDao() {
		this(null);
	}
	@Inject
	public EntradaDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirEntrada(Entrada entrada) throws IllegalArgumentException, NoSuchFieldException, SecurityException{
		try {
			em.persist(entrada);
			gravaLogAcao(CADASTRAR_ENTRADA,entrada, em);
		} catch (NoResultException e) {
			
		}
	}
	
	public Entrada buscarEntradaPorId(Long id) {
		return em.find(Entrada.class, id);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Entrada> getListaCincoUltimasEntradas(){
		List<Entrada> listaEntrada = new ArrayList<Entrada>();
		try{
		listaEntrada = montaQry("from " + Entrada.class.getSimpleName())
				.append("where empresa_id = ?")
				.append("order by id desc")
				.parametro(usuarioLogado.getIdEmpresa())
				.maximoResultado(5)
				.retornoLista(em);
		}catch(Exception ex){}
		return listaEntrada;
	}
}