package br.com.medclin.boot.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Paciente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private Calendar dataNascimento;
	private String endereco;
    
	@NotNull
	private String cpf;
    private String PlanoDeSaude;
    
    
	
    public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf, String planoDeSaude) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.PlanoDeSaude = planoDeSaude;
	}



	public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
	}



	public Paciente(String pctCpf) {
		this.cpf = pctCpf;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public Calendar getDataNascimento() {
		return dataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		dataNascimento = dataNascimento;
	}



	public String getEndereco() {
		return endereco;
	}



	public void setEndereco(String endereco) {
		endereco = endereco;
	}



	public String getCpf() {
		return cpf;
	}



	public void setCpf(String cpf) {
		cpf = cpf;
	}



	public String getPlanoDeSaude() {
		return PlanoDeSaude;
	}



	public void setPlanoDeSaude(String planoDeSaude) {
		PlanoDeSaude = planoDeSaude;
	}



	public boolean equals(Paciente pct) {
		if (this.cpf == pct.cpf)
			return true;
		else return false;
	}



	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}



	@Override
	public String toString() {
		return getCpf() + getNome();
	}

}
