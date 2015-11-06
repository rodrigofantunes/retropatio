package br.com.retropatio.architecture;

import java.lang.reflect.Field;

import javax.inject.Inject;

import br.com.retropatio.dao.LoggerDao;
import br.com.retropatio.model.Logs;
import br.com.retropatio.utilities.Utilities;



public interface Logger{

	@Inject LoggerDao loggerDao = null;
	
	public default void gravaLogAcao(String tipo, Object classe) {
		String modulo, id;
		try {
			modulo = classe.getClass().getSimpleName();
			id = getValueField(classe);
			loggerDao.gravarLog(preparaLog(tipo, modulo, id));
		} catch (SecurityException | NoSuchFieldException | IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	default Logs preparaLog(String tipo, String modulo, String id){
		Logs log = new Logs();
		log.setEmpresa(new Utilities().getEmpresaUsuarioLogado());
		log.setUsuario(new Utilities().getUsuarioLogado());
		log.setDataAcao(Utilities.getDataAtual());
		log.setTipoAcao(tipo);
		log.setModulo(modulo);
		log.setIdModulo(id);
		return log;
	}
	
	default String getValueField(Object classe) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
	    Field[] fields = classe.getClass().getDeclaredFields();
	    for (Field field : fields) {
	    	field.setAccessible(true);
	    	String fieldValue = field.getName() == "id" ? field.get(classe).toString() : "";
	    	if(fieldValue != null){
	    		return fieldValue.toString();
	    	}
		}
	    return "";
	}
	
}
