package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("bodegaService")
public class BodegaServiceImpl implements BodegaService{
	
	@Autowired
	private BodegaRepository bodegaRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<Bodegas> bodegas = new ArrayList<Bodegas>();
		
		Iterable<Bodegas> itBodegas = bodegaRepository.findAll();
		
		itBodegas.forEach(bodegas::add);
		
		responseServiceMessage.setTimestamp(new Date());
		//Todos los 200's serán "ok"
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(bodegas);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject save(Bodegas bodega) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(bodegaRepository.save(bodega));
		
		responseServiceMessage.setTimestamp(new Date());
		//Todos los 200's serán "ok, "201": create
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
	
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject findById(Integer idBodega) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(bodegaRepository.findById(idBodega));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro con Id " + idBodega);
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject update(Bodegas bodegas, Integer idBodega) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		bodegas.setIdBodega(idBodega);
		responseServiceObject.setBody(bodegaRepository.save(bodegas));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

	@Override
	public ResponseServiceObject delete(Integer idBodega) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		bodegaRepository.deleteById(idBodega);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro eliminado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}

}
