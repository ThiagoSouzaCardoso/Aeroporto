package br.com.usjt.aeroporto.mb;

import java.util.Locale;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.stereotype.Component;

@Component
@SessionScoped
public class InternacionalizacaoBean {
	private Locale locale = new Locale("pt");

	public void mudaParaPortugues() {
		locale = new Locale("pt");
		// Locale locale = new Locale("pt","BR");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void mudaParaIngles() {
		locale = new Locale("en");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public void mudaParaFrances() {
		locale = new Locale("fr");
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}
}
