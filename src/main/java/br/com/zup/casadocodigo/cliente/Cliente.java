package br.com.zup.casadocodigo.cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.casadocodigo.estado.Estado;
import br.com.zup.casadocodigo.pais.Pais;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private @Email(message = "O formato do email é inválido!") @NotBlank String email;
	private @NotBlank String nome;
	private @NotBlank String sobrenome;
	private @NotBlank String documento;
	private @NotBlank String endereco;
	private @NotBlank String cidade;
	private @ManyToOne Estado estado;
	private @NotNull @ManyToOne Pais pais;
	private @NotBlank String telefone;
	private @NotBlank String cep;

	public Cliente(@Email(message = "O formato do email é inválido!") @NotBlank String email, @NotBlank String nome,
			@NotBlank String sobrenome, @NotBlank String documento, @NotBlank String endereco, @NotBlank String cidade,
			Estado estado, @NotNull Pais pais, @NotBlank String telefone, @NotBlank String cep) {
				this.email = email;
				this.nome = nome;
				this.sobrenome = sobrenome;
				this.documento = documento;
				this.endereco = endereco;
				this.cidade = cidade;
				this.estado = estado;
				this.pais = pais;
				this.telefone = telefone;
				this.cep = cep;
		
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public Pais getPais() {
		return pais;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

}
