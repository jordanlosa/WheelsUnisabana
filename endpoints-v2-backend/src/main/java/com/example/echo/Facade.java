package main.java.com.example.echo;

import java.util.ArrayList;
import java.util.HashMap;

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


public class Facade {

	private ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	private HashMap<String,Long> sesiones = new HashMap<String,Long>();
	private ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 
	
	private static Facade unicains = null;
	
	public void setSesion(@Named("us") String us,@Named("key") Long key)
	{
		sesiones.put(us,key);
	}
	
	
	public void validacion(@Named("us") String us,@Named("key") Long key)
	{
		sesiones.get(us);
		boolean val = false;
		if(sesiones.get(us).equals(key))
		{
			val = true;
		}
		
	}
	
	
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
			@Named("PuntoEncuentrox") Double Px,@Named("PuntoEncuentroy") Double Py,@Named("ValorReserva") int valor,
			@Named("key") Long key)
	{
		int id = this.reservas.size() + 1;
		 Reserva res = new Reserva(id,pas,ruta,Px,Py,valor);
		 this.reservas.add(res);
		 return res;
	}
	
	@ApiMethod(name = "BuscarReserva", path = "BuscarReserva",httpMethod = "GET")
	public Reserva BuscarReserva(@Named("Pasajero") int pas,@Named("key") Long key)
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
	
	@ApiMethod(name = "ListarReserva", path = "ListarReserva",httpMethod = "GET")
	public ArrayList<Reserva> ListarReserva(@Named("Pasajero") int pas, @Named("key") Long key)
	{
		ArrayList<Reserva> busque = new ArrayList<Reserva>();
		for(Reserva bus:reservas)
		{
			if(bus.getPasajero()==pas)
			{
				busque.add(bus);
			}
				
		}
		 return busque;
	}
	
	@ApiMethod(name="modificar", path="reservamodif")
	public void modificarReserva (@Named ("n")Integer IDreserva, @Named ("p")String Pasajero,
			@Named ("x")Double PuntoX, @Named ("y") Double PuntoY, @Named ("v")Integer Valor, @Named("key") Long key)
	{
		for (Reserva bus:reservas) {
			
			if(bus.ID == IDreserva) {				
				bus.setPuntoEncuentrox(PuntoX);
				bus.setPuntoEncuentrox(PuntoY);
				bus.setValor(Valor);							
			}						
		}			
	}			
	 @ApiMethod(name = "eliminar", path = "reservaelim")
	 public void eliminarReserva(@Named("n") Integer idReserva)
	 {
		 for (Reserva bus:reservas) {
				
				if(bus.ID == idReserva) {				
					reservas.remove(bus);				
				}						
			}	
	 }  
}
