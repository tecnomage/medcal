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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<Paciente> getPct() {
		return pacientes;
	}

	public void setPct(List<Paciente> pct) {
		this.pacientes = pct;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Receita> getReceita() {
		return receita;
	}

	public void setReceita(List<Receita> receita) {
		this.receita = receita;
	}

 
	@Override
	public String toString() {
		
		return getPct().toString() + this.medico.getCrm();
		
		 
	}

}
