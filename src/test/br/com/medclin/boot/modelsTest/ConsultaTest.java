package br.com.medclin.boot.modelsTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import br.com.medclin.boot.builders.ConsultaBuilder;
import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Medico;

public class ConsultaTest {
	
	//FIXME modificar o teste para comportar Paciente como lista na classe consulta
	@Test(expected = Error.class)
	public void TodaConsultaDeveTerMedicoEpaciente(){
		
		Consulta consulta = new ConsultaBuilder().medico().paciente("808123").constroi();
			
		//return getPct() + medico.toString() + getReceita();
		//assertEquals("", consulta.toString());
		
	
	}
	
//TODO testar o toString
	@Test
	public void TestaTostring(){
		Consulta consulta = new ConsultaBuilder().medico("123", "fulano").paciente("pct", "808").constroi();
		
		//return this.pct.getNome() + this.medico.getCrm();
		assertEquals("pct" + "123",consulta.toString() );
		
		
	}
	
	

}
