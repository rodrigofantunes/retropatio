package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.retropatio.controller.LoginController;
import br.com.retropatio.dao.EntradaDao;
import br.com.retropatio.dao.SaidaDao;
import br.com.retropatio.model.Entrada;
import br.com.retropatio.model.Saida;



public class HomeBusiness extends UsuarioBusiness {

	private static final long serialVersionUID = 1L;
	@Inject protected Result result;
	@Inject private EntradaDao entradaDao;
	@Inject private SaidaDao saidaDao; 
	
	public void home() throws ParseException{
		if(!verificaSessaoLogada()){
			result.redirectTo(LoginController.class).login(null);
			return;
		}
			result.include(LISTA_5_ULTIMAS_ENTRADAS,getCincoUltimasEntradas());
			result.include(LISTA_5_ULTIMAS_SAIDAS,getCincoUltimasSaidas());
	}

	public List<Saida> getCincoUltimasSaidas(){
		return saidaDao.getListaCincoUltimasSaidas();
	}
	
	private List<Entrada> getCincoUltimasEntradas(){
		return entradaDao.getListaCincoUltimasEntradas();
	}
}