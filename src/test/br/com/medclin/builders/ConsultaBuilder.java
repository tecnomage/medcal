package br.com.medclin.builders;

import java.util.Calendar;

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
	
	public ConsultaBuilder paciente(String pctnome ,String cpf) {
		this.pctNome = pctnome;
		this.pctCpf = cpf;
		return this;
		
	}
	
	

	//TODO atualizar o método para vários construtores de pct
	public Consulta constroi() {
		
		Medico medico;
		Paciente paciente;
		medico = new Medico(nomeMedico, crm);
		
		
		if (this.pctNome == null) {
			paciente = new Paciente(pctCpf);
		}else{
			paciente= new Paciente(this.pctNome ,Calendar.getInstance(),"End tese" , this.pctCpf,"unmined" ); 
		}
		if (medico == null || paciente == null) {
			throw new RuntimeException();
		}

		//TODO alterar o retorno para que seja uma listagem de pct
		return this.consulta= new Consulta(medico,paciente);
		
		
	}

	
	
}
