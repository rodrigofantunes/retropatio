package br.com.retropatio.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.CaminhaoBusiness;
import br.com.retropatio.model.Caminhao;

@Controller
public class CaminhaoController extends CaminhaoBusiness {

	private final Result result;

	protected CaminhaoController() {
		this(null);
	}
	
	@Inject
	public CaminhaoController(Result result) {
		this.result = result;
	}

	@Path("/caminhao")
	public void index() {
		result.include(listaUltimosCaminhoes());
	}
	
	@Path("/caminhao/cadastrar")
	public void cadastrar(Caminhao caminhao){
		cadastrarCaminhao(caminhao);
		result.redirectTo(this).index();
	}

	@Path("/caminhao/ver/{caminhao.id}")
	public Caminhao verCaminhao(Long id) {
		return super.verCaminhao(id);
	}
	
	@Path("/caminhao/alterar")
	public void alterar(Caminhao caminhao){
		alterarCaminhao(caminhao);
		result.redirectTo(this).verCaminhao(caminhao.getId());
	}
	
	@Path("/caminhao/deletar/{caminhao.id}")
	public void deletar(Long id){
		deletarCaminhao(id);
		result.redirectTo(this).index();
	}
}