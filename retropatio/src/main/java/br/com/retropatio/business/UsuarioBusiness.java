package br.com.retropatio.business;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.inject.Inject;

import br.com.retropatio.dao.UsuarioDao;
import br.com.retropatio.model.Usuario;
import br.com.retropatio.session.UsuarioLogado;


public class UsuarioBusiness{

	@Inject
	private UsuarioDao usuarioDao;
	@Inject private UsuarioLogado usuarioLogado;
	
	protected boolean efetuarAutenticacao(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		boolean retorno = false;
		Usuario usuarioParaAutenticar = new Usuario();
		usuarioParaAutenticar = usuarioDao.autenticar(usuario.getLogin(), usuario.getSenha());
		if( usuarioParaAutenticar != null ){
			usuarioLogado.logar(usuarioParaAutenticar);		
			retorno = true;
		}
		return retorno;
	}

	protected void inserir(Usuario usuario) throws NoSuchAlgorithmException{
		usuario.setEmpresa(usuarioLogado.getEmpresa());
		usuarioDao.insert(usuario);
	}

}