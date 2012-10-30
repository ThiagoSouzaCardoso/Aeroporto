package br.com.usjt.aeroporto.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.usjt.aeroporto.dao.UsuarioDAO;
import br.com.usjt.aeroporto.entity.Usuario;

@ManagedBean
@SessionScoped
@Component
@Scope("session")
public class LoginBean {

	private Usuario usuario;

	@Autowired
	@Qualifier("UsuarioDAO")
	private UsuarioDAO dao;

	public LoginBean() {
		this.setUsuario(new Usuario());
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuarLogin() {
		boolean loginValido = dao.validUserAndPassword(this.usuario);
		if (loginValido) {
			return "aeronave?faces-redirect=true";
		} else {
			return "login?faces-redirect=true";
		}

	}

}
