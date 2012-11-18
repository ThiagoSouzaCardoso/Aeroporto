package br.com.usjt.aeroporto.util;

import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class MessageUtil {

	public static void addMessage(String key, String title, Severity type) {
		currentInstanceUtil().addMessage(null, new FacesMessage(type, bundleName(title), bundleName(key)));
	}

	public static String addMessageEnum(String key) {
		return bundleName(key);
	}

	private static String bundleName(String key) {
		String bundleName = "br.com.usjt.mensagens.Resources";
		return bundleMessage(bundleName).getString(key);

	}

	private static ResourceBundle bundleMessage(String bundleName) {
		return ResourceBundle.getBundle(bundleName, currentInstanceUtil().getViewRoot().getLocale());
	}

	private static FacesContext currentInstanceUtil() {
		return FacesContext.getCurrentInstance();
	}

}
