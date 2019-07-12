package br.com.wvs.infra;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

import br.com.wvs.dao.SqlServer;

@ApplicationScoped
public class EntityManagerProducer {
	
	@PersistenceUnit(unitName = "default")
	private EntityManagerFactory factory = Persistence.createEntityManagerFactory("default");
	
	@PersistenceUnit(unitName = "SqlServer")
	private EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("SqlServer");
	
	
	@Produces
	@RequestScoped
	@Default
	public EntityManager createDefaultManager() {
		return factory.createEntityManager();
	}
	
	
	@Produces
	@RequestScoped
	@SqlServer
	public EntityManager createSqlServerManager() {
		return factory2.createEntityManager();
	}
	
	public void close (@Disposes EntityManager manager) {
		manager.close();
	}
	

}
