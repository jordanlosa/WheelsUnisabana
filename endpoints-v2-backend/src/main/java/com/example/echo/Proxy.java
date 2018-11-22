package main.java.com.example.echo;


import java.util.ArrayList;
import java.util.Random;

import main.java.com.example.echo.Facade;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;


@Api(
	    name = "proxy",
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
	Facade sesionf = Facade.reemplazar();
	
	/*
	public void CrearPasajero(){
		
	}
	public void CrearConductor(){
		
	}
	public void CrearAdministrador(){
		
	}
	*/
        
	@ApiMethod(name = "IniciarSesion", path = "IniciarSesion",httpMethod="GET")
	public Sesion IniciarSesion(@Named("Usuario") String us,@Named("Contrasena") String con){
		Usuario admin = new Administrador();
		admin.setCorreo("jordan");
		admin.setContrasena("jordan");
		usuarios.add(admin);
		Sesion sesion = new Sesion();
		Long Login = (Long) 12345678910L;		
		for(Usuario persona:usuarios){
			if(persona.getCorreo().equals(us) && persona.getContrasena().equals(con)){				
				Login = new Random().nextLong();
				sesion.setLog(Login);
				sesionf.setSesion(us, Login);
			}
		}	
		return sesion;
	}
}
