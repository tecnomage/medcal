package br.com.medclin.boot.daosTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
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
import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;



@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
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
		
		//this.entityManager.persist(new Medico("123"));
		
		//Medico medico = this.medicoDao.findByCrm("123");
		
		//Medico medico2 = new Medico("123");
		
		 //assertThat(medico.getCrm()).isEqualTo("123");
				
	}
	
//TODO erro ao realizar o teste	
//	17:01:46.475 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test cl
//	ass [br.com.medclin.boot.daosTest.MedicoDaoTest], using SpringBootContextLoader
//	17:01:46.479 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [br.com.medclin.boot.
//	daosTest.MedicoDaoTest]: class path resource [br/com/medclin/boot/daosTest/MedicoDaoTest-context.xml] does not exist
//	17:01:46.479 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [br.com.medclin.boot.
//	daosTest.MedicoDaoTest]: class path resource [br/com/medclin/boot/daosTest/MedicoDaoTestContext.groovy] does not exist
//	17:01:46.480 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [br.com.medclin.boo
//	t.daosTest.MedicoDaoTest]: no resource found for suffixes {-context.xml, Context.groovy}.
//	17:01:46.480 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [br
//	.com.medclin.boot.daosTest.MedicoDaoTest]: MedicoDaoTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
	
}
