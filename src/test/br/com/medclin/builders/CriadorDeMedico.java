package br.com.medclin.builders;

import br.com.medclin.models.Medico;

public class CriadorDeMedico {

	private String nome;
	private String crm;

	public CriadorDeMedico nome(String nome) {
		this.nome = nome;
		return this;
	}

	public CriadorDeMedico crm(String crm) {
		this.crm = crm;
		return this;
	}
	
	
	
	public Medico controi(){
		return new Medico(nome,crm);
	}

}