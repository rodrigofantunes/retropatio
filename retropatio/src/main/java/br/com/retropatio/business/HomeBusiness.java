package br.com.retropatio.business;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.retropatio.controller.LoginController;



public class HomeBusiness extends UsuarioBusiness {

	private static final long serialVersionUID = 1L;
	@Inject protected Result result;
	
	
	public void home() throws ParseException{
		if(!verificaSessaoLogada()){
			result.redirectTo(LoginController.class).login(null);
		}
			
	}
}