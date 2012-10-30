package br.com.usjt.aeroporto.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.usjt.aeroporto.entity.Usuario;

@Repository("UsuarioDAO")
@Transactional
public class UsuarioDAOImpl extends GenericDAOImpl<Usuario> implements UsuarioDAO {

	public UsuarioDAOImpl() {
		super(Usuario.class);
	}

	@Override
	public boolean existeUsuario(String login) {

		javax.persistence.Query query = getCurrentSession().createQuery("from " + classe.getName() + " u where u.login = :pLogin");
		query.setParameter("pLogin", login);

		boolean existe = (query.getResultList().isEmpty() ? false : true);

		return existe;
	}

	@Override
	public boolean validUserAndPassword(Usuario usuario) {

		javax.persistence.Query query = getCurrentSession().createQuery("from " + classe.getName() + " u where u.login = :pLogin and u.senha = :pSenha");
		query.setParameter("pLogin", usuario.getLogin());
		query.setParameter("pSenha", usuario.getSenha());

		boolean usuarioValido = (query.getResultList().isEmpty() ? false : true);

		return usuarioValido;
	}
}
