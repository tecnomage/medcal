package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Medico;

@Repository
public interface MedicoDao extends CrudRepository<Medico, Serializable> {

	// Exemplo da documentacao
	// @Query("select u from User u where u.firstname = :firstname")
	// List<User> findByFirstname(String firstname);

	Medico findByCrm(String crm);

	Medico findByNome(String nome);

	@Query("select m.cpf from Medico m where m.cpf = ?1")
	String findByCpf(String cpf);

	@Query("select m.endereco from Medico m where m.endereco = ?1")
	String findByEndereco(String string);

	
}
