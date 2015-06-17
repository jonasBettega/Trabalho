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
		f.setCpf("00490803938");
		f.setEmail("jonas.bettega@gmail.com");
		f.setGrupo(grupo);
		f.setNascimento(Calendar.getInstance());
		f.setNome("Josue");
		f.setNomeUsuario("josue");
		f.setSalario(10000.00);
		f.setSenha("12345");
		f.setSetor(setor);
		em.getTransaction().begin();
		em.persist(f);
		em.getTransaction().commit();
		System.out.println(" sucesso da inserção");
		
		

	}

}
