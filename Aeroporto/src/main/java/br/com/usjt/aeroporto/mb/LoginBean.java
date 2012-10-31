package br.com.usjt.aeroporto.mb;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import br.com.usjt.aeroporto.entity.Usuario;
import br.com.usjt.aeroporto.service.UsuarioService;

@ManagedBean
@SessionScoped
@Component
@Scope("session")
public class LoginBean {

	private Usuario usuario;

	@Autowired
	private UsuarioService service;

	@Autowired
	private UsuarioLogado logado;

	public LoginBean() {
		this.setUsuario(new Usuario());
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario == null ? new Usuario() : usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String efetuarLogin() {
		if (service.validaUsuarioESenha(this.usuario)) {
			logado.setUsuario(this.usuario);
			return "aeronave?faces-redirect=true";
		} else {
			return "login?faces-redirect=true";
		}
	}

	public boolean isLogado() {
		return logado.isLogado();
	}

	public String logout() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
		request.getSession().invalidate();

		return "login?faces-redirect=true";
	}

}
