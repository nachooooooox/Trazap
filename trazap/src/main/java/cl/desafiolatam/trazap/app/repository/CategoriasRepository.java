package cl.desafiolatam.trazap.app.repository;

import org.springframework.data.repository.CrudRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;

public interface CategoriasRepository extends CrudRepository<Categorias, Integer> {

}
