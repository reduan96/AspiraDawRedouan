/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

//Importamos el JOption para la lectura y muestra de los datos del programa.
import javax.swing.JOptionPane;

/**
 *
 * @author reduan
 */
public class RobotAspirador {

    public static void main(String[] args) {

        /*
        Creación de un menu que se muestre por JOptionPane con las siguientes 
        opciones: CONFIGURAR EL SISTEMA, CARGA, ASPIRACIÓN, ASPIRACIÓN Y FREGADO,
        ESTADO GENERAL, BASE DE CARGA y SALIR.
        ***Ha este menu solo se accederá si las credenciales son correctas
        (nombre de usuario y contraseña)Estas se almacenan en constantes.
         */
        //Instanciación de las constantes correpondientes al nombre de usuario 
        //y a la contraseña.
        final String NOMBRE_USUARIO = "Reduan";
        final String CONTRASENIA = "Contraseña";
        //Declaración del boolean para la función de salida del programa
        boolean repetirPrograma = true;

        //Introducción de las creedenciales que serán comparadas para ver si son
        //correctas y así visualizar el menú.
        String nomUs = JOptionPane.showInputDialog(null, "Bienvenido al programa "
                + "del robot aspirador.\n Introduzca su nombre de usuario");
        String pass = JOptionPane.showInputDialog(null, "Introduzca su contraseña");

        //Realizamos un bucle while que compruebe las credenciales,si son erroneas
        //el bucle dará true y entrará al bucle hasta que pongas las credenciales
        //correctas y dará false en la condicion y se saldrá
        while (!nomUs.equals(NOMBRE_USUARIO) && !pass.equals(CONTRASENIA)) {

            JOptionPane.showMessageDialog(null, "Error al introducir la/s"
                    + "credencial/es");
            JOptionPane.showInputDialog(null, "Introduzca de nuevo su nombre "
                    + "de usuario");
            JOptionPane.showInputDialog(null, "Introduzca de nuevo su contraseña");

        }
        
        //Realización del bucle principal que mostrará el menu hasta que elijamos
        //finalizar el programa
        do{
            
            JOptionPane.showMessageDialog(null, "Credenciales correctas\n"
                    + "Bienvenido");
            String op = JOptionPane.showInputDialog(null,"MENU\n 1.CONFIGURAR "
                    + "EL SISTEMA\n 2.CARGA\n 3.ASPIRACIÓN\n 4.ASPIRACIÓN Y FREGADO\n "
                    + "5.ESTADO GENERAL\n 6.BASE DE CARGA\n 7.SALIR");
            //Hacemos el parse para convertir el string en un int
            int opcion = Integer.parseInt(op);
            
            //Estructura switch que determina la elección tomada 
            switch(opcion){
                case 1:
                    
                case 2:
                    
                case 3:
                    
                case 4:
                    
                case 5:
                    
                case 6:   
                    
                case 7:
                    //Al escribir 7 que corresponde a salir entramos aqui y nos
                    //pregunta que si estamos seguros de salir
                    String afirmacion = JOptionPane.showInputDialog(null,"Seguro"
                            + " que quieres salir?\n SI   NO");
                    
                    //Según lo introducido en el input del JOption dara true y 
                    //seguirá la ejecución del programa o no.
                    if(afirmacion.equalsIgnoreCase("no")){
                        
                        repetirPrograma = true;
                        
                    }else{
                        
                        repetirPrograma = false;
                        JOptionPane.showMessageDialog(null, "Finalizando el "
                                + "programa...");
                        
                    }
                
            }
            
            
        }while(repetirPrograma);

    }

}
