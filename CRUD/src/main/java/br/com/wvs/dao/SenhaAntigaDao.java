package br.com.wvs.dao;

import br.com.wvs.infra.EntityManagerProducer;
import br.com.wvs.model.SenhaAntiga;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@RequestScoped
public class SenhaAntigaDao {

	EntityManager manager = new EntityManagerProducer().createSqlServerManager();

    @Inject
    public SenhaAntigaDao(@SqlServer  EntityManager manager) {
        this.manager = manager;
    }

    public SenhaAntigaDao(){}

    public void salvaSenhaAntiga (SenhaAntiga senhaAntiga){
        manager.getTransaction().begin();
        manager.persist(senhaAntiga);
        manager.getTransaction().commit();

    }

    public List<SenhaAntiga> buscaSenhaAntiga(int id){       
            TypedQuery<SenhaAntiga> query = manager.createQuery("select u from SenhaAntiga u where u.id = :id order by id desc", SenhaAntiga.class);
            query.setParameter("id",id);       
            query.setMaxResults(5);
        return query.getResultList();
    }

    public SenhaAntiga find(String senha){
        return manager.find(SenhaAntiga.class, senha);
    }


}
