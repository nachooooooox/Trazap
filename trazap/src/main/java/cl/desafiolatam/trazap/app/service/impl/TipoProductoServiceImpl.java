package cl.desafiolatam.trazap.app.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.desafiolatam.trazap.app.delegate.TipoProductoDelegate;
import cl.desafiolatam.trazap.app.repository.TipoProductoRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.repository.dao.model.TipoProducto;
import cl.desafiolatam.trazap.app.service.TipoProductoService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@Service("tipoProcductoService")
public class TipoProductoServiceImpl  implements TipoProductoService{

	@Autowired
	private TipoProductoRepository tipoProductoRepository;
	@Autowired
	private ResponseServiceObject responseServiceObject;
	@Autowired
	private ResponseServiceMessage responseServiceMessage;
	
	@Override
	public ResponseServiceObject findAll() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		List<TipoProducto> tipoProducto = new ArrayList<TipoProducto>();
		
		Iterable<TipoProducto> itTipoProducto = tipoProductoRepository.findAll();
		
		itTipoProducto.forEach(tipoProducto::add);
		
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setBody(tipoProducto);
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
		
	}
	@Override
	public ResponseServiceObject save(TipoProducto tipoProducto) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(tipoProductoRepository.save(tipoProducto));
		
		responseServiceMessage.setTimestamp(new Date());
		//Todos los 200's ser??n "ok, "201": create
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
	
		responseServiceObject.setMessageList(messageList);
		
		return responseServiceObject;
	}
	@Override
	public ResponseServiceObject findById(Integer idTipoProducto) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(tipoProductoRepository.findById(idTipoProducto));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("B??squeda finalizada del id " + idTipoProducto);
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		return responseServiceObject;
	}
	@Override
	public ResponseServiceObject update(TipoProducto tipoProducto, Integer idTipoProducto) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		tipoProducto.setIdTipoProducto(idTipoProducto);
		
		responseServiceObject.setBody(tipoProductoRepository.save(tipoProducto));
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Registro actualizado correctamente");
		
		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);
		return responseServiceObject;
	}
	@Override
	public ResponseServiceObject delete(Integer idTipoProducto) {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		tipoProductoRepository.deleteById(idTipoProducto);
		
		responseServiceMessage.setTimestamp(new Date());
		responseServiceMessage.setCode("200");
		responseServiceMessage.setType(ResponseServiceMessageType.ERROR);
		responseServiceMessage.setMessage("Registro eliminado correctamente");

		messageList.add(responseServiceMessage);
		
		responseServiceObject.setMessageList(messageList);

		return responseServiceObject;
	}
}
