package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Paciente;

@Repository
public interface PacienteDao extends CrudRepository<Paciente, Serializable> {

}
