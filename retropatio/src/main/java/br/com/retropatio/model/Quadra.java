package br.com.retropatio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Quadra {

	@Id @GeneratedValue
	private Long id;

	@NotNull @Size(max=2) 
	@Column(nullable = false) 
	private String letra;
	
	private int numero;
	
	private int fileira;
	
	private int altura;
	
	@OneToOne
	private TamanhoContainer tamanhoContainer;
	
	@OneToOne
	private Container container;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getFileira() {
		return fileira;
	}

	public void setFileira(int fileira) {
		this.fileira = fileira;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public TamanhoContainer getTamanhoContainer() {
		return tamanhoContainer;
	}

	public void setTamanhoContainer(TamanhoContainer tamanhoContainer) {
		this.tamanhoContainer = tamanhoContainer;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}
}
