package br.com.trabalho.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;

import br.com.trabalho.beans.Funcionario;
import br.com.trabalho.beans.Grupo;
import br.com.trabalho.beans.Setor;
import br.com.trabalho.jpa.EntityManagerUtil;

public class TesteInserirFuncionario {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Grupo grupo = em.find(Grupo.class, 1);
		Setor setor = em.find(Setor.class, 1);
		Funcionario f=new Funcionario();
		f.setAtivo(true);
		f.setCpf("853.420.278-88");
		f.setEmail("xaxa@gmail.com");
		f.setGrupo(grupo);
		f.setNascimento(Calendar.getInstance());
		f.setNome("Jeca");
		f.setNomeUsuario("xuxa");
		f.setSalario(10000.00);
		f.setSenha("1234566");
		f.setSetor(setor);
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		System.out.println(" sucesso da inserção");
		
		

	}

}
