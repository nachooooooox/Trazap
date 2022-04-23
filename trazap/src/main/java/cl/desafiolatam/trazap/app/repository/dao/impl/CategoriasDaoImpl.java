package cl.desafiolatam.trazap.app.repository.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cl.desafiolatam.trazap.app.repository.dao.CategoriasDao;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;

@Repository("categoriasDao")
public class CategoriasDaoImpl implements CategoriasDao {

	@Override
	public List<Categorias> getCategorias() {
		String sql = "";
		return null;
	}

}
