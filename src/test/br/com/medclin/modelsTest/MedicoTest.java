package br.com.medclin.modelsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.CriadorDeMedico;

public class MedicoTest {
	
	@Test( expected = Error.class)
	public void MedicoDeveTerCRM(){
	Medico medic = new CriadorDeMedico().nome("medico teste").crm().controi();
	
}
	
	
	@Test
	public void deveRetornarNomeEcpfMockado(){
		 Medico medico = new CriadorDeMedico().crm("1233").nome("maria").controi();
		 
		 assertEquals("1233"+"maria", medico.toString());
		 
	}
	
	
	
	
}
