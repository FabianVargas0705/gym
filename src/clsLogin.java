
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
    

    clsMenu clsM = new clsMenu();

    int cantP = 0;

    public void menuLogin() {
        int opcion = 0;

        boolean generarBd = false, llenarBd = false;

        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    
                    + "\n1. Login"
                   
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    login();
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

    public void login(){
       
        int usuario = clsF.recibeInt("Digite el usuario");
        int passwordT = clsF.recibeInt("Digite la contraseña");
        
        
        if (usuario == 118160457 && passwordT == 123) {
           
            clsF.imprimeMensaje("login correcto");
            clsM.menuPrincipal();
                
            
        }else {
            clsF.imprimeMensaje("No se encontraron coincidencias");
        }
        
    }
}
