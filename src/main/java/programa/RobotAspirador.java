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
        do {

            JOptionPane.showMessageDialog(null, "Credenciales correctas\n"
                    + "Bienvenido al Aspirador Robot\n Configurando el sistema...");

            //Primero Configuramos el sistema antes de mostrar el menu
            double mCocina, mSalon, mBanio, mDom1, mDom2;

            JOptionPane.showMessageDialog(null, "Introduzca el número de metros"
                    + "de las dependencias(1m²--100m²)");
            String mC = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + "correspondientes de la cocina");
            mCocina = Double.parseDouble(mC);
            String mS = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + "correpsondientes del salon");
            mSalon = Double.parseDouble(mS);
            String mB = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + "correspondientes al baño");
            mBanio = Double.parseDouble(mB);
            String mD1 = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + "correspondientes al dormitorio 1");
            mDom1 = Double.parseDouble(mD1);
            String mD2 = JOptionPane.showInputDialog(null, "Introduzca los metros"
                    + "correspondientes al dormitorio 2");
            mDom2 = Double.parseDouble(mD2);

            //Establecemos el nivel de carga del robot, tiene que estar entre el 
            //0% y 100% e instanciamos nivelCarga para guardar la variable
            int cargaEstablecida;
            do {

                String C = JOptionPane.showInputDialog(null, "Indica el nivel "
                        + "de carga del robot aspirador\n 0% --- 100%");
                cargaEstablecida = Integer.parseInt(C);

            } while (cargaEstablecida < 0 || cargaEstablecida > 100);

            String op = JOptionPane.showInputDialog(null, "MENU\n 1.ASPIRACIÓN\n"
                    + " 2.ASPIRACIÓN Y FREGADO\n 3.ESTADO GENERAL\n "
                    + "4.BASE DE CARGA\n 5.SALIR");
            //Hacemos el parse para convertir el string en un int
            int opcion = Integer.parseInt(op);

            //Estructura switch que determina la elección tomada 
            switch (opcion) {
                case 1:

                case 2:

                case 3:

                case 4:

                case 5:
                    //Al escribir 7 que corresponde a salir entramos aqui y nos
                    //pregunta que si estamos seguros de salir
                    String afirmacion = JOptionPane.showInputDialog(null, "Seguro"
                            + " que quieres salir?\n SI   NO");

                    //Según lo introducido en el input del JOption dara true y 
                    //seguirá la ejecución del programa o no.
                    do {
                        if (afirmacion.equalsIgnoreCase("si")) {

                            repetirPrograma = false;
                            JOptionPane.showMessageDialog(null, "Finalizando el "
                                    + "programa...");

                        } else {

                            repetirPrograma = true;
                            JOptionPane.showMessageDialog(null, "Repitiendo el "
                                    + "programa...");

                        }

                    } while (!afirmacion.equalsIgnoreCase("si")
                            && !afirmacion.equalsIgnoreCase("no"));

            }

        } while (repetirPrograma);

    }

}
