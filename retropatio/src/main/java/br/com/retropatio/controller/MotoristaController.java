package br.com.retropatio.controller;

import java.text.ParseException;

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
	
	@Path("/motorista/cadastro")
	public void cadastro(Motorista motorista) throws ParseException { 
		if(validaSessao(result)){
			result.include(DATA_ATUAL,converteDataToString(getDataAtual()));
		}
	}
	
	@Path("/motorista/cadastrar")
	public void cadastrar(Motorista motorista) throws ParseException{
		if(validaSessao(result)){
			cadastrarMotorista(motorista);
			result.redirectTo(this).index();
		}
	}

	@Path("/motorista/ver/{motorista.id}")
	public Motorista verMotorista(Long id) throws ParseException {
		return super.verMotorista(id);
	}
	
	@Path("/motorista/alterar")
	public void alterar(Motorista motorista) throws ParseException{
		alterarMotorista(motorista);
		result.redirectTo(this).verMotorista(motorista.getId());
	}
	
	@Path("/motorista/deletar/{motorista.id}")
	public void deletar(Long id) throws ParseException{
		deletarMotorista(id);
		result.redirectTo(this).index();
	}
}