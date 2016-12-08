package br.com.medclin.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//@ComponentScan(basePackages = {"br.com.medclin.boot",
//		"br.com.medclin.boot.builders",
//		"br.com.medclin.boot.controllers",
//		"br.com.medclin.boot.daos",
//		"br.com.medclin.boot.models",
//		"br.com.medclin.boot.confs"
//		})

public class Boot {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(Boot.class, args);
		System.out.println("ola meus amigos" +"\n" + ctx.getApplicationName());

		// SpringApplication.run(Boot.class, args);
	}


}
