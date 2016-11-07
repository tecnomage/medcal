package br.com.medclin.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import br.com.medclin.models.Paciente;

public interface PacienteDao extends CrudRepository<Paciente, Serializable> {

}
