package br.com.retropatio.architecture;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Failure {

	@Id @GeneratedValue
	private Long id;
	private Date dataOcorrido;
	private String Acao;
	private String informacoes;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDataOcorrido() {
		return dataOcorrido;
	}
	public void setDataOcorrido(Date dataOcorrido) {
		this.dataOcorrido = dataOcorrido;
	}
	public String getAcao() {
		return Acao;
	}
	public void setAcao(String acao) {
		Acao = acao;
	}
	public String getInformacoes() {
		return informacoes;
	}
	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}
	
	
}
