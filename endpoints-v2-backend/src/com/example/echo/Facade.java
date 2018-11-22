package com.example.echo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import com.google.api.server.spi.auth.EspAuthenticator;
import com.google.api.server.spi.auth.common.User;
import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;
import com.google.api.server.spi.response.UnauthorizedException;

import main.java.com.example.echo.Pasajero;
import main.java.com.example.echo.Reserva;
import main.java.com.example.echo.Usuario;

@Api(
	    name = "facade",
	    version = "v1",
	    namespace =
	    @ApiNamespace(
	        ownerDomain = "echo.example.com",
	        ownerName = "echo.example.com",
	        packagePath = ""
	    ))
public class Facade {
	/*ecra*/
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	HashMap<Long,String> sesiones = new HashMap<Long,String>();
	ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 
	
private ArrayList<Usuario> usuario;
			
	@ApiMethod(name = "facade")
	public void crearUsuario(@Named("Nombre") String Nombre, @Named("Correo") String Correo, 
							@Named("Contraseña") String contrasena,@Named("Tipo") String tipo) {
		
		Usuario usu = new Pasajero(Nombre,Correo, contrasena,tipo);
		usuario.add(usu);
	}
	
Usuario pas = new Pasajero();
	
	
	@ApiMethod (name = "listarUsuario", path = "reserva list")
	public ArrayList<Reserva> listarReserva (@Named String nombreP) {
			
		ArrayList<Reserva> reservs = new ArrayList<>();
		for (int x=0; x < this.reservas.size(); x++) {
			if (reservas.get(x).getPasajero().getNombre().equals(nombreP)) {
				reservs.add(reservas.get(x));
			}
			
		}

		return reservs;	
	}

}
