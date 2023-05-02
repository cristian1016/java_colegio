import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Procesos_arrays {
    static ArrayList<String> nombres = new ArrayList<String>();
    static ArrayList<Integer> edades = new ArrayList<Integer>();
    
    public  void iniciar() {
		System.out.println("Iniciar");
		String menu="GESTION ESTUDIANTES\n";
		menu+="1. Llenar Datos\n";
		menu+="2. Imprimir Datos\n";
		menu+="3. Buscar por nombre\n";
		menu+="4. Ver promdeio de edades\n";
		menu+="5. Estudiantes mayores de edad\n";
		menu+="6. Estudiantes menores de edad\n";
		menu+="7. Edad mayor del grupo\n";
		menu+="8. Edad menor del grupo\n";
		menu+="9. Buscar por edad\n";
		menu+="10. Salir\n";
		menu+="Ingrese una opcion:\n";
		

		int opc=0;
		do {
			opc=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			validarMenu(opc);
			
		} while (opc!=10);
	}
    
    public void validarMenu(int opc) {
    	
            switch (opc) {
                case 1:
                    agregarEstudiante();
                    break;
                case 2:
                    imprimirEstudiantes();
                    break;
                case 3:
                    promedioEdades();
                    break;
                case 4:
                    estudiantesMayorEdad();
                    break;
                case 5:
                    estudiantesMenorEdad();
                    break;
                case 6:
                    estudiantesMayoresEdad();
                    break;
                case 7:
                    buscarPorNombre();
                    break;
                case 8:
                    buscarPorEdad();
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Adiós!");
                    break;
                case 10:
    				System.out.println("Chao pa'!");
    					break;
    			default:
    				System.out.println("Ingrese una opci�n valida");
    					break;
            }
     }
    
    public static void agregarEstudiante() {
    	int cantidad = 0;

        cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cuantos estudiantes quiere registrar"));

        for (int i = 0; i < cantidad; i++) {

            String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad de " + nombre + ":"));

            nombres.add(nombre);
            edades.add(edad);
        }

        JOptionPane.showMessageDialog(null, "Estudiantes agregado correctamente");
    }
    
    public static void imprimirEstudiantes() {
        String listaEstudiantes = "";
        for (int i = 0; i < nombres.size(); i++) {
            listaEstudiantes += nombres.get(i) + " - " + edades.get(i) + "\n";
        }
        JOptionPane.showMessageDialog(null, listaEstudiantes);
        
    }
    
    public static void promedioEdades() {
        int sumaEdades = 0;
        for (int i = 0; i < edades.size(); i++) {
            sumaEdades += edades.get(i);
        }
        double promedio = (double) sumaEdades / edades.size();
        JOptionPane.showMessageDialog(null, "El promedio de edades es: " + promedio);
    }
    
    public static void estudiantesMayorEdad() {
        int mayorEdad = Integer.MIN_VALUE;
        ArrayList<String> estudiantes = new ArrayList<String>();
        for (int i = 0; i < edades.size(); i++) {
            if (edades.get(i) > mayorEdad) {
                mayorEdad = edades.get(i);
                estudiantes.clear();
                estudiantes.add(nombres.get(i));
            } else if (edades.get(i) == mayorEdad) {
                estudiantes.add(nombres.get(i));
            }
        }
        String estudiantesMayorEdad = String.join(", ", estudiantes);
        JOptionPane.showMessageDialog(null, "Los estudiantes de mayor edad son: " + estudiantesMayorEdad);
    }
    

	public static void estudiantesMenorEdad() {
		int menorEdad = Integer.MAX_VALUE;
		ArrayList<String> estudiantes = new ArrayList<String>();
		
		for (int i = 0; i < edades.size(); i++) {
			if (edades.get(i) < menorEdad) {
				
		menorEdad = edades.get(i);
		estudiantes.clear();
		estudiantes.add(nombres.get(i));
		
	} else if (edades.get(i) == menorEdad) {
		estudiantes.add(nombres.get(i));
		}
	}
			String estudiantesMenorEdad = String.join(", ", estudiantes);
			JOptionPane.showMessageDialog(null, "Los estudiantes de menor edad son: " + estudiantesMenorEdad);
	}
	
	public static void estudiantesMayoresEdad() {
	    int mayoresEdad = 0;
	    for (int i = 0; i < edades.size(); i++) {
	        if (edades.get(i) >= 18) {
	            mayoresEdad++;
	        }
	    }
	    JOptionPane.showMessageDialog(null, "Hay " + mayoresEdad + " estudiantes mayores de edad");
	}

	public static void buscarPorNombre() {
	    String nombreBuscado = JOptionPane.showInputDialog(null, "Ingrese el nombre del estudiante a buscar");
	    int indice = nombres.indexOf(nombreBuscado);
	    if (indice != -1) {
	        JOptionPane.showMessageDialog(null, nombreBuscado + " tiene " + edades.get(indice) + " años");
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontró al estudiante " + nombreBuscado);
	    }
	}

	public static void buscarPorEdad() {
	    int edadBuscada = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese la edad a buscar"));
	    ArrayList<String> estudiantes = new ArrayList<String>();
	    for (int i = 0; i < edades.size(); i++) {
	        if (edades.get(i) == edadBuscada) {
	            estudiantes.add(nombres.get(i));
	        }
	    }
	    if (estudiantes.size() > 0) {
	        String estudiantesEdadBuscada = String.join(", ", estudiantes);
	        JOptionPane.showMessageDialog(null, "Los estudiantes de " + edadBuscada + " años son: " + estudiantesEdadBuscada);
	    } else {
	        JOptionPane.showMessageDialog(null, "No se encontraron estudiantes de " + edadBuscada + " años");
	    }
	}
}