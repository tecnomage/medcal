package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Paciente;

@Repository
public interface PacienteDao extends CrudRepository<Paciente, Integer> {

	Paciente findByCpf(String cpf);

	Paciente findByNome(String nome);
	
	@Query("select p.cpf from Paciente p where p.cpf = ?1")
	String findByCpfString(String cpf);

	@Query("select p.endereco from Paciente p where p.endereco = ?1")
	String findByEndereco(String string);
	
	Paciente findOne(@Param("id") Integer id) throws DataAccessException;
	
}
