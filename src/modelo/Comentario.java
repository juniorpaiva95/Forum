package modelo;

import javax.persistence.*;

@Entity
public class Comentario  extends Model{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable=false)
	private String comentario;
	
	@OneToOne
	private Usuario usuario;
	@OneToOne
	private Postagem postagem;
	
	
	public Comentario() {}
	public Comentario(String comentario, Usuario usuario, Postagem postagem) {
		super();
		this.comentario = comentario;
		this.usuario = usuario;
		this.postagem = postagem;
	}
	private String getComentario() {
		return comentario;
	}
	private void setComentario(String comentario) {
		this.comentario = comentario;
	}
	private Usuario getUsuario() {
		return usuario;
	}
	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	private Postagem getPostagem() {
		return postagem;
	}
	private void setPostagem(Postagem postagem) {
		this.postagem = postagem;
	}
	
}
