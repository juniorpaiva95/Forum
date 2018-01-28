package modelo;

import javax.persistence.*;

@Entity
public class Usuario extends Model{
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String senha;
	
}
