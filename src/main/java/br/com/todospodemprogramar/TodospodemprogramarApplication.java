package br.com.todospodemprogramar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * Created by Natalia Rosa on 08/07/19.
 */
@SpringBootApplication
public class TodospodemprogramarApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(TodospodemprogramarApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TodospodemprogramarApplication.class);
	}
}
