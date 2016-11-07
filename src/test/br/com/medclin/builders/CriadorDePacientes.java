package br.com.medclin.builders;

import java.util.Calendar;

import br.com.medclin.models.Paciente;

public class CriadorDePacientes {
	
	private String nome;
	private Calendar DataNascimento;
	private String endereco;
    private String cpf;
	
    private Paciente pct;
    
    public CriadorDePacientes nome(String nome) {
    	this.nome = nome;
    	return this;
		
	}

	public CriadorDePacientes nascimento(Calendar instance) {
         this.DataNascimento = instance; 
		return this;
	}

	public CriadorDePacientes endereco(String endereco) {
		this.endereco = endereco;
		return this;
	}

	public CriadorDePacientes cpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

	public Paciente constroi() {
		this.pct = new Paciente(nome, DataNascimento, endereco, cpf);
		return pct;
	}
	
    
    
    
	

}