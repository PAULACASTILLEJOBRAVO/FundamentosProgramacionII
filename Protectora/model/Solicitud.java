package model;

public class Solicitud {
    
    private String nombreDuenio;
	private String apellidoDuenio;
	private int telefono;
	private String eleccion;
	
	public Solicitud(String nombreDuenio, String apellidoDuenio, int telefono, String eleccion) {
	
        this.nombreDuenio = nombreDuenio;
		this.apellidoDuenio = apellidoDuenio;
		this.telefono = telefono;
		this.eleccion = eleccion;

    }

    public void Informacion(){

        System.out.printf("\nDueño: %s %s, Telefono: %d, Elección: %s ", this.nombreDuenio, this.apellidoDuenio, this.telefono, this.eleccion);

    }


    public String getEleccion(){
    
        return eleccion;
    
    }
}
