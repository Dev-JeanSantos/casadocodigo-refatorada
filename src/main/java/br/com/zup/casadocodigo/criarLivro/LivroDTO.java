package br.com.zup.casadocodigo.criarLivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.casadocodigo.criarAutor.Autor;
import br.com.zup.casadocodigo.criarCategoria.Categoria;
import br.com.zup.casadocodigo.validations.ExistsId;
import br.com.zup.casadocodigo.validations.UniqueValue;

public class LivroDTO {
	
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo", message = "Esse titulo já existe")
	private String titulo;
	@NotBlank
	@Size(max = 500)
	private String resumo;
	@NotBlank
	private String sumario;
	@NotNull
	@Min(20)
	private BigDecimal preco ;
	@Min(20)
	private int numeroPaginas;
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn", message = "Esse ISBN já existe" )
	private String isbn;
	@Future
	@NotNull
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private LocalDate dataPublicacao ;
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id", message = "Essa categoria ainda não está cadastrada")
	private Long idCategoria;
	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id", message = "Essa Autor(a) ainda não está cadastrado(a)")
	private Long idAutor;
	
	public LivroDTO(@NotBlank String titulo, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@Min(20) BigDecimal preco, @Min(20) int numeroPaginas, @NotBlank String isbn,Long idCategoria, Long idAutor) {

		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.numeroPaginas = numeroPaginas;
		this.isbn = isbn;
		this.idCategoria = idCategoria;
		this.idAutor = idAutor;
	}
	
	//Unico setter da classe devido a jackson na serializar a data	
	public void setDataPublicacao(LocalDate dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	@Override
	public String toString() {
		return "LivroDTO [titulo=" + titulo + ", resumo=" + resumo + ", sumario=" + sumario + ", preco=" + preco
				+ ", numeroPaginas=" + numeroPaginas + ", isbn=" + isbn + ", dataPublicacao=" + dataPublicacao
				+ ", idCategoria=" + idCategoria + ", idAutor=" + idAutor + "]";
	}

	public Livro saveAs(EntityManager manager) {
		
		@NotNull Autor autor = manager.find(Autor.class, idAutor);
		@NotNull Categoria categoria = manager.find(Categoria.class, idCategoria);
		
		Assert.state(autor!= null, "VOCE ESTÁ CADASTRANDO UM LIVRO COM UM AUTOR(A) QUE NÃO EXISTE " +idAutor);
		Assert.state(categoria!= null, "VOCE ESTÁ CADASTRANDO UM LIVRO COM UMA CATEGORIA QUE NÃO EXISTE " +idCategoria);
		
		return new Livro(titulo, resumo, sumario, preco, numeroPaginas, isbn, dataPublicacao, autor, categoria);
	}
	
}
