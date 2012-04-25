package br.com.usjt.aeroporto.entity;

public enum TipoPassageiro {

	ADULTO("Adulto"), CRIANCA("Criança"), BEBE("Bebê");

	private String tipoPassageiro;

	TipoPassageiro(String tipoPassageiro) {
		this.tipoPassageiro = tipoPassageiro;
	}

	/**
	 * @return the tipoPassageiro
	 */
	public String getTipoPassageiro() {
		return tipoPassageiro;
	}

}
