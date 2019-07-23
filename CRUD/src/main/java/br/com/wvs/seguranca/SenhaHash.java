package br.com.wvs.seguranca;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SenhaHash {

	public String senhaCriptografada(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest cript = MessageDigest.getInstance("SHA-256");
		byte senhaCrip[] = cript.digest(senha.getBytes("UTF-8"));
		
		StringBuilder senhaHex = new StringBuilder();
		for(byte b : senhaCrip) {
			senhaHex.append(String.format("%02X", 0xFF & b));
		}
		
		String senhacript = senhaHex.toString();
		return senhacript;
	}
}
