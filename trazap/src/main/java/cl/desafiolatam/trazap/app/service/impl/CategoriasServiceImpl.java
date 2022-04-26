package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.CategoriasRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Categorias;
import cl.desafiolatam.trazap.app.service.CategoriasService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("categoriasService")
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	private CategoriasRepository categoriasRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Categorias> categoriaList = new ArrayList<Categorias>();
		
		Iterable<Categorias> itCategorias = categoriasRepository.findAll();
		
		//Prueba
		itCategorias.forEach(categoriaList::add);
		for (Categorias categorias : itCategorias) {
			System.out.println(categorias);
		}
		//fin de la prueba
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(categoriaList);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
