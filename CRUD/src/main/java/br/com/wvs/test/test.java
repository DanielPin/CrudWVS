package br.com.wvs.test;

import br.com.wvs.controller.SenhaAntigaController;
import br.com.wvs.dao.SenhaAntigaDao;
import br.com.wvs.infra.EntityManagerProducer;
import br.com.wvs.model.SenhaAntiga;
import br.com.wvs.model.Usuario;
import org.hibernate.jpa.HibernateEntityManager;

import javax.persistence.EntityManager;
import java.util.List;

public class test {
    public static void main(String[] args) {

//		
//		 EntityManager manager = new EntityManagerProducer().createSqlServerManager();
//		  Usuario user = new Usuario(); SenhaAntiga antiga = new SenhaAntiga();
//		 
//
//
//
//        user.setNome("kim");
//        user.setEmail("benegao@gmail.com");
//        user.setSenha("123");
//        user.setLogin("kinzinho3");
//        user.setTipoUser(0);
//
//        manager.getTransaction().begin();
//        manager.persist(user);
//        manager.getTransaction().commit();
//
//        antiga.setSenhaAntiga(user.getSenha());
//        antiga.setUsuario(user);
//										
//        manager.getTransaction().begin();
//        manager.persist(antiga);
//        manager.getTransaction().commit();



        SenhaAntigaDao dao = new SenhaAntigaDao();
        SenhaAntigaController anti = new SenhaAntigaController();
        
        

        System.out.println(dao.buscaSenhaAntiga(1));
       
        
        





    }

}
