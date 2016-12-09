package br.com.medclin.boot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.daos.ConsultaDao;
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.daos.PacienteDao;
import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.boot.models.Paciente;

@Controller
@RequestMapping("/medclin")
public class ConsultaController {

	@Autowired
	private ConsultaDao consultaDao;

	@Autowired
	private MedicoDao medicoDao;

	@Autowired
	private PacienteDao pacienteDao;

	@RequestMapping("/consulta")
	public ModelAndView Consulta() {

		ModelAndView modelAndView = new ModelAndView("consulta/consulta");

		ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDao.findAll();

		ArrayList<Paciente> pacientes = (ArrayList<Paciente>) pacienteDao.findAll();

		modelAndView.addObject("medicos", medicos);
		modelAndView.addObject("pacientes", pacientes);
		
		return modelAndView;
	}
	
	
	@RequestMapping("/consulta2")
	public ModelAndView Consulto() {

		ModelAndView modelAndView = new ModelAndView("consulta/consulta2");

		ArrayList<Medico> medicos = (ArrayList<Medico>) medicoDao.findAll();

		ArrayList<Paciente> pacientes = (ArrayList<Paciente>) pacienteDao.findAll();

		modelAndView.addObject("medicos", medicos);
		modelAndView.addObject("pacientes", pacientes);
		
		modelAndView.addObject("consulta", new Consulta());
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(@ModelAttribute Consulta consulta) {
		
		consultaDao.save(consulta);
		
		return "forward:/medclin/home";
	}

}
