package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;

import br.com.medclin.boot.models.Paciente;

public interface PacienteDao extends CrudRepository<Paciente, Serializable> {

}
