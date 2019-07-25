package br.com.wvs.dao;

import java.util.List;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


import br.com.wvs.model.Usuario;



@RequestScoped
public class UsuarioDao {
	private EntityManager manager;
	
	// Construtor com as variáveis
	@Inject
	public UsuarioDao(@SqlServer EntityManager manager){
		this.manager = manager;
	}
	
	// Construtor vazio
	public UsuarioDao(){}
	
	//Método para adiconar novo usuario no banco(usuario para realizar login)
	public void adiciona(Usuario usuario) { // Recebe o usuário que será cadastardo
		manager.getTransaction().begin(); // Inicia transação para adicionar usuário no banco
		manager.persist(usuario); // Adiciona usuário no banco
		manager.getTransaction().commit(); // Indica o fim da transação
		
	}


	// Método para buscar usurio, para realização de validação de dados
	public Usuario busca(String login, String senha) { // Recebe login e senha para serem localizados no banco
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :login AND u.senha = :senha ",Usuario.class); // Criação da query para buscar usuario com login e senha iguais com base na classe usuario
		query.setParameter("login",login); // Parametro para realizar busca na query
		query.setParameter("senha",senha); // Parametro para realizar busca na query
		try {
		return query.getSingleResult(); // Retorna um único resultado
		}catch (Exception e) {	// Caso não encontre um usuário com login e senha iguais ele retornará uma exception
            return null; // Retorna nulo
		}
	}
	
	
	//Método usadao para listar o usuarios registrados no banco
	public List<Usuario> lista() {
		TypedQuery<Usuario> query = manager.createQuery("select r from Usuario r", Usuario.class); // Criação da query para pegar todos os usuários cadastrados com base na classe Usuario
		return query.getResultList(); //Retona uma lista de resultados
	}
	
	//Método para localizar a chave primaria passada
	public Usuario find(int id) { // Recebe o id para realização da busca
		return manager.find(Usuario.class, id); // Retorna o usuário encontrado com base no id
	}

	//Método usado para remover usuario
	public void remove(Usuario usuario) { // Recebe usuário que será removido
		manager.getTransaction().begin(); // Incia transação para remover usuário
		usuario = find(usuario.getId()); // Procura o usuario informado pelo id e armazena na variavel usuario
		manager.remove(usuario); // Remove o usuario do banco
		manager.getTransaction().commit(); // Indica o fim da transação
	}

	//Método para atualizar um usuário
	public void update(Usuario usuario) { // Recebe usuário que será atualiazado
		manager.getTransaction().begin(); // Inicia transação para atualizar usuário
		manager.merge(usuario); // Atualiza usuário
		manager.getTransaction().commit(); // Indica o fim da transação
	}
}
