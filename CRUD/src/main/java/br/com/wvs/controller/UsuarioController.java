package br.com.wvs.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.wvs.dao.UsuarioDao;
import br.com.wvs.model.Usuario;
import br.com.wvs.seguranca.UsuarioLogado;

@Controller
public class UsuarioController {
	private UsuarioDao usuarioDao;
	private Result result;
	private UsuarioLogado usuarioLogado;
	
	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
		this.result = result;
	}
	
	public UsuarioController() {}
	
	@Path("/usuario/trocaSenha/{usuario.id}")
	public Usuario trocaSenha(Usuario usuario) {
		return usuarioDao.find(usuario.getId());
	}

	public void formAttLog() {}
	public void formAttSenha() {}
	public void formCadUsu() {}
	public void listaUser() {
		List<Usuario> usuarios = usuarioDao.lista();
		result.include("usuarios", usuarios);				
	}
	
	
	public void adiciona (Usuario usuario) {		
		try {		
		usuarioDao.adiciona(usuario);
		result.include("addUserSucesso","USUARIO CADASTRADO COM SUCESSO");
		result.redirectTo(this).listaUser();
		}catch (Exception e) {
			result.include("login","LOGIN JÁ EXISTE, TENTE OUTRO");
			result.redirectTo(this).formCadUsu();
			
		}
	}
	
	@Delete
	public void remove(Usuario usuario) {
		usuarioDao.remove(usuario);
		result.include("sucesso","show");		
		result.redirectTo(this).listaUser();
	}
	
	@Path("/usuario/formAttUser/{usuario.id}")
	public Usuario formAttUser(Usuario usuario) {
		return usuarioDao.find(usuario.getId());
	}
	
	//Trocar senha com acesso ADM
	@Put
	public void update(Usuario usuario, String confSenha) {
		
		if(usuario.getSenha().equals(confSenha)) {			
				usuarioDao.update(usuario);
				result.include("senhaS","SENHA ATUALIZADA COM SUCESSO");
				result.redirectTo(this).listaUser();			
		}else {			
			result.include("senhaCo","AS SENHAS NÃO COINCIDEM");
			result.redirectTo(this).trocaSenha(usuario);
		}
		
	}
	
	// Att dados do usuario 
	public void updateUser(Usuario usuario) {
		try {	
			usuarioDao.update(usuario);
			result.include("attSu","USUARIO ATUALIZADO COM SUCESSO");
			result.redirectTo(this).listaUser();
			
		}catch (Exception e) {
			result.include("erroAtualizar", "LOGIN JÁ EXISTE, TENTE OUTRO");
			result.redirectTo(this).formAttUser(usuario);
		}
		
	}
	
	
	@Put
	public void updateLog(Usuario usuario) {
		try {
		
		usuarioDao.update(usuario);		
		result.include("suscessoAt", "INFORMAÇÕES ATUALIZADAS COM SUCESSO" );		
		this.usuarioLogado.fazLogin(usuario);
		result.redirectTo(this).formAttLog();
		
		}catch (Exception e) {
			result.include("erroAtt", "LOGIN JÁ EXISTE, TENTE OUTRO");
			result.redirectTo(this).formAttLog();
		}
	}
	
	
	@Put
	public void updateSenha(Usuario usuario) {
		Usuario user = usuarioDao.find(usuario.getId());
	//Compara a senha Atual com a senha salva no banco
	 if(user.getSenha().equals(usuario.getSenhaAtual())) {
		 //Caso as senhas sejam iguais verifica se a nova senha e o campo confirma senha são iguais
		 if(usuario.getSenha().equals(usuario.getSenhaConf())) {
			 usuarioDao.update(usuario);
			 result.include("senhaTrue","SENHA ATUALIZADA COM SUCESSO");
			 this.usuarioLogado.fazLogin(usuario);
			 result.redirectTo(this).formAttLog();
		 }else {
			 result.include("senhaConf","AS SENHAS NÃO COINCIDEM");
			 result.redirectTo(this).formAttSenha();
		 }
	 }else {
		 result.include("senhaFalse","SENHA ATUAL INVALIDA");
		 result.redirectTo(this).formAttSenha();
	 }
	
	}
	
	
	
}
