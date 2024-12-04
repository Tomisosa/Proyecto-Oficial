package com.primerproyecto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.primerproyecto.dao.UsuarioDao;
import com.primerproyecto.modelos.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuario() {
    	
        List<Usuario> user=usuarioDao.getUsuarios();
        
        return user;
    }
    
    
    @DeleteMapping(value = "api/usuarios/{id}")
    
    public void eliminarUsuario(@PathVariable Long id) {
    	 usuarioDao.eliminarUsuario(id);
    }

    @PostMapping(value = "api/usuarios")
    public void registrarUsuario(@RequestBody Usuario usuario) {
    	
    	Argon2 argon2;
    	argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        usuarioDao.registrarUsuario(usuario);
    }
    
}
