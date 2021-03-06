package br.com.medclin.boot.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Medico medico;

	@ManyToMany
	@JoinTable(name = "CONSULTA_PACIENTES")
	private List<Paciente> pacientes = new ArrayList<>();


	@ManyToMany
	@JoinTable(name = "CONSULTA_RECEITA")
	private List<Receita> receita = new ArrayList<>();

	public Consulta(Medico med, List<Paciente> paciente) {
		this.medico = med;
		this.pacientes = paciente;
	}

	public Consulta() {

	}

	public Consulta(Medico medico2) {
		this.medico = medico2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((pacientes == null) ? 0 : pacientes.hashCode());
		result = prime * result + ((receita == null) ? 0 : receita.hashCode());
		return result;
	}
		
	@Override
	public String toString() {
		return "Consulta [id=" + id + ", medico=" + medico + ", pacientes=" + pacientes + ", receita=" + receita + "]";
	}

	public boolean equals(Consulta cons) {
		if (this.id == cons.getId())
			return true;
		else
		return false;
	}

 
	
}
