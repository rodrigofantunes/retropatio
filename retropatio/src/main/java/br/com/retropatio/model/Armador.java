package br.com.retropatio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Armador {

	@Id @GeneratedValue
	private Long id;

	@NotNull @Size(max=60) @Column(nullable = false) private String nomeArmador;

	public String getNomeArmador() {
		return nomeArmador;
	}

	public void setNomeArmador(String nomeArmador) {
		this.nomeArmador = nomeArmador;
	}
	
}
