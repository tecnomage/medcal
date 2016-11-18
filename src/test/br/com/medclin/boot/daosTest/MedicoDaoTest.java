package br.com.medclin.boot.daosTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.AssertionErrors;

import br.com.medclin.boot.builders.CriadorDeMedico;
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;
import ch.qos.logback.core.net.SyslogOutputStream;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MedicoDaoTest {

	private Medico medico;

	@Autowired
	private MedicoDao medicoDao;

	@Autowired
	private MedicoDao repository;

	@Autowired
	private TestEntityManager entityManager;

	@Before
	public void setupMock() {
		medico = mock(Medico.class);
		repository = mock(MedicoDao.class);

	}

	@Test
	public void buscaPorCrmMockado() {

		when(medico.getCpf()).thenReturn("123");

		when(repository.findByCrm("123")).thenReturn(medico);

		Medico medicoCrm = new CriadorDeMedico().crm("123").controi();

		Medico MedicoTeste = repository.findByCrm("123");

		assertTrue(medicoCrm.equals(MedicoTeste));

		// assertEquals(medicoCrm , repository.findByCrm("123"));
	}

	@Test
	public void buscaPorCrmNoBD() {

		this.entityManager.persist(new Medico("123"));

		Medico medico = this.medicoDao.findByCrm("123");

		Medico medico2 = new Medico("123");

		assertThat(medico.getCrm()).isEqualTo("123");

	}

	@Test
	public void buscaporNome() {

		this.entityManager.persist(new Medico("vinicius", "123"));

		Medico medico = this.medicoDao.findByNome("vinicius");

		assertEquals("vinicius", medico.getNome());

	}

	@Test
	public void buscaporCpf() {

		Medico medico = new Medico("123", "vinicius", "80862730244", "rua 10");

		this.entityManager.persist(medico);

		String medCpf = this.medicoDao.findByCpf("80862730244");
		//System.out.println(medCpf.getCpf());

		//assertEquals("80862730244", medCpf.getCpf());
		assertEquals("80862730244", medCpf);
	}

	@Test
	public void buscaEndereco() {

		Medico medico = new Medico("123", "vinicius", "80862730244", "rua 10");

		this.entityManager.persist(medico);

		String medCpf = this.medicoDao.findByEndereco("rua 10");
		
		assertEquals("rua 10", medCpf);

	}

}
