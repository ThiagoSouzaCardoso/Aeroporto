package br.com.usjt.aeroporto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import br.com.usjt.aeroporto.dao.UsuarioDAO;
import br.com.usjt.aeroporto.entity.Usuario;

@Service
public class UsuarioService {

	@Autowired
	@Qualifier("UsuarioDAO")
	private UsuarioDAO dao;

	public boolean validaUsuarioESenha(Usuario usuario) {
		return dao.validUserAndPassword(usuario);
	}

}
