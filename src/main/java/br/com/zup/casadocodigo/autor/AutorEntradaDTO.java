package br.com.zup.casadocodigo.autor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.zup.casadocodigo.validations.UniqueValue;

public class AutorEntradaDTO {
	
	@NotBlank(message = "O campo nome não deve ser vazio")
	private String nome;
	@NotBlank(message = "O campo email não deve ser vazio")
	@Email(message = "Email inválido")
	@UniqueValue(domainClass = Autor.class, fieldName = "email", message = "Email já está cadastrado")
	private String email;
	@NotBlank(message = "O campo descrição não deve ser vazio")
	@Size(max = 400, message = "O campo descrição não deve ultrapasar 400 caracteres")
	private String descricao;	
	
	public AutorEntradaDTO(@NotBlank String nome, @NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor convert() {
		// TODO Auto-generated method stub
		return new Autor(this.nome, this.email, this.descricao);
	}

	public String getEmail() {
		
		return email;
	}


	
}
