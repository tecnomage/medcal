package br.com.medclin.boot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;

@Controller
@RequestMapping("medclin/medico")
public class MedicoController {
	
	
	@Autowired
	MedicoDao medicodao;

	@RequestMapping("/cadastro")
	public ModelAndView Cadastro() {
	
	ModelAndView modelAndView = new ModelAndView("medico/cadastro");	
		
		modelAndView.addObject("medico", new Medico());
		
		return modelAndView;
		
	}
	
	
	//TODO fazer o tymeleaf date formate antes de salvar.
	@RequestMapping(value="/salvar" , method = RequestMethod.POST)
	public String salvar(@ModelAttribute Medico medico){
		
		//TODO alterar para caso de erro no salvamento, nao vá para listagem
		medicodao.save(medico);

		return "redirect:/listar";
		
		
	}

	@RequestMapping("/listar")
	public ModelAndView listar() {
		
		ModelAndView modelAndView = new ModelAndView("medico/listar");
		List<Medico> medicos = (ArrayList<Medico>) medicodao.findAll();
		
		modelAndView.addObject("medicos", medicos);
		
		return modelAndView;
	} 
	
	
}
