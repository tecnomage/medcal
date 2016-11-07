package br.com.medclin.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import br.com.medclin.models.Medico;

public interface MedicoDao extends CrudRepository<Medico, Serializable>{

}
