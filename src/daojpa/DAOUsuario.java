package daojpa;

import modelo.Usuario;
import javax.persistence.*;
public class DAOUsuario extends DAO<Usuario>{
	public Usuario localilzarPeloLogin(String login){
		try{
			Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login");
			query.setParameter("login", login);
			return (Usuario) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
	
	public Usuario validateLogin(String login, String password) {
		try{
			Query query = manager.createQuery("SELECT u FROM Usuario u WHERE u.login = :login and u.password = :password");
			query.setParameter("login", login);
			query.setParameter("password", password);
			return (Usuario) query.getSingleResult();
		}catch(NoResultException e){		
			return null;
		}
	}
}
