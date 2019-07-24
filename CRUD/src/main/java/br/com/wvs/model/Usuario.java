package br.com.wvs.model;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -4408884323966792449L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty
	@Column(unique = true)
	private String login;

	@NotEmpty
	private String senha;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String email;

	private int tipoUser;

	@Transient
	private String senhaAtual;

	@Transient
	private String senhaConf;


	public Usuario() {
	}
	
	public void senha() throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest cript = MessageDigest.getInstance("SHA-256");
		byte senhaCrip[] = cript.digest(this.senha.getBytes("UTF-8"));
		
		StringBuilder senhaHex = new StringBuilder();
		for(byte b : senhaCrip) {
			senhaHex.append(String.format("%02X", 0xFF & b));
		}
		
		this.setSenha(senhaHex.toString());
		
	}
	@Transient
	public String getSenhaConf() {
		return senhaConf;
	}

	@Transient
	public void setSenhaConf(String senhaConf) {
		this.senhaConf = senhaConf;
	}

	@Transient
	public String getSenhaAtual() {		
		return senhaAtual;
	}

	@Transient
	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTipoUser() {
		return tipoUser;
	}

	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {		
		return senha;
	}

	public void setSenha(String senha) {	
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
