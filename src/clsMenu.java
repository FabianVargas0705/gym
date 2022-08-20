/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
public class clsMenu {
    clsFunciones clsF = new clsFunciones();
    clsCatalogo clsC = new clsCatalogo();
    clsCatalogo catalogo[] = new clsCatalogo[0];
    clsPersona cls = new clsPersona();
    clsFactura clsFac = new clsFactura();
    clsPersona personas[] = new clsPersona[0];
    clsValoracionCliente clsV = new clsValoracionCliente();
    int cantP = 0;
    public void menuPrincipal() {
        
        boolean generarBd = false, llenarBd = false;
        int opcion = 0;
        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    + "\n1. Valoracion Cliente"
                    + "\n2. Catalogos"
                    + "\n3. pago y factura"
                    + "\n4. Generar BD cliente"
                    + "\n5. Agregar una cliente"
                    + "\n6. Editar una cliente"
                    + "\n7. Eliminar una cliente"
                    + "\n8. Listar cliente"
                    + "\n9. Buscar cliente"
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    clsV.menUValroacion();
                    break;
                case 2:
                    clsC.menuCata();
                    break;
                case 3:
                    clsFac.Factura(personas, cantP);
                    break;
                case 4:
                    personas = cls.generarBDPersona();

                    generarBd = true;
                    break;
                case 5:
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
                    }
                    break;
                case 6:
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
                case 7:
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
                    
                    
                case 8:
                    if (cantP == 0) {
                        clsF.imprimeMensaje("Debe agregar una persona");
                    } else {
                        cls.imprimirPersonas(personas, cantP);
                    }
                     break;
                case 9:
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
