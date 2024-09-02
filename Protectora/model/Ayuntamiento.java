package model;

import utils.Constantes;

public class Ayuntamiento implements Constantes{

  private String nombrePersonaContacto;
	private int telefono;  
	private double suvencionVariable;
	
	public Ayuntamiento(String nombrePersonaContacto, int telefono, double suvencionVariable) {

		this.nombrePersonaContacto = nombrePersonaContacto;
		this.telefono = telefono;
		this.suvencionVariable = suvencionVariable;
	
  }

  public void Subvencion(Protectora protectora) {

		System.out.printf("\nLa subvención es %,.2f€\n", cantidad_fija_ayuntamiento + suvencionVariable * (protectora.getNumGatos() + protectora.getNumPerros()));
	
  }

}
