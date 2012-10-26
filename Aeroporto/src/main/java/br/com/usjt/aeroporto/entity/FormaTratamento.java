package br.com.usjt.aeroporto.entity;

import br.com.usjt.aeroporto.util.MessageUtil;

public enum FormaTratamento {

	SRA, SR, SRTA;

	@Override
	public String toString() {

		return MessageUtil.addMessageEnum(name());
	}
}
