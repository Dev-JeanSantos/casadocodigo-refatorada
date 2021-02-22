package br.com.zup.casadocodigo.criarCategoria;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {
	
	@NotBlank
	private String nome;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		// TODO Auto-generated method stub
		return nome;
	}
	
}
