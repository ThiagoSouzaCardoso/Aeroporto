package br.com.usjt.aeroporto.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.usjt.aeroporto.dao.PassageiroDAO;
import br.com.usjt.aeroporto.entity.FormaTratamento;
import br.com.usjt.aeroporto.entity.Passageiro;

@ManagedBean(name = "passageiroBean")
@ViewScoped
@Service
public class PassageiroBean {

	private Passageiro passageiro = new Passageiro();

	@Autowired
	@Qualifier("PassageiroDAO")
	PassageiroDAO dao;

	public void salvarPassageiro() {
		dao.save(passageiro);
	}

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
}
