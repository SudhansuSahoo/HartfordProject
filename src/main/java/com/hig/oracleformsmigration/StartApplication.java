package com.hig.oracleformsmigration;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class StartApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(StartApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("StartApplication.configure()");
		return application.sources(StartApplication.class);
	}
	
	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Bean public SessionFactory sessionFactory(HibernateEntityManagerFactory
	 * hemf) { return hemf.getSessionFactory(); }
	 */

	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
				.addMapping("/**")
				.allowedMethods("*")
				.allowCredentials(true)
				 .allowedOrigins("*");
			}
		};
	}
	
}
