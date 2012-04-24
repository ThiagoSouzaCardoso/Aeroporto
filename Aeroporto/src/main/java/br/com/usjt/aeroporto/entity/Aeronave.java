package br.com.usjt.aeroporto.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Aeronave implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5552083734025912959L;
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty
	private String nome;
	@NotNull
	private Integer quantidadeAssentos;
	@OneToMany(mappedBy = "aeronave")
	private List<Voo> listVoos;

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

	/**
	 * @return the listVoos
	 */
	public List<Voo> getListVoos() {
		return listVoos;
	}

	/**
	 * @param listVoos
	 *            the listVoos to set
	 */
	public void setListVoos(List<Voo> listVoos) {
		this.listVoos = listVoos;
	}

}
