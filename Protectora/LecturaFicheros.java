import java.io.*;
import java.util.*;

import model.*;
import exceptions.*;

public class LecturaFicheros {

	private static final Scanner entradaTeclado = new Scanner(System.in);
	
	private static final int NUMERO_OPCIONES_MENU = 8;

    public static void main(String[] args) throws FicheroNoEncontrado, IOException{
        
		Protectora protectora = new Protectora("Protectora FPII");
		Clinica clinica = new Clinica("+cotas", 987654321 , 100.0);
		Ayuntamiento ayuntamiento = new Ayuntamiento("Evan James", 456123789, 25.0);
		
		try {
			leerAnimales("./Protectora/Animales.txt", protectora);
			gestionProtectora(protectora, clinica, ayuntamiento);
		} catch (Exception e) {
			System.out.println("El fichero no existe en el sistema.");
		}
	
	}

    public static void leerAnimales(String fichero, Protectora protectora) throws FicheroNoEncontrado, IOException {
		File file = new File(fichero);
		
		if(!file.exists())
			throw new FicheroNoEncontrado("El fichero no existe en el sistema.");
		else{
			Scanner escaner = new Scanner(file);
			String tipoAnimal, nombre, sexo, raza;
			int edad, tamanio;
			boolean sociables, apadrinado, ppp, leishmaniasis, esterilizado;

			while (escaner.hasNext()) {
				tipoAnimal = escaner.next();
				nombre = escaner.next();
				sexo = escaner.next();
				edad = escaner.nextInt();
				sociables = escaner.nextBoolean();
				apadrinado = escaner.nextBoolean();
				Animal animal;

				if (tipoAnimal.charAt(0) == 'p') {
					raza = escaner.next();
					tamanio = escaner.nextInt();
					ppp = escaner.nextBoolean();
					leishmaniasis = escaner.nextBoolean();
					animal = new Perro(nombre, edad, apadrinado, sociables, sexo, raza, tamanio, ppp, leishmaniasis);
					protectora.setNumPerros();
				} else {
					esterilizado = escaner.nextBoolean();
					animal = new Gato(nombre, edad, apadrinado, sociables, sexo, esterilizado);
					protectora.setNumGatos();
				}
				
				protectora.AgregarAnimal(animal);
				
			}
			
			escaner.close();
		}
	}

	public static void gestionProtectora(Protectora protectora, Clinica clinica, Ayuntamiento ayuntamiento) throws MaximoSolicitudesException {

		int opcion = 0;
		
		do {
			// Mostrar menú
			System.out.println("\nIndique el número de la consulta a realizar: \n");
			System.out.println("1. Mostrar la información de los animales rescatados");
			System.out.println("2. Realizar una solicitud (de adopción o acogida) de un animal");
			System.out.println("3. Listar las solicitudes de adopción de un animal");
			System.out.println("4. Calcular los gastos veterinarios anuales de la protectora");
			System.out.println("5. Calcular el coste total de una campra de esterilización de gatas");
			System.out.println("6. Calcular la cantidad de pienso de perro adulto que se necesita por semana");
			System.out.println("7. Calcular la cantidad de subvención que concede el ayuntamiento");
			System.out.println("8. Salir");
			
			// Lectura de la selección del usuario
			boolean salir = false;
			do {
				try {
					// Comprobando entrada numérica y opción de menú válida
					opcion = leerDatoRango(1, NUMERO_OPCIONES_MENU);
					salir = true;
				} catch (NumeroFueraRangoException e) {
					System.out.println("Introdujo una opción de menú no válida\nVuelva a intentarlo:");				
				}		
			} while(!salir);

			// Llamar al método correspondiente según la opción elegida por el usuario
			switch (opcion) {
				case 1: 
					listaInformacionAnimales(protectora);
					break;
				case 2: 
					try {
						realizarSolicitud(protectora);
					} catch (Exception e) {
						System.out.println("El animal ha superado el máximo de solicitudes admitidas.");
					}
					break;
				case 3:
					listaInfoSolicitud(protectora);
					break;
				case 4:	
					gastosVeterinariosAnuales(protectora);
					break;
				case 5:
					costeCampaniaEsterilizacion(clinica, protectora);
					break;
				case 6:
					piensoPerroAdultoSemana(protectora);
					break;
				case 7:
					subvencionAyuntamiento(ayuntamiento, protectora);
					break;
				case 8:
					System.out.println("Gracias por usar esta aplicación ...");
					break;
				}
		} while (opcion != NUMERO_OPCIONES_MENU);
	}

	private static int leerDatoRango(int min, int max) throws NumeroFueraRangoException { 
		int num = leerEntero();
		
		if (num < min || num > max) {
			throw new NumeroFueraRangoException("Error. Las opciones no estan en el rango ["+min+", "+max+"].");
		}
		
		return num;
	}

	private static int leerEntero() {
		int opcion = 0;
		boolean salir = false;
		
		do {
			
			try { 

				opcion = entradaTeclado.nextInt();
				salir = true;
			
			} catch (InputMismatchException e) {
				
				System.out.println("Error leyendo entero. Reintroducir el dato");
				entradaTeclado.next();

			}

		} while(!salir);		
		
		return opcion;
	}

	private static void listaInformacionAnimales(Protectora protectora) {
		
		protectora.ConocerAnimal();

	}

	private static void realizarSolicitud(Protectora protectora) throws MaximoSolicitudesException {

		protectora.HacerSolicitud();
	
	}

	private static void listaInfoSolicitud(Protectora protectora) {
		protectora.ComprobarNombre();
	}

	private static void gastosVeterinariosAnuales(Protectora protectora) {
	
		protectora.PrecioTotal();
	
	}

	private static void costeCampaniaEsterilizacion(Clinica clinica, Protectora protectora) {
	
		protectora.ComprobarGatasNoEsterilizadas(clinica);
	
	}

	private static void piensoPerroAdultoSemana(Protectora protectora) {

		protectora.ComidaPerrosSemana();
	
	}

	private static void subvencionAyuntamiento(Ayuntamiento ayuntamiento, Protectora protectora) {
	
		ayuntamiento.Subvencion(protectora);
	
	}

}
