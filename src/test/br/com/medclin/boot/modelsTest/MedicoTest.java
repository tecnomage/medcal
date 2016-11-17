package br.com.medclin.boot.modelsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.medclin.boot.builders.CriadorDeMedico;
import br.com.medclin.boot.models.Medico;

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
