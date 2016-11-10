package br.com.medclin.boot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Consulta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	private Medico medico;

	private Paciente pct;

	private Receita receita;

	Restrito restrito;

	public enum Restrito {
		SIM, NAO
	}

	public Consulta(Medico med, Paciente paciente) {
		this.medico = med;
		this.pct = paciente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Paciente getPct() {
		return pct;
	}

	public void setPct(Paciente pct) {
		this.pct = pct;
	}

	public Medico getMedico() { 
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Receita getReceita() {
		return receita;
	}

	public void setReceita(Receita receita) {
		this.receita = receita;
	}

	public Restrito getRestrito() {
		return restrito;
	}

	public void setRestrito(Restrito restrito) {
		this.restrito = restrito;
	}

	@Override
	public String toString() {

		return getPct() + medico.toString() + getReceita();
	}

}
