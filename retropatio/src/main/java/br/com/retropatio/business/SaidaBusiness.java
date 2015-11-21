package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.dao.SaidaDao;
import br.com.retropatio.entity.Saida;


public class SaidaBusiness extends ValidationSession{

	private static final long serialVersionUID = 1L;
	@Inject private SaidaDao saidaDao; 
	
	public List<Saida> getCincoUltimasSaidas(){
		return saidaDao.getListaCincoUltimasSaidas();
	}

	protected void cadastrarSaida(Saida saida) throws ParseException, IllegalArgumentException, NoSuchFieldException, SecurityException{
		saidaDao.inserirSaida(saida);
	}
	
	protected Saida verSaida(Long id) throws ParseException{
		return saidaDao.buscarSaidaPorId(id);
	}
}