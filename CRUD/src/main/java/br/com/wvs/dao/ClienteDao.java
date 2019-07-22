 	package br.com.wvs.dao;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;




import br.com.wvs.model.Cliente;


@RequestScoped
public class ClienteDao {
	
	private EntityManager manager;

	//Construtor com as variáveis
	@Inject
	public ClienteDao(EntityManager manager ) {
		this.manager = manager;
	}
	
	//Construtor vazio
	public ClienteDao() {};
	
	// Método que adicona os dados do  cliente no banco
	public void adiciona (Cliente cliente) { // Recebe os dados do cliente			
		manager.getTransaction().begin(); // Inicia transação para inserção dos dados
		manager.persist(cliente); // Adiciona os dados do cliente no banco 
		manager.getTransaction().commit();	// Indica o fim da transação		
	}
	
	// Atualiza os dados de um cliente
	public void update (Cliente cliente) { // Recebe os dados do cliente		
		manager.getTransaction().begin(); // Inicia transação para atualização dos dados
		manager.merge(cliente); // Atualiza os dados do cliente no banco
		manager.getTransaction().commit(); // Indica o fim da transação
	}

	// Pega todos os usuários cadastrados no banco
	public List<Cliente> lista(){ 
		TypedQuery<Cliente> query = manager.createQuery("Select r from Cliente r", Cliente.class); // Query para fazer a consulta no banco de dados e inserir em uma lista
		return query.getResultList(); // Retorna os resultados em forma de uma lista
	}

	// Fazer a busca de CPF no banco
	public Cliente busca(String cpf) {	// Recebe o numero do cpf a ser consultado
		manager.getTransaction().begin(); // Inicia transação para realização da busca do cpf
		TypedQuery<Cliente> query = manager.createQuery("select u from Cliente u where u.cpf = :cpf ",Cliente.class); // Query para fazer a busca do cpf no banco de dados
		query.setParameter("cpf",cpf);	// Parametros para realização da query (where)
		manager.getTransaction().commit(); // Indica o fim da transação	
		return query.getSingleResult(); // Retorna um único resultado		
	}	

	// Método para encontrar um cliente com base no id
	public Cliente find(int id) { //Recebe o id
		return manager.find(Cliente.class, id); // Passa a classe e a variavel que será consultado
	}

	//Método para remover um usuário do banco
	public void remove(Cliente cliente) { // Recebe o cliente que será removido
		manager.getTransaction().begin(); // Inicia transação para remover um cliente
		cliente= find(cliente.getId()); // Procura o cliente com base no id e armazena na variavel cliente
		manager.remove(cliente); // Deleta o cliente
		manager.getTransaction().commit(); // Indica o fim da transação	
		
	}
	
}
