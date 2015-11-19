package br.com.retropatio.utilities;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Properties;

import javax.inject.Inject;

import br.com.retropatio.model.Empresa;
import br.com.retropatio.model.Usuario;
import br.com.retropatio.session.UsuarioLogado;

public class Utilities implements Serializable, UtilStatic{

	private static final long serialVersionUID = 1L;
	private static SimpleDateFormat dateToString = new SimpleDateFormat("dd/MM/yyyy");
	private static final String MESSAGES_PROPERTIES = "/messages.properties";
	private static final Properties properties = new Properties();
	
	@Inject protected UsuarioLogado usuarioLogado;
	
	public static String codificaSenha(String Senha) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(Senha.getBytes(),0,Senha.length());
		return new BigInteger(1,m.digest()).toString(32);
	}
	
	public Usuario preparaUsuarioLogin(Usuario usuario) throws NoSuchAlgorithmException{
		usuario.setSenha(codificaSenha(usuario.getSenha()));
		return usuario;
	}
	
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
	
	public static Date getDataAtual(){  
        Calendar calendar = new GregorianCalendar();  
        Date date = new Date();  
        calendar.setTime(date);  
        return calendar.getTime();  
    }
	
	public Usuario getUsuarioLogado(){
		return usuarioLogado.getUsuario();
	}
	
	public boolean isLogado(){
		return usuarioLogado.isLogado();
	}
	
	public UsuarioLogado getUsuario(){
		return usuarioLogado;
	}
	public Empresa getEmpresaUsuario(){
		return usuarioLogado.getEmpresa();
	}
	
	public String getNomeUsuarioLogado(){
		return usuarioLogado.getNome();
	}
	
	public Long getIdUsuarioLogado(){
		return usuarioLogado.getIdUsuarioLogado();
	}
	
	public Empresa getEmpresaUsuarioLogado(){
		return usuarioLogado.getEmpresa();
	}
	
	public Long getIdEmpresaUsuarioLogado(){
		return usuarioLogado.getIdEmpresa();
	}
	
	public void gravaUsuarioLogado(Usuario usuario){
		usuarioLogado.logar(usuario);
	}

	public static String converteDataToString(Date data) {
		if(data == null) return "";
		return dateToString.format(data);
	}
	
	public static Long removeCaracterCPF(String cpf){
		if(cpf == "" || cpf == null) return Long.parseLong("0");
		return Long.parseLong(cpf.trim().replaceAll("[.|-]", ""));
	}
	
	public String formataDataLongStringToDateShortString(String data) throws ParseException{
	    DateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.US);
	    Date date = (Date)formatter.parse(data.toString());
	    Calendar cal = Calendar.getInstance();
	    cal.setTime(date);
	    return cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) +"/" + cal.get(Calendar.YEAR);
	}
	
	public String converteDateToDataMysql(Date data){
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		return formatter.format(data);
	}
	
	protected String getInformacoes(Object classe) throws IllegalArgumentException, IllegalAccessException, ParseException{
		 Field[] fields = classe.getClass().getDeclaredFields();
		 StringBuilder texto = new StringBuilder();
		    for (Field field : fields) {
		    	field.setAccessible(true);
		    	String fieldValue = field.get(classe) != null ? field.get(classe).toString() : null;
		    	if(fieldValue != null && !fieldValue.contains("br.com.retropatio")){
		    		if(texto.length() > 1){
		    			if(field.getName().contains("data")){
		    				texto.append(", " + field.getName() + ": " + formataDataLongStringToDateShortString(fieldValue));
		    			}else{
		    				texto.append(", " + field.getName() + ": " + fieldValue.toString());
		    			}
		    		}
		    		else{
		    			if(field.getName().contains("data")){
		    				texto.append(field.getName() + ": " + formataDataLongStringToDateShortString(fieldValue));
		    			}else{
		    				texto.append(field.getName() + ": " + fieldValue.toString());
		    			}
		    		}
		    	}
			}
		    
		    return texto.toString();
	}
}
