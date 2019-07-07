 	package br.com.wvs.dao;

import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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

	public List<Cliente> busca(String nome) {	
		manager.getTransaction().begin();
		
		CriteriaBuilder criteria = manager.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		
		Path<String> nmPath = root.<String>get("nome");		

			Predicate nomeIgual = criteria.like(nmPath,"%" + nome + "%");
			query.where(nomeIgual);

		TypedQuery<Cliente> tQuery = manager.createQuery(query);
		manager.getTransaction().commit();
		
		return tQuery.getResultList();			
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
