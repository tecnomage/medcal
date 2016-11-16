package br.com.medclin.daosTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.CriadorDeMedico;



@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
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

		when(medicoDao.findByCrm(medico.getCpf())).thenReturn(medico);

		Medico medicoCrm = new CriadorDeMedico().crm("123").controi();

		assertEquals(medicoCrm.getCrm(), medicoDao.findByCrm("123").getCpf());
	}
	
	
	@Test
	public void buscaPorCrmNoBD() {
		
		this.entityManager.persist(new Medico("123"));
		
		Medico medico = this.medicoDao.findByCrm("123");
		
		//Medico medico2 = new Medico("123");
		
		 assertThat(medico.getCrm()).isEqualTo("123");
				
	}
	
	
	
}
