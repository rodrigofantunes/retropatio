package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.com.retropatio.business.MotoristaBusiness;
import br.com.retropatio.model.Motorista;

@Controller
public class MotoristaController extends MotoristaBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;
	private Validator validation;
	
	protected MotoristaController() {
		this(null,null);
	}
	
	@Inject
	public MotoristaController(Result result, Validator validation) {
        this.validation = validation;
		this.result = result;
	}

	@Path("/motorista")
	public void index() { }
	
	@Path("/motorista/cadastro")
	public void cadastro(Motorista motorista) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{ 
		if(validaSessao(result)){
			result.include(DATA_ATUAL,converteDataToString(getDataAtual()));
		}
	}
	
	@Path("/motorista/cadastrar")
	public void cadastrar(Motorista motorista) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		if(validaSessao(result)){
				cadastrarMotorista(motorista);
				validation.add(new SimpleMessage("mensagem", "Motorista cadastrado com sucesso!")).onErrorRedirectTo(MotoristaController.class).cadastro(null);
				result.redirectTo(this).cadastro(null);
		}
	}

	@Path("/motorista/ver/{motorista.id}")
	public Motorista verMotorista(Long id) throws ParseException {
		return super.verMotorista(id);
	}
	
	@Path("/motorista/alterar")
	public void alterar(Motorista motorista) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		alterarMotorista(motorista);
		result.redirectTo(this).verMotorista(motorista.getId());
	}
	
	@Path("/motorista/deletar/{motorista.id}")
	public void deletar(Long id) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		deletarMotorista(id);
		result.redirectTo(this).index();
	}
}