package br.com.medclin.modelsTest;

import br.com.medclin.builders.ConsultaBuilder;

public class ConsultaTest {
	
	@Test
	public void TodaConsultaDeveTerMedicoEpaciente(){
		ConsultaBuilder.medico("1222").paciente("808123").constroi();
	}

}
