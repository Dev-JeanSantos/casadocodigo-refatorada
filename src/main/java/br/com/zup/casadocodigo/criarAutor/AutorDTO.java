package br.com.zup.casadocodigo.criarAutor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorDTO {
	
	@NotBlank(message = "O campo nome não deve ser vazio")
	private String nome;
	@NotBlank(message = "O campo email não deve ser vazio")
	@Email(message = "Email inválido")
	private String email;
	@NotBlank(message = "O campo descrição não deve ser vazio")
	@Size(max = 400, message = "O campo descrição não deve ultrapasar 400 caracteres")
	private String descricao;
	
	
	public AutorDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}


	public Autor convert() {
		// TODO Auto-generated method stub
		return new Autor(this.nome, this.email, this.descricao);
	}
		
	
	
}
