package app;

import ed.ito.*;
import javax.swing.JOptionPane;

public class MyAppNumeros {
	static ListaDinamica<Numeros> num = new ListaDinamica<Numeros>(20);
	
	// Estructura del menu:
	static int menu() {
		int opc = 0;
        String[] datos = {
        	"1) Agregar numero",
            "2) Primer número de la lista",
            "3) Ultimo número de la lista",
            "4) Cantidad de numeros",
            "5) Eliminar primer número de la lista",
            "6) Eliminar ultimo número de la lista",
            "7) Limpiar la lista",
            "8) Buscar número en lista",
            "9) Terminar el programa"
        };
        
        String x = (String)JOptionPane.showInputDialog(null,"Seleccione uno", "Menu",
        JOptionPane.INFORMATION_MESSAGE, null,datos,datos[0]);
        opc = Integer.parseInt(x.charAt(0)+"");
        return opc;
	}
	
	// Agregar numero a la lista:
	static void llegada() {
		Numeros numero = new Numeros(0);
		numero.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa un número a la lista: ")));
		try {
			num.add(numero);
		} catch(ExcepcionDeListaLlena e) {
            System.err.println(e.getMessage());
		}
	}
	
	// Primer número de la lista:
	static void primero() {
		try {
			Numeros numero = num.first();
	        JOptionPane.showMessageDialog(null, numero, "Primer número", 0);
		} catch(ExcepcionDeListaVacia e){
            System.err.println(e.getMessage());
        }
	}
	
	// Último número de la lista:
	static void ultimo() {
		try {
			Numeros numero = num.last();
			JOptionPane.showMessageDialog(null, numero, "Último número", 0);
		} catch(ExcepcionDeListaVacia e){
			System.err.println(e.getMessage());
		}
	}
	
	// Cantidad de números en la lista:
	static void cantidad() {
		JOptionPane.showMessageDialog(null, "Cantidad de numeros en la lista: [ "+num.size()+" ]", "Total de piezas", 0);
	}
	
	// Elimina el primer número de la Lista:
	static void eliminaPrimerNum() {
		try {
			Numeros numero = num.deleteFirst();
			JOptionPane.showMessageDialog(null, "El primer número ( "+numero+" ) ha sido elimidado correctamente", "Eliminar primer número", 0);
		} catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Elimina el ultimo número de la Lista:
	static void eliminaUltimoNum() {
		try {
			Numeros numero = num.deleteLast();
			JOptionPane.showMessageDialog(null, "El último número ( "+numero+" ) ha sido elimidado correctamente", "Eliminar último número", 0);
		} catch(ExcepcionDeListaVacia e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Buscar número en la lista:
	static void buscar(){
        Numeros numero = new Numeros(0);
        numero.setNumero(Integer.parseInt(JOptionPane.showInputDialog(null, "Proporciona número a buscar:")));
        int i = num.search(numero);
        if(i==-1)
           JOptionPane.showMessageDialog(null, "No se localiza dicho número");
        else
           JOptionPane.showMessageDialog(null, numero+"\nSe localiza en la posición: "+i);
    }
	
	// Aplicación del menú:
	static void run() {
        boolean salir = false;
        while(!salir){
            switch(menu()) {
            	case 1: llegada(); break;
            	case 2: primero(); break;
            	case 3: ultimo(); break;
            	case 4: cantidad(); break;
            	case 5: eliminaPrimerNum(); break;
            	case 6: eliminaUltimoNum(); break;
            	case 7: num.clear(); break;
            	case 8: buscar(); break;
                case 9: salir = true;
            }
        }
    }
	
	// Ejecución del menú:
	public static void main(String[] args) {
		run();
	}
}