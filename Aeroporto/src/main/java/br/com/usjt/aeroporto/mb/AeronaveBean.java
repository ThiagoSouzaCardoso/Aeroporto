package br.com.usjt.aeroporto.mb;

import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import static javax.faces.application.FacesMessage.SEVERITY_INFO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.usjt.aeroporto.entity.Aeronave;
import br.com.usjt.aeroporto.service.AeronaveService;
import br.com.usjt.aeroporto.util.MessageUtil;

@ManagedBean(name = "aeronaveBean")
@SessionScoped
@Component
@Scope("session")
public class AeronaveBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5111562560040908083L;

	private Aeronave aeronave = new Aeronave();
	private List<Aeronave> listaAeronaves = new ArrayList<Aeronave>();

	@Autowired
	private AeronaveService aeronaveService;

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
		aeronaveService.salvarAeronave(aeronave);
		clean();
		MessageUtil.addMessage("msg_sucessOk", "tlt_cadastre", SEVERITY_INFO);

	}

	public void consultaAeronave() {
		this.listaAeronaves = aeronaveService.consultaAeronave(aeronave);

		if (listaAeronaves.isEmpty())
			MessageUtil.addMessage("tlt_consult", "msg_errorForSearch", SEVERITY_ERROR);

	}

	public void clean() {
		this.aeronave = new Aeronave();
		this.listaAeronaves = new ArrayList<Aeronave>();
	}

	public void remove() {
		aeronaveService.removeAeronave(aeronave);
	}

	public void onEdit(RowEditEvent event) {

		aeronaveService.atualizaAeronave((Aeronave) event.getObject());

	}

	public void onCancel(RowEditEvent event) {
		FacesMessage msg = new FacesMessage("Car Cancelled", ((Aeronave) event.getObject()).getNome());
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
