package br.com.wvs.seguranca;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.com.wvs.model.Usuario;



@Named
@SessionScoped
public class UsuarioLogado implements Serializable{

	private static final long serialVersionUID = -6649846404932418640L;
	private Usuario usuario;


	public void fazLogin(Usuario usuario){
		this.usuario = usuario;
	
	}
	
	public String getNome() {
		return usuario.getNome();
	}
	
	public String getEmail() {
		return usuario.getEmail();
	}
	
	
	public String getLogin() {
		return usuario.getLogin();
	}
	
	public String getSenha() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		return usuario.getSenha();
	}
	
	public int getTipoUser() {
		return usuario.getTipoUser();
	}
	
	public int getId() {
		return usuario.getId();
	}
	
	public void desloga(){
		this.usuario = null;
	}
	
	public boolean isLogado(){
		try {
		if(usuario.getTipoUser() == 1) {
			return true;
		}else {
			return false;
		}
		}catch (NullPointerException e) {			
			return false;
		}
	}
	
	
	public boolean isLogado2(){
		try {
		if(usuario.getTipoUser() == 0) {
			return true;
		}else {
			return false;
		}
		}catch (NullPointerException e) {			
			return false;
		}
	}
}
