package br.com.medclin.models;

import java.util.Calendar;

import javax.persistence.Entity;


@Entity
public class Paciente {
	
	
	private String nome;
	private Calendar DataNascimento;
	private String Endereco;
    private String Cpf;
    private String PlanoDeSaude;
    
    
	
    public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf, String planoDeSaude) {
		super();
		this.nome = nome;
		DataNascimento = dataNascimento;
		Endereco = endereco;
		Cpf = cpf;
		PlanoDeSaude = planoDeSaude;
	}



	public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf) {
		super();
		this.nome = nome;
		DataNascimento = dataNascimento;
		Endereco = endereco;
		Cpf = cpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Calendar getDataNascimento() {
		return DataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		DataNascimento = dataNascimento;
	}



	public String getEndereco() {
		return Endereco;
	}



	public void setEndereco(String endereco) {
		Endereco = endereco;
	}



	public String getCpf() {
		return Cpf;
	}



	public void setCpf(String cpf) {
		Cpf = cpf;
	}



	public String getPlanoDeSaude() {
		return PlanoDeSaude;
	}



	public void setPlanoDeSaude(String planoDeSaude) {
		PlanoDeSaude = planoDeSaude;
	}

}
