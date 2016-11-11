package br.com.medclin.boot.models;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Receita {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private String[] remedio;
	private String Descrição;
	
	@Enumerated(EnumType.STRING)
	Restrito restrito;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String[] getRemedio() {
		return remedio;
	}

	public void setRemedio(String[] remedio) {
		this.remedio = remedio;
	}

	public String getDescrição() {
		return Descrição;
	}

	public void setDescrição(String descrição) {
		Descrição = descrição;
	}

	public Restrito getRestrito() {
		return restrito;
	}

	public void setRestrito(Restrito restrito) {
		this.restrito = restrito;
	}

	
	//somente o último arg. pode ter parametros variáveis
	public Receita(String descrição, Restrito restrito,String... remedio) {
		
		this.remedio = remedio;
		this.Descrição = descrição;
		this.restrito = restrito;
	} 
	
	
	
	
}
