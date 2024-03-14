package co.edu.unbosque.model;

import co.edu.unbosque.model.persistence.EjemploFile;

public class GestorArchivos{
	
	public String gestionarArchivoCadena(String msg) {
		
		 EjemploFile archivo = new EjemploFile();
		
			archivo.escribirArchivo("Dato de tipo String");
			return "leí este dato: "+archivo.leerArchivo();
		
	}
	
	
	public String gestionarArchivoCadena2(String msg) {
		
		EjemploFile archivo = new EjemploFile();
		
		archivo.escribirArchivo2(archivo.leerArchivo()+msg);
		return archivo.leerArchivo2();		
	}
	
}

	
	
	




