
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
public class clsLogin {
    clsFunciones clsF = new clsFunciones();

    clsPersona cls = new clsPersona();
    clsPersona personas[] = new clsPersona[0];

    clsMenu clsM = new clsMenu();

    int cantP = 0;

    public void menuLogin() {
        int opcion = 0;

        boolean generarBd = false, llenarBd = false;

        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    + "\n1. Generar BD Persona"
                    + "\n2. Agregar una Persona"
                    + "\n3. Editar una Persona"
                    + "\n4. Eliminar una Persona"
                    + "\n5. Login"
                    + "\n6. Listar Personas"
                    + "\n7. Buscar Persona"
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    personas = cls.generarBDPersona();

                    generarBd = true;
                    break;
                case 2:
                    if (generarBd) {
                        if (cantP < personas.length) {
                            boolean guardo = cls.llenarBDPersona(personas, cantP);

                            if (guardo) {
                                llenarBd = true;
                                cantP++;
                                clsF.imprimeMensaje("La persona se registró correctamente");
                            } else {
                                clsF.imprimeMensaje("La persona no se registró correctamente");
                            }
                        } else {
                            clsF.imprimeMensaje("Ha llegado al limite de personas que ingresar");
                        }
                    } else {
                        clsF.imprimeMensaje("Debe generar la BD primero");
                    }
                    break;
                case 3:
                    if (cantP == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    } else {
                        //0 - se presenta un error
                        //1 - se realiza una edición
                        //2 - no hubieron coincidencias
                        int mensj = cls.editarPersona(personas, cantP);
                        if (mensj == 0) {
                            clsF.imprimeMensaje("Error al editar a la persona");
                        } else if (mensj == 1) {
                            clsF.imprimeMensaje("Se ha editado a la persona con éxito.");
                        } else {
                            clsF.imprimeMensaje("No se encontró a la persona indicada");
                        }
                    }
                    break;
                case 4:
                    if (cantP == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    } else {
                        int mensj = cls.eliminarPersona(personas, cantP);
                        if (mensj == 0) {
                            clsF.imprimeMensaje("Error al eliminar a la persona");
                        } else if (mensj == 1) {
                            cantP--;
                            clsF.imprimeMensaje("Se ha eliminado a la persona con éxito.");

                        } else {
                            clsF.imprimeMensaje("No se encontró a la persona indicada");
                        }
                    }
                    break;
                case 5:
                    cls.login(personas, cantP);
                    break;
                case 6:
                    if (cantP == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    } else {
                        cls.imprimirPersonas(personas, cantP);
                    }
                    break;
                case 7:
                    if (cantP == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    } else {
                        cls.buscarPersonas(personas, cantP);
                    }
                    break;
                case 0:
                    clsF.imprimeMensaje("Gracias por utilizar la aplicacion!!!");
                    break;
                default:
                    clsF.imprimeMensaje("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);
    }

    

}
