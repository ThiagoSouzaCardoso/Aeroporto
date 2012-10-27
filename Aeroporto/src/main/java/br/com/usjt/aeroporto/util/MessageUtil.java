package br.com.usjt.aeroporto.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessageUtil {

	public static void addMessage(String key, String title) {
		currentInstanceUtil().addMessage(null, new FacesMessage(bundleName(title), bundleName(key)));
	}

	public static void addErrorMessage(String key, String title) {
		currentInstanceUtil().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, bundleName(title), bundleName(key)));
	}

	public static String addMessageEnum(String key) {

		return bundleName(key);
	}

	private static String bundleName(String key) {

		FacesContext facesContext = currentInstanceUtil();
		String bundleName = "br.com.usjt.mensagens.Resources";
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName, facesContext.getViewRoot().getLocale());
		String message = bundle.getString(key);

		return message;
	}

	private static FacesContext currentInstanceUtil() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		return facesContext;
	}

}
