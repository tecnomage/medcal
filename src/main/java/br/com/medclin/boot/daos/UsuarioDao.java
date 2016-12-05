package br.com.medclin.boot.daos;

import java.io.Serializable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.User;

@Repository
public interface UsuarioDao extends CrudRepository<User , Serializable>{

@Query("select u From User u"+ " where u.nome = :nome")
public User loadUserByUsername(String nome);

}
		
				
		


	
	


