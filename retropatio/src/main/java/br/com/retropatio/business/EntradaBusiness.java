package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.dao.EntradaDao;
import br.com.retropatio.model.Entrada;


public class EntradaBusiness extends ValidationSession{

	private static final long serialVersionUID = 1L;
	@Inject private EntradaDao entradaDao;
	
	public List<Entrada> getCincoUltimasEntradas(){
		return entradaDao.getListaCincoUltimasEntradas();
	}

	protected void cadastrarEntrada(Entrada entrada) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		entradaDao.inserirEntrada(entrada);
	}
	
	protected Entrada verEntrada(Long id) throws ParseException{
		return entradaDao.buscarEntradaPorId(id);
	}
}