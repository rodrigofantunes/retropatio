package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.dao.ContainerDao;
import br.com.retropatio.model.Container;


public class ContainerBusiness extends ValidationSession{

	private static final long serialVersionUID = 1L;
	@Inject private ContainerDao containerDao; 
	
	protected List<Container> listaUltimosContainers(){
		return containerDao.listarUltimosContainers();
	}

	protected void cadastrarContainer(Container container) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
			containerDao.inserirContainer(container);
	}
	
	protected void alterarContainer(Container container) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
			containerDao.alterarContainer(container);
	}
	
	protected void deletarContainer(Long id) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
			containerDao.deletarContainer(containerDao.buscarContainerPorId(id));
	}
	
	protected Container verContainer(Long id) throws ParseException{
			return containerDao.buscarContainerPorId(id);
	}
}