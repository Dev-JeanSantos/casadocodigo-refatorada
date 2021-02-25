package br.com.zup.casadocodigo.estado;

import javax.persistence.EntityManager;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.Assert;

import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.validations.ExistsId;
import br.com.zup.casadocodigo.validations.UniqueValue;

public class EstadoDTO {
	
	@NotBlank
    @UniqueValue(domainClass = Estado.class, fieldName = "nome", message = "Estado já cadastrado")
    private String nome;
    @NotNull
    @ExistsId(domainClass = Estado.class, fieldName = "id", message = "Estado já cadastrado")
    private Long paisId;
	
    @Deprecated
    public EstadoDTO() {
		
	}

	public EstadoDTO(@NotBlank String nome, @NotNull Long paisId) {
		this.nome = nome;
		this.paisId = paisId;
	}

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}

	public Estado toModel(EntityManager manager) {
		
		@NotNull Pais pais = manager.find(Pais.class,this.paisId);

        Assert.state(pais!=null, "O País informado não existe. id:"+this.paisId);

        return new Estado(this.nome,pais);
	}   
}
