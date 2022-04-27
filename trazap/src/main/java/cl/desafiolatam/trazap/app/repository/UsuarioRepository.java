package cl.desafiolatam.trazap.app.repository;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.trazap.app.repository.dao.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{

}
