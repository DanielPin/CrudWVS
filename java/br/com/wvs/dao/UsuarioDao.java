package br.com.wvs.dao;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.wvs.model.Cliente;
import br.com.wvs.model.Usuario;



@RequestScoped
public class UsuarioDao {
	private EntityManager manager;
	
	@Inject
	public UsuarioDao(@SqlServer EntityManager manager){
		this.manager = manager;
	}
	
	public UsuarioDao(){}
	
	//Método para adiconar noco usuario no banco(usuario para realizar login)
	public void adiciona(Usuario usuario) {
		manager.getTransaction().begin();
		manager.persist(usuario);
		manager.getTransaction().commit();
		
	}


	// Método para buscar usurio, para realização de validação de dados
	public Usuario busca(String login, String senha) {
		TypedQuery<Usuario> query = manager.createQuery("select u from Usuario u where u.login = :login AND u.senha = :senha ",Usuario.class);
		query.setParameter("login",login);
		query.setParameter("senha",senha);
		try {
		return query.getSingleResult();
		}catch (Exception e) {
			e.printStackTrace();
            return null;
		}
	}
	
	
	//Método usadao para listar o usuarios registrados no banco para exibição
	public List<Usuario> lista() {
		TypedQuery<Usuario> query = manager.createQuery("select r from Usuario r", Usuario.class);
		return query.getResultList();
	}
	
	//Método para localizar a chave primaria passada
	public Usuario find(int id) {
		return manager.find(Usuario.class, id);
	}

	//Método usado para remover usuario encontrado no metodo find
	public void remove(Usuario usuario) {
		manager.getTransaction().begin();
		usuario = find(usuario.getId());
		manager.remove(usuario);
		manager.getTransaction().commit();
	}

	public void update(Usuario usuario) {
		manager.getTransaction().begin();
		manager.merge(usuario);
		manager.getTransaction().commit();
	}
}
