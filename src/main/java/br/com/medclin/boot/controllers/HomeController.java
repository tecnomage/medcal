package br.com.medclin.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/medclin")
public class HomeController {

	
	@RequestMapping("/home")
	public ModelAndView home(){
		
		ModelAndView mv = new ModelAndView("index");
				
		return mv;
		
	}
	
	
	@RequestMapping("/login")
	public ModelAndView test(){
		
		ModelAndView mv = new ModelAndView("login/login");
				
		return mv;
		
	}
	
	
}
