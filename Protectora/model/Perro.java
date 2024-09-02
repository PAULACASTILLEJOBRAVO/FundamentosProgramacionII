package model;

import utils.Constantes;

public class Perro extends Animal implements Constantes{

    private String raza;
	private int tamanio;
	private boolean ppp;
	private boolean leishmaniasis;

	public Perro(String nombre, int edad, boolean apadrinado, boolean sociables, String sexo, String raza, int tamanio, boolean ppp, boolean leishmaniasis) {
	
        super(nombre, edad, apadrinado, sociables, sexo);
		
        this.raza = raza;
		this.tamanio = tamanio;
		this.ppp = ppp;
		this.leishmaniasis = leishmaniasis;
	
    }

	public void Informacion(){

		System.out.printf("Nombre: %s, Tipo: perro, Sexo: %s, Edad: %d, Sociables: %s, Apadrinado: %s, Raza: %s, Tamaño: %d, PPP: %s, Leishmaniasis: %s\n", this.nombre, this.sexo, this.edad, BoolString(this.sociables), BoolString(this.apadrinado), this.raza, this.tamanio, BoolString(this.ppp), BoolString(this.leishmaniasis));

	}

	public String BoolString(boolean bool){

		return bool ? "Sí" : "No";

	}

	public double CalcularGastosVeterinarios(){
			
		double gastos = 0.0;

		if (!apadrinado) 
			if(ppp == true && sociables == false) 
				gastos = coste_vacuna_rabia + coste_vacuna_leishmaniosis + coste_sedacion;
			else 
				gastos = coste_vacuna_rabia + coste_vacuna_leishmaniosis;
		
		return gastos;

    }

	public double ComidaPerro() {
		
		double kg = 0;
		
		if (edad > 1) 
			if(tamanio <= tamanio_pequenio) 
				kg = 200;
			else if (tamanio > tamanio_pequenio && tamanio <= tamanio_grande) 
				kg = 300;
			else 
				kg = tamanio*0.015;
		
		return kg;
	
	}

}
