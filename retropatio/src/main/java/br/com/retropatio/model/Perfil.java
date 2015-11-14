package br.com.retropatio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Perfil {

	@Id @GeneratedValue
	private Long id;
	
	private boolean acessoConsulta;
	private boolean acessoCadastro;
	private boolean acessoConfiguracao;
	private boolean acessoEntrada;
	private boolean acessoSaida;
	private boolean acessoRelatorio;

	@NotNull @Size(max=60) @Column(nullable = false) private String nome;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAcessoConsulta() {
		return acessoConsulta;
	}
	public void setAcessoConsulta(boolean acessoConsulta) {
		this.acessoConsulta = acessoConsulta;
	}
	public boolean isAcessoCadastro() {
		return acessoCadastro;
	}
	public void setAcessoCadastro(boolean acessoCadastro) {
		this.acessoCadastro = acessoCadastro;
	}
	public boolean isAcessoConfiguracao() {
		return acessoConfiguracao;
	}
	public void setAcessoConfiguracao(boolean acessoConfiguracao) {
		this.acessoConfiguracao = acessoConfiguracao;
	}
	public boolean isAcessoEntrada() {
		return acessoEntrada;
	}
	public void setAcessoEntrada(boolean acessoEntrada) {
		this.acessoEntrada = acessoEntrada;
	}
	public boolean isAcessoSaida() {
		return acessoSaida;
	}
	public void setAcessoSaida(boolean acessoSaida) {
		this.acessoSaida = acessoSaida;
	}
	public boolean isAcessoRelatorio() {
		return acessoRelatorio;
	}
	public void setAcessoRelatorio(boolean acessoRelatorio) {
		this.acessoRelatorio = acessoRelatorio;
	}

}
