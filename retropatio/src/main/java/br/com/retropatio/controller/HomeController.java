package br.com.retropatio.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.HomeBusiness;

@Controller
public class HomeController extends HomeBusiness {

	private final Result result;

	/**
	 * @deprecated CDI eyes only
	 */
	protected HomeController() {
		this(null);
	}
	
	@Inject
	public HomeController(Result result) {
		this.result = result;
	}

	@Path("/")
	public void home() {
		result.redirectTo(LoginController.class).login(null);
	}
}