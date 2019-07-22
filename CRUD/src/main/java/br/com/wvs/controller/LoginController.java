package br.com.wvs.controller;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;


import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.wvs.dao.UsuarioDao;
import br.com.wvs.model.Usuario;
import br.com.wvs.seguranca.Open;
import br.com.wvs.seguranca.UsuarioLogado;
@Dependent
@Controller
public class LoginController {
	private UsuarioDao usuarioDao;
	private UsuarioLogado usuarioLogado;
	private Result result;

	
	@Inject
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado,Result result){
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
	
	}
	public LoginController(){}
	
	@Open
    public void form(){
    	
    }
    
	@Open
    public void autentica(String login, String senha){
    	Usuario usuario = usuarioDao.busca(login,senha);
    	if(usuario != null){
    		usuarioLogado.fazLogin(usuario);
    		result.redirectTo(IndexController.class).index();
    	}else { 
    		result.include("erro","Login invalido");
    		result.redirectTo(this).form();
    	}
    }
    
	@Open
    public void desloga(){
    	this.usuarioLogado.desloga();
    	result.redirectTo(this).form();
    }
}