package br.com.medclin.boot.daos;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.medclin.boot.models.Paciente;
import br.com.medclin.boot.models.Plano;

@Repository
public interface PlanoDao  extends CrudRepository<Plano , Serializable>{

	
//	@Query("select p.nome from Plano p join fetch p.pacientes")
//	List<Paciente> getNumeroDePctPorPlano();
	
	
	//("select distinct c from Conta c join fetch c.movimentacoes");
//	 @Query("select distinct p.nome from Plano p LEFT JOIN Paciente p on"
//			 + "paciente.plano = p.id" +
//			 	"ORDER BY p.nome")
	
	
	//sendo plano = conta
	// movimentação = paciente
//"select distinct c from Conta c join fetch c.movimentacoes");
	
	
}
