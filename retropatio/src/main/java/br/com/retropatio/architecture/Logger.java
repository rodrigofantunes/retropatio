package br.com.retropatio.architecture;

import java.text.ParseException;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.retropatio.dao.LoggerDao;
import br.com.retropatio.entity.Usuario;

public class Logger extends Persistences {

	private static final long serialVersionUID = 1L;
	@Inject private LoggerDao loggerDao;
	
	public void gravaLogAcao(String tipo, Object classe, EntityManager em){
		loggerDao.gravaLogAcao(tipo, classe, em);
	}
	
	public void gravaLogAcaoLogin(String tipo, Usuario userLogin, Object classe) throws ParseException, IllegalArgumentException, IllegalAccessException{
		loggerDao.gravaLogAcaoLogin(tipo, userLogin, classe);
	}
	
	public void gravaLogAcaoLogOff(String tipo, Usuario userLogin, Object classe){
		loggerDao.gravaLogAcaoLogOff(tipo, userLogin, classe);
	}
}
