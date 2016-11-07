package br.com.medclin.modelsTest;


import static org.junit.Assert.assertEquals;

import java.util.Calendar;

import org.junit.Test;

import br.com.medclin.builders.CriadorDePacientes;
import br.com.medclin.models.Paciente;


public class PacienteTest {


	
	@Test(expected = Error.class )
	public void NaoPodeCriarSemCPF(){
		
		//Paciente mocado = mock(Paciente.class);
		Paciente pct = new Paciente("maria",Calendar.getInstance(),"rua brig franco 1999", null);
			assertEquals(null, pct);
	}
	
	@Test(expected = Error.class)
	public void NaoPodeCriarSemEndereco(){
		
			//Paciente pct = new Paciente("teste", Calendar.getInstance(), null , "80862730244");
			Paciente pct = new CriadorDePacientes().nome("vincius").cpf("80807747474").nascimento(Calendar.getInstance())
					.endereco().constroi();;
		
	}
	
	
	
	
	
	
	
// todo paciente deve ter um cpf
// todo paciente deve ter um endereço
// plano de saúde é opcional 
//	
//	
//
//	
//	
	
}