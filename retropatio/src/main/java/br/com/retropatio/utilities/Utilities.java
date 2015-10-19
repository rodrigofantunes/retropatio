package br.com.retropatio.utilities;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Properties;

public class Utilities {

	private static final String MESSAGES_PROPERTIES = "/messages.properties";
	private static Properties properties;
	
	public static String codificaSenha(String Senha) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(Senha.getBytes(),0,Senha.length());
		return new BigInteger(1,m.digest()).toString(32);
	}
	
	public static Date getDataAtual(){
		return new Date();
	}
	
	public static String getMessage(String key){
		String retorno = null;
		try{ 				
			if(properties==null){
				properties = new Properties();					
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
