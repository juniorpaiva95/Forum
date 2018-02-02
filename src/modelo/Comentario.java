package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcomentario;
	@OneToMany(mappedBy = "idpostagem")
	private int idpostagem;
	@OneToMany(mappedBy = "iduser")
	private int iduser;

}
