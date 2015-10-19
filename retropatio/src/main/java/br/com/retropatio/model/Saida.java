package br.com.retropatio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Saida {

	@Id @GeneratedValue
	private Long id;

	@OneToOne
	private Motorista motorista;
	
	@OneToOne
	private Caminhao caminhao;
	
	@OneToOne
	private Container container;
	
	@OneToOne
	private Quadra quadra;
	
	private Date dataSaida;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Motorista getMotorista() {
		return motorista;
	}

	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}

	public Caminhao getCaminhao() {
		return caminhao;
	}

	public void setCaminhao(Caminhao caminhao) {
		this.caminhao = caminhao;
	}

	public Container getContainer() {
		return container;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public Quadra getQuadra() {
		return quadra;
	}

	public void setQuadra(Quadra quadra) {
		this.quadra = quadra;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
