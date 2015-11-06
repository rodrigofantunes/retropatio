package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.HomeBusiness;

@Controller
public class HomeController extends HomeBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected HomeController() {
		this(null);
	}
	
	@Inject
	public HomeController(Result result) {
		this.result = result;
	}

	@Path("/home")
	public void home() throws ParseException { super.home();}
	
	@Post("/home/logout")
	public void logout() throws ParseException{
		usuarioLogado.deslogar();
		result.redirectTo(LoginController.class).login(null);
	}
}