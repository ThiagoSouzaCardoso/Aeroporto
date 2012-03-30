package br.com.usjt.aeroporto.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.usjt.aeroporto.entity.Aeronave;

@ManagedBean(name = "aeronaveBean")
@ViewScoped
public class AeronaveBean {

	private Aeronave aeronave = new Aeronave();

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

}
