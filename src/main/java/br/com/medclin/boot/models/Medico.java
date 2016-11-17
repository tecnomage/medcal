package br.com.medclin.boot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String nome;

	@NotNull
	private String crm;

	@NotEmpty
	private String cpf;

	private String Endereco;

	public Medico(String nome, String crm) {
		this.nome = nome;
		this.crm = crm;
	}

	public Medico(String crm2) {
		this.crm = crm2;
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
		return cpf;
	}

	public void setCpf(String cpf) {
		cpf = cpf;
	}

	public String getEndereco() {
		return Endereco;
	}

	public void setEndereco(String endereco) {
		Endereco = endereco;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public String toString() {

		return getCrm() + getNome();
	}

	@Override
	public boolean equals(Object med) {
		if (this.getCpf() == ((Medico) med).getCpf())
			return true;
		else {
			return false;
		}
	}
}