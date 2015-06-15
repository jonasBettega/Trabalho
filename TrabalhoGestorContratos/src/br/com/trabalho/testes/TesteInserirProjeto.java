package br.com.trabalho.testes;

import java.util.Calendar;

import javax.persistence.EntityManager;


import br.com.trabalho.beans.Funcionario;
import br.com.trabalho.beans.Projeto;
import br.com.trabalho.beans.ProjetoFuncionario;
import br.com.trabalho.beans.Setor;
import br.com.trabalho.jpa.EntityManagerUtil;

public class TesteInserirProjeto {

	public static void main(String[] args) {
		EntityManager em = EntityManagerUtil.getEntityManager();
		Setor setor = em.find(Setor.class, 1);
		Funcionario func = em.find(Funcionario.class, 1);
		Projeto projeto = new Projeto();
		projeto.setAtivo(true);
		projeto.setDescricao("Meu novo projeto com Contratos");
		projeto.setFim(Calendar.getInstance());
		projeto.setInicio(Calendar.getInstance());
		projeto.setNome("Sistema de funcionario");
		projeto.setSetor(setor);
		ProjetoFuncionario pf = new ProjetoFuncionario();
		pf.setCargahoraria(100);
		pf.setFimparticipacao(Calendar.getInstance());
		pf.setFuncionario(func);
		pf.setGestor(true);
		pf.setInicioParticipacao(Calendar.getInstance());
		projeto.adicionarFuncionario(pf);
		em.getTransaction().begin();
		em.persist(projeto);
		em.getTransaction().commit();
	}
}

