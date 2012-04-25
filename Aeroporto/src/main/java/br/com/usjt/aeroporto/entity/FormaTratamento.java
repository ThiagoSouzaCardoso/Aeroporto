package br.com.usjt.aeroporto.entity;

import java.util.ResourceBundle;

public enum FormaTratamento {

	SRA, SR, SRTA;

	private static final ResourceBundle res = ResourceBundle
			.getBundle("br.com.usjt.mensagens.Resources");

	@Override
	public String toString() {
		return res.getString(name() + ".string");
	}

}
