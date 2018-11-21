package com.example.echo;


import java.util.ArrayList;
import java.util.Random;

import com.example.echo.Facade;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;


@Api(
	    name = "facade",
	    version = "v1",
	    namespace =
	    @ApiNamespace(
	        ownerDomain = "echo.example.com",
	        ownerName = "echo.example.com",
	        packagePath = ""
	    )
	)


public class Proxy {
	
	ArrayList<Usuario> usuarios = new ArrayList<Usuario>();	
	Facade sesion = Facade.reemplazar();
	
	/*
	public void CrearPasajero(){
		
	}
	public void CrearConductor(){
		
	}
	public void CrearAdministrador(){
		
	}
	*/
        
	@ApiMethod(name = "IniciarSesion", path = "IniciarSesion")
	public void IniciarSesion(@Named("Usuario") String us,@Named("Contraseña") String con){
		Long Login = null;
		for(Usuario persona:usuarios){
			if(persona.getCorreo().equals(us) && persona.getContrasena().equals(con)){				
				Login = new Random().nextLong();				
				sesion.setSesion(us, Login);
			}
		}		
	}
}
