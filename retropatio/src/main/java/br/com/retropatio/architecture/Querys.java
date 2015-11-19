package br.com.retropatio.architecture;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.retropatio.model.Pessoa;
import br.com.retropatio.model.Usuario;
import br.com.retropatio.utilities.Utilities;

@SuppressWarnings("rawtypes")
public class Querys extends Utilities {
	
private static final long serialVersionUID = 1L;

private List<Comparable> parametro = new ArrayList<Comparable>();
private Query qry;
private int maximoResultado = 0;
private String query = "";
protected String idNomes = "", idPessoas = "", idClientes = "", idDataRetorno = "";

/**
 * M�todo monta Query
 * @param query (texto)
 * @return Querys
 */
public Querys montaQry(String query) {
    this.query = query;
    return this;
}

/**
 * M�todo adiciona parte da query, na existente
 * (identico ao metodo append do StruingBuilder)
 * @param texto
 * @return Querys
 */
public Querys append(String query) {
	this.query += " " + query + " ";
	return this;
}


/**
 * M�todo acrescenta parametros a query
 * @param parametro
 * @return Querys
 */
public Querys parametro(Comparable parametro) {
    this.parametro.add(parametro);
    return this;
}

public Querys maximoResultado(int maximo){
	this.maximoResultado = maximo;
	return this;
}

/**
 * M�todo retorna resultado da Query com ou sem parametros
 * @param em
 * @return List
 */
public List retornoLista(EntityManager em) {
    qry = em.createQuery(query);
    if(maximoResultado > 0) qry.setMaxResults(maximoResultado);
	if(parametro.size() > 0){
		verificaParametros();
		limpaParametros();
		return qry.getResultList();
	}
	limpaParametros();
    return qry.getResultList();
}

/**
 * M�todo retorna resultado unico da Query com ou sem parametros
 * @param em
 * @return List
 */
public Object retornoUnico(EntityManager em) {
    qry = em.createQuery(query);
	if(parametro.size() > 0){
		verificaParametros();
		limpaParametros();
		return qry.getSingleResult();
	}
	limpaParametros();
    return qry.getSingleResult();
}

/**
 * M�todo retorna Usuario para logon no sistema
 * @param em
 * @return Usuario
 */
public Usuario logar(EntityManager em) {
    qry = em.createQuery(query);
    if(parametro.size() > 0){
		verificaParametros();
		 limpaParametros();
		return (Usuario) qry.getSingleResult();
	}
    limpaParametros();
    return (Usuario) qry.getSingleResult();
}

/**
 * M�todo retorna id Pessoa ou id Nomes, separados por v�rgula
 * para ser usado em outra query usando IN ( )
 * @param em
 * @return String
 */
public String stringVirgula(EntityManager em) {
    qry = em.createQuery(query);
    String lista = "";
	if(parametro.size() > 0){
		verificaParametros();
	}
	List banco = qry.getResultList();
	
	for(Object p : banco){
		if(p.getClass().getName().contains("Pessoa")){
			lista += ((Pessoa) p).getIdPessoa().toString() + ",";	
		}
	}
	
	if(lista.length() > 0) lista = lista.substring (0, lista.length() - 1);
	limpaParametros();
    return lista;
}

/**
 * M�todo verifica os parametros da query
 */
private void verificaParametros() {
	int i = 1;
	for(Object param : parametro){
			if(param.getClass().toString().contains("Boolean")){
				qry.setParameter(i++, param);
				continue;
			}
			if(param.getClass().toString().contains("String")){
				qry.setParameter(i++, String.valueOf(param));
				continue;
			}
			if(param.getClass().toString().contains("Long")){
				qry.setParameter(i++, param);
				continue;
			}
			if(param.getClass().toString().contains("Integer")){
				qry.setParameter(i++, param);
				continue;
			}
		}
	}

/**
 * M�todo limpa os parametros da Query
 */
private void limpaParametros(){
	query = idPessoas = "";
	parametro.clear();
}

public void executar(EntityManager em){
	qry = em.createNativeQuery(query);
    if(maximoResultado > 0) qry.setMaxResults(maximoResultado);
	if(parametro.size() > 0){
		verificaParametros();
	}
	qry.executeUpdate();
}

}
