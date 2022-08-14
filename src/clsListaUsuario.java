/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faby0
 */
import java.util.Vector;
public class clsListaUsuario {
    private static Vector<clsUsuario> datos = new Vector<clsUsuario>();
    public void añadir(clsUsuario obj){
        datos.add(obj);
    }
    public void eliminar(int pos){
        datos.removeElementAt(pos);
    }
    public static Vector mostrar(){
        return datos;
    }
    
}
