package br.com.retropatio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import br.com.retropatio.architecture.Persistences;
import br.com.retropatio.entity.Usuario;

public class UsuarioDao extends Persistences{

	private static final long serialVersionUID = 1L;
	private final EntityManager em;
	List<Usuario> listaUsuarios = new ArrayList<Usuario>();
	public UsuarioDao() {
		this(null);
	}
	
	@Inject
	public UsuarioDao(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	public Usuario buscarPorId(Long id) { return em.find(Usuario.class, id); }

	public void inserir(Usuario usuario) { persistUsuario(usuario,em); }
	
	public void alterar(Usuario usuario) { em.merge(usuario); }
	
	public void deletar(Usuario usuario) { em.remove(em.merge(usuario)); }
	
	public Usuario autenticar ( Usuario user ){
		try {
			Usuario usuario = montaQry("from " + Usuario.class.getSimpleName() + " where login = ?")
							   .append("and senha = ?")
							   .parametro(user.getLogin())
							   .parametro(user.getSenha())
							   .logar(em);
			return usuario;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public String verificaLogin(String login){
		try{
			return ((Usuario) montaQry("from " + Usuario.class.getSimpleName() + " where login = ?").parametro(login).retornoUnico(em)).getLogin();
		}
		catch(Exception ex){
			return "";
		}
	}
	
//	@SuppressWarnings("unchecked")
//	public List<Usuario> buscaUsuario(Consulta consulta){
//		
//		switch(Integer.parseInt(consulta.getTipoPesquisa())){
//		
//		case CODIGO_USUARIO:
//			listaUsuarios = montaQry("from " + Usuario.class.getSimpleName() + " where id_usuario = ?")
//			.parametro(Long.parseLong(consulta.getTexto()))
//			.retornoLista(em);
//			break;
//			
//		case NOME_USUARIO:
//			listaUsuarios = montaQry("from " + Usuario.class.getSimpleName() + " where pessoa_id_pessoa in ( )")
//			.retornoLista(em);
//			break;
//			
//		case CPF_USUARIO:
//			listaUsuarios = montaQry("from " + Usuario.class.getSimpleName() + " where pessoa_id_pessoa in ( )")
//			.retornoLista(em);
//			break;
//			
//		case TODOS_USUARIOS:
//			listaUsuarios = montaQry("from " + Usuario.class.getSimpleName() + " where pessoa_id_pessoa in ( )")
//			.retornoLista(em);
//			break;
//		}
//		
//		return listaUsuarios;
//	}	
	
	public String verificarNickLogin(String login){
		try{
			return ((Usuario) montaQry("from " + Usuario.class.getSimpleName() + " where login = ?").parametro(login).retornoUnico(em)).getLogin();
		}
		catch(NoResultException  e){
			return "";
		}
	}
}