package cl.desafiolatam.trazap.app.delegate.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cl.desafiolatam.trazap.app.delegate.CategoriasDelegate;
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

}
