package br.com.medclin.boot.daosTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

import java.util.Calendar;
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

import br.com.medclin.boot.daos.PacienteDao;
import br.com.medclin.boot.daos.PlanoDao;
import br.com.medclin.boot.models.Paciente;
import br.com.medclin.boot.models.Plano;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class PlanoDaoTest {

	private Paciente pct;

	@Autowired
	private PlanoDao planoDao;

	@Autowired
	private PacienteDao repository;

	@Autowired
	private TestEntityManager entityManager;

	@Before
	public void preparaTest() {

		Plano unimed = new Plano("unimed");
		Plano cacic = new Plano("cacic");
		Plano amil = new Plano("amil");

		this.entityManager.persist(unimed);
		this.entityManager.persist(cacic);
		this.entityManager.persist(amil);

		this.entityManager.persist(new Paciente("vinicius", Calendar.getInstance(), "rua 1", "11", unimed));
		this.entityManager.persist(new Paciente("mario", Calendar.getInstance(), "rua 2", "12", cacic));
		this.entityManager.persist(new Paciente("marcio", Calendar.getInstance(), "rua 3", "13", unimed));
		this.entityManager.persist(new Paciente("marcio", Calendar.getInstance(), "rua 4", "14", cacic));
		this.entityManager.persist(new Paciente("marcio", Calendar.getInstance(), "rua 5", "15", unimed));

	}

	@Test
	public void pegaNdePctPorPlano() {
		
				
		//List<Paciente> planosPorPcte = this.planoDao.getNumeroDePctPorPlano();
		
		List<Plano> planosPorPcte = this.planoDao.getNumeroDePctPorPlano();
		
		assertThat(planosPorPcte, hasSize(5));
	}

}
