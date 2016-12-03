package br.com.medclin.boot.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDao  implements UserDetailsService {

	@PersistenceContext
	private EntityManager manager;
	
	
	
	public UserDetails loadUserByUsername(String user){
		
		List<String> usuarios = manager.createQuery("select * From user u")			
			.getResultList();
		
		if(usuarios.isEmpty()){
			throw new UsernameNotFoundException("Usuario"+"nao foi encontrado");
		}
		
		return usuarios.get(0);
					
	}

}
