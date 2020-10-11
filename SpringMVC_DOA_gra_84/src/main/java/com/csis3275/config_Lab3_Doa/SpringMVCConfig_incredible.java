package com.csis3275.config_Lab3_Doa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.csis3275")
//Add to read the database config - add this outside of the class declaration.
@PropertySource("classpath:database.properties")

public class SpringMVCConfig_incredible implements WebMvcConfigurer {
	//Add to read the database config - add this outside of the class

	 @Autowired
	 Environment environment;
	 private final String URL = "url";
	 private final String USER = "dbuser";
	 private final String DRIVER = "driver";
	 private final String PASSWORD = "dbpassword";
	 @Bean
	 DataSource dataSource() {
	 DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	 driverManagerDataSource.setUrl(environment.getProperty(URL));
	 driverManagerDataSource.setUsername(environment.getProperty(USER));

	driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));

	driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
	 return driverManagerDataSource;
	 }


	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		//System.out.println("**********************SpringMVCConfig_incredible000************************8");
		return viewResolver;
	}

	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages");
		return messageSource;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//System.out.println("**********************addResourceHandlers123************************8");
		
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		

	}

}