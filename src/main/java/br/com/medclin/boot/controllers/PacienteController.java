package br.com.medclin.boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.models.Paciente;

@Controller
@RequestMapping("medclin/paciente")
public class PacienteController {

	
	@RequestMapping("/cadastro")
	public ModelAndView Cadastro() {
	
	ModelAndView modelAndView = new ModelAndView("cadastro");	
		modelAndView.addObject("paciente", new Paciente() );
		return modelAndView;
		
	}
	
	
	
	
		
}

