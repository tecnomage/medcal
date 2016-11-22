package br.com.medclin.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//
@Controller(value= "home")
public class HomeController {

	
	@RequestMapping(method = RequestMethod.GET )
	public ModelAndView home(){
		
		ModelAndView mv = new ModelAndView("about");
				
		return mv;
		
	}
	
	
}
