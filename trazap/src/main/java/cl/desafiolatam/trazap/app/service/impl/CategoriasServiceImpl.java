package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.CategoriasRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.CategoriasService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Categorias> categoriaList = new ArrayList<Categorias>();
		
		Iterable<Categorias> itCategorias = CategoriasRepository.findAll();
		
		return null;
	}

}
