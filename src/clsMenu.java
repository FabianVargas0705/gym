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

    public void menuPrincipal() {
        int opcion = 0;

        

        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    + "\n1. Cajas"
                    + "\n2. Asistencia cliente"
                    + "\n3. Registro usuario"
                    + "\n4. Valoracion Cliente"
                    + "\n5. Catalogos"
                    + "\n6. Factura"
                    + "\n7. "
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                case 5:
                    clsC.catalogo();
                    break;
                case 6:
                    
                    break;
                case 7:
                    
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
