package br.com.retropatio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class ModeloCaminhao {

	@Id @GeneratedValue
	private Long id;

	@NotNull @Size(max=60) @Column(nullable = false) private String nomeModelo;

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}
	
}
