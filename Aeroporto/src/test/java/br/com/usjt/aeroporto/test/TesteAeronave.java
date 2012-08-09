package br.com.usjt.aeroporto.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import br.com.usjt.aeroporto.dao.AeronaveDAO;
import br.com.usjt.aeroporto.entity.Aeronave;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class TesteAeronave {

	@Autowired
	@Qualifier("AeronaveDAO")
	private AeronaveDAO dao;

	@Test
	public void teste() {

		// Aeronave aeronave = dao.findById(1L);
		Aeronave aeronave = new Aeronave();
		aeronave.setId(1L);
		dao.update(aeronave);

		System.out.println(aeronave.getNome());

	}
}
