package br.com.medclin.boot.builders;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.boot.models.Paciente;

public class ConsultaBuilder implements GenericBuilder {

	Consulta consulta;
	
	private String crm;
	private String nomeMedico;
	
	private List<Paciente> pacientes;
	
	//TODO alterar o construtor para aceitar uma listagem de pct
	public ConsultaBuilder medico(String crm, String nome) {
		this.crm = crm;
		this.nomeMedico = nome;
		return this;
	}


	public ConsultaBuilder pacientes(ArrayList<Paciente> pcts) {
		this.pacientes = pcts;
		return this;
	}
	
//	public ConsultaBuilder paciente(String pctnome ,String cpf) {
//		this.pctNome = pctnome;
//		this.pctCpf = cpf;
//		return this;
//		
//	}
	
	

	//TODO atualizar o método para vários construtores de pct
	public Consulta constroi() {
		
		Medico medico;
		//Paciente paciente;
		medico = new Medico(nomeMedico, crm);
		
		
//		if (this.pctNome == null) {
//			paciente = new Paciente(pctCpf);
//		}else{
//			paciente= new Paciente(this.pctNome ,Calendar.getInstance(),"End tese" , this.pctCpf,"unmined" ); 
//		}
//		if (medico == null || paciente == null) {
//			throw new RuntimeException();
//		}

		//TODO alterar o retorno para que seja uma listagem de pct
		return this.consulta= new Consulta(medico, pacientes); 
				
		};
		
		
	}

	
	

