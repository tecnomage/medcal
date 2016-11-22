package br.com.medclin.boot.builders;

import br.com.medclin.boot.models.Medico;

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

	public Medico constroi() {

//		if (nome == null) {
//			return new Medico(crm);
//		} else if (crm != null)
//			return new Medico(nome, crm);
//
		
		return new Medico(nome,crm);
		
	}

	@Override
	public String toString() {
		return nome + crm;
	}

}
