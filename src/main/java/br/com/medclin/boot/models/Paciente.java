package br.com.medclin.boot.models;

import java.util.Calendar;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;


@Entity
public class Paciente {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private Calendar dataNascimento;
	private String endereco;
    
	@NotNull
	private String cpf;
    
	//TODO mapear planos de saúde
	@OneToMany(mappedBy= "Plano")
	private String planoDeSaude;
    
    
	
    public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf, String planoDeSaude) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.planoDeSaude = planoDeSaude;
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
		return this.dataNascimento;
	}



	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}



	public String getEndereco() {
		return this.endereco;
	}



	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}



	public String getCpf() {
		return this.cpf;
	}



	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	public String getPlanoDeSaude() {
		return planoDeSaude;
	}



	public void setPlanoDeSaude(String planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
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
