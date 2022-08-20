
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
public class clsFactura {
    clsPersona clsP = new clsPersona();
    clsFunciones clsF = new clsFunciones();
    clsCatalogo clsC = new clsCatalogo();
    //boolean generarBd = false, llenarBd = false;
     
    public void Factura(clsPersona personas[], int cantP){
    int opcion = 0;
    double total = 0;
    double monto1 = 0;
    
    String buscar = clsF.recibeString("Digite la identificacion");    
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
                                + "\nNombre: "+personas[poscBuscar].getNombre());
            
            opcion = clsF.recibeInt("Ingrese el plan que prefiere: "
                        + "\n1. PlanOneSede"
                        + "\n2. PlanBlack"
                        + "\n3. PlanFamiliar"
                        + "\n0. Salir");
            while (opcion != 0){
                switch(opcion){
                        case 1:
                            if (opcion == 1) {
                                clsF.recibeInt("Selecciono el PlanOneSede\n"
                                    + "\nFormas de pago y facturacion:\n"
                                    + "\n1. Efectivo"
                                    + "\n2. Sinpe"
                                    + "\n3. Tarjeta"
                                    + "\n0. Salir");
                                switch(opcion){
                                    case 1:
                                        if(opcion == 1){
                                             total = 21000 * 0.13; //0.13 = iva
                                             monto1 = Double.parseDouble(JOptionPane.showInputDialog("Selecciono pago en efectivo"
                                                    + "\nMonto a pagar: "+total+" mil colones"));
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        }else{
                                            clsF.imprimeMensaje("Gracias por utilizar la aplicacion!!");
                                            break;
                                        }
                                        
                                        break;
                                    case 2:
                                         total = 21000 * 0.13; //0.13 = iva
                                             monto1 = Double.parseDouble(JOptionPane.showInputDialog("Selecciono pago en sinpe"
                                                    + "\nMonto a pagar: "+total+" mil colones"));
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        
                                        break;
                                    case 3:
                                         total = 21000 * 0.13; //0.13 = iva
                                             monto1 = Double.parseDouble(JOptionPane.showInputDialog("Selecciono pago en tarjeta"
                                                    + "\nMonto a pagar: "+total+" mil colones"));
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        break;
                                    case 0:
                                        clsF.imprimeMensaje("Gracias por usar la aplicacion!!");
                                }
                            }else{
                                clsF.imprimeMensaje("Opcion incorrecta");
                            }    
                        case 2:
                            if (opcion == 2) {
                                clsF.recibeInt("Selecciono el Plan black\n"
                                    + "\nFormas de pago y facturacion:\n"
                                    + "\n1. Efectivo"
                                    + "\n2. Sinpe"
                                    + "\n3. Tarjeta"
                                    + "\n0. Salir");
                                switch(opcion){
                                    case 1:
                                        total = 27000 * 0.13; //0.13 = iva
                                        if(opcion == 2){
                                            JOptionPane.showInputDialog("Selecciono pago en efectivo"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        }else{
                                            clsF.imprimeMensaje("Gracias por utilizar la aplicacion!!");
                                            break;
                                        }
                                        
                                        break;
                                    case 2:
                                        JOptionPane.showInputDialog("Selecciono pago en sinpe"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        break;
                                    case 3:
                                        JOptionPane.showInputDialog("Selecciono pago en tarjeta"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                    break;
                                    case 0:
                                        clsF.imprimeMensaje("Gracias por usar la aplicacion!!");
                
                                }
                            }
                            break;
                        case 3:
                            if (opcion == 2) {
                                clsF.recibeInt("Selecciono el Plan Familiar\n"
                                    + "\nFormas de pago y facturacion:\n"
                                    + "\n1. Efectivo"
                                    + "\n2. Sinpe"
                                    + "\n3. Tarjeta"
                                    + "\n0. Salir");
                                switch(opcion){
                                    case 1:
                                        total = 50000 * 0.13; //0.13 = iva
                                        if(opcion == 2){
                                            JOptionPane.showInputDialog("Selecciono pago en efectivo"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        }else{
                                            clsF.imprimeMensaje("Gracias por utilizar la aplicacion!!");
                                            break;
                                        }
                                        
                                        break;
                                    case 2:
                                        JOptionPane.showInputDialog("Selecciono pago en sinpe"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                        break;
                                    case 3:
                                        JOptionPane.showInputDialog("Selecciono pago en tarjeta"
                                                    + "\nMonto a pagar: "+total+" mil colones");
                                            if (monto1 == total) {
                                                clsF.imprimeMensaje("Pago realizado");
                                                break;
                                            }else{
                                                clsF.imprimeMensaje("Favor digite el monto exacto");
                                            }
                                    break;
                                    case 0:
                                        clsF.imprimeMensaje("Gracias por usar la aplicacion!!");
                
                                }
                            }
                            break;
                        default:
                            clsF.imprimeMensaje("Opcion incorrecta");
                            break;
                    }
            }
        }
    }
}
