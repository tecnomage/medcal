package br.com.medclin.daosTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.medclin.boot.daos.MedicoDao;
import br.com.medclin.boot.models.Medico;
import br.com.medclin.builders.CriadorDeMedico;

public class MedicoDaoTest {

	private Medico medico;
	private MedicoDao medicoDao;
	
	
	@Before
	public void setupMock() {
		medico = mock(Medico.class);
		medicoDao = mock(MedicoDao.class);
		
	}
	
	
	@Test
	public void buscaPorCrm() {
		when(medico.getCpf()).thenReturn("123");
				
		when(medicoDao.findByCrm(medico.getCpf())).thenReturn(medico);
		
		Medico medicoCrm = new CriadorDeMedico().crm("123").controi();
				
		assertEquals(medicoCrm.getCrm(), medicoDao.findByCrm("123").getCpf());
	}
	
	
	
	
	
	
	
	
	
}
