package br.com.medclin.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class LoginController {

	

@RequestMapping("/login")
public ModelAndView test(){
		
		ModelAndView mv = new ModelAndView("login");
				
		return mv;
		
	}
	
	
	
}
