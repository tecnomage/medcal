package br.com.medclin.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ComponentScan(basePackages = {"br.com.medclin.boot"})
public class Boot {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Boot.class, args);
		System.out.println("ola meus amigos" +"\n" + ctx.getApplicationName());

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
	
}
