package br.com.zup.casadocodigo.autor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.livro.Livro;

@Entity
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank 
	private String nome;
	@NotBlank @Email
	@Column(unique = true)
	private  String email;
	@NotBlank @Size(max = 400) 
	private String descricao;
	
	private LocalDateTime momentoCriacao = LocalDateTime.now();
	
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros = new ArrayList<>();

	public Autor(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;		
	}
	
	@Deprecated
	public Autor() {
		
	}
	
	@Override
	public String toString() {
		return "Autor [id=" + id + ", nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", momentoCriacao=" + momentoCriacao + "]";
	}

	public String getNome() {
		return this.nome;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
