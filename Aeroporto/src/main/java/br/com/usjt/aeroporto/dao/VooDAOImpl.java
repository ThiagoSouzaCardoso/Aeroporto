package br.com.usjt.aeroporto.dao;

import br.com.usjt.aeroporto.entity.Voo;

public class VooDAOImpl extends GenericDAOImpl<Voo> implements VooDAO {

	public VooDAOImpl() {
		super(Voo.class);
	}

}
