package br.com.retropatio.dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.entity.Container;
import br.com.retropatio.session.UsuarioLogado;

public class ContainerDao extends Logger{
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioLogado usuarioLogado;
	
	private final EntityManager em;
	public ContainerDao() {
		this(null);
	}
	@Inject
	public ContainerDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public void inserirContainer(Container container) throws IllegalArgumentException, NoSuchFieldException, SecurityException{
		try {
			em.persist(container);
			gravaLogAcao(CADASTRAR_CONTAINER,container, em);
		} catch (NoResultException e) {
			
		}
	}
	
	public Container buscarContainerPorId(Long id) {
		return em.find(Container.class, id);
	}
	
	public void alterarContainer(Container container) throws IllegalArgumentException, NoSuchFieldException, SecurityException {
		try {
			em.merge(container);
			gravaLogAcao(ALTERAR_CONTAINER,container, em);
		} catch (NoResultException e) {
			
		}
	}
	
	public void deletarContainer(Container container) throws IllegalArgumentException, NoSuchFieldException, SecurityException {
		try {
			em.remove(em.merge(container));
			gravaLogAcao(DELETAR_CONTAINER,container, em);
		} catch (NoResultException e) {
			
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Container> listarUltimosContainers(){
		return montaQry("from " + Container.class.getSimpleName())
				.append("where empresa = ?")
				.parametro(usuarioLogado.getIdEmpresa())
				.maximoResultado(10)
				.retornoLista(em);
	}
}