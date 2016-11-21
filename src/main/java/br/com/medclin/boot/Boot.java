package br.com.medclin.boot;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"br.com.medclin.boot.controllers",
"br.com.medclin.boot.daos", "br.com.medclin.boot.models",
"br.com.medclin.boot"})
public class Boot {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Boot.class, args);
		System.out.println("ola meus amigos" +"\n" + ctx.getDisplayName());

		// SpringApplication.run(Boot.class, args);
	}


//	@Bean
//	public DataSource dataSource(){
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//		dataSource.setUrl("jdbc:mysql://localhost:3306/medcal");
//		dataSource.setUsername("root");
//		dataSource.setPassword("");
//		return dataSource;
//	}
//	
//	@Bean
//    public HibernateJpaSessionFactoryBean sessionFactory(EntityManagerFactory emf) {
//         HibernateJpaSessionFactoryBean factory = new HibernateJpaSessionFactoryBean();
//         factory.setEntityManagerFactory(emf);
//         
//         Properties props = new Properties();
//         props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
//         props.setProperty("hibernate.show_sql", "true");
//         props.setProperty("hibernate.hbm2ddl.auto", "update");
//
//         factory.setJpaProperties(props);
//         
//           return factory;
//    }
	
	
	@RequestMapping("/")
	@ResponseBody
	public String home() {
		return "index";
	}

}
