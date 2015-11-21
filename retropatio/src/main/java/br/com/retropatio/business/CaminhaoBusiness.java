package br.com.retropatio.business;

import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.architecture.ValidationSession;
import br.com.retropatio.dao.CaminhaoDao;
import br.com.retropatio.entity.Caminhao;


public class CaminhaoBusiness extends ValidationSession{

	private static final long serialVersionUID = 1L;
	@Inject private CaminhaoDao caminhaoDao; 
	
	protected List<Caminhao> listaUltimosCaminhoes(){
		return caminhaoDao.listarUltimosCaminhoes();
	}

	protected void cadastrarCaminhao(Caminhao caminhao) throws Exception{
			caminhaoDao.inserirCaminhao(caminhao);
	}
	
	protected void alterarCaminhao(Caminhao caminhao) throws Exception{
			caminhaoDao.alterarCaminhao(caminhao);
	}
	
	protected void deletarCaminhao(Long id) throws Exception{
			caminhaoDao.deletarCaminhao(caminhaoDao.buscarCaminhaoPorId(id));
	}
	
	protected Caminhao verCaminhao(Long id) throws ParseException{
			return caminhaoDao.buscarCaminhaoPorId(id);
	}
}