package br.com.retropatio.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Caminhao {

	@Id @GeneratedValue
	private Long id;

	private String placa1;
	private String placa2;
	
	@OneToOne
	private Empresa empresa;
	
	@OneToOne
	private MarcaCaminhao marca;
	
	@OneToOne
	private ModeloCaminhao modelo;
	
	private Date dataCadastro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca1() {
		return placa1;
	}

	public void setPlaca1(String placa1) {
		this.placa1 = placa1;
	}

	public String getPlaca2() {
		return placa2;
	}

	public void setPlaca2(String placa2) {
		this.placa2 = placa2;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public MarcaCaminhao getMarca() {
		return marca;
	}

	public void setMarca(MarcaCaminhao marca) {
		this.marca = marca;
	}

	public ModeloCaminhao getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCaminhao modelo) {
		this.modelo = modelo;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
}
