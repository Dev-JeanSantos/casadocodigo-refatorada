package br.com.zup.casadocodigo.estado;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long>{
	
	@Query("SELECT e FROM Estado e WHERE e.pais.id = :idPais")
	List<Estado> buscarTodosEstadosPorPais(Long idPais);

}
