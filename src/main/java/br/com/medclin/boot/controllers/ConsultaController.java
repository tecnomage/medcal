package br.com.medclin.boot.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.daos.ConsultaDao;
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;

@Controller
@RequestMapping("/medclin")
public class ConsultaController {

	
@Autowired
private ConsultaDao consultaDao;
	
@Autowired
private MedicoDao medicoDao;


@RequestMapping("/consulta")
public ModelAndView Consulta() {
	
	ModelAndView modelAndView = new ModelAndView("consulta/consulta"); 
	
	ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDao.findAll();
	
	modelAndView.addObject("medicos", medicos);
	
	return modelAndView;
}
	
	
	
	
	
}
