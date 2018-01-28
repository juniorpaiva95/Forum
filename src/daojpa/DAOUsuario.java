package daojpa;

import modelo.Usuario;
import javax.persistence.*;
public class DAOUsuario extends DAO<Usuario>{
	public Usuario localilzarPeloEmail(String email){
		try{
			Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.email = :email");
			query.setParameter("email", email);
			return (Usuario) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
}
