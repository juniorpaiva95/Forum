package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Tema;

public class DAOTema extends DAO<Tema> {
	public Tema localilzarPeloNome(String nome){
		try{
			Query query = manager.createQuery("SELECT t FROM Tema t WHERE t.nome = :nome");
			query.setParameter("nome", nome);
			return (Tema) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
}
