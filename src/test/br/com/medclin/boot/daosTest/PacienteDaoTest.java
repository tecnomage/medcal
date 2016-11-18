package br.com.medclin.boot.daosTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.medclin.boot.builders.CriadorDeMedico;
import br.com.medclin.boot.builders.CriadorDePaciente;
import br.com.medclin.boot.builders.CriadorDePacientes;
import br.com.medclin.boot.daos.PacienteDao;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.boot.models.Paciente;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PacienteDaoTest {

	private Paciente pct;

	@Autowired
	private PacienteDao pctDao;
	
	@Autowired
	private PacienteDao repository;

	@Autowired
	private TestEntityManager entityManager;

	@Before
	public void prepareMocks() {
		 pct = mock(Paciente.class);
		 pctDao = mock(PacienteDao.class);
			}

	@Test
	public void buscaPorCpfMockado() {
		
		when(pct.getCpf()).thenReturn("123");

		when(pctDao.findByCpf("123")).thenReturn(pct);

		//Paciente pct = new CriadorDePacientes().cpf("123").nome("vini").endereco("rua 10").constroi();
		
		
		Paciente pctRepoMocado = pctDao.findByCpf("123");
		
		assertEquals("123", pct.getCpf());
		
	}

}
