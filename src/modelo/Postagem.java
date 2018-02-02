package modelo;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Postagem {
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idpostagem;
	@Column(nullable = false)
	private String titulo;
	@Column(nullable = false)
	private String texto;
	@ManyToOne
	@JoinColumn(name = "idpostagem")
	private ArrayList<Comentario> comentarios;
	@OneToMany(mappedBy = "idtema")
	private int idtema;
	@OneToMany(mappedBy = "iduser")
	private int iduser;
	
	public Postagem(String titulo, String texto, int tema) {
		this.idtema = tema;
		this.texto = texto;
		this.titulo = titulo;
		this.comentarios = new ArrayList<Comentario>();
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public ArrayList<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(ArrayList<Comentario> comentarios) {
		this.comentarios = comentarios;
	}
}
