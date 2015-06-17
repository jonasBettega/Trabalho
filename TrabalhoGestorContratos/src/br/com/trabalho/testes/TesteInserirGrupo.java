package br.com.trabalho.testes;


import javax.persistence.EntityManager;

import br.com.trabalho.beans.Grupo;
import br.com.trabalho.jpa.EntityManagerUtil;

public class TesteInserirGrupo {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo g= new Grupo();
		g.setNome("Admistrativo");
		em.getTransaction().begin();
		em.persist(g);
		em.getTransaction().commit();
		System.out.println(" sucesso da inserção");
	}

}
