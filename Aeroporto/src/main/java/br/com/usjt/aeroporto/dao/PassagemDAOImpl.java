package br.com.usjt.aeroporto.dao;

import br.com.usjt.aeroporto.entity.Passagem;

public class PassagemDAOImpl extends GenericDAOImpl<Passagem> implements
		PassagemDAO {

	public PassagemDAOImpl() {
		super(Passagem.class);
	}

}
