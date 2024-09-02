package model;

import utils.Constantes;

public class Gato extends Animal implements Constantes{
    
    private boolean esterilizado;

	public Gato(String nombre, int edad, boolean apadrinado, boolean sociables, String sexo, boolean esterilizado) {
	
        super(nombre, edad, apadrinado, sociables, sexo);

		this.esterilizado = esterilizado;
	
    }

    public void Informacion(){

		  System.out.printf("Nombre: %s, Tipo: gato, Sexo: %s, Edad: %d, Sociables: %s, Apadrinado: %s, Esterilizado: %s\n", this.nombre, this.sexo, this.edad, BoolString(this.sociables), BoolString(this.apadrinado), BoolString(this.esterilizado));
  
    }

    public String BoolString(boolean bool){        

        return bool ? "Sí" : "No";
    
    }

    public double CalcularGastosVeterinarios(){

        double gastos = 0.0;

        if(!apadrinado)
            if(sexo.equalsIgnoreCase("h"))
    		    if(esterilizado == false)
	    		    gastos = coste_esterilizar;
		
        return gastos*12;

    }

    public boolean isEsterilizado() {
	
        return esterilizado;
	
    }

    public double ComidaPerro(){

        return 0.0;
    
    }

}
