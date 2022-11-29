package app;

import javax.swing.JOptionPane;
import ed.ito.*;

public class MyAppNombres {
	// static ListaOrdenada<Nombres> nom = new ListaOrdenada<Nombres>(30);
	static ListaDinamica<String> nom = new ListaDinamica<String>(30);
	
	// Estructura del menu:
	static int menu() { 
		int opc = 0;
		String[] datos = {
			"1) Agregar nombre",
			"2) Primer nombre de la lista",
			"3) Ienecimo nombre de la lista",
			"4) Ultimo nombre de la lista",
			"5) Cantidad de nombres",
			"6) Eliminar primer nombre de la lista",
			"7) Eliminar un nombre es especifico de la lista",
			"8) Terminar el programa" 
		};
		
		String x = (String)JOptionPane.showInputDialog(null,"Seleccione uno", "Menú",
				JOptionPane.INFORMATION_MESSAGE, null,datos,datos[0]);
		opc = Integer.parseInt(x.charAt(0)+"");
		return opc;
	}
	
	// Agregar nombre a la lista:
	static void llegada() {
		Nombres nombre = new Nombres("");
		nombre.setNombre(JOptionPane.showInputDialog(null, "Ingresa un nombre a la lista: "));
		try {
			nom.add(nombre.getNombre());
		} catch(ExcepcionDeListaLlena e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Primer nombre de la lista:
	static void primero() {
		try {
			String nombre = nom.first();
			JOptionPane.showMessageDialog(null, nombre, "Primer número", 0);
		} catch(ExcepcionDeListaVacia e){
			System.err.println(e.getMessage());
		}
	}
	
	// Último nombre de la lista:
	static void ultimo() {
		try {
			String nombre = nom.last();
			JOptionPane.showMessageDialog(null, nombre, "último número", 0);
		} catch(ExcepcionDeListaVacia e){
			System.err.println(e.getMessage());
		}
	}
	
	// Cantidad de nombres en la lista:
	static void cantidad() {
		JOptionPane.showMessageDialog(null, "Cantidad de nombres en la lista: [ "+nom.size()+" ]", "Total de piezas", 0);
	}
	
	// Elimina el primer nombre de la Lista:
	static void eliminaPrimerNom() {
		try {
			String nombre = nom.deleteFirst();
			JOptionPane.showMessageDialog(null, "El primer nombre ( "+nombre+" ) ha sido elimidado correctamente", "Eliminar primer nombre", 0);
		} catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Elimina un nombre en específico de la Lista:
	static void eliminaNom() {
		try {
			Nombres nombre = new Nombres("");
	        nombre.setNombre(JOptionPane.showInputDialog(null, "Proporciona un nombre a buscar:"));
	        int i = nom.search(nombre.getNombre());
	        if(i==-1)
	            JOptionPane.showMessageDialog(null, "No es posible localizar el nombre [ "+nombre+" ]");
	        else
	            nom.delete(i);
	            JOptionPane.showMessageDialog(null, "[ "+nombre+" ] ha sido eliminad@ correctamente");
		} catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Aplicación del menú:
	static void run() {
		boolean salir = false;
		while(!salir){
			switch(menu()) {
				case 1: llegada(); break;
				case 2: primero(); break;
				case 4: ultimo(); break;
				case 5: cantidad(); break;
				case 6: eliminaPrimerNom(); break;
				case 7: eliminaNom(); break;
				case 8: salir = true;
			}
		}
	}
	
	// Ejecución del menú:
	public static void main(String[] args) {
		run();
	}

}