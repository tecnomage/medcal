package br.com.medclin.boot.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Plano {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	
	@OneToMany(mappedBy= "Paciente")
	private List<Paciente> pcts;
	
	
	public Plano(String planoDeSaude) {
	 this.nome=planoDeSaude;
	}

	
	

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Plano [nome=" + nome + "]";
	}
	
}
