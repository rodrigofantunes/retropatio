package br.com.retropatio.architecture;

import java.text.ParseException;

import br.com.caelum.vraptor.Result;
import br.com.retropatio.controller.LoginController;

public class ValidationSession extends Logger {

	private static final long serialVersionUID = 1L;
	public static boolean sessionValid = false;
	
	public boolean validaSessao(Result result) throws ParseException{
		if(!verificaSessaoLogada()){ 
			result.redirectTo(LoginController.class).login(null);
			if(isSessionValid()) {
				result.include("atencao", "Sua sessão expirou, favor entre com seu login novamente.");
			}
			return false;
		}
		return true;
	}
	
	public boolean verificaSessaoLogada(){
		if(!usuarioLogado.isLogado()){
			return false;
		}		
		return true;
	}
	
	public boolean validaSessaoLogin(){ 
		return usuarioLogado.isLogado();
	}
	
	public boolean verificaSessaoValida(){
		return sessionValid;
	}

	public static boolean isSessionValid() {
		return sessionValid;
	}

	public static void setSessionValid(boolean sessionValid) {
		ValidationSession.sessionValid = sessionValid;
	}
}
