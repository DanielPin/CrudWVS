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
	
	public void form() {}; //Cadastro de clientes
	
	public void formCpf() {}; //Verifica se já tem o cpf cadastrado antes de iniciar o cadastro
	
	//Trás os dados do cliente da base de dados para realizar a atualização dos mesmos
	@Path("/cliente/form_att/{cliente.id}")
	public Cliente form_att(Cliente cliente) {		
		return clienteDao.find(cliente.getId()); //Retorna o cliente que foi encontrado com base no ID que foi passado
	};
	
	
	// Método usado para cadastrar um novo cliente na base de dados
	public void adiciona (Cliente cliente) {
		try {
			clienteDao.adiciona(cliente);	//Passa o cliente a ser adionado no banco
			result.include("cadSu","Novo cliente cadastrado com sucesso"); //Mostra mensagem após execução da instrução
			result.redirectTo(this).lista(); //Redireciona para a pagina que lista os clientes cadastrados	
		}catch (Exception e) {
			result.include("invalido","CPF já cadastrado"); //Mostra mensagem após execução da instrução
			result.redirectTo(this).form();	//Redireciona para o formulario novamente
			
		}{
			
		}
	}
	
	// Método usado para atualizar o cliente na base de dados
	@Put("/cliente/update")
	public void update(Cliente cliente) {
		clienteDao.update(cliente); //Passa o cliente que deve ser atualizado
		result.include("attSucesso", "CLIENTE ATUALIZADO COM SUCESSO"); //Mostra mensagem após execução da instrução
		result.redirectTo(this).lista(); //Redireciona para a lista de clientes cadastrados
	}
	
	//Método usado para retornar todos os cliente cadastrados
	public void lista() {
		List<Cliente> clientes = clienteDao.lista(); //Cria uma lista de clientes retornados do banco
		result.include("clientes", clientes); //Passa o valor da variavel a ser usado na view
	};
	
	//Método usado para remover um cliente do banco
	@Delete //Anotação para informa que o metodo tera a função de deletar
	public void remove (Cliente cliente) {
		clienteDao.remove(cliente); //Passa o cliente que sera deletado do banco
		result.include("sucesso","show"); //Mostra o modal após instrução ter sido realizada		
		result.redirectTo(this).lista(); //Redireciona para a lista de clientes cadastrados
	}
	

	// Método usado para buscar no banco se o CPF já esta cadastrado
	public void busca(String cpf){		
		try {
			clienteDao.busca(cpf);	//Passa o CPF a ser buscado no banco	
			result.include("cad","CPF já cadastrado");	//Mostra mensagem após execução da instrução
			result.redirectTo(this).lista(); //Redireciona para a lista de clientes cadastardo caso o CPF esteja cadastrado no banco
			}catch (Exception e) { //Caso o CPF não exista no banco sera retornado uma exception 
				result.include("cadN","CPF não cadastrado, realize o cadastro"); //Mostra mensagem no form que sera redirecionado 
				result.redirectTo(this).form(); //Direciona para o formulario para cadastrar o cliente 
				
			} 

	}

}
