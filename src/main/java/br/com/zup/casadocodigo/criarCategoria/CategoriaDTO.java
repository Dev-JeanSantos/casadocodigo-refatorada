package br.com.zup.casadocodigo.criarCategoria;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validations.UniqueValue;

public class CategoriaDTO {
	
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
