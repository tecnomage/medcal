package br.com.medclin.boot.daosTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.List;

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
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MedicoDaoTest {

	private Medico medico;

	@Autowired
	private MedicoDao repository;

	@Autowired
	private MedicoDao medicoDaoMock;

	@Autowired
	private TestEntityManager entityManager;

	@Before
	public void setupMock() {
		medico = mock(Medico.class);
		medicoDaoMock = mock(MedicoDao.class);

		this.entityManager.persist(new Medico("vinicius", "123"));
		this.entityManager.persist(new Medico("1234", "maria", "80862730244", "rua 10"));
		this.entityManager.persist(new Medico("12", "antonio", "8086217", "rua 11"));
	}

	@Test
	public void buscaPorCrmMockado() {

		when(medico.getCpf()).thenReturn("123");

		when(medicoDaoMock.findByCrm("123")).thenReturn(medico);

		Medico medicoCrm = new CriadorDeMedico().crm("123").controi();

		Medico MedicoTeste = medicoDaoMock.findByCrm("123");

		assertTrue(medicoCrm.equals(MedicoTeste));

		// assertEquals(medicoCrm , repository.findByCrm("123"));
	}

	@Test
	public void buscaPorCrmNoBD() {

		Medico medico = this.repository.findByCrm("123");

		assertThat(medico.getCrm()).isEqualTo("123");

	}

	@Test
	public void buscaporNome() {

		Medico medico = this.repository.findByNome("vinicius");

		assertEquals("vinicius", medico.getNome());

	}

	@Test
	public void buscaporCpf() {

		String medCpf = this.repository.findByCpf("80862730244");
		// System.out.println(medCpf.getCpf());

		// assertEquals("80862730244", medCpf.getCpf());
		assertEquals("80862730244", medCpf);
	}

	@Test
	public void buscaEndereco() {

		String medCpf = this.repository.findByEndereco("rua 10");

		assertEquals("rua 10", medCpf);

	}

	
	@Test
	public void buscaTodos() {
		List<Medico> medicos =  (List<Medico>) repository.findAll();

		assertThat(medicos, hasSize(3));
		
	}

}
