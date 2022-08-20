
import java.awt.TextArea;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
public class clsPersona {
    clsFunciones clsF = new clsFunciones();
    private String identificacion;
    private String nombre;
    private String apellidos;
    private int edad;
    private String estado;

    public clsPersona(String identificacion, String nombre, String apellidos, int edad, String estado) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.estado = estado;
    }
   
    
    
    
    
    

    public clsPersona() {
        
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    

    public clsPersona[] generarBDPersona() {
        int tamano = clsF.recibeInt("Digite la cantidad de personas de la base de datos: ");
        clsPersona personas[] = new clsPersona[tamano];
        return personas;
    }

    
    
    public boolean llenarBDPersona(clsPersona personas[], int cantP) {
        String identificacion = clsF.recibeString("Digite la identificacion");
        String nombre = clsF.recibeString("Digite el nombre");
        String apellidos = clsF.recibeString("Digite los apellidos");
        int edad = clsF.recibeInt("Digite la edad");
        String estado = clsF.recibeString("Activo/inactivo");
        
        

        clsPersona nuevaPersona = new clsPersona(identificacion, nombre, apellidos, edad, estado);
        personas[cantP] = nuevaPersona;

        return true;
    }

    public int eliminarPersona(clsPersona personas[], int cantP) {
        String buscarIdenti = clsF.recibeString("Digite la identificación que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantP; i++) {
            if (personas[i].getIdentificacion().equalsIgnoreCase(buscarIdenti)) {
                poscBuscar = i;
                break;
            }
        }
        if (poscBuscar == -1) {
            return 2;
        } else {
            for (int i = poscBuscar; i < cantP-1; i++) {
                personas[i] = personas[i+1];
            }
            personas[cantP-1] = null;
            return 1;
        }

    }

    public int editarPersona(clsPersona personas[], int cantP) {
        String buscarIdenti = clsF.recibeString("Digite la identificación que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantP; i++) {
            if (personas[i].getIdentificacion().equalsIgnoreCase(buscarIdenti)) {
                poscBuscar = i;
                break;
            }
        }
        if (poscBuscar == -1) {
            return 2;
        } else {
            char opcion = ' ';
            do {
                opcion = clsF.recibeChar("Seleccione el dato que desea editar\n"
                        + "A. Nombre"
                        + "\nB. Apellidos"
                        + "\nC. Edad"
                        + "\nE. Estado "
                        + "\nS. Salir");
                switch (opcion) {
                    case 'A':
                        personas[poscBuscar].setNombre(clsF.recibeString("Digite el nuevo nombre"));
                        break;
                    case 'B':
                        personas[poscBuscar].setApellidos(clsF.recibeString("Digite los nuevos apellidos"));
                        break;
                    case 'C':
                        personas[poscBuscar].setEdad(clsF.recibeInt("Digite la nueva edad"));
                        break;
                    case 'E':
                        personas[poscBuscar].setEstado(clsF.recibeString("Actvio/inactivo"));
                        break;
                    case 'S':
                        break;
                    default:
                        clsF.imprimeMensaje("Opción no válida");
                        break;
                }

            } while (opcion != 'S');
            return 1;
        }
    }

    public void imprimirPersonas(clsPersona personas[], int cantP) {
        String imprimir="";
        int i = 0;
        for (i = 0; i < cantP; i++) {
            imprimir += "Identificacion: "+personas[i].identificacion + "\n"
                    + "Nombre: " +personas[i].nombre + "\n"
                    + "Apellidos: " +personas[i].apellidos + "\n"
                    + "Edad: " + personas[i].edad + "\n"
                    + "Estado: " + personas[i].estado + "\n";
      
        }
        
        clsF.imprimeMensaje(new TextArea(imprimir));
    }
    
    public void buscarPersonas(clsPersona personas[], int cantP){
    String buscar = clsF.recibeString("Digite la identificación o el nombre que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantP; i++) {
            if (personas[i].getIdentificacion().equalsIgnoreCase(buscar) ||personas[i].getNombre().equalsIgnoreCase(buscar) ) {
                poscBuscar = i;
                break;
            }
        }
        if (poscBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            clsF.imprimeMensaje("Identificacion: "+personas[poscBuscar].getIdentificacion()
                                + "\tNombre: "+personas[poscBuscar].getNombre()
                                + "\tApellidos: "+personas[poscBuscar].getApellidos()
                                + "\tEdad: "+personas[poscBuscar].getEdad()
                                + "\tEstado: " + personas[poscBuscar].getEstado() + "\n"
                                + "");
        }
    }
    
    @Override
    public String toString() {
        return identificacion + "\t" + nombre + "\t" + apellidos + "\t" + edad;
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
