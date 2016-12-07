package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Consulta;

@Repository
public interface ConsultaDao  extends CrudRepository<Consulta , Serializable>{

}
