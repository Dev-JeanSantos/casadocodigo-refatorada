package br.com.zup.casadocodigo.livro;

public class LivroSaidaDTO {
	
	private Long id;
    private String titulo;
	
    public LivroSaidaDTO(Livro entity) {
		this.id = entity.getId();
		this.titulo = entity.getTitulo();
	}
	public LivroSaidaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	@Override
	public String toString() {
		return "RetornoDTOLivro [id=" + id + ", titulo=" + titulo + "]";
	}    
    
}
