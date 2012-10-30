package br.com.usjt.aeroporto.dao;

import br.com.usjt.aeroporto.entity.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario> {

	public boolean existeUsuario(String nome);

	public boolean validUserAndPassword(Usuario usuario);

}
