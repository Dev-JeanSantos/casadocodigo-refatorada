package br.com.zup.casadocodigo.cliente;

import java.util.List;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;
import br.com.zup.casadocodigo.validations.CnpjCPF;
import br.com.zup.casadocodigo.validations.UniqueValue;

public class ClienteDTO {

	@Email(message = "O formato do email é inválido!")
	@NotBlank
	 @UniqueValue(domainClass = Cliente.class, fieldName = "email", message =
	 "Email já cadastrado")
	private String email;
	@NotBlank
	private String nome;
	@NotBlank
	private String sobrenome;
	@NotBlank
	@CnpjCPF()
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento", message = "Documento já cadastrado")
	private String documento;
	@NotBlank
	private String endereco;
	@NotBlank
	private String complemento;
	@NotBlank
	private String cidade;
	@NotNull
	private Long idPais;
	private Long idEstado;
	@NotBlank
	private String telefone;
	@NotBlank
	private String cep;

	public ClienteDTO(@Email @NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank Long idPais, Long idEstado, @NotBlank String telefone,
			@NotBlank String cep) {
		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento.replaceAll("[^\\d]", "");;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.idPais = idPais;
		this.idEstado = idEstado;
		this.telefone = telefone;
		this.cep = cep;
	}

	@Override
	public String toString() {
		return "ClienteDTO [email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome + ", documento=" + documento
				+ ", endereco=" + endereco + ", complemento=" + complemento + ", cidade=" + cidade + ", idPais="
				+ idPais + ", idEstado=" + idEstado + ", telefone=" + telefone + ", cep=" + cep + "]";
	}

	public boolean estadoTaNoPais(List<Estado> estadosPais) {
		for (Estado estado : estadosPais) {
			if (estado.getId() == this.getIdEstado()) {
				return true;
			}
		}
		return false;
	}

	public Cliente saveAs(EntityManager manager) {
		
		@NotNull
		Pais pais = manager.find(Pais.class, this.getIdPais());
		Estado estado = null;
		
		if(this.getIdEstado() != null) {
			
			estado = manager.find(Estado.class, this.getIdEstado());
		}
		
		
		return new Cliente(email, nome, sobrenome, documento, endereco, cidade, estado, pais, telefone, cep);
	}

	public Long getIdPais() {
		return idPais;
	}

	public Long getIdEstado() {
		return idEstado;
	}
	
	
}