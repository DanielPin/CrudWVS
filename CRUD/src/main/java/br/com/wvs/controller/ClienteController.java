package br.com.wvs.controller;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.IncludeParameters;
import br.com.caelum.vraptor.validator.Validator;
import br.com.wvs.dao.ClienteDao;
import br.com.wvs.model.Cliente;

@Controller
public class ClienteController {
	
	private ClienteDao clienteDao;
	private Result result;
	private Validator validator;
	
	@Inject
	public ClienteController(ClienteDao clienteDao, Result result, Validator validator) {
		this.clienteDao = clienteDao;
		this.result = result;
		this.validator = validator;
	}
	
	public ClienteController() {};
	
	public void form() {};
	
	
	@Path("/cliente/form_att/{cliente.id}")
	public Cliente form_att(Cliente cliente) {		
		return clienteDao.find(cliente.getId());
	};
	
	
	@IncludeParameters
	public void adiciona (@Valid Cliente cliente) {
		validator.onErrorRedirectTo(this).form();
		clienteDao.adiciona(cliente);
		result.redirectTo(this).lista();
	}
	
	
	@Put("/cliente/update")
	public void update(Cliente cliente) {
		clienteDao.update(cliente);
		result.redirectTo(this).lista();
	}
	
	public void lista() {
		List<Cliente> clientes = clienteDao.lista();
		result.include("clientes", clientes);
	};
	
	@Delete
	public void remove (Cliente cliente) {
		clienteDao.remove(cliente);
		result.redirectTo(this).lista();
	}
	

	
	public List<Cliente> busca(String nome){
		result.include("nome", nome);
		return clienteDao.busca(nome);
	}

}
