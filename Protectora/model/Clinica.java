package model;

import utils.Constantes;

public class Clinica implements Constantes{

    private String nombre;
	private int telefono;
	private double precio;

	public  Clinica(String nombre, int telefono, double precio){
	
		this.nombre = nombre;
		this.telefono = telefono;
		this.precio = precio;
	
	}

	public double getPrecio(){

		return precio;

	}

}
