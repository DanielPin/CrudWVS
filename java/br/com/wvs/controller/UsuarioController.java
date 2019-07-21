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
	public void formCadUsu(Usuario user) {}
	public void listaUser() {
		List<Usuario> usuarios = usuarioDao.lista();
		result.include("usuarios", usuarios);				
	}
	
	
	public void adiciona (Usuario usuario) {
		Usuario user = usuario;
		try {		
		usuarioDao.adiciona(usuario);
		result.redirectTo(this).listaUser();
		}catch (Exception e) {
			result.include("login","Login já existe");
			result.redirectTo(this).formCadUsu(user);
			
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
	
	@Put
	public void update(Usuario usuario) {
		try {
		usuarioDao.update(usuario);
		result.redirectTo(this).listaUser();
		}catch (Exception e) {
			result.include("erroAtualizar", "Login já existe, tente outro");
			result.redirectTo(this).formAttUser(usuario);
			
		}
	}
	
	@Put
	public void updateLog(Usuario usuario) {
		try {
		
		usuarioDao.update(usuario);		
		result.include("suscessoAt", "Informações atualizadas com sucesso" );		
		this.usuarioLogado.fazLogin(usuario);
		result.redirectTo(this).formAttLog();
		
		}catch (Exception e) {
			result.include("erroAtt", "Login já existe, tente outro");
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
			 result.include("senhaTrue","Senha atualizada com sucesso");
			 this.usuarioLogado.fazLogin(usuario);
			 result.redirectTo(this).formAttLog();
		 }else {
			 result.include("senhaConf","As senhas não coincidem");
			 result.redirectTo(this).formAttSenha();
		 }
	 }else {
		 result.include("senhaFalse","Senha atual invalida");
		 result.redirectTo(this).formAttSenha();
	 }
	
	}
	
	
	
}
