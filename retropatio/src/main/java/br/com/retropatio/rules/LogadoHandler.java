package br.com.retropatio.rules;

import javax.inject.Inject;

import br.com.caelum.brutauth.auth.handlers.RuleHandler;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.retropatio.controller.LoginController;

public class LogadoHandler implements RuleHandler{

	@Inject Result result;
	
	private Validator validation;
	
	protected LogadoHandler(){
		this(null);
	}
	
	@Inject
    public LogadoHandler(Validator validation) {
        this.validation = validation;
    }
	
	@Override
	public void handle() {
		validation.add(new SimpleMessage("erro","Você precisa estar logado para acessar essa área")).onErrorForwardTo(LoginController.class).login(null);
	}

}
