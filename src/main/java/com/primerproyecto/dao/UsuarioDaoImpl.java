package com.primerproyecto.dao;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.primerproyecto.modelos.Usuario;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Repository
@Transactional

public class UsuarioDaoImpl implements UsuarioDao {
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Usuario> getUsuarios() {
		String query = "SELECT u FROM Usuario u";
		List<Usuario> resultado = entityManager.createQuery(query).getResultList();
		
		return resultado;
	}

	public void borrarUsuarioPorId(Long id) {
		Usuario usuario = entityManager.find(Usuario.class, id);
		entityManager.remove(usuario);
		
		
	}

	public void registrartUsuario(Usuario usuario) {
		entityManager.persist(usuario);
		
	}

	@Override
	public void eliminarUsuario(Long id) {
	    Usuario usuario = entityManager.find(Usuario.class, id);
	        entityManager.remove(usuario);
	}


	@Override
	public void registrarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		entityManager.merge(usuario);
	}

	@Override
	public boolean verificarCredenciales(Usuario usuario) {
		
		String query="FROM Usuario WHERE email= :email";
		
		List<Usuario> lista= entityManager.createQuery(query).
				setParameter("email", usuario.getEmail()).getResultList();
		
		
		if(lista.isEmpty()) {
			return false;
		}
		
		String passHasheada=lista.get(0).getPassword();
		
		Argon2 argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);		
		
		boolean passEsIgual=argon2.verify(passHasheada, usuario.getPassword());
			   
			   return passEsIgual; 
	}
	}
