package fachada;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;

import javax.persistence.NoResultException;

import daojpa.DAO;
import daojpa.*;
import modelo.*;

/**********************************
 * IFPB - Curso Superior de Tec. em Sist. para Internet
 * Persistencia de Objetos
 * Prof. Fausto Ayres
 *
 */

public class Fachada {
	
	private static DAOFuncionario daofuncionario = new DAOFuncionario();
	private static DAOCargo daocargo = new DAOCargo();
	private static DAOFilme daofilme = new DAOFilme();
	private static DAOSala daosala = new DAOSala();
	private static DAOSessao daosessao = new DAOSessao();
	private static DAOHorario daohorario = new DAOHorario();
	
	public static void inicializar(){
		DAO.abrir();
	}
	
	public static void finalizar(){
		DAO.fechar();
	}
}
