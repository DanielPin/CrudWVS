package br.com.wvs.controller;

import java.util.List;

import javax.inject.Inject;


import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;

import br.com.wvs.dao.ClienteDao;
import br.com.wvs.model.Cliente;

@Controller
public class ClienteController {
	
	private ClienteDao clienteDao;
	private Result result;
	
	@Inject
	public ClienteController(ClienteDao clienteDao, Result result) {
		this.clienteDao = clienteDao;
		this.result = result;
	}
	
	public ClienteController() {};
	
	public void form() {};
	
	
	@Path("/cliente/form_att/{cliente.id}")
	public Cliente form_att(Cliente cliente) {		
		return clienteDao.find(cliente.getId());
	};
	
	
	
	public void adiciona (Cliente cliente) {
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
		result.include("sucesso","show");		
		result.redirectTo(this).lista();
	}
	

	
	public List<Cliente> busca(String nome){
		result.include("nome", nome);
		return clienteDao.busca(nome);
	}

}
