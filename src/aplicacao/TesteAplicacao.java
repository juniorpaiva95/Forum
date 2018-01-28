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
		
		Fachada.inicializar();
		try { 
			System.out.println("Inicializando o sistema");
			Fachada.cadastrarUsuario("Junior","juniorpaiva3@hotmail.com","123456");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		Fachada.finalizar();
	}

}
