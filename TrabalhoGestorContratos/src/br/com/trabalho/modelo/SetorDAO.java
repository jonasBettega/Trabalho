package br.com.trabalho.modelo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.trabalho.beans.Grupo;
import br.com.trabalho.beans.Setor;
import br.com.trabalho.jpa.EntityManagerUtil;
import br.com.trabalho.util.UtilErros;
import br.com.trabalho.util.UtilMensagens;

public class SetorDAO {
	
	private EntityManager em;
	
	public SetorDAO(){
		em = EntityManagerUtil.getEntityManager();
	}
	
	public List<Setor> ListarTodos(){
		return em.createQuery("from Setor order by nome").getResultList();
	}
	
	public boolean gravar(Setor obj){
		try {
			em.getTransaction().begin();
			if (obj.getId() == null){
				em.persist(obj);
			} else {
				em.merge(obj);
			}
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto persistido com sucesso!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao persistir objeto: "+
												UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public boolean excluir(Setor obj){
		try {
			em.getTransaction().begin();
			em.remove(obj);
			em.getTransaction().commit();
			UtilMensagens.mensagemInformacao("Objeto removido com sucesso!");
			return true;
		} catch (Exception e){
			if (em.getTransaction().isActive() == false){
				em.getTransaction().begin();
			}
			em.getTransaction().rollback();
			UtilMensagens.mensagemErro("Erro ao remover objeto: "+
												UtilErros.getMensagemErro(e));
			return false;
		}
	}
	
	public Setor localizar(Integer id){
		return em.find(Setor.class, id);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
}
