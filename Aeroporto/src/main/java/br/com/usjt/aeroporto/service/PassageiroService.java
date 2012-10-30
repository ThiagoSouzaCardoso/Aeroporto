package br.com.usjt.aeroporto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.usjt.aeroporto.dao.PassageiroDAO;
import br.com.usjt.aeroporto.entity.Passageiro;

@Service
public class PassageiroService {

	@Autowired
	@Qualifier("PassageiroDAO")
	PassageiroDAO dao;

	public void salvarPassageiro(Passageiro passageiro) {
		dao.save(passageiro);
	}

}
