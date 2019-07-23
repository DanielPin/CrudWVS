package br.com.wvs.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.wvs.dao.UsuarioDao;
import br.com.wvs.model.Usuario;
import br.com.wvs.seguranca.Open;
import br.com.wvs.seguranca.SenhaHash;
import br.com.wvs.seguranca.UsuarioLogado;

@Controller
public class UsuarioController {
	private UsuarioDao usuarioDao;
	private Result result;
	private UsuarioLogado usuarioLogado;
	
	// Construtor com variáveis
	@Inject
	public UsuarioController(UsuarioDao usuarioDao, Result result, UsuarioLogado usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
		this.usuarioDao = usuarioDao;
		this.result = result;
	}
	
	// Construtor vazio
	public UsuarioController() {}
	
	// Trocar senha ( como administrador )
	@Path("/usuario/trocaSenha/{usuario.id}")
	public Usuario trocaSenha(Usuario usuario) { // Recebe o usuario que irá ter a senha alterada
		return usuarioDao.find(usuario.getId()); // Procura o usuario com base no ID
	}
	
	public void formAttLog() {} // Formulário para atualização de usuário que esta logado no sistema
	public void formAttSenha() {} // Formulário para alterar senha de usuário que está logado no sistema
	public void formCadUsu() {} // Formlário para cadastro de novos usuário de acesso ao sistema
	
	// Lista todos os usuário que tem acesso ao sistema
	
	public void listaUser() { 
		List<Usuario> usuarios = usuarioDao.lista(); // Busca todos os usuários cadastrados e armazena na lista usuarios
		result.include("usuarios", usuarios);		// Informa a variavel que sera usada no jsp		
	}

	// Adiciona um novo usuario no banco
	public void adiciona (Usuario usuario) {			
		try {		
			usuario.senha();	
			usuarioDao.adiciona(usuario); // Informa o usuário para o método adicionar o mesmo no banco
			result.include("addUserSucesso","USUARIO CADASTRADO COM SUCESSO"); // Prepara mensagem para ser exibi na lista de usuários
			result.redirectTo(this).listaUser(); // Redireciona para a lista de usuários cadastrados
		}catch (Exception e) { // Caso altere o login e ele já esteja cadastrado no banco a resposta será uma exception
			result.include("login","LOGIN JÁ EXISTE, TENTE OUTRO"); //Prepara mensagem de erro para ser exibir no formulario de cadastro
			result.redirectTo(this).formCadUsu(); // Redireciona para o formulário de cadastro
			
		}
	}
	
	// Remove um usuário do banco
	@Delete
	public void remove(Usuario usuario) { // Recebe o usuario que será deletado
		usuarioDao.remove(usuario); // Passa o usuário que deverá ser deletado do banco
		result.include("sucesso","show"); // Informa para o modal que ele deve aparecer		
		result.redirectTo(this).listaUser(); // Redireciona para a lista de usuários
	}
	
	// Atualiza um usuário (como Administrador)
	@Path("/usuario/formAttUser/{usuario.id}") // recebe ID do usuário
	public Usuario formAttUser(Usuario usuario) { // Recebe o usuario que será atualizado ( Exibir dados no form de att )
		return usuarioDao.find(usuario.getId()); // Procura o usuario para ser atualizado com base no ID
	}
	
	//Trocar senha ( como ADM )
	@Put
	public void update(Usuario usuario, String confSenha) throws NoSuchAlgorithmException, UnsupportedEncodingException { //Recebe o usuário com a nova senha , e recebe a confirmação da nova senha
		SenhaHash senhaC = new SenhaHash();
		String s = senhaC.senhaCriptografada(confSenha);
		
		if(usuario.getSenha().equals(s)) {	// Caso o valor das duas senhas sejam iguais entra no if		
			usuarioDao.update(usuario); // Envia os dados para o metodo que irá realizar a atualização 
			result.include("senhaS","SENHA ATUALIZADA COM SUCESSO"); // Prepara mensagem para ser exibida na lista de usuários
			result.redirectTo(this).listaUser(); // Redireciona para a lista de usuários			
		}else {	// Caso as senhas não sejam iguais		
			result.include("senhaCo","AS SENHAS NÃO COINCIDEM"); // Prepara mensagem para ser exibida na tela de troca de senha
			result.redirectTo(this).trocaSenha(usuario); // Redireciona para a troca de senha 
		}
		
	}
	
