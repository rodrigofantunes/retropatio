package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.EntradaBusiness;
import br.com.retropatio.model.Entrada;

@Controller
public class EntradaController extends EntradaBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected EntradaController() {
		this(null);
	}
	
	@Inject
	public EntradaController(Result result) {
		this.result = result;
	}

	@Path("/entrada")
	public void index() {
		result.include("listaEntradas",getCincoUltimasEntradas());
	}
	
	@Path("/entrada/cadastro")
	public void cadastro() throws ParseException { 
		validaSessao(result);
		result.include(DATA_ATUAL,converteDataToString(getDataAtual()));
	}
	
	@Path("/entrada/cadastrar")
	public void cadastrar(Entrada entrada) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		cadastrarEntrada(entrada);
		result.redirectTo(this).index();
	}

	@Path("/entrada/ver/{entrada.id}")
	public Entrada verEntrada(Long id) throws ParseException {
		return super.verEntrada(id);
	}
	
}