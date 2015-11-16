package br.com.retropatio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.retropatio.utilities.Utilities;


@Entity
public class Motorista {

	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Pessoa pessoa;
	
	private Date dataCadastro;
	private Date dataAcesso;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	public String getDataCadastro() {
		return Utilities.converteDataToString(dataCadastro);
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Date getDataAcesso() {
		return dataAcesso;
	}
	public void setDataAcesso(Date dataAcesso) {
		this.dataAcesso = dataAcesso;
	}
}
