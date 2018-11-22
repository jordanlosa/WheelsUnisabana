package main.java.com.example.echo;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

public class Facade {

	/*juanD */
	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	HashMap<Long,String> sesiones = new HashMap<Long,String>();
	ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 
	
	@ApiMethod(name="modificar", path="reservamodif")
	public void modificarReserva (@Named ("n")Integer IDreserva, @Named ("p")String Pasajero, @Named ("x")Double PuntoX, @Named ("y") Double PuntoY, @Named ("v")Integer Valor   )
	{
		for (int i=0; i < reservas.size(); i++) {
			
			if(reservas.get(i).getPasajero().getNombre().equals(Pasajero)) {
				
				reservas.get(i).setPuntoEncuentrox(PuntoX);
				reservas.get(i).setPuntoEncuentroy(PuntoY);
				reservas.get(i).setValor(Valor);
				
			}
			
			
		}
		
		
	}
	
	
}
