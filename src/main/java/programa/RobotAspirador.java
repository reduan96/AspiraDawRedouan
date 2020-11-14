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
        final String CONTRASENIA = "Codigoentrada";
        //Declaración del boolean para la función de salida del programa
        boolean repetirPrograma = true;

        //Introducción de las creedenciales que serán comparadas para ver si son
        //correctas y así visualizar el menú.
        JOptionPane.showMessageDialog(null, "\"Bienvenido al programa del robot "
                + "aspirador\nA continuación introduzca sus datos de acceso");
        String nomUs = JOptionPane.showInputDialog(null, "Usuario");
        String pass = JOptionPane.showInputDialog(null, "Contraseña");

        //Realizamos un bucle while que compruebe las credenciales,si son erroneas
        //el bucle dará true y entrará al bucle hasta que pongas las credenciales
        //correctas y dará false en la condicion y se saldrá
        while (!nomUs.equals(NOMBRE_USUARIO) || !pass.equals(CONTRASENIA)) {

            nomUs = JOptionPane.showInputDialog(null, "Introduzca de nuevo su "
                    + "nombre de usuario", "Error!", JOptionPane.ERROR_MESSAGE);
            pass = JOptionPane.showInputDialog(null, "Introduzca de nuevo su "
                    + "contraseña", "Error!", JOptionPane.ERROR_MESSAGE);

        }

        //Realización del bucle principal que mostrará el menu hasta que elijamos
        //finalizar el programa
        do {

            JOptionPane.showMessageDialog(null, "Credenciales correctas\n"
                    + "Bienvenido al Aspirador Robot\nConfigurando el sistema...");

            //Primero Configuramos el sistema antes de mostrar el menu
            int mCocina, mSalon, mBanio, mDom1, mDom2;

            JOptionPane.showMessageDialog(null, "Introduzca el número de metros"
                    + " de las dependencias(1m²--100m²)");

            //Creación de un bucle while para evitar así el la introducción
            //erronea de los m² de las dependencias por parte del usuario
            String mC = JOptionPane.showInputDialog(null, "m² Cocina");
            mCocina = Integer.parseInt(mC);
            String mS = JOptionPane.showInputDialog(null, "m² Salon");
            mSalon = Integer.parseInt(mS);
            String mB = JOptionPane.showInputDialog(null, "m² Baño");
            mBanio = Integer.parseInt(mB);
            String mD1 = JOptionPane.showInputDialog(null, "m² Dormitorio 1");
            mDom1 = Integer.parseInt(mD1);
            String mD2 = JOptionPane.showInputDialog(null, "m² Dormitorio 2");
            mDom2 = Integer.parseInt(mD2);
            while (mCocina < 0 || mCocina > 100 || mSalon < 0 || mSalon > 100
                    || mBanio < 0 || mBanio > 100 || mDom1 < 0 || mDom1 > 100
                    || mDom2 < 0 || mDom2 > 100) {
                mC = JOptionPane.showInputDialog(null, "Introduzca de nuevo "
                        + "m² Cocina", "Error!", JOptionPane.ERROR_MESSAGE);
                mCocina = Integer.parseInt(mC);
                mS = JOptionPane.showInputDialog(null, "Introduzca de nuevo "
                        + "m² Salon", "Error!", JOptionPane.ERROR_MESSAGE);
                mSalon = Integer.parseInt(mS);
                mB = JOptionPane.showInputDialog(null, "Introduzca de nuevo "
                        + "m² Baño", "Error!", JOptionPane.ERROR_MESSAGE);
                mBanio = Integer.parseInt(mB);
                mD1 = JOptionPane.showInputDialog(null, "Introduzca de nuevo "
                        + "m² Dormitorio 1", "Error!", JOptionPane.ERROR_MESSAGE);
                mDom1 = Integer.parseInt(mD1);
                mD2 = JOptionPane.showInputDialog(null, "Introduzca de nuevo "
                        + "m² Dormitorio 2", "Error!", JOptionPane.ERROR_MESSAGE);
                mDom2 = Integer.parseInt(mD2);

            }

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
                    /*Al escribir 5 que corresponde a salir entramos aqui y nos
                    pregunta que si estamos seguros de salir si le damos si este
                    valor se guarda en un int y se compara con los JOption YES
                    o con JOption NO y con el bucle if según la repsuesta, se 
                    ejecuta de nuevo el programa o no*/
                    int confirmacion = JOptionPane.showConfirmDialog(null, "Seguro"
                            + " que quieres salir?", "SALIDA DEL PROGRAMA",
                            JOptionPane.YES_NO_OPTION);

                    if (confirmacion == JOptionPane.YES_OPTION) {

                        repetirPrograma = false;
                        JOptionPane.showMessageDialog(null, "Finalizando programa...");

                    } else {

                        repetirPrograma = true;
                        JOptionPane.showMessageDialog(null, "Repitiendo programa...");

                    }

            }

        } while (repetirPrograma);

    }

}
