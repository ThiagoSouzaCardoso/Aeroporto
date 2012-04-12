/**
 * 
 */
package br.com.usjt.aeroporto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.usjt.aeroporto.entity.Aeronave;

/**
 * @author thiagosouzacardoso
 * 
 */
@Repository("AeronaveDAO")
@Transactional
public class AeronaveDAOImpl extends GenericDAOImpl<Aeronave> implements
		AeronaveDAO {

	public AeronaveDAOImpl() {
		super(Aeronave.class);
	}

}
