package br.com.medclin.modelsTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.ConsultaBuilder;

public class ConsultaTest {
	
	@Test(expected = Error.class)
	public void TodaConsultaDeveTerMedicoEpaciente(){
		
		Consulta consulta = new ConsultaBuilder().medico().paciente("808123").constroi();
			
		//return getPct() + medico.toString() + getReceita();
		//assertEquals("", consulta.toString());
		
	
	}
	
//TODO testar o toString

}
