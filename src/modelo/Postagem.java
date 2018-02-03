package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Postagem extends Model{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false, unique=true)
	private String titulo;
	@Column(nullable=false,columnDefinition="LONGTEXT")
//	@Lob
	private String texto;
	
	@ManyToOne
	private Tema tema;
	
	@ManyToOne
	private Usuario usuario;
	
	public Postagem() {}
	public Postagem(String titulo, String texto, Tema tema, Usuario usuario) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.tema = tema;
		this.usuario = usuario;
	}
	private int getId() {
		return id;
	}

	private void setId(int id) {
		this.id = id;
	}

	private String getTitulo() {
		return titulo;
	}

	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	private String getTexto() {
		return texto;
	}

	private void setTexto(String texto) {
		this.texto = texto;
	}

	private Tema getTema() {
		return tema;
	}

	private void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
