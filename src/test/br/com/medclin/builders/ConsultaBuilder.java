package br.com.medclin.builders;

import br.com.medclin.boot.builders.GenericBuilder;
import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.boot.models.Paciente;

public class ConsultaBuilder implements GenericBuilder {

	Consulta consulta;
	
	private String crm;
	private String pctCpf;
	private String nomeMedico;
	private String pctNome;
	
	public ConsultaBuilder medico(String crm, String nome) {
		this.crm = crm;
		this.nomeMedico = nome;
		return this;
	}


	public ConsultaBuilder paciente(String cpf) {
		this.pctCpf = cpf;
		return this;
	}
	

	//TODO finalizar o constroi
	public Consulta constroi() {
		
		Medico medico;
		Paciente paciente;
		medico = new Medico(nomeMedico, crm);
		paciente = new Paciente(pctCpf);
		
		if (medico == null || paciente == null) {
			throw new RuntimeException();
		}
		
		return this.consulta= new Consulta(medico,paciente);
		
		
	}

	
	
}
