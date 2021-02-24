package br.com.zup.casadocodigo.categoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validations.UniqueValue;

public class CategoriaEntardaDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome", message = "Nome da Categoria ja está cadastrado!")
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
}
