package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.SaidaBusiness;
import br.com.retropatio.model.Saida;

@Controller
public class SaidaController extends SaidaBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected SaidaController() {
		this(null);
	}
	
	@Inject
	public SaidaController(Result result) {
		this.result = result;
	}

	@Path("/saida")
	public void index() {
		result.include("listaSaidas",getCincoUltimasSaidas());
	}
	
	@Path("/saida/cadastro")
	public void cadastro() throws ParseException { 
		validaSessao(result);
		result.include(DATA_ATUAL,converteDataToString(getDataAtual()));
	}
	
	@Path("/saida/cadastrar")
	public void cadastrar(Saida saida) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		cadastrarSaida(saida);
		result.redirectTo(this).index();
	}

	@Path("/saida/ver/{saida.id}")
	public Saida verSaida(Long id) throws ParseException {
		return super.verSaida(id);
	}
	
}