package cl.desafiolatam.trazap;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import cl.desafiolatam.trazap.app.repository.BodegaRepository;
import cl.desafiolatam.trazap.app.repository.dao.model.Bodegas;

@SpringBootApplication
public class TrazapApplication {

	private final static Logger logger = LoggerFactory.getLogger(TrazapApplication.class);
	
	@Autowired
	private BodegaRepository bodegaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(TrazapApplication.class, args);
	}

	@Bean
	public CommandLineRunner createBodega() {
		return (args) -> {
			Bodegas bodega1 = new Bodegas();
			Bodegas bodega2 = new Bodegas();
			bodega1.setDescripcion("MI BODEGA 1");
			bodega2.setDescripcion("MI BODEGA 2");
			bodegaRepository.save(bodega1);
			bodegaRepository.save(bodega2);
			logger.info(bodega1.toString());
			logger.info(bodega2.toString());
		};
	}
	
	@Bean
	public CommandLineRunner findAllBodega() {
		return (args) -> {
			Bodegas bodega = new Bodegas();
			bodega.setDescripcion("MI BODEGA");
			Iterator<Bodegas> itBodega = bodegaRepository.findAll().iterator();
			
			while(itBodega.hasNext()) {
				logger.info(itBodega.next().toString());
			}
			
			
		};
	}
	
}
