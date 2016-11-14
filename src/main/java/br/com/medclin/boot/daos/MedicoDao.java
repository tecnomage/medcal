package br.com.medclin.boot.daos;

import java.io.Serializable;

import javax.management.Query;

import org.springframework.data.repository.CrudRepository;

import br.com.medclin.boot.models.Medico;

public interface MedicoDao extends CrudRepository<Medico, Serializable>{

	public default Medico findByCrm(String crm){
		//TODO verificar se a tabela é medico msm
//		Query query = manager.createQuery("select m from Movimentacao m where m.conta.id="
//                + conta.getId());
		
		
		
		return Medico;
		
	}
	  		
	
	
}
