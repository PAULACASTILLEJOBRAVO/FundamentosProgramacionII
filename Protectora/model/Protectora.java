package model;

import java.util.Scanner;

import exceptions.MaximoSolicitudesException;
import utils.Constantes;

public class Protectora implements Constantes{
    
	public static Scanner hacerSolicitudes = new Scanner(System.in);

    String nombre;

    private int numPerros = 0;
	private int numGatos = 0;
    private int numAnimal = 0;
    
	private static final int Capacidad_protectora = 30;
	private Animal [] animales = new Animal[Capacidad_protectora];

    public Protectora(String nombre){
        this.nombre = nombre;
    }

    public void AgregarAnimal(Animal animal){
        
		if(numAnimal < Capacidad_protectora) {
           
            animales[numAnimal] = animal;
            numAnimal++;
		
        }
    }

    public void ConocerAnimal(){

        for(int i = 0; i < numAnimal; i++)
           animales[i].Informacion();

    }

    public void PrecioTotal(){
        
        double precioTotal = 0.0;

		for(int i=0; i<numAnimal; i++) 
			precioTotal += animales[i].CalcularGastosVeterinarios();
		
        System.out.printf("\nEl precio total es %,.1f€\n", precioTotal);
    
    }

    public void HacerSolicitud() throws MaximoSolicitudesException{
		
        System.out.println("Escriba su nombre: ");
        String nombreDuenio = hacerSolicitudes.next();
    
        System.out.println("Escriba su apellido: ");
        String apellidoDuenio = hacerSolicitudes.next();
    
        System.out.println("Escriba su telefono: ");
        int telefono = hacerSolicitudes.nextInt();
    
        System.out.println("Si quiere adoptar a una mascota, pulse 1; en caso contrario, presione 0 para apadrinarlo: ");
        int eleccion = hacerSolicitudes.nextInt();   
        
        ConocerAnimal();
        System.out.printf("\nDe la lista recién mostrada, escriba el nombre del animal que desea %s: \n", eleccion == 0 ? "apadrinar" : "adoptar");
        String nombreAnimal = hacerSolicitudes.next();

        for(int i=0; i<numAnimal; i++){
            if(animales[i].getNombre().equalsIgnoreCase(nombreAnimal)){
                
                animales[i].AgregarSolicitud(nombreDuenio, apellidoDuenio, telefono, eleccion == 0 ? "apadrinar" : "adoptar");
                System.out.printf(", Animal: %s\n ", animales[i].getNombre());
            
            }
        }

    }

    public void ComprobarNombre() {
        
        System.out.println("Escriba el nombre del animal al cual desea revisar las adopciones: ");
	    String nombreAnimal = hacerSolicitudes.next();

		for(int i=0; i<numAnimal; i++) {
	
            if (animales[i].getNombre().equalsIgnoreCase(nombreAnimal)){
	
                System.out.println("El animal está registrado.");
				Solicitud solicitudesAnimales [] = animales[i].listadoAdopcion();
                
                for(int j=0; j<animales[i].getNumSolicitud(); j++){
    
                    solicitudesAnimales[j].Informacion();   
    
                }
		
            }
		
        }

	}

    public void ComidaPerrosSemana() {
	
        double precioComida = 0.0;
    	
        for(int i=0; i<numAnimal; i++) {

    		precioComida += animales[i].ComidaPerro();
    	
        } 

        System.out.printf("\nEl precio total es %,.1f€\n", precioComida);
	
    }

    public void ComprobarGatasNoEsterilizadas(Clinica clinica) {
		
        int gatas = 0;

		for(int i=0; i<numAnimal; i++)
            if(animales[i] instanceof Gato)
			    if (animales[i].getSexo().equals("h"))
                    if(!((Gato) animales[i]).isEsterilizado())
                        gatas++;
        
        System.out.printf("\n El precio total de la campaña de esterilización es %,.2f€\n", gatas*clinica.getPrecio());

	}


    public int getNumAnimal(){

        return numAnimal;
    
    }

    public void setNumGatos(){
        
        numGatos++;
    
    }

    public int getNumGatos() {

		return numGatos;
	
    }
    
    public void setNumPerros(){
        
        numPerros++;
    
    }

    public int getNumPerros() {

		return numPerros;
	
    }

}
