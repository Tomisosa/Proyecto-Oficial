package com.primerproyecto.dao;

import java.util.List;

import com.primerproyecto.modelos.Usuario;

import jakarta.transaction.Transactional;

@Transactional
public interface UsuarioDao {
	
	public List<Usuario> getUsuarios();

	void eliminarUsuario(Long id);

	void registrarUsuario(Usuario usuario);

	boolean verificarCredenciales(Usuario usuario);

}
