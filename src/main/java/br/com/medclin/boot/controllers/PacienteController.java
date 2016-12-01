package br.com.medclin.boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.daos.PacienteDao;
import br.com.medclin.boot.models.Paciente;

@Controller
@RequestMapping("medclin/paciente")
public class PacienteController {

	
	@Autowired
	PacienteDao pacientedao;
	
	
	@RequestMapping("/cadastro")
	public ModelAndView Cadastro() {
	
	ModelAndView modelAndView = new ModelAndView("cadastro");	
		modelAndView.addObject("paciente", new Paciente() );
		return modelAndView;
		
	}
	
	
	//TODO fazer o tymeleaf date formate antes de salvar.
	@RequestMapping(value="/salvar" , method = RequestMethod.POST)
	public ModelAndView salvar(@ModelAttribute Paciente paciente){
		
		System.out.println(paciente.toString()); 
		pacientedao.save(paciente);
		ModelAndView modelAndView = new ModelAndView("/listar");
		
		
		return modelAndView;
		
		
	}
	
	
		
}

