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
public class clsCatalogo {
    clsFunciones clsF = new clsFunciones();
    int meses,precio;
    String descripcion;
    clsCatalogoMaquinas clsCM = new clsCatalogoMaquinas();
    clsCatalogoMaquinas catalogoM[] = new clsCatalogoMaquinas[0];
    int cantM = 0;
    public clsCatalogo() {
    }

    public clsCatalogo(int meses, int precio, String descripcion) {
        this.meses = meses;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public clsFunciones getClsF() {
        return clsF;
    }

    public void setClsF(clsFunciones clsF) {
        this.clsF = clsF;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
    
    
    public clsCatalogo[] generarBDCatalogo() {
        int tamano = clsF.recibeInt("Digite la cantidad de promociones que tiene: ");
        clsCatalogo catalogo[] = new clsCatalogo[tamano];
        return catalogo;
    }

    
    public void imprimir2catalogo(){
        String imprimir = "Nombre\t"+"\tMeses\t"+"Precio\t"+"Descripicon"+"\n"
                           +"PlanOneSede\t"+ "1\t"+"21000\t"+"Plan solo incluye poder ir a una sola sede \n"
                            +"PlanBlack\t"+ "1\t"+"27000\t"+"Con este plan puedes ir a cualquiera de nuestras sedes\n "
                            +"PlanFamiliar\t"+ "1\t"+"50000\t"+"Con este plan pueden venir 3 personas de tu familia\n ";
                            
        clsF.imprimeMensaje(new TextArea(imprimir));
        
    }
 
   public void menuCata(){
       int opcion = 0;

        boolean generarBd = false, llenarBd = false;
        do {
            opcion = clsF.recibeInt("Seleccione una opcion:"
                    
                    + "\n1. Imprimir promociones"
                    
                    + "\n2. Generar base de datos catalogo maquinas"
                    + "\n3. Agregar maquina"
                    + "\n4. editar maquina"
                    + "\n5. Imprimir catalogo de maquinas"
                    + "\n6. eliminar maquina"
                    + "\n7. Buscar maquina"
                    + "\n0. Salir");
            switch (opcion) {
                case 1:
                    imprimir2catalogo();
                 break;
                case 2:
                    catalogoM = clsCM.generarBDMaquina();

                    generarBd = true;
                    break;
                case 3:
                    if (generarBd) {
                        if (cantM < catalogoM.length) {
                            boolean guardo = clsCM.llenarBDMaquina(catalogoM, cantM);

                            if (guardo) {
                                llenarBd = true;
                                cantM++;
                                clsF.imprimeMensaje("La maquina se registró correctamente");
                            } else {
                                clsF.imprimeMensaje("La maquina no se registró correctamente");
                            }
                        } else {
                            clsF.imprimeMensaje("Ha llegado al limite de maquina que ingresar");
                        }
                    }
                    break;
                case 4:
                     if (cantM == 0) {
                        clsF.imprimeMensaje("Debe agregar una maquina");
                    } else {
                        
                        int mensj = clsCM.editarMaquina(catalogoM, cantM);
                        if (mensj == 0) {
                            clsF.imprimeMensaje("Error al editar la maquina");
                        } else if (mensj == 1) {
                            clsF.imprimeMensaje("Se ha editado la maquina con exito.");
                        } else {
                            clsF.imprimeMensaje("No se encontró a la maquina indicada");
                        }
                    }
                    break;
                case 5:
                    if (cantM == 0) {
                        clsF.imprimeMensaje("Debe agregar una maquina");
                    } else {
                        clsCM.imprimirCatalogoM(catalogoM, cantM);
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
    

    


