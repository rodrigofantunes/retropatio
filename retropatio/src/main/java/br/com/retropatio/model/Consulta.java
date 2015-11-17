package br.com.retropatio.model;

import java.util.Date;

import javax.persistence.OneToOne;

public class Consulta {

	private String dataInicial;
	private String dataFinal;
	private int tipoPesquisa;
	
	@OneToOne
	private Motorista motorista;
	
	@OneToOne
	private Caminhao caminhao;
	
	@OneToOne
	private Container container;
	
	@OneToOne
	private Quadra quadra;
	
	private Date dataEntrada;
	private Date dataSaida;
	
	
	public String getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(String dataInicial) {
		this.dataInicial = dataInicial;
	}
	public String getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(String dataFinal) {
		this.dataFinal = dataFinal;
	}
	public int getTipoPesquisa() {
		return tipoPesquisa;
	}
	public void setTipoPesquisa(int tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
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
	public Date getDataEntrada() {
		return dataEntrada;
	}
	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}
	public Date getDataSaida() {
		return dataSaida;
	}
	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}
	
	
}
