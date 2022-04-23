package cl.desafiolatam.trazap.conf;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
public class DataBaseConf {
	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setDriverClassName(environment.getProperty("pg.driver"));
		driverManagerDataSource.setUrl(environment.getProperty("pg.datasource.url"));
		driverManagerDataSource.setUsername(environment.getProperty("pg.datasource.username"));
		driverManagerDataSource.setPassword(environment.getProperty("pg.datasource.password"));
		return driverManagerDataSource;
	}

}
