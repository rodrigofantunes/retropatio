package br.com.retropatio.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.MotoristaBusiness;
import br.com.retropatio.model.Motorista;

@Controller
public class MotoristaController extends MotoristaBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected MotoristaController() {
		this(null);
	}
	
	@Inject
	public MotoristaController(Result result) {
		this.result = result;
	}

	@Path("/motorista")
	public void index() { }
	
	@Path("/motorista/cadastrar")
	public void cadastrar(Motorista motorista){
		cadastrarMotorista(motorista);
		result.redirectTo(this).index();
	}

	@Path("/motorista/ver/{motorista.id}")
	public Motorista verMotorista(Long id) {
		return super.verMotorista(id);
	}
	
	@Path("/motorista/alterar")
	public void alterar(Motorista motorista){
		alterarMotorista(motorista);
		result.redirectTo(this).verMotorista(motorista.getId());
	}
	
	@Path("/motorista/deletar/{motorista.id}")
	public void deletar(Long id){
		deletarMotorista(id);
		result.redirectTo(this).index();
	}
}