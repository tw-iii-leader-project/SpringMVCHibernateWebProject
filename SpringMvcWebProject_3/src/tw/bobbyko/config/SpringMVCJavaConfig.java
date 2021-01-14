package tw.bobbyko.config;


import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = {"tw.bobbyko"})
public class SpringMVCJavaConfig implements WebMvcConfigurer{

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	@Bean
	public InternalResourceViewResolver viewResolver(){
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		viewResolver.setOrder(2);
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/images/**").addResourceLocations("/WEB-INF/pages/resources/images/");
	}
	
	@Bean
	public DataSource getJndiDataSource() throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean factoryBean = new JndiObjectFactoryBean();
		factoryBean.setJndiName("java:comp/env/connectSQLServerJdbc/OrderService");
		factoryBean.afterPropertiesSet();
		return (DataSource) factoryBean.getObject();
	}
	
	
}
