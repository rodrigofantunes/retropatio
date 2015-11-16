package br.com.retropatio.business;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.inject.Inject;

import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.dao.UsuarioDao;
import br.com.retropatio.model.Usuario;


public class UsuarioBusiness extends ValidationSession{

	private static final long serialVersionUID = 1L;
	@Inject private UsuarioDao usuarioDao;

	protected boolean efetuarAutenticacao(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		boolean retorno = false;
		Usuario usuarioParaAutenticar = new Usuario();
		usuarioParaAutenticar = usuarioDao.autenticar(preparaUsuarioLogin(usuario));
		if( usuarioParaAutenticar != null ){
			gravaUsuarioLogado(usuarioParaAutenticar);
			retorno = true;
		}
		return retorno;
	}

	protected void cadastrarUsuario(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		usuario.setEmpresa(usuarioLogado.getEmpresa());
		usuarioDao.inserir(usuario);
	}
	
	protected void alterarUsuario(Usuario usuario) throws ParseException{
		usuarioDao.alterar(usuario);
	}
	
	protected void deletarUsuario(Long id) throws ParseException{
		usuarioDao.deletar(usuarioDao.buscarPorId(id));
	}
	
	protected Usuario verUsuario(Long id) throws ParseException{
		return usuarioDao.buscarPorId(id);
	}

}