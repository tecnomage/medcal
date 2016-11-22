package br.com.medclin.boot.modelsTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;

import org.junit.Test;

import br.com.medclin.boot.builders.CriadorDePacientes;
import br.com.medclin.boot.models.Paciente;

public class PacienteTest {

	@Test(expected = Error.class)
	public void NaoPodeCriarSemCPF() {

		// Paciente mocado = mock(Paciente.class);
		Paciente pct = new Paciente("maria", Calendar.getInstance(), "rua brig franco 1999", null);
		assertEquals(null, pct);
	}

	@Test(expected = Error.class)
	public void NaoPodeCriarSemEndereco() {

		// Paciente pct = new Paciente("teste", Calendar.getInstance(), null ,
		// "80862730244");
		try {
			Paciente pct = new CriadorDePacientes().nome("vincius").cpf("80807747474")
					.nascimento(Calendar.getInstance()).endereco(null).constroi();
		} catch (Error e) {

			e.printStackTrace();
		}

	}

	@Test
	public void deveRetornarNomeEcpf() {
		CriadorDePacientes criadorDePacientes = new CriadorDePacientes();

		criadorDePacientes.nome("vincius").cpf("80807747474").nascimento(Calendar.getInstance())
				.endereco("rua mass effect").constroi();

		assertEquals("80807747474" + "vincius", criadorDePacientes.toString());

	}

	@Test
	public void deveComparar2objetos() {
		Paciente pct = new CriadorDePacientes().nome("vinicius").cpf("123").endereco("rua 10").constroi();
		Paciente pctEquals = new CriadorDePacientes().nome("vinicius").cpf("123").endereco("rua 12").constroi();

		assertTrue(pct.equals(pctEquals));

	}

}
