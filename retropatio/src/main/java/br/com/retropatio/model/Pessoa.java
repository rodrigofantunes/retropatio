package br.com.retropatio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import br.com.retropatio.utilities.Utilities;

@Entity
public class Pessoa  {

	@Id @GeneratedValue private Long id;
	@NotNull @Size(min=5, max=150) private String nome;
	private Long cpf;
	private String cnh;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getCnh() {
		return cnh;
	}
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public Long getIdPessoa() {
		return id;
	}
	public void setIdPessoa(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public Long getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = Utilities.removeCaracterCPF(cpf);
	}
}
