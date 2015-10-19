package br.com.retropatio.business;

import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.dao.CaminhaoDao;
import br.com.retropatio.model.Caminhao;


public class CaminhaoBusiness{

	@Inject private CaminhaoDao caminhaoDao; 
	
	protected List<Caminhao> listaUltimosCaminhoes(){
		return caminhaoDao.listarUltimosCaminhoes();
	}

	protected void cadastrarCaminhao(Caminhao caminhao){
		caminhaoDao.inserirCaminhao(caminhao);
	}
	
	protected void alterarCaminhao(Caminhao caminhao){
		caminhaoDao.alterarCaminhao(caminhao);
	}
	
	protected void deletarCaminhao(Long id){
		caminhaoDao.deletarCaminhao(caminhaoDao.buscarCaminhaoPorId(id));
	}
	
	protected Caminhao verCaminhao(Long id){
		return caminhaoDao.buscarCaminhaoPorId(id);
	}
}