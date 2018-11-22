package main.java.com.example.echo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.Named;

public class Facade {

	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
	HashMap<Long,String> sesiones = new HashMap<Long,String>();
	ArrayList<Usuario> usuarios= new ArrayList<Usuario>(); 
	
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