	// Atualizar dados do usuário
	public void updateUser(Usuario usuario) { // recebe usuário que será atualizado
		try {	
			usuarioDao.update(usuario); // Envia os dados para o metodo que irá realizar a atualização 
			result.include("attSu","USUARIO ATUALIZADO COM SUCESSO"); // Prepara mensagem para ser exibida na lista de usuários
			result.redirectTo(this).listaUser(); // Redireciona para a lista de usuários
			
		}catch (Exception e) { // Caso altere o login e ele já esteja cadastrado no banco a resposta será uma exception
			result.include("erroAtualizar", "LOGIN JÁ EXISTE, TENTE OUTRO"); // Prepara mensagem para ser exibida no formulário de atualização de usuarios
			result.redirectTo(this).formAttUser(usuario); // Redireciona para formulário de atualização de usuários
		}		
	}
	
	// Atualiza usuário que esteja logado
	@Put
	public void updateLog(Usuario usuario) { // Recebe o usuário que esta atualmente logado
		try {				
			usuarioDao.update(usuario);	// Envia os dados para o metodo que irá realizar a atualização 	
			result.include("suscessoAt", "INFORMAÇÕES ATUALIZADAS COM SUCESSO" ); // Prepara mensagem para ser exibida no formulário de atualização do usuário logado		
			this.usuarioLogado.fazLogin(usuario); // Faz novo login passando os novos dados do usuários
			result.redirectTo(this).formAttLog(); // Redireciona para o formulário de atualização do usuário logado		
		}catch (Exception e) {
			result.include("erroAtt", "LOGIN JÁ EXISTE, TENTE OUTRO"); // Prepara mensagem para ser exibida no formulário de atualização de usuarios
			result.redirectTo(this).formAttLog(); // Redireciona para formulário de atualização de usuário logado
		}
	}
	
	// Atualizar senha do usuário que está logado
	@Put
	public void updateSenha(Usuario usuario) throws NoSuchAlgorithmException, UnsupportedEncodingException { // Recebe os dados do usuário que está logado
		Usuario user = usuarioDao.find(usuario.getId()); // Procura os dados do usuário logado no banco
		SenhaHash senhaC = new SenhaHash();
		usuario.setSenhaConf(senhaC.senhaCriptografada(usuario.getSenhaConf()));
		usuario.setSenhaAtual(senhaC.senhaCriptografada(usuario.getSenhaAtual()));
		usuario.setSenha(senhaC.senhaCriptografada(usuario.getSenha()));
	//Compara a senha Atual com a senha salva no banco
	 if(user.getSenha().equals(usuario.getSenhaAtual())) {
		 //Caso as senhas sejam iguais verifica se a nova senha e o campo confirma senha são iguais
		 if(usuario.getSenha().equals(usuario.getSenhaConf())) {
			 usuarioDao.update(usuario); // Envia os dados para o metodo que irá realizar a atualização 
			 result.include("senhaTrue","SENHA ATUALIZADA COM SUCESSO"); // Prepara mensagem para ser exibida no formulário de atualização de usuarios
			 this.usuarioLogado.fazLogin(usuario); // Faz novo login passando os novos dados do usuários
			 result.redirectTo(this).formAttLog(); // Redireicona para o formulário de atualização de usuário logado
		 }else { // Caso a nova senha e a confirma senha não sejam iguais
			 result.include("senhaConf","AS SENHAS NÃO COINCIDEM"); // Prepara mensagem para se exibida no formulário de atualizar senha
			 result.redirectTo(this).formAttSenha(); // Redireciona para o formulário de atualização de senha
		 }
	 }else { // Caso a Senha atual não seja igual ah que esteja salva no banco
		 result.include("senhaFalse","SENHA ATUAL INVALIDA"); // Prepara mensagem para se exibida no formulário de atualizar senha
		 result.redirectTo(this).formAttSenha(); // Redireciona para o formulário de atualização de senha
	 }
	
	}
	
	
	
}
