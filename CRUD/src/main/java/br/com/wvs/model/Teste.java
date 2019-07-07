package br.com.wvs.model;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.wvs.infra.EntityManagerProducer;

public class Teste {
	
	public static void main(String[] args) {
		EntityManager em = new EntityManagerProducer().getEntityManager();
		em.getTransaction().begin();
		
		String nome = "e";

		CriteriaBuilder criteria = em.getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteria.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		
		Path<String> nmPath = root.<String> get("nome");		
	
		
			Predicate nomeIgual = criteria.like(nmPath,"%" + nome + "%");
			query.where(nomeIgual);
		
		
		
		TypedQuery<Cliente> tQuery = em.createQuery(query);
	
		List<Cliente> resultado = 	tQuery.getResultList();
		for(Cliente cliente : resultado) {
			System.out.println("nome: " + cliente.getNome());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String jpql = "select m from Cliente m where m.nome = 'Jorge'";
//		Query query = em.createQuery(jpql);
//		
//		List <Cliente> resultado = query.getResultList();
//		
//		for (Cliente cliente : resultado) {
//			System.out.println("Nome: " + cliente.getNome());
//			System.out.println("Bairro: " + cliente.getBairro());
//			System.out.println("Cep: " + cliente.getCep());
//			System.out.println("Cidade: " + cliente.getCidade());
//			System.out.println("CPF: " + cliente.getCpf());
//			System.out.println("E-Mail: " + cliente.getEmail());
//			System.out.println("RG: " + cliente.getRg());
//			System.out.println("Rua: " + cliente.getRua());
//		}
//		
		
		em.getTransaction().commit();
		em.close();
		
	}
}
