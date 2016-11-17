package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Medico;

@Repository
public interface MedicoDao extends CrudRepository<Medico, Serializable>{

//Exemplo da documentacao
//	@Query("select u from User u where u.firstname = :firstname")
//	List<User> findByFirstname(String firstname);	

	
	
//	Query("from Medico m where m.crm=:crm")
public Medico findByCrm(String crm);	
	
}
