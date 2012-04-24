package br.com.usjt.aeroporto.dao;

import br.com.usjt.aeroporto.entity.Passageiro;

public class PassageiroDaoImpl extends GenericDAOImpl<Passageiro> implements
		PassageiroDAO {

	public PassageiroDaoImpl() {
		super(Passageiro.class);
	}

}
