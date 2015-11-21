package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.CaminhaoBusiness;
import br.com.retropatio.entity.Caminhao;

@Controller
public class CaminhaoController extends CaminhaoBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected CaminhaoController() {
		this(null);
	}
	
	@Inject
	public CaminhaoController(Result result) {
		this.result = result;
	}

	@Path("/caminhoes")
	public void caminhoes() {
		result.include("listaCaminhoes",listaUltimosCaminhoes());
	}
	
	@Path("/caminhao/cadastro")
	public void cadastro() throws ParseException { 
		validaSessao(result);
	}
	
	@Path("/caminhao/cadastrar")
	public void cadastrar(Caminhao caminhao) throws Exception{
		if(validaSessao(result)){
			cadastrarCaminhao(caminhao);
			result.redirectTo(this).caminhoes();
		}
	}

	@Path("/caminhao/ver/{caminhao.id}")
	public Caminhao verCaminhao(Long id) throws ParseException {
		return super.verCaminhao(id);
	}
	
	@Path("/caminhao/alterar")
	public void alterar(Caminhao caminhao) throws Exception{
		alterarCaminhao(caminhao);
		result.redirectTo(this).verCaminhao(caminhao.getId());
	}
	
	@Path("/caminhao/deletar/{caminhao.id}")
	public void deletar(Long id) throws Exception{
		deletarCaminhao(id);
		result.redirectTo(this).caminhoes();
	}
}