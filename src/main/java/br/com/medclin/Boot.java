package br.com.medclin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableAutoConfiguration
public class Boot
{

   public static void main(String[] args) {
	   ApplicationContext ctx = SpringApplication.run(Boot.class, args);
	   System.out.println(ctx.getDisplayName());
	  
	   SpringApplication.run(Boot.class, args);
}
   @RequestMapping("/")
   @ResponseBody
   public String home()
   {
      return "home";
   }

}

