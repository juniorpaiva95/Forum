package fachada;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import daojpa.*;
import modelo.*;
import util.Utilitaries;

public class Fachada {
	private static DAOUsuario daousuario = new DAOUsuario();
	private static DAOPostagem daopostagem = new DAOPostagem();
	private static DAOTema daotema = new DAOTema();
	private static DAOComentario daocomentario = new DAOComentario();
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
			throw new Exception("Usuï¿½rio ja cadastrado: " + nome);
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
	public static Tema cadastrarTema(String nome) throws Exception{
		DAO.iniciar();
		Tema t = daotema.localilzarPeloNome(nome);
		if(t != null){
			throw new Exception("Tema informado já cadastrado!");
		}
		t = new Tema(nome);
		daotema.persistir(t);
		DAO.efetivar();
		return t;
	}
	public static Postagem cadastrarPostagem(String titulo, String texto, String tema, Usuario usuario) throws Exception{
		DAO.iniciar();
		Postagem p = daopostagem.localilzarPeloTitulo(titulo);
		Tema t = daotema.localilzarPeloNome(tema);
		if(p != null){
			throw new Exception("Postagem " + titulo + " já cadastrada!");
		}
		if(t == null){
			throw new Exception("Tema informado não localizado!");
		}
		p  = new Postagem(titulo, texto, t, usuario);
		daopostagem.persistir(p);
		DAO.efetivar();
		return p;
	}
	
	public static Comentario cadastrarComentario(String comentario, Usuario usuario, int idpostagem) throws Exception{
		DAO.iniciar();
		Postagem p = daopostagem.localilzarPeloId(idpostagem);
		if(p == null) {
			throw new Exception("Postagem não localizada!");
		}
		Comentario c = new Comentario(comentario,usuario,p);
		daocomentario.persistir(c);
		DAO.efetivar();
		return c;
	}
	
	public static List<Tema> listarTemas() throws Exception{
		try {
			return (List<Tema>) daotema.listar();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public static List<Postagem> listarPostagens() throws Exception{
		try {
			return (List<Postagem>) daopostagem.listar();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
