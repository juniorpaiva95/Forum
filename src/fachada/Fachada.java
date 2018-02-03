package fachada;

import daojpa.*;
import modelo.*;
import util.Utilitaries;

public class Fachada {
	private static DAOUsuario daousuario = new DAOUsuario();
	public static void inicializar(){
		DAO.abrir();
	}
	
	public static void finalizar(){
		DAO.fechar();
	}
	
	public static Usuario cadastrarUsuario(String nome, String login, String senha) 
			throws  Exception{
		DAO.iniciar();
		Usuario u = daousuario.localilzarPeloLogin(login);
		if(u != null) {
			DAO.cancelar();
			throw new Exception("Usu�rio ja cadastrado: " + nome);
		}
		u = new Usuario(login,nome,Utilitaries.makeMd5(senha));
		daousuario.persistir(u);
		
		DAO.efetivar();
		return u;
	}

	public static Usuario efetuarLogin(String login, String password) throws Exception {
		
		DAO.iniciar();
		Usuario u = daousuario.validateLogin(login, password);
//		DAO.fechar();
		return u;
	}
	
	
}
