
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
    clsMenu clsM = new clsMenu();
    private String identificacion;
    private String nombre;
    private String apellidos;
    private String password;
    private int edad;
   
    
    
    public clsPersona(String identificacion, String nombre, String apellidos, int edad, String password) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.password = password;
        
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    

    public clsPersona[] generarBDPersona() {
        int tamano = clsF.recibeInt("Digite la cantidad de personas de la base de datos: ");
        clsPersona personas[] = new clsPersona[tamano];
        return personas;
    }

    
    
    public boolean llenarBDPersona(clsPersona personas[], int cantP) {
        String identificacion = clsF.recibeString("Digite la identificacion");
        String password = clsF.recibeString("Digite la contraseña");
        String nombre = clsF.recibeString("Digite el nombre");
        String apellidos = clsF.recibeString("Digite los apellidos");
        int edad = clsF.recibeInt("Digite la edad");
        
        

        clsPersona nuevaPersona = new clsPersona(identificacion, nombre, apellidos, edad, password);
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
        //0 - se presenta un error
        //1 - se realiza una edición
        //2 - no hubieron coincidencias
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
                        + "\nE. Estado Civil"
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
                    + "Estado Civil: " + personas[i].password + "\n"
                    + "Mascotas: \n";
      
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
                                + "\nNombre: "+personas[poscBuscar].getNombre()
                                + "\nApellidos: "+personas[poscBuscar].getApellidos()
                                + "\nEdad: "+personas[poscBuscar].getEdad()
                                + "\nContraseña: "+personas[poscBuscar].getPassword()
                                + "");
        }
    }
    public void login(clsPersona personas[], int cantP){
        String identificacionT = clsF.recibeString("Digite la identificación");
        String passwordT = clsF.recibeString("Digite la contraseña");
        int poscBuscar = -1;
        for (int i = 0; i < cantP; i++) {
            if (personas[i].getIdentificacion().equalsIgnoreCase(identificacionT) && personas[i].getPassword().equalsIgnoreCase(passwordT) ) {
                poscBuscar = i;
                clsF.imprimeMensaje("login correcto");
                clsM.menuPrincipal();
                break;
            }
        }
        if (poscBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        }
    }
    @Override
    public String toString() {
        return identificacion + "\t" + nombre + "\t" + apellidos + "\t" + edad + password+"\t";
    }

    public String getIdentificacion() {
        return identificacion;
    }
}
