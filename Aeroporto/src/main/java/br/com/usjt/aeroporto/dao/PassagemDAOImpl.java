package br.com.usjt.aeroporto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.usjt.aeroporto.entity.Passagem;

@Repository("PassagemDAO")
@Transactional
public class PassagemDAOImpl extends GenericDAOImpl<Passagem> implements
		PassagemDAO {

	public PassagemDAOImpl() {
		super(Passagem.class);
	}

}
