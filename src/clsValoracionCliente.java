/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
import java.awt.TextArea;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class clsValoracionCliente {
    
    clsFunciones clsF = new clsFunciones();
    ArrayList valoracion = new ArrayList();
    ArrayList comentarioL = new ArrayList();
    public void menUValroacion(){
    int opcion = 0;
   
    

        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    
                    + "\n1. Califiquenos del 1 al 10"
                    +"\n2. Dejanos un comentario"
                    +"\n3. imprimir valoracion y comentarios"
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    int x =1;
                    while(x==1){
                        calificacion();
                        x =clsF.recibeInt("Desea agresar otra calificacion \n1.Si\n2.no");
                    }
                 break;
                 case 2:
                    int y =1;
                    while(y==1){
                        comentario();
                        y =clsF.recibeInt("Desea agresar otra calificacion \n1.Si\n2.no");
                    }
                    
                 break;
                 case 3:
                    imprimir();
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
    public void calificacion(){
        
            String dato=clsF.recibeString("Digite la valoracion");
            
            valoracion.add(dato);
}
    public void comentario(){
        String comentario=clsF.recibeString("Digite el comentario");
            
            comentarioL.add(comentario);
    }
    public void imprimir(){
        String imprimir = "",imprimir2="",imprimir3;
         for(int i = 0; i < valoracion.size(); i++) {
            
            imprimir += (String) valoracion.get(i)+",";

         }
         for (int i = 0; i < comentarioL.size(); i++) {
            imprimir2 += (String) comentarioL.get(i)+",";
        }
         imprimir3 = "Valoracion 1 al 10\t"+imprimir + "\n"+"Cometarios\t"+imprimir2;
         clsF.imprimeMensaje(new TextArea(imprimir3));

    }
}


