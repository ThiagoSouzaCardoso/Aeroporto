package br.com.usjt.aeroporto.entity;

import br.com.usjt.aeroporto.util.MessageUtil;

public enum TipoPassageiro {

	ADULTO, CRIANCA, BEBE;

	@Override
	public String toString() {
		return MessageUtil.addMessageEnum(name());
	}
}
