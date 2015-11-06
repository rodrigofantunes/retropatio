package br.com.retropatio.utilities;

import java.io.Serializable;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import javax.inject.Inject;

import br.com.retropatio.architecture.Logger;
import br.com.retropatio.model.Empresa;
import br.com.retropatio.model.Usuario;
import br.com.retropatio.session.UsuarioLogado;

public class Utilities implements Serializable, UtilStatic, Logger{

	private static final long serialVersionUID = 1L;
	@Inject protected UsuarioLogado usuarioLogado;
	
	public static String codificaSenha(String Senha) throws NoSuchAlgorithmException{
		MessageDigest m = MessageDigest.getInstance("MD5");
		m.update(Senha.getBytes(),0,Senha.length());
		return new BigInteger(1,m.digest()).toString(32);
	}
	
	public static Date getDataAtual(){
		return new Date();
	}
	
	public Usuario preparaUsuarioLogin(Usuario usuario) throws NoSuchAlgorithmException{
		usuario.setSenha(codificaSenha(usuario.getSenha()));
		return usuario;
	}
	
	public Usuario getUsuarioLogado(){
		return usuarioLogado.getUsuario();
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
	
	public boolean verificaSessaoLogada(){
			if(usuarioLogado.getUsuario() == null || !usuarioLogado.isLogado() || usuarioLogado.getEmpresa() == null){
				return false;
			}		
			return true;
	}
}
