package br.com.retropatio.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Empresa {

	@Id @GeneratedValue private Long id;
	@NotNull @Size(max=60) @Column(nullable = false) private String nomeEmpresa;
	@Size(max=18) private Long cnpj;
	@ManyToOne	private Armador armador;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}
	public void setNomeEmpresa(String nome) {
		this.nomeEmpresa = nome;
	}
	public Long getCnpj() {
		return cnpj;
	}
	public void setCnpj(Long cnpj) {
		this.cnpj = cnpj;
	}
	public Armador getArmador() {
		return armador;
	}
	public void setArmador(Armador armador) {
		this.armador = armador;
	}
}
