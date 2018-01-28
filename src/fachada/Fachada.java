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
	
	public static Usuario cadastrarUsuario(String nome, String email, String senha) 
			throws  Exception{
		DAO.iniciar();
		Usuario u = daousuario.localilzarPeloEmail(email);
		if(u != null) {
			DAO.cancelar();
			throw new Exception("Usuário ja cadastrado: " + nome);
		}
		u = new Usuario(email,nome,Utilitaries.makeMd5("123456"));
		daousuario.persistir(u);
		
		DAO.efetivar();
		return u;
	}
}
