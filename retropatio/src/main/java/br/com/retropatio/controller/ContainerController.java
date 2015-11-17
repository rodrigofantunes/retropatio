package br.com.retropatio.controller;

import java.text.ParseException;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Result;
import br.com.retropatio.business.ContainerBusiness;
import br.com.retropatio.model.Container;

@Controller
public class ContainerController extends ContainerBusiness {

	private static final long serialVersionUID = 1L;
	private final Result result;

	protected ContainerController() {
		this(null);
	}
	
	@Inject
	public ContainerController(Result result) {
		this.result = result;
	}

	@Path("/container")
	public void index() {
		result.include(listaUltimosContainers());
	}
	
	@Path("/container/cadastro")
	public void cadastro() throws ParseException { 
		validaSessao(result);
	}
	
	@Path("/container/cadastrar")
	public void cadastrar(Container container) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		if(validaSessao(result)){
			cadastrarContainer(container);
			result.redirectTo(this).index();
		}
	}

	@Path("/container/ver/{container.id}")
	public Container verContainer(Long id) throws ParseException {
		return super.verContainer(id);
	}
	
	@Path("/container/alterar")
	public void alterar(Container container) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		alterarContainer(container);
		result.redirectTo(this).verContainer(container.getId());
	}
	
	@Path("/container/deletar/{container.id}")
	public void deletar(Long id) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		deletarContainer(id);
		result.redirectTo(this).index();
	}
}