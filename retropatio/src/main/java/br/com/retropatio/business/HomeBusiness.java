package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Result;
import br.com.retropatio.controller.LoginController;
import br.com.retropatio.dao.EntradaDao;
import br.com.retropatio.dao.SaidaDao;
import br.com.retropatio.entity.Entrada;
import br.com.retropatio.entity.Saida;



public class HomeBusiness extends UsuarioBusiness {

	private static final long serialVersionUID = 1L;
	@Inject protected Result result;
	@Inject private EntradaDao entradaDao;
	@Inject private SaidaDao saidaDao; 
	
	public void home() throws ParseException{
		if(validaSessao(result)){
			result.include("listaEntradas",getCincoUltimasEntradas());
			result.include("listaSaidas",getCincoUltimasSaidas());
		}
	}

	public List<Saida> getCincoUltimasSaidas(){
		return saidaDao.getListaCincoUltimasSaidas();
	}
	
	private List<Entrada> getCincoUltimasEntradas(){
		return entradaDao.getListaCincoUltimasEntradas();
	}

	public void logOff() throws ParseException {
		gravaLogAcaoLogOff(LOGOFF, usuarioLogado.getUsuario(), this);
		usuarioLogado.deslogar();
		result.redirectTo(LoginController.class).login(null);
		
	}
}