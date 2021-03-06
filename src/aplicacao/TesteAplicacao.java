package aplicacao;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import daojpa.*;
import fachada.Fachada;
import modelo.*;
import util.Utilitaries;

public class TesteAplicacao {
	protected static EntityManager manager;
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fDataEHora = new SimpleDateFormat("dd/MM/yyyy H:m:s");
		DAOUsuario daousuario = new DAOUsuario();
		DAOPostagem daopostagem = new DAOPostagem();
		Fachada.inicializar();
		try { 
			System.out.println("Inicializando o sistema");
//			Fachada.cadastrarTema("TEMA 2");
//			Fachada.cadastrarTema("TEMA 1");
//			for (Tema tema : Fachada.listarTemas()) {
//				System.out.println(tema.getNome());
//			}
//			Fachada.cadastrarUsuario("Junior","juniorpaiva95","123456");
//			Usuario u = daousuario.localilzarPeloLogin("juniorpaiva95");
//			Fachada.cadastrarTema("TEMA 2");
//			Fachada.cadastrarPostagem("Titulo 3", "Segundo Post", "TEMA 2", u);
			Postagem p = daopostagem.localizarPeloId(1);
			System.out.println(p.getComentarios().size());
//			Fachada.cadastrarComentario("Comentario 1", u, 1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
	}

}
