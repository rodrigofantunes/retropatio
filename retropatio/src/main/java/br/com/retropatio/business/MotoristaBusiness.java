package br.com.retropatio.business;

import javax.inject.Inject;

import br.com.retropatio.dao.MotoristaDao;
import br.com.retropatio.model.Motorista;
import br.com.retropatio.utilities.Utilities;


public class MotoristaBusiness extends Utilities{

	private static final long serialVersionUID = 1L;
	@Inject private MotoristaDao motoristaDao; 
	
	protected void cadastrarMotorista(Motorista motorista){
		motoristaDao.inserirMotorista(motorista);
	}
	
	protected void alterarMotorista(Motorista motorista){
		motoristaDao.alterarMotorista(motorista);
	}
	
	protected void deletarMotorista(Long id){
		motoristaDao.deletarMotorista(motoristaDao.buscarMotoristaPorId(id));
	}
	
	protected Motorista verMotorista(Long id){
		return motoristaDao.buscarMotoristaPorId(id);
	}
}