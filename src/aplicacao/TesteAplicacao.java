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

public class TesteAplicacao {
	protected static EntityManager manager;
	public static void main(String[] args) {
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat fDataEHora = new SimpleDateFormat("dd/MM/yyyy H:m:s");
		
		Fachada.inicializar();
		try { 
			
		} catch (Exception e) {
			System.out.println("OI");
			System.out.println(e.getMessage());
		}
		
	}

}
