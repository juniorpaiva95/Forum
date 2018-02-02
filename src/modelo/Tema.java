package modelo;

import java.util.ArrayList;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Tema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idtema;
	@ManyToOne
	@JoinColumn(name = "idtema")
	private ArrayList<Postagem> postagens;

}
