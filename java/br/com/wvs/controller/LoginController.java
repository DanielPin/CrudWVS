package br.com.wvs.controller;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.servlet.jsp.tagext.ValidationMessage;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Message;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
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
	private Validator validator;
	private int tipoUser;
	
	@Inject
	public LoginController(UsuarioDao usuarioDao, UsuarioLogado usuarioLogado,Result result,Validator validator){
		this.usuarioDao = usuarioDao;
		this.usuarioLogado = usuarioLogado;
		this.result = result;
		this.validator = validator;
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