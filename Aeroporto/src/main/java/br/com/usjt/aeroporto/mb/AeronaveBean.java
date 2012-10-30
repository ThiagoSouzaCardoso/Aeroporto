package br.com.usjt.aeroporto.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.usjt.aeroporto.dao.AeronaveDAO;
import br.com.usjt.aeroporto.entity.Aeronave;
import br.com.usjt.aeroporto.util.MessageUtil;

@ManagedBean(name = "aeronaveBean")
@ViewScoped
@Service
public class AeronaveBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5111562560040908083L;

	private Aeronave aeronave = new Aeronave();
	private List<Aeronave> listaAeronaves = new ArrayList<Aeronave>();

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

	/**
	 * @return the listaAeronaves
	 */
	public List<Aeronave> getListaAeronaves() {
		return listaAeronaves;
	}

	public void salvarAeronave() {
		dao.save(this.aeronave);
		this.aeronave = new Aeronave();

		MessageUtil.addMessage("msg_sucessOk", "tlt_cadastre");

	}

	public void consultaAeronave() {
		this.listaAeronaves = dao.findAllName(this.aeronave.getNome());

		if (listaAeronaves.isEmpty())
			MessageUtil.addErrorMessage("msg_errorForSearch", "tlt_consult");

	}

	public void clean() {
		this.aeronave = new Aeronave();
		this.listaAeronaves = new ArrayList<Aeronave>();
	}

	public void remove() {
		dao.delete(aeronave);
	}

	public void onEdit(RowEditEvent event) {
		dao.update(((Aeronave) event.getObject()));

		FacesMessage msg = new FacesMessage("Car Edited", ((Aeronave) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Cancelled", ((Aeronave) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
