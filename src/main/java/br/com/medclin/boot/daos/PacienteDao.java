package br.com.medclin.boot.daos;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Paciente;

@Repository
public interface PacienteDao extends CrudRepository<Paciente, Serializable> {

	Paciente findByCpf(String cpf);

	Paciente findByNome(String nome);
	
	@Query("select p.cpf from Paciente p where p.cpf = ?1")
	String findByCpfString(String cpf);

	@Query("select p.endereco from Paciente p where p.endereco = ?1")
	String findByEndereco(String string);

	@Query("select p.nome from Plano p join fetch p.pacientes")
	List<Paciente> getNumeroDePctPorPlano();
	
//	@Query("select p.nome from Plano p join fetch p.pacientes")
//	List<Paciente> getNumeroDePctPorPlano();
	
	
}
