package com.example.echo;

public class Reserva {

 	Usuario Pasajero;
 	String Ruta;
	Double PuntoEncuentrox;
	Double PuntoEncuentroy;
	int Valor;
	
	public Reserva(Usuario pasajero, String ruta, Double puntoEncuentrox, Double puntoEncuentroy, int valor) {		
		Pasajero = pasajero;
		Ruta = ruta;
		PuntoEncuentrox = puntoEncuentrox;
		PuntoEncuentroy = puntoEncuentroy;
		Valor = valor;
	}
	
	public Reserva() {
		
	}

	public Usuario getPasajero() {
		return Pasajero;
	}
	public void setPasajero(Usuario pasajero) {
		Pasajero = pasajero;
	}
	public String getRuta() {
		return Ruta;
	}
	public void setRuta(String ruta) {
		Ruta = ruta;
	}
	public Double getPuntoEncuentrox() {
		return PuntoEncuentrox;
	}
	public void setPuntoEncuentrox(Double puntoEncuentrox) {
		PuntoEncuentrox = puntoEncuentrox;
	}
	public Double getPuntoEncuentroy() {
		return PuntoEncuentroy;
	}
	public void setPuntoEncuentroy(Double puntoEncuentroy) {
		PuntoEncuentroy = puntoEncuentroy;
	}
	public int getValor() {
		return Valor;
	}
	public void setValor(int valor) {
		Valor = valor;
	}
	
}
