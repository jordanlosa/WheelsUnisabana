package com.example.echo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiIssuer;
import com.google.api.server.spi.config.ApiIssuerAudience;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.config.Nullable;


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


public class Facade {

	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private HashMap<String,Long> sesiones = new HashMap<String,Long>();
	private ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 
	
	private static Facade unicains = null;
	
	public static Facade reemplazar()
	{
		if(unicains == null)
		{
			unicains = new Facade();
		}
		return unicains;
	}
	
	
	@ApiMethod(name = "CrearReserva", path = "CrearReserva")
	public Reserva CrearReserva(@Named("Pasajero") int pas,@Named("Ruta") int ruta,
			@Named("PuntoEncuentrox") Double Px,@Named("PuntoEncuentroy") Double Py,@Named("ValorReserva") int valor)
	{
		int id = this.reservas.size() + 1;
		 Reserva res = new Reserva(id,pas,ruta,Px,Py,valor);
		 this.reservas.add(res);
		 return res;
	}
	
	@ApiMethod(name = "BuscarReserva", path = "BuscarReserva")
	public Reserva BuscarReserva(@Named("Pasajero") int pas)
	{
		Reserva busqueda = null;
		for(Reserva bus:reservas)
		{
			if(bus.getPasajero()==pas)
			{
				busqueda = bus;
			}
				
		}
		 return busqueda;
	}
	
	@ApiMethod(name = "ListarReserva", path = "ListarReserva")
	public ArrayList<Reserva> ListarReserva()
	{
		 return this.reservas;
	}
		
	
	public void setSesion(@Named("us") String us,@Named("key") Long key)
	{
		sesiones.put(us,key);
	}
	
	/*
	private boolean validacion(String us,Long key)
	{
		sesiones.get(us);
		boolean val = false;
		if(sesiones.get(us).equals(key))
		{
			val = true;
		}
		return val;
	}
	*/
	
}
