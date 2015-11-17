package br.com.retropatio.architecture;

import javax.persistence.EntityManager;

import br.com.retropatio.model.Caminhao;
import br.com.retropatio.model.Container;
import br.com.retropatio.model.Entrada;
import br.com.retropatio.model.Motorista;
import br.com.retropatio.model.Pessoa;
import br.com.retropatio.model.Quadra;
import br.com.retropatio.model.Saida;
import br.com.retropatio.model.Usuario;

public class Persistences extends Querys{

	private static final long serialVersionUID = 1L;

	protected void persistMotorista(Motorista motorista, EntityManager em){
		persistPessoa(motorista.getPessoa(),em);
		em.persist(motorista);
	}
	protected void persistCaminhao(Caminhao caminhao, EntityManager em){
		em.persist(caminhao);
	}
	protected void persistContainer(Container container, EntityManager em){
		em.persist(container);
	}
	protected void persistQuadra(Quadra quadra, EntityManager em){
		em.persist(quadra);
	}
	protected void persistEntrada(Entrada entrada, EntityManager em){
		em.persist(entrada);
	}
	protected void persistSaida(Saida saida, EntityManager em){
		em.persist(saida);
	}
	protected void persistUsuario(Usuario usuario, EntityManager em){
		em.persist(usuario);
	}
	protected void persistPessoa(Pessoa pessoa, EntityManager em){
		em.persist(pessoa);
	}
}
