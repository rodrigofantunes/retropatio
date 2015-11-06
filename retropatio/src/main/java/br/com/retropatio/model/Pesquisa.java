package br.com.retropatio.model;

public class Pesquisa {

	private String nome;
	private String texto;
	private String tipoPesquisa;
	private boolean ativos;
	private boolean inativos;
	private boolean preCadastrados;
	private boolean semRegistro;
	private boolean validaPesquisa;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public String getTipoPesquisa() {
		return tipoPesquisa;
	}
	public void setTipoPesquisa(String tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}
	public boolean isAtivos() {
		return ativos;
	}
	public void setAtivos(boolean ativos) {
		this.ativos = ativos;
	}
	public boolean isInativos() {
		return inativos;
	}
	public void setInativos(boolean inativos) {
		this.inativos = inativos;
	}
	public boolean isPreCadastrados() {
		return preCadastrados;
	}
	public void setPreCadastrados(boolean preCadastrados) {
		this.preCadastrados = preCadastrados;
	}
	public boolean isSemRegistro() {
		return semRegistro;
	}
	public void setSemRegistro(boolean semRegistro) {
		this.semRegistro = semRegistro;
	}
	public boolean isValidaPesquisa() {
		return validaPesquisa;
	}
	public void setValidaPesquisa(boolean validaPesquisa) {
		this.validaPesquisa = validaPesquisa;
	}
	
}
