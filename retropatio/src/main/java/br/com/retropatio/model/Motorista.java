package br.com.retropatio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Motorista {

	@Id @GeneratedValue
	private Long id;
	
	@OneToOne
	private Pessoa pessoa;
	
	private Date dataCadastro;
	private Date dataAcesso;
	
	private String cpf;
	private String cnh;
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
	public Date getDataCadastro() {
		return dataCadastro;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	

	

}
