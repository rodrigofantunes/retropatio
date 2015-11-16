package br.com.retropatio.utilities;

import java.io.IOException;
import java.util.Properties;

public interface UtilStatic {

	public static final String MESSAGES_PROPERTIES = "/messages.properties";
	public static final long serialVersionUID = 1L;
	public static final Properties properties = new Properties();
	
	public final String CADASTRAR_PERFIL 	= getMessage("label.cadastrar.perfil");
	public final String CADASTRAR_USUARIO 	= getMessage("label.cadastrar.usuario");
	public final String CADASTRAR_CAMINHAO 	= getMessage("label.cadastrar.caminhao");
	public final String CADASTRAR_CONTAINER = getMessage("label.cadastrar.container");
	public final String CADASTRAR_MOTORISTA = getMessage("label.cadastrar.motorista");
	public final String CADASTRAR_ENTRADA 	= getMessage("label.cadastrar.entrada");
	public final String CADASTRAR_SAIDA 	= getMessage("label.cadastrar.saida");
	
	public final String ALTERAR_PERFIL 		= getMessage("label.alterar.perfil");
	public final String ALTERAR_USUARIO 	= getMessage("label.alterar.usuario");
	public final String ALTERAR_CAMINHAO 	= getMessage("label.alterar.caminhao");
	public final String ALTERAR_CONTAINER 	= getMessage("label.alterar.container");
	public final String ALTERAR_MOTORISTA 	= getMessage("label.alterar.motorista");
	
	public final String DELETAR_PERFIL 		= getMessage("label.deletar.perfil");
	public final String DELETAR_USUARIO 	= getMessage("label.deletar.usuario");
	public final String DELETAR_CAMINHAO 	= getMessage("label.deletar.caminhao");
	public final String DELETAR_CONTAINER 	= getMessage("label.deletar.container");
	public final String DELETAR_MOTORISTA 	= getMessage("label.deletar.motorista");
	
	public final int CODIGO_CLIENTE	 		= 1;
	public final int NOME_CLIENTE	 		= 2;
	public final int CPF_CLIENTE	 		= 3;

	public final int CODIGO_USUARIO	 		= 1;
	public final int NOME_USUARIO	 		= 2;
	public final int CPF_USUARIO	 		= 3;
	public final int TODOS_USUARIOS	 		= 4;

	
	public static String getMessage(String key){
		String retorno = null;
		try{ 				
			if(properties==null){
				properties.load(new String().getClass().getResourceAsStream(MESSAGES_PROPERTIES));
			}				
		 	if(key != null){
		 		retorno = properties.getProperty(key);
		 	}
	 		return retorno;
		}catch (IOException e) {
			return null;
		}
	 }	
	
}
