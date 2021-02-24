package br.com.zup.casadocodigo.livrodetalhado;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.casadocodigo.livro.Livro;

public class DetalhesLivroResponse {
	

	private DetalhesAutorResponse autor;	
	private  String titulo;
	private  String resumo;
	private String sumario;
	private BigDecimal preco;
	private  int numeroPaginas;
	private String isbn;
	private String dataPublicacao;
	
	public DetalhesLivroResponse(Livro entity) {
		
		this.autor = new DetalhesAutorResponse(entity.getAutor());
		this.titulo = entity.getTitulo();
		this.resumo = entity.getResumo();
		this.sumario = entity.getSumario();
		this.preco = entity.getPreco();
		this.numeroPaginas = entity.getNumeroPaginas();
		this.isbn = entity.getIsbn();
		this.dataPublicacao = entity.getDataPublicacao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	
	}

	public DetalhesAutorResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getNumeroPaginas() {
		return numeroPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getDataPublicacao() {
		return dataPublicacao;
	}
}
