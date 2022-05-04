package cl.desafiolatam.trazap.app.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import cl.desafiolatam.trazap.app.repository.dao.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
	public List<Usuario> findByEmail(String email);
}
