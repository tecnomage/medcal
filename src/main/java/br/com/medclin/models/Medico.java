package br.com.medclin.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class Medico {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	
	@NotNull
	private String crm;
	
	@NotEmpty
	private String Cpf;
	
	private String Endereco;
	
	
	public Medico(String nome, String crm) {
		this.nome=nome;
		this.crm = crm;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCrm() {
		return crm;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public String getCpf() {
		return Cpf;
	}


	public void setCpf(String cpf) {
		Cpf = cpf;
	}


	public String getEndereco() {
		return Endereco;
	}


	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	
	
}
