package cl.desafiolatam.trazap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;
import cl.desafiolatam.trazap.app.service.BodegaService;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessage;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceMessageType;
import cl.desafiolatam.trazap.app.service.response.ResponseServiceObject;

@SpringBootTest
public class BodegaServiceTests {
	//Mockito o Mocks en Spring boot con junit jupiter
	private static BodegaService bodegaService;
	private static ResponseServiceObject responseServiceObject;
	private static ResponseServiceMessage responseServiceMessage;
	private static Bodegas bodegasMock1;
	private static List<Bodegas> bodegas;
	
	@BeforeAll
	public static void setUp() {
		bodegaService = mock(BodegaService.class);
		responseServiceObject = new ResponseServiceObject();
		responseServiceMessage = new ResponseServiceMessage();
		bodegasMock1 = new Bodegas();
		bodegasMock1.setIdBodega(1);
		bodegasMock1.setDescripcion("Bodega Uno");
		bodegas = new ArrayList<Bodegas>();
		bodegas.add(bodegasMock1);
	}
	
	@Test
	public void saveBodega() {
		List<ResponseServiceMessage> messageList = new ArrayList<ResponseServiceMessage>();
		
		responseServiceObject.setBody(bodegasMock1);
		
		responseServiceMessage.setTimestamp(new Date());
		//Todos los 200's serán "ok, "201": create
		responseServiceMessage.setCode("201");
		responseServiceMessage.setType(ResponseServiceMessageType.OK);
		responseServiceMessage.setMessage("Servicio finalizado correctamente");
		
		messageList.add(responseServiceMessage);
	
		responseServiceObject.setMessageList(messageList);
		
		Bodegas bodegas = new Bodegas();
		bodegasMock1.setDescripcion("Bodega Uno");
		
		when(bodegaService.save(bodegas)).thenReturn(responseServiceObject);
		
		ResponseServiceObject respuesta = bodegaService.save(bodegas);
		
		assertThat(((Bodegas) respuesta.getBody()).getIdBodega()).isEqualTo(1);
	}
	
//	@Test
//	public void findAllBodega() {
//		
//	}
}
