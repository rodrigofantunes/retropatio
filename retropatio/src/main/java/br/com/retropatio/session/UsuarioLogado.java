package br.com.retropatio.session;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.retropatio.model.Empresa;
import br.com.retropatio.model.Usuario;

@SessionScoped
@Named("sessaoLogada")
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuarioLogado;
	
	public void logar(Usuario usuario ){
		this.usuarioLogado = usuario;
	}
	
	public boolean isLogado(){
		return usuarioLogado != null;
	}
	
	public void deslogar(){
		this.usuarioLogado = null;
	}
	
	public Long getPerfil(){
		return this.usuarioLogado.getPerfil().getId();
	}
	
	public String getNome(){
		return this.usuarioLogado.getPessoa().getNome();
	}
	
	public Long getIdUsuarioLogado(){
		return this.usuarioLogado.getId();
	}
	
	public Usuario getUsuario(){
		return this.usuarioLogado;
	}
	
	public Empresa getEmpresa(){
		return this.usuarioLogado.getEmpresa();
	}
	
	public Long getIdEmpresa(){
		return this.usuarioLogado.getEmpresa().getId();
	}
	
}
