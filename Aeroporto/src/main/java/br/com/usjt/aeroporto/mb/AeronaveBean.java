package br.com.usjt.aeroporto.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import br.com.usjt.aeroporto.dao.AeronaveDAO;
import br.com.usjt.aeroporto.entity.Aeronave;

@ManagedBean(name = "aeronaveBean")
@ViewScoped
public class AeronaveBean {

	private Aeronave aeronave = new Aeronave();

	@Autowired
	@Qualifier("AeronaveDAO")
	private AeronaveDAO dao;

	/**
	 * @return the aeronave
	 */
	public Aeronave getAeronave() {
		return aeronave;
	}

	/**
	 * @param aeronave
	 *            the aeronave to set
	 */
	public void setAeronave(Aeronave aeronave) {
		this.aeronave = aeronave;
	}

	public void salvarAeronave() {
		dao.save(aeronave);
	}

}
