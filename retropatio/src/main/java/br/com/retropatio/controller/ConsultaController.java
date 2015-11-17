package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.model.Consulta;

@Controller
public class ConsultaController extends ValidationSession {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected ConsultaController() {
		this(null);
	}
	
	@Inject
	public ConsultaController(Result result) {
		this.result = result;
	}

	@Path("/consulta")
	public void consulta(Consulta consulta) throws ParseException {
		validaSessao(result);
	}
}