package modelo;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
public class Usuario extends Model{
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int iduser;
	@Column(nullable=false, unique=true)
	private String email;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String senha;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private ArrayList<Postagem> postagens;
	@ManyToOne
	@JoinColumn(name = "iduser")
	private ArrayList<Comentario> comentarios;
	
	public Usuario() {}
	
	public Usuario(String email, String nome, String senha) {
		super();
		this.email = email;
		this.nome = nome;
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}
