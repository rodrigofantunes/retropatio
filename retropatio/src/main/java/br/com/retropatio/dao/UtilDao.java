package br.com.retropatio.dao;

import javax.inject.Inject;

import br.com.retropatio.architecture.Persistences;

public class UtilDao extends  Persistences {
	
	private static final long serialVersionUID = 1L;

	@Inject private UsuarioDao usuarioDao;
	
	public String verificarNickLogin(String login){
		return usuarioDao.verificaLogin(login);
	}
	
}