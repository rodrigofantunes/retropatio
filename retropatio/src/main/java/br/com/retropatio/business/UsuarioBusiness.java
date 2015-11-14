package br.com.retropatio.business;

import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;

import javax.inject.Inject;

import br.com.retropatio.dao.UsuarioDao;
import br.com.retropatio.model.Pesquisa;
import br.com.retropatio.model.Usuario;
import br.com.retropatio.utilities.Utilities;


public class UsuarioBusiness extends Utilities{

	private static final long serialVersionUID = 1L;
	@Inject private UsuarioDao usuarioDao;

	protected boolean efetuarAutenticacao(Usuario usuario) throws NoSuchAlgorithmException, ParseException{
		boolean retorno = false;
		Usuario usuarioParaAutenticar = new Usuario();
		usuarioParaAutenticar = usuarioDao.autenticar(preparaUsuarioLogin(usuario));
		if( usuarioParaAutenticar != null ){
			gravaUsuarioLogado(usuarioParaAutenticar);
			retorno = true;
		}
		return retorno;
	}

	protected void cadastrarUsuario(Usuario usuario) throws NoSuchAlgorithmException{
		usuario.setEmpresa(usuarioLogado.getEmpresa());
		usuarioDao.inserir(usuario);
	}
	
	protected void alterarUsuario(Usuario usuario){
		usuarioDao.alterar(usuario);
	}
	
	protected void deletarUsuario(Long id){
		usuarioDao.deletar(usuarioDao.buscarPorId(id));
	}
	
	protected Usuario verUsuario(Long id){
		return usuarioDao.buscarPorId(id);
	}

	protected List<Usuario> pesquisaUsuario(Pesquisa pesquisa) {
		return usuarioDao.buscaUsuario(pesquisa);
	}
	
}