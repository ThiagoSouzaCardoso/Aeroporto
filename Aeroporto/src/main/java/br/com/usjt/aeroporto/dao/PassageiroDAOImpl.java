package br.com.usjt.aeroporto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.usjt.aeroporto.entity.Passageiro;

@Repository("PassageiroDAO")
@Transactional
public class PassageiroDAOImpl extends GenericDAOImpl<Passageiro> implements
		PassageiroDAO {

	public PassageiroDAOImpl() {
		super(Passageiro.class);
	}

}
