package br.com.usjt.aeroporto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Aeronave {

	@Id
	private Long id;
	private String nome;
	private Integer quantidadeAssentos;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the quantidadeAssentos
	 */
	public Integer getQuantidadeAssentos() {
		return quantidadeAssentos;
	}

	/**
	 * @param quantidadeAssentos
	 *            the quantidadeAssentos to set
	 */
	public void setQuantidadeAssentos(Integer quantidadeAssentos) {
		this.quantidadeAssentos = quantidadeAssentos;
	}

}
