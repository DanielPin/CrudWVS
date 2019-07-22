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
    public void form(){ //Formulario para realização do login no sistema
    	
    }
    
	// Autenticação 
	@Open
    public void autentica(String login, String senha){  // Recebe login e senha digitados no formualário de login
    	Usuario usuario = usuarioDao.busca(login,senha); // Variavel usuario recebe usuario que o banco encontrou compativel com login e senha
    	if(usuario != null){ // Caso o retorno da variavel usuario nao seja null entra no if
    		usuarioLogado.fazLogin(usuario); //Método faz login recebe usuario encontrado no banco
    		result.redirectTo(IndexController.class).index(); //Redireciona para a pagina inicial(index) da aplicação
    	}else { // Caso o valor da variavel usuario seja null
    		result.include("erro","Login invalido"); // Prepara mensagem para ser exibida no form
    		result.redirectTo(this).form(); // Redireciona para o form de login novamente exibindo a mensagem de erro
    	}
    }
    
	// Deslogar usuario
	@Open
    public void desloga(){
    	this.usuarioLogado.desloga(); //passa o usuario que esta logado para o metodo desloga
    	result.redirectTo(this).form(); // redirecicona para a pagina de login após deslogar
    }
}