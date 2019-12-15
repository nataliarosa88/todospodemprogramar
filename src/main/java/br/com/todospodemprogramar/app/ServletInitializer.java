package br.com.todospodemprogramar.app;

import br.com.todospodemprogramar.TodospodemprogramarApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * Created by Natalia Rosa on 08/07/19.
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TodospodemprogramarApplication.class);
	}

}
