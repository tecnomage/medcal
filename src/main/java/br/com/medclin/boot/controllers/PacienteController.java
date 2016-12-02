package br.com.medclin.boot.controllers;

import java.util.ArrayList;
import java.util.List;

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
	
	ModelAndView modelAndView = new ModelAndView("paciente/cadastro");	
		modelAndView.addObject("paciente", new Paciente() );
		return modelAndView;
		
	}
	
	
	//TODO fazer o tymeleaf date formate antes de salvar.
	@RequestMapping(value="/salvar" , method = RequestMethod.POST)
	public String salvar(@ModelAttribute Paciente paciente){
		
		//TODO alterar para caso de erro no salvamento, nao vá para listagem
		pacientedao.save(paciente);

		return "redirect:listar";
		
		
	}

	@RequestMapping("/listar")
	public ModelAndView listar() {
		
		//TODO alinhar para a listagem ficar centralizada.
		ModelAndView modelAndView = new ModelAndView("paciente/listar");
		List<Paciente> pct = (ArrayList<Paciente>) pacientedao.findAll();
		
		modelAndView.addObject("pacientes", pct);
		
		return modelAndView;
	}
	
	
		
}

