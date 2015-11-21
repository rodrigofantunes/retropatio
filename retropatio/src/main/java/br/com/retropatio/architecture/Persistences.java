package br.com.retropatio.architecture;

import java.util.Date;

import javax.persistence.EntityManager;

import br.com.retropatio.entity.Caminhao;
import br.com.retropatio.entity.Container;
import br.com.retropatio.entity.Entrada;
import br.com.retropatio.entity.MarcaCaminhao;
import br.com.retropatio.entity.ModeloCaminhao;
import br.com.retropatio.entity.Motorista;
import br.com.retropatio.entity.Pessoa;
import br.com.retropatio.entity.Quadra;
import br.com.retropatio.entity.Saida;
import br.com.retropatio.entity.Usuario;

public class Persistences extends Querys{

	private static final long serialVersionUID = 1L;

	protected void persistMotorista(Motorista motorista, EntityManager em){
		persistPessoa(motorista.getPessoa(),em);
		em.persist(motorista);
	}
	protected void persistCaminhao(Caminhao caminhao, EntityManager em){
		persistMarcaCaminhao(caminhao.getMarca(),em);
		persistModeloCaminhao(caminhao.getModelo(),em);
		caminhao.setDataCadastro((java.sql.Date)getDataAtual());
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
		persistPessoa(usuario.getPessoa(),em);
		em.persist(usuario);
	}
	protected void persistPessoa(Pessoa pessoa, EntityManager em){
		em.persist(pessoa);
	}
	protected void persistMarcaCaminhao(MarcaCaminhao marca, EntityManager em){
		em.persist(marca);
	}
	protected void persistModeloCaminhao(ModeloCaminhao modelo, EntityManager em){
		em.persist(modelo);
	}
}
