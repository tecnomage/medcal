package br.com.medclin.modelsTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.CriadorDeMedico;

public class MedicoTest {
	
	
	
	@Test( expected = Error.class)
	public void MedicoDeveTerCRM(){
	Medico medic = new CriadorDeMedico().nome("medico teste").crm().controi();
	
}
	
	
	@Test
	public void deveRetornarNomeEcpf(){
		 Medico medico = new CriadorDeMedico().crm("1233").nome("maria").controi();
		 
		 assertEquals("1233"+"maria", medico.toString());
		 
	}
	
	
	
	
}
