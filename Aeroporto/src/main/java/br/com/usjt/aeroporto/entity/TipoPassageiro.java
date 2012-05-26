package br.com.usjt.aeroporto.entity;

import java.util.ResourceBundle;

import javax.faces.context.FacesContext;

public enum TipoPassageiro {

	ADULTO, CRIANCA, BEBE;

	@Override
	public String toString() {

		ResourceBundle res = ResourceBundle.getBundle(
				"br.com.usjt.mensagens.Resources", FacesContext
						.getCurrentInstance().getViewRoot().getLocale());

		return res.getString(name() + ".string");
	}
}
