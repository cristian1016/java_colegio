import javax.swing.JOptionPane;

public class Procesos {
	String nombres[];
	int edades[];
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
				llenarDatos();
				 	break;
			case 2:
				if (validarArreglo()) {
					imprimirDatos();	
				}
			 		break;
			case 3:
				if (nombres!=null) {
					buscarPorNombre();
				}else {
					System.out.println("Debe primero llenar datos");
				}
			 		break;
			case 4:
				promedioEdades();
			 		break;
			case 5:
				estudiantesMayores();
			 		break;
			case 6:
				estudiantesMenores();
			 		break;
			case 7:
				mayorDelGrupo();
					break;
			case 8:
				menorDelGrupo();
					break;
			case 9:
				buscarPorEdad();
					break;
			case 10:
				System.out.println("Chao pa'!");
					break;
			default:System.out.println("Ingrese una opci�n valida");
					break;
			}
	}
	
	public boolean validarArreglo() {
		if (nombres!=null) {
			return true;
		}else {
			System.out.println("Debe primero llenar datos");
			return false;
		}
	}
	
	public int validacionNumeros(String msj) {
        double num = 0;
        
        do {
            num = Integer.parseInt(JOptionPane.showInputDialog(msj));
            if (num < 0) {
                System.out.println("El numero es negativo, ingrese un numero valido");
            }
        } while (num < 0);
        return (int) num; 
    }

    public void llenarDatos() {
        int tamaño=validacionNumeros("Ingrese la cantidad de estudiantes");
        
        nombres=new String[tamaño];
        edades=new int[tamaño];

        for (int i = 0; i < nombres.length; i++) {
            nombres[i]=JOptionPane.showInputDialog("Ingrese el nombre "+(i+1));//"Nombre"+(i+1);
            edades[i]=validacionNumeros("Ingrese la edad ");
        }

    }
	
	public void imprimirDatos() {
		for (int i = 0; i < nombres.length; i++) {
			System.out.print(nombres[i]+",");
		}
		System.out.println();
		for (int i = 0; i < edades.length; i++) {
			System.out.print(edades[i]+",");
		}
		System.out.println();
	}
	
	public void promedioEdades() {
		int promedio=0;
		int suma=0;
		
		for (int i = 0; i < edades.length; i++) {
			suma +=edades[i];
		}
		promedio = suma/edades.length;
		System.out.println(promedio);
	}
	
	public void mayorDelGrupo() {
		int mayor;
		
		mayor = edades[0];
		
		for (int i = 0; i < nombres.length; i++) {
			if(edades[i] > mayor) {
				mayor = edades[i];	
				System.out.println("La edad mayor del grupo es "+mayor+" que corresponde a "+nombres[i]);
			}
		}
	}
	
	public void menorDelGrupo() {
		int menor;
		
		menor = edades[0];
		
		for (int i = 0; i < nombres.length; i++) {
			if(edades[i] < menor) {
				menor = edades[i];	
				System.out.println("La edad menor del grupo es "+menor+" que corresponde a "+nombres[i]);
			}
		}
	}
	
	public void estudiantesMayores() {
		int contador = 0;
		
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] >= 18) {
				contador+=1;
			}
		}
		System.out.println("Las edades mayores de edad son "+ contador);
	}
	
	public void estudiantesMenores() {
		int contador = 0;
		
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] < 18) {
				contador += 1;
			}
		}
		System.out.println("Las edades menores de edad son "+contador);
	}
	
	public void buscarPorNombre() {
		int contador=0;
		
		String nombreBuscar=JOptionPane.showInputDialog("Ingrese el nombre a buscar");
		
		for (int i = 0; i < nombres.length; i++) {
			if (nombres[i].equalsIgnoreCase(nombreBuscar)) {
				System.out.println("Se encontro a "+nombreBuscar+" con una edad de: "+edades[i]);
				contador++;
			}
		}
		
		if (contador>0) {
			System.out.println("Encontro a "+nombreBuscar+" "+contador+" veces");
		}else {
			System.out.println("la persona "+nombreBuscar+" no fue registrada");
		}
	}
	
	public void buscarPorEdad() {
		int contador=0;
		int edadBuscar=validacionNumeros("Ingrese la edad a buscar");
		
		for (int i = 0; i < edades.length; i++) {
			if (edades[i] == (edadBuscar)) {
				System.out.println("Se encontro la edad "+edadBuscar+" correspondiente a: "+nombres[i]);
				contador++;
			}
		}
		
		if (contador>0) {
			System.out.println("Encontro a "+edadBuscar+" "+contador+" veces");
		}else {
			System.out.println("la edad "+edadBuscar+" no fue registrada");
		} 
	}
}