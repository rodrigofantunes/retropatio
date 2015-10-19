package br.com.retropatio.controller;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.retropatio.business.LoginBusiness;
import br.com.retropatio.model.Usuario;

@Controller
public class LoginController extends LoginBusiness {

	@Inject private Result result;
	private Validator validation;
	
	protected LoginController(){
		this(null);
	}
	
	@Inject
    public LoginController(Validator validation) {
        this.validation = validation;
    }
	
	@Path("/login")
	public void login(Usuario usuario) {
		result.include(usuario);
	}
	
	@Path("/autenticar")
	public void autenticar(@NotNull @Valid Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		validation.onErrorForwardTo(this).login(usuario);
		if(efetuaAutenticacao(usuario)){
			result.redirectTo(HomeController.class).home();
		}else{
			validation.add(new SimpleMessage("login", "Email ou Senha inválidos.")).onErrorForwardTo(this).login(usuario);
		}
	}
}