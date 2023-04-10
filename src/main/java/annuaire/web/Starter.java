package annuaire.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import annuaire.model.GroupTable;
import annuaire.model.Person;
import annuaire.repo.GroupTableRepository;
import annuaire.repo.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import annuaire.model.Course;
import annuaire.repo.CourseRepository;

import java.sql.SQLException;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = {CourseRepository.class, PersonRepository.class, GroupTableRepository.class})
@EntityScan(basePackageClasses = {Course.class, Person.class, GroupTable.class})


public class Starter extends SpringBootServletInitializer implements WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Starter.class);
	}




	public static void main(String[] args) throws SQLException {
		SpringApplication.run(Starter.class, args);







	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		System.out.println("--- addResourceHandlers");
		registry.addResourceHandler("/webjars/**")//
				.addResourceLocations("/webjars/");
	}
}
