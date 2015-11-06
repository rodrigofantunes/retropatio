package br.com.retropatio.business;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import br.com.retropatio.model.Usuario;

public class LoginBusiness extends UsuarioBusiness {

	private static final long serialVersionUID = 1L;

	protected boolean efetuaAutenticacao(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		return efetuarAutenticacao(usuario);
	}

}