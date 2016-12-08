package br.com.medclin.boot.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.medclin.boot.daos.ConsultaDao;
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.daos.PacienteDao;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.boot.models.Paciente;

@Controller
@RequestMapping("/medclin")
public class ConsultaController {

	
	//private ConsultaDao consultaDao;

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
	
	
	@RequestMapping("/salvar")
	public void salvar() {
		
	}

}
