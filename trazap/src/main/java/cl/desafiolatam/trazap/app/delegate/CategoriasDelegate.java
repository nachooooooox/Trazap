package cl.desafiolatam.trazap.app.delegate;

import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface CategoriasDelegate {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(Integer idCategoria);
	public ResponseServiceObject create(Categorias categoria);
	public ResponseServiceObject update(Integer idCategoria, Categorias categorias);
	public ResponseServiceObject delete(Integer idCategoria);
}
