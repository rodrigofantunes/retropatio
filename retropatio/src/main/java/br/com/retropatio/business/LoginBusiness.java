package br.com.retropatio.business;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import br.com.retropatio.model.Usuario;

public class LoginBusiness extends UsuarioBusiness {

	protected boolean efetuaAutenticacao(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		return efetuarAutenticacao(usuario);
	}

}