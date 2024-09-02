package model;

import exceptions.MaximoSolicitudesException;

public abstract class Animal {

    protected String nombre;
	protected int edad;
	protected boolean apadrinado;
	protected boolean sociables;
	protected String sexo;

	private static final int Capacidad_solicitud = 10;
	private Solicitud [] solicitudes = new Solicitud[Capacidad_solicitud];
	private int numSolicitud = 0;
	
	public Animal(String nombre, int edad, boolean apadrinado, boolean sociables, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.apadrinado = apadrinado;
		this.sociables = sociables; 
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	abstract public void Informacion();

	abstract public String BoolString(boolean bool);

	abstract public double CalcularGastosVeterinarios();

	abstract public double ComidaPerro(); 

	public void AgregarSolicitud(String nombreDuenio, String apellidoDuenio, int telefono, String eleccion) throws MaximoSolicitudesException{
		
		Solicitud solicitud = new Solicitud(nombreDuenio, apellidoDuenio, telefono, eleccion);

		if(numSolicitud < Capacidad_solicitud){

			solicitudes [numSolicitud] = solicitud;
			solicitudes[numSolicitud].Informacion();	
			numSolicitud++;
			
		}else{
			throw new MaximoSolicitudesException("El animal ha superado el máximo de solicitudes admitidas.");
		}

	}

	public Solicitud [] listadoAdopcion() {
			
		Solicitud solicitudesAdopcion [] = new Solicitud[Capacidad_solicitud];

		for(int i=0; i<numSolicitud; i++) {

			if (solicitudes[i].getEleccion().equalsIgnoreCase("adoptar")) {
				
				solicitudesAdopcion[i] = solicitudes[i];

			}

		}

		return solicitudesAdopcion;
	
	}

	public int getNumSolicitud(){

		return numSolicitud;

	}

	public String getSexo(){

		return sexo;
	
	}

}
