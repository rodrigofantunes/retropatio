package br.com.retropatio.controller;

import java.text.ParseException;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.retropatio.business.HomeBusiness;

@Controller
public class HomeController extends HomeBusiness {

	private static final long serialVersionUID = 1L;

	@Path("/home")
	public void home() throws ParseException { super.home();}
	
	@Post("/home/logout")
	public void logout() throws ParseException{ super.logOff();}
}