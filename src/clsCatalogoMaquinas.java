
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
public class clsCatalogoMaquinas {
    clsFunciones clsF = new clsFunciones();
    String nombre;
    String descripcion;
    String estado;
    String caracteristicas;
    
    
    public clsCatalogoMaquinas() {
    }

    public clsCatalogoMaquinas(String nombre, String descripcion, String estado, String caracteristicas) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.caracteristicas = caracteristicas;
    }

    public clsFunciones getClsF() {
        return clsF;
    }

    public void setClsF(clsFunciones clsF) {
        this.clsF = clsF;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }
    
    public clsCatalogoMaquinas[] generarBDMaquina() {
        int tamano = clsF.recibeInt("Digite la cantidad de maquinas de la base de datos: ");
        clsCatalogoMaquinas catalogoM[] = new clsCatalogoMaquinas[tamano];
        return catalogoM;
    }

    
    //
    public boolean llenarBDMaquina(clsCatalogoMaquinas catalogoM[], int cantM) {
  
        String nombre = clsF.recibeString("Digite el nombre");
        String descripcion = clsF.recibeString("Digite la descripcion de la maquina");
        String estado = clsF.recibeString("Activo/inactivo");
        String caracteristicas = clsF.recibeString("digite las caracteriscas");
        
        
        clsCatalogoMaquinas nuevoArticlo = new clsCatalogoMaquinas(nombre,descripcion,estado,caracteristicas);
        catalogoM[cantM ]= nuevoArticlo;

        return true;
    }

    public int eliminarMaquina(clsCatalogoMaquinas catalogoM[], int cantM) {
        String buscarNombre = clsF.recibeString("Digite el nombre de la maquina que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantM; i++) {
            if (catalogoM[i].getNombre().equalsIgnoreCase(buscarNombre)) {
                poscBuscar = i;
                break;
            }
        }
        if (poscBuscar == -1) {
            return 2;
        } else {
            for (int i = poscBuscar; i < cantM-1; i++) {
                catalogoM[i] = catalogoM[i+1];
            }
            catalogoM[cantM-1] = null;
            return 1;
        }

    }

    public int editarMaquina(clsCatalogoMaquinas catalogoM[], int cantM) {
        String buscarNombre = clsF.recibeString("Digite el nombre de la maquina que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantM; i++) {
            if (catalogoM[i].getNombre().equalsIgnoreCase(buscarNombre)) {
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
                        + "\nB. descripcion"
                        + "\nC. estado"
                        + "\nE. caracteristicas "
                        + "\nS. Salir");
                switch (opcion) {
                    case 'A':
                        catalogoM[poscBuscar].setNombre(clsF.recibeString("Digite el nuevo nombre"));
                        break;
                    case 'B':
                        catalogoM[poscBuscar].setDescripcion(clsF.recibeString("Digite la nueva descripcion"));
                        break;
                    case 'C':
                        catalogoM[poscBuscar].setEstado(clsF.recibeString("Digite el nuevo estado"));
                        break;
                    case 'E':
                        catalogoM[poscBuscar].setCaracteristicas(clsF.recibeString("Digite la nueva caracteristica"));
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

    public void imprimirCatalogoM(clsCatalogoMaquinas catalogoM[], int cantM) {
        String imprimir="";
        int i = 0;
        for (i = 0; i < cantM; i++) {
            imprimir += "nombre: "+catalogoM[i].nombre + "\n"
                    + "descripcion: " +catalogoM[i].descripcion + "\n"
                    + "estado: " +catalogoM[i].estado + "\n"
                    + "caracteristicas: " + catalogoM[i].caracteristicas + "\n";
      
        }
        
        clsF.imprimeMensaje(new TextArea(imprimir));
    }
    
    public void buscarMaquina(clsCatalogoMaquinas catalogoM[], int cantM){
    String buscar = clsF.recibeString("Digite el nombre que desea buscar");
        int poscBuscar = -1;
        for (int i = 0; i < cantM; i++) {
            if (catalogoM[i].getNombre().equalsIgnoreCase(buscar) ) {
                poscBuscar = i;
                break;
            }
        }
        if (poscBuscar == -1) {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        } else {
            clsF.imprimeMensaje("Identificacion: "+catalogoM[poscBuscar].getNombre()
                                + "\tNombre: "+catalogoM[poscBuscar].getDescripcion()
                                + "\tApellidos: "+catalogoM[poscBuscar].getEstado()
                                + "\tEdad: "+catalogoM[poscBuscar].getCaracteristicas()
                                + "\n"
                                + "");
        }
    }
 
    
    

  
}
