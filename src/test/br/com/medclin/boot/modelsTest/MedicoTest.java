package br.com.medclin.boot.modelsTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.medclin.boot.builders.CriadorDeMedico;
import br.com.medclin.boot.models.Medico;

@RunWith(SpringRunner.class)
public class MedicoTest {

	private Medico medico,medicoSemCRM;
	
	@Before
	public void iniciaTestes() {
		medico = new CriadorDeMedico().nome("vinicius").crm("1233").constroi();
		medicoSemCRM = new CriadorDeMedico().nome("maria").crm("").constroi();
	}
	
	
	
	@Test
	public void MedicoDeveTerCRM(){

		assertThat(medicoSemCRM.getCrm(), isEmptyOrNullString());
	
}
	
	
	@Test
	public void deveRetornarNomeEcpfMockado(){
		 
		assertThat(medico.toString(), containsString("1233") );
		 
	}
	
	
	
	
}
