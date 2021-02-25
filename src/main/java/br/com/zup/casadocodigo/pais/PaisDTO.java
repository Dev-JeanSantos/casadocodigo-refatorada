package br.com.zup.casadocodigo.pais;

import javax.validation.constraints.NotBlank;

import br.com.zup.casadocodigo.validations.UniqueValue;

public class PaisDTO {
	
	@NotBlank
    @UniqueValue( domainClass = Pais.class, fieldName = "nome", message = "País já cadastrado")
    private String nome;  
	
    public String getNome() {
		return nome;
	}

	public Pais toModel() {
		return new Pais(nome);
	}

	

}
