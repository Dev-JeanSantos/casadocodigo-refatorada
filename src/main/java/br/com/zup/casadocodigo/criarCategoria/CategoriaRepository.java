package br.com.zup.casadocodigo.criarCategoria;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

	 Optional<Categoria> findByNome(String nome);

}
