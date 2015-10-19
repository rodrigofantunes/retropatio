package br.com.retropatio.dao;

import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Querys;
import br.com.retropatio.model.Usuario;

public class UsuarioDao extends Querys{
	private static final long serialVersionUID = 1L;

	private final EntityManager em;
	public UsuarioDao() {
		this(null);
	}
	@Inject
	public UsuarioDao(EntityManager entityManager) {
		this.em = entityManager;
	}

	public Usuario autenticar ( String login, String senha ){
		try {
			Usuario usuario = montaQry("from Usuario where login = ?")
							  .append("and senha = ?")
							  .parametro(login)
							  .parametro(senha)
							  .logar(em);
			
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public void insert(Usuario usuario) throws NoSuchAlgorithmException{ 
		em.persist(usuario);
	}
	
	public Usuario buscarPorId(Long id) {
		return em.find(Usuario.class, id);
	}
	
	public void alterar(Usuario usuario) {
		em.merge(usuario);
	}
	
	public String verificaLogin(String login){
		return ((Usuario) montaQry("from Usuario where login = ?").parametro(login).retornoUnico(em)).getLogin();
	}
	
}