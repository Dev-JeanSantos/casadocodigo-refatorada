package br.com.zup.casadocodigo.livrodetalhado;

import br.com.zup.casadocodigo.autor.Autor;

public class DetalhesAutorResponse {

	private String nome;
	private String descricao;

	public DetalhesAutorResponse(Autor entity) {
		
		nome = entity.getNome();
		descricao = entity.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
}
