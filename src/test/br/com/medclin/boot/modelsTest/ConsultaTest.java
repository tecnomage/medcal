package br.com.medclin.boot.modelsTest;


import static org.hamcrest.Matchers.contains;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Before;
import org.junit.Test;

import br.com.medclin.boot.builders.ConsultaBuilder;
import br.com.medclin.boot.models.Consulta;
import br.com.medclin.boot.models.Paciente;

public class ConsultaTest {

	private List<Paciente> pacientes = new ArrayList<>();

	@Before
	public void setTest() {

		pacientes.add(new Paciente("vinicius", Calendar.getInstance(), "rua 1", "123"));
		pacientes.add(new Paciente("jorge", Calendar.getInstance(), "rua 2", "124"));
		pacientes.add(new Paciente("maria", Calendar.getInstance(), "rua 3", "125"));

	}


	@Test(expected = Error.class)
	public void TodaConsultaDeveTerMedicoEpaciente() {

		Consulta consulta = new ConsultaBuilder().medico("123", "fulano").constroi();
		
		// return getPct() + medico.toString() + getReceita();
		assertThat(consulta.getPct(), IsEmptyCollection.emptyCollectionOf(Paciente.class));
		
		
	}

	// FIXME not work
	@Test
	public void TestaTostring() {
		Consulta consulta = new ConsultaBuilder().medico("123", "fulano").pacientes((ArrayList<Paciente>) pacientes)
				.constroi();

		assertThat(consulta.toString(),containsString("vinicius"));


	}

}
