package br.com.usjt.aeroporto.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.usjt.aeroporto.entity.FormaTratamento;
import br.com.usjt.aeroporto.entity.Passageiro;
import br.com.usjt.aeroporto.entity.TipoPassageiro;
import br.com.usjt.aeroporto.service.PassageiroService;
import br.com.usjt.aeroporto.util.MessageUtil;

@ManagedBean(name = "passageiroBean")
@ViewScoped
@Component
@Scope("session")
public class PassageiroBean {

	private Passageiro passageiro = new Passageiro();

	@Autowired
	PassageiroService passageiroService;

	/**
	 * @return the passageiro
	 */
	public Passageiro getPassageiro() {
		return passageiro;
	}

	/**
	 * @param passageiro
	 *            the passageiro to set
	 */
	public void setPassageiro(Passageiro passageiro) {
		this.passageiro = passageiro;
	}

	public List<SelectItem> getFormaTratamento() {

		List<SelectItem> listFormaTratamento = new ArrayList<SelectItem>();

		for (FormaTratamento ft : FormaTratamento.values()) {
			listFormaTratamento.add(new SelectItem(ft.name(), ft.toString()));
		}
		return listFormaTratamento;
	}

	public List<SelectItem> getTipoPassageiro() {
		List<SelectItem> listTipoPassageiro = new ArrayList<SelectItem>();
		for (TipoPassageiro ft : TipoPassageiro.values()) {
			listTipoPassageiro.add(new SelectItem(ft.name(), ft.toString()));
		}
		return listTipoPassageiro;
	}

	public void salvarPassageiro() {
		passageiroService.salvarPassageiro(this.passageiro);
		clean();
		MessageUtil.addMessage("msg_sucessOk", "tlt_cadastre");
	}

	public void clean() {
		this.passageiro = new Passageiro();
	}

}
