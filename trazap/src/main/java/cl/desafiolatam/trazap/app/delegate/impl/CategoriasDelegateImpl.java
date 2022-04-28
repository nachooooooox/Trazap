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
	public ResponseServiceObject findById(Integer idCategorias) throws ServiceException {
		return CategoriasService.findById(idCategorias);
	}

	@Override
	public ResponseServiceObject create(Categorias categorias) {
		return CategoriasService.create(categorias);
	}

	@Override
	public ResponseServiceObject update(Integer idCategorias, Categorias categorias) {
		return CategoriasService.update(idCategorias, categorias);
	}

	@Override
	public ResponseServiceObject delete(Integer idCategorias) {
		return CategoriasService.delete(idCategorias);
	}

}
