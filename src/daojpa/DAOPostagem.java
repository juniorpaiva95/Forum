package daojpa;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import modelo.Postagem;

public class DAOPostagem extends DAO<Postagem>{
	
	public Postagem localizarPeloId(int id){
		try{
			Query query = manager.createQuery("SELECT p FROM Postagem p WHERE p.id = :id");
			query.setParameter("id", id);
			return (Postagem) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
	public Postagem localilzarPeloTitulo(String titulo){
		try{
			Query query = manager.createQuery("SELECT p FROM Postagem p WHERE p.titulo = :titulo");
			query.setParameter("titulo", titulo);
			return (Postagem) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
}
