package br.com.medclin.boot.daosTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.List;

import org.hamcrest.collection.IsIterableContainingInOrder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.medclin.boot.daos.PacienteDao;
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
		
		this.entityManager.persist(new Paciente("vinicius", Calendar.getInstance(), "rua 10", "1"));
		this.entityManager.persist(new Paciente("marcio", Calendar.getInstance(), "rua 10", "2"));
		this.entityManager.persist(new Paciente("ius", Calendar.getInstance(), "rua 10", "3"));
		this.entityManager.persist(new Paciente("mariozinho", Calendar.getInstance(), "rua 10", "123"));
		this.entityManager.persist(new Paciente("marcela", Calendar.getInstance(), "rua 10", "4"));
		
		
	}

	@Test
	public void buscaPorCpfMockado() {

		when(pct.getCpf()).thenReturn("123");

		when(pctDao.findByCpf("123")).thenReturn(pct);

		Paciente pctRepoMocado = pctDao.findByCpf("123");

		assertEquals("123", pct.getCpf());

	}

	@Test
	public void BuscaPorNome() {
		
		Paciente pct = this.repository.findByNome("vinicius");
		
		assertEquals("vinicius",pct.getNome());
	}
	
	@Test
	public void BuscaPorCpf() {
		
		
		
		Paciente paciente = this.repository.findByCpf("123");
		
		// Paciente pctAux = new Paciente("123");
		
		assertThat(paciente.getCpf()).isEqualTo("123");
		
	}
	
	@Test
	public void BuscaTodos() {
		

		List<Paciente> pcts = (List<Paciente>) repository.findAll(); 
		
		List<Paciente> pcts2 = (List<Paciente>) repository.findAll();
		
		for (Paciente paciente : pcts2) {
			System.out.println( paciente.getNome());
		}
		
		assertThat(pcts,
				IsIterableContainingInOrder.contains(pcts2.toArray()));
		
	}
	
	

}
