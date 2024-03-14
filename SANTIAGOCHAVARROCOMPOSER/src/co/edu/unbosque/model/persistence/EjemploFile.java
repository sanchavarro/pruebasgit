package co.edu.unbosque.model.persistence;

import java.io.*;

public class EjemploFile {
	
	private String archivodata = "c:\\data\\datanumeros.txt";
	private String archivodata2 = "c:\\data\\datanumeros2.txt";
	
	public int escribirArchivo(String dato) {
		
		File f = new File(this.archivodata); 
		
		try {
			FileWriter fw = new FileWriter(f); 
			PrintWriter pw = new PrintWriter(fw); 
			
			pw.println(dato); 
			
			fw.close();
			
		} catch (IOException e) {
			return -1;
		} 
		
		return 0;
	}
	
	public int escribirArchivo2(String dato) {
		
		File f = new File(this.archivodata2); 
		
		try {
			FileWriter fw = new FileWriter(f); 
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println(dato); 
			
			fw.close();
			
		} catch (IOException e) {
			return -1;
		} 
		
		return 0;
	}
	public String leerArchivo() {
		
		String linea = "";
		String cadena = "";
		
		File f = new File(this.archivodata); 
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr); 
			linea = br.readLine();     
			while (linea != null) {    
				cadena += linea;  
				linea = br.readLine(); 
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena;
	}
	
	public String leerArchivo2() {
		
		String linea = "";
		String cadena = "";
		
		File f = new File(this.archivodata2); 
		
		try {
			FileReader fr = new FileReader(f); 
			BufferedReader br = new BufferedReader(fr); 
			linea = br.readLine();     
			while (linea != null) {    
				cadena += linea;       
				linea = br.readLine(); 
			}
			fr.close();
		} 
		catch (IOException e) {
			return null;
		}
		return cadena;
	}


}
