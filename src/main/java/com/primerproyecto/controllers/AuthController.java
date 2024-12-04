package com.primerproyecto.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



import com.primerproyecto.dao.UsuarioDao;
import com.primerproyecto.modelos.Usuario;

@RestController
public class AuthController {
	
	 @Autowired
	    private UsuarioDao usuarioDao;
	

    @PostMapping(value = "api/login")
    public String login(@RequestBody Usuario usuario) {
    	
      if( usuarioDao.verificarCredenciales(usuario)) {
        return "OK";
        
        }
	    return "Fail";
    }
    
}
	

