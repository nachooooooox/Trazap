package cl.desafiolatam.trazap.app.service;

import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public interface CategoriasService {
	public ResponseServiceObject findAll();
	public ResponseServiceObject findById(Integer idCategorias);
	public ResponseServiceObject create(Categorias categorias);
	public ResponseServiceObject update(Integer idCategorias, Categorias categorias);
	public ResponseServiceObject delete(Integer idCategorias);
}
