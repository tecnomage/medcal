package br.com.medclin.boot.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;
	private Calendar dataNascimento;
	private String endereco;

	@NotNull
	private String cpf;

	@ManyToOne
	private Plano planoDeSaude;

	public Paciente(String nome, Calendar dataNascimento, String endereco, String cpf, Plano plano) {
		super();
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.cpf = cpf;
		this.planoDeSaude = plano;
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

	public Paciente() {

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

	public String getIdString() {
		return id.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setIdString(String id) {
		Integer chave = Integer.valueOf(id);
		this.id= chave;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Plano getPlanoDeSaude() {
		return planoDeSaude;
	}

	public void setPlanoDeSaude(Plano planoDeSaude) {
		this.planoDeSaude = planoDeSaude;
	}

	public boolean equals(Paciente pct) {
		if (this.id == pct.id)
			return true;
		else
			return false;
	}

	@Override
	public int hashCode() {

		return super.hashCode();
	}

	@Override
	public String toString() {
		return "Paciente [id=" + id + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", endereco=" + endereco
				+ ", cpf=" + cpf + ", planoDeSaude=" + planoDeSaude + "]";
	}

}
