package br.com.retropatio.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Container {

	@Id @GeneratedValue
	private Long id;

	@NotNull @Size(max=60) @Column(nullable = false) private String numero;
	
	@OneToOne
	private ModeloContainer modelo;
	
	@OneToOne
	private Armador armador;
	
	@OneToOne
	private TamanhoContainer tamanho;
	
	private Date dataCadastro;
	
	private String cor;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	public ModeloContainer getModelo() {
		return modelo;
	}

	public void setModelo(ModeloContainer modelo) {
		this.modelo = modelo;
	}

	public Armador getArmador() {
		return armador;
	}

	public void setArmador(Armador armador) {
		this.armador = armador;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public TamanhoContainer getTamanho() {
		return tamanho;
	}

	public void setTamanho(TamanhoContainer tamanho) {
		this.tamanho = tamanho;
	}
	
}
