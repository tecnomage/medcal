package br.com.medclin.builders;

import br.com.medclin.boot.models.Consulta;

public class ConsultaBuilder {

	
	
	String crm;
	String pctCpf;
	
	public ConsultaBuilder medico(String crm) {
		this.crm = crm;
		return this;
	}


	public ConsultaBuilder paciente(String cpf) {
		this.pctCpf = cpf;
		return this;
	}


	public Consulta constroi() {

		 new Consulta(this.crm , this.pctCpf);
		
	}

	
	
}
