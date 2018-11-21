package com.example.echo;

public class Reserva {

	int ID;
 	int Pasajero;
 	int Ruta;
	Double PuntoEncuentrox;
	Double PuntoEncuentroy;
	int Valor;
	
	public Reserva(int id,int pasajero, int ruta, Double puntoEncuentrox, Double puntoEncuentroy, int valor) {
		ID = id;
		Pasajero = pasajero;
		Ruta = ruta;
		PuntoEncuentrox = puntoEncuentrox;
		PuntoEncuentroy = puntoEncuentroy;
		Valor = valor;
	}
	
	public Reserva() {
		
	}

	public int getPasajero() {
		return Pasajero;
	}
	public void setPasajero(int pasajero) {
		Pasajero = pasajero;
	}
	public int getRuta() {
		return Ruta;
	}
	public void setRuta(int ruta) {
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
