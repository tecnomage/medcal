package br.com.medclin.modelsTest;

import org.junit.Test;

import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.CriadorDeMedico;

public class medicoTest {
	
	
	
	@Test( expected = Error.class)
	public void MedicoDeveTerCRM(){
	Medico medic = new CriadorDeMedico().nome("medico teste").crm().controi();
	
}
	
//todo medico deve ter crm	
	
}
