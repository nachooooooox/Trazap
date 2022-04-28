package cl.desafiolatam.trazap.app.delegate.impl;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.CategoriasDelegate;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.CategoriasService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Component("categoriasDelegate")
public class CategoriasDelegateImpl implements CategoriasDelegate{
	
	@Autowired
	private CategoriasService CategoriasService;
	
	@Override
	public ResponseServiceObject findAll() {
		return CategoriasService.findAll();
	}

	@Override
	public ResponseServiceObject findById(Integer idCategoria) throws ServiceException {
		return CategoriasService.findById(idCategoria);
	}

	@Override
	public ResponseServiceObject create(Categorias categorias) {
		return CategoriasService.create(categorias);
	}

	@Override
	public ResponseServiceObject update(Integer idCategorias, Categorias categoria) {
		return CategoriasService.update(idCategorias, categoria);
	}

	@Override
	public ResponseServiceObject delete(Integer idCategoria) {
		return CategoriasService.delete(idCategoria);
	}

}
