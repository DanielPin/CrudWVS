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

	
	@Inject
	public ClienteDao(EntityManager manager ) {
		this.manager = manager;
	}
	
	public ClienteDao() {};
	
	public void adiciona (Cliente cliente) {		
		
		manager.getTransaction().begin();
		manager.persist(cliente);
		manager.getTransaction().commit();	
		
	}
	
	public void update (Cliente cliente) {
		manager.getTransaction().begin();
		manager.merge(cliente);
		manager.getTransaction().commit();
	}

	public List<Cliente> lista(){
		TypedQuery<Cliente> query = manager.createQuery("Select r from Cliente r", Cliente.class);
		return query.getResultList();
	}
	
	
	
	
	
	
	
	
	
	
	

	public Cliente busca(String cpf) {	
		manager.getTransaction().begin();
		TypedQuery<Cliente> query = manager.createQuery("select u from Cliente u where u.cpf = :cpf ",Cliente.class);
		query.setParameter("cpf",cpf);	
		manager.getTransaction().commit();
	
		return query.getSingleResult();
		
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Cliente find(int id) {
		return manager.find(Cliente.class, id);
	}


	public void remove(Cliente cliente) {
		manager.getTransaction().begin();
		cliente= find(cliente.getId());
		manager.remove(cliente);
		manager.getTransaction().commit();
		
	}
	
}
