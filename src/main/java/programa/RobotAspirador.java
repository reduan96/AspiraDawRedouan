/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa;

//Importamos el JOption para la lectura y muestra de los datos del programa.
import javax.swing.JOptionPane;
//Importamos el date para mostrar fecha en el estado general
import java.util.Date;

/**
 *
 * @author reduan
 */
public class RobotAspirador {

    //Variable que guarda el valor de carga de la batería
    static double cargaEstablecida;
    //Variable donde se guarda la respuesta de salida del programa del menú 5.Salir
    static int confirmacion;
    //Declaración del boolean para la función de salida del programa del menú 5.Salir
    static boolean repetirPrograma = true;
    //Declaración de las variables donde guardamos los m de la casa y de cada dependencia
    static int mCuadradosCasa;
    static int mCocina;
    static int mSalon;
    static int mBanio;
    static int mDom1;
    static int mDom2;
    //Declaramos la variable String que guardará la posición del robot en la casa
    static String posicionRobot;
    //Le damos variables a las posiciones de memoria del array posicion
    static String[] posicion = {"Cocina", "Salón", "Baño", "Dormitorio1",
        "Dormitorio2", "Base de carga"};
    //Creamos objeto fecha con el constructor Date y su new para mostrar la fecha
    static Date fecha = new Date();

    public static void main(String[] args) {

        //Instanciación de las constantes correpondientes al nombre de usuario 
        //y a la contraseña.
        final String NOMBRE_USUARIO = "Reduan";
        final String CONTRASENIA = "password";
        //JOption que te pide autenticación (usuario y contraseña)
        String nomUs = JOptionPane.showInputDialog(null, "Bienvenido al programa Robot"
                + "Aspirador\nIntroduce usuario");
        String pass = JOptionPane.showInputDialog(null, "Introduce contraseña");
        //Bucle while que comprobará si las credenciales son correctas, sino se escriben de nuevo
        while (!nomUs.equals(NOMBRE_USUARIO) || !pass.equals(CONTRASENIA)) {
            nomUs = JOptionPane.showInputDialog(null, "Introduzca de nuevo su "
                    + "nombre de usuario", "Error!", JOptionPane.ERROR_MESSAGE);
            pass = JOptionPane.showInputDialog(null, "Introduzca de nuevo su "
                    + "contraseña", "Error!", JOptionPane.ERROR_MESSAGE);
        }
        //Si las credenciales son correctas se inicia el programa y su configuración
        JOptionPane.showMessageDialog(null, "Credenciales correctas\nBienvenido al Aspirador "
                + "Robot\nConfigurando el sistema...\nIntroduzca el número de m² "
                + " de las dependencias(1m²--100m²)");
        //JOption para la introducción de los m² de las dependencias
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
        //Bucle while para comprobar si los m² de las dependencias están en el rango
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
        //JOption para establecer la batería de manera manual la primera vez
        String C = JOptionPane.showInputDialog(null, "Indica el nivel "
                + "de carga del robot aspirador\n 0% --- 100%");
        cargaEstablecida = Double.parseDouble(C);
        //Bucle while que comprueba el valor metido a la bateria para que este en el rango
        while (cargaEstablecida < 0 || cargaEstablecida > 100) {
            C = JOptionPane.showInputDialog(null, "Indica de nuevo el nivel "
                    + "de carga del robot aspirador\n 0% --- 100%",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            cargaEstablecida = Double.parseDouble(C);
        }
        //La posición del robot al iniciar el menú y elegir directamente 3.E.GENERAL
        posicionRobot = posicion[5];
        //Variable donde se guardará la opción elegida del menú()
        int opcion;
        //Bucle while que repite el menú mientras no se elija salir del mismo.
        while (repetirPrograma) {
            //Bucle do while para que elijas una opción del menú correctamente
            do {
                String op = JOptionPane.showInputDialog(null, "MENU\n 1.ASPIRACIÓN\n"
                        + " 2.ASPIRACIÓN Y FREGADO\n 3.ESTADO GENERAL\n "
                        + "4.BASE DE CARGA\n 5.SALIR");
                opcion = Integer.parseInt(op);
            } while (opcion < 1 || opcion > 5);
            //Variable donde se guardarán los m² recorridos de cada dependencia
            int mCo = 0;
            int mSa = 0;
            int mBa = 0;
            int mDo1 = 0;
            int mDo2 = 0;
            //Constante de batería mínima estblecida por mi para el funcionamiento correcto
            final int MIN_BAT = 4;
            //Switch que determina la elección tomada y guardada en la variable opcion
            switch (opcion) {
                case 1:
                    //Variable donde se guardará la elección del submenú de aspiración
                    int opAspiracion;
                    //Bucle do while que se asegura de que elijas una opción del submenú
                    JOptionPane.showMessageDialog(null, "Elige el modo de aspiración");
                    do {
                        String opAsp = JOptionPane.showInputDialog(null, "1.Modo "
                                + "completo\n2.Modo dependencias");
                        opAspiracion = Integer.parseInt(opAsp);
                    } while (opAspiracion < 1 || opAspiracion > 2);
                    //Declaración constante de gasto de bateria * m² de dependencia
                    final double GASTO_BAT_ASP = 1.5;
                    //Switch para el selección de modo de aspiración
                    switch (opAspiracion) {
                        case 1:
                            //Variable que acumulará m² limpiados
                            int acumuladorMetros;
                            //1.Algoritmo que restará 1.5% de batería * m² recorrido de cada dependencia
                            while (cargaEstablecida > MIN_BAT && mCocina > mCo) {
                                cargaEstablecida -= GASTO_BAT_ASP;
                                mCo++;
                            }
                            //2.Preguntamos si los m² recorridos son != m² de la dependencia
                            //por si no los recorre todos, nos avise de ello el programa
                            if (mCo != mCocina) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar la cocina\n"
                                        + "Posición: " + posicion[0]);
                                posicionRobot = posicion[0];
                                //3.Sumamos todos los m² recorridos 
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //4.Bucle if al que entra si sale de las dependencias
                                if (cargaEstablecida == MIN_BAT) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\n"
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                        + " la cocina que tiene " + mCo + " m\n"
                                        + "Batería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT && mSalon > mSa) {
                                cargaEstablecida -= GASTO_BAT_ASP;
                                mSa++;
                            }
                            //comentario 2.
                            if (mSa != mSalon) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el salón\n"
                                        + "Posición: " + posicion[1]);
                                posicionRobot = posicion[1];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\n"
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                        + " el salón que tiene " + mSa + " m\n"
                                        + "Batería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT && mBanio > mBa) {
                                cargaEstablecida -= GASTO_BAT_ASP;
                                mBa++;
                            }
                            //comentario 2.
                            if (mBa != mBanio) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el baño\n"
                                        + "Posición: " + posicion[2]);
                                posicionRobot = posicion[2];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\n"
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                        + " el baño que tiene " + mBa + " m\n"
                                        + "Batería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT && mDom1 > mDo1) {
                                cargaEstablecida -= GASTO_BAT_ASP;
                                mDo1++;
                            }
                            //comentario 2.
                            if (mDo1 != mDom1) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el dormitorio 1\n"
                                        + "Posición: " + posicion[3]);
                                posicionRobot = posicion[3];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\n"
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                        + " el dormitorio1 que tiene " + mDo1 + " m\n"
                                        + "Batería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT && mDom2 > mDo2) {
                                cargaEstablecida -= GASTO_BAT_ASP;
                                mDo2++;
                            }
                            //comentario 2.
                            if (mDo2 != mDom2) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el dormitorio 2\n"
                                        + "Posición: " + posicion[4]);
                                posicionRobot = posicion[4];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\n"
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                        + " el dormitorio2 que tiene " + mDo2 + " m\n"
                                        + "Batería restante " + cargaEstablecida + "%");
                            }
                            posicionRobot = posicion[5];
                            break;
                        case 2:
                            //Variable opción para guardar elección de dependencia/s a limpiar
                            int opDep;
                            //Variable para salir luego del submenú dependencias al menú principal
                            boolean repetirOpDep = true;
                            //Bucle while que se encarga de que se limpien las dependencias hasta que la batería se agote
                            while (repetirOpDep) {
                                //Bucle do while para que se elija una opción de las que aparecen
                                do {

                                    String op = JOptionPane.showInputDialog(null, "Introduce"
                                            + " la dependencia deseada\n1.Cocina\n2.Salón"
                                            + "\n3.Baño\n4.Dormitorio1\n5.Dormitorio2\n"
                                            + "6.MENÚ");
                                    opDep = Integer.parseInt(op);

                                } while (opDep < 1 || opDep > 7);
                                //Switch que determina la dependencia seleccionada
                                switch (opDep) {
                                    case 1:
                                        while (cargaEstablecida > MIN_BAT && mCocina > mCo) {
                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mCo++;
                                        }
                                        break;
                                    case 2:
                                        while (cargaEstablecida > MIN_BAT && mSalon > mSa) {
                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mSa++;
                                        }
                                        break;
                                    case 3:
                                        while (cargaEstablecida > MIN_BAT && mBanio > mBa) {
                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mBa++;
                                        }
                                        break;
                                    case 4:
                                        while (cargaEstablecida > MIN_BAT && mDom1 > mDo1) {
                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mDo1++;
                                        }
                                        break;
                                    case 5:
                                        while (cargaEstablecida > MIN_BAT && mDom2 > mDo2) {
                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mDo2++;
                                        }
                                        break;
                                }
                                //Switch anidado que comprueba si tiene suf. batería para limpiar cada dep.
                                switch (opDep) {
                                    case 1:
                                        if (mCo != mCocina) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar la cocina\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " la cocina que tiene " + mCo + " m\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                        }
                                        break;
                                    case 2:
                                        if (mSa != mSalon) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el salón\n"
                                                    + "Posición: " + posicion[1]);
                                            posicionRobot = posicion[1];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el salón que tiene " + mSa + " m\n"
                                                    + "Posición: " + posicion[1]);
                                            posicionRobot = posicion[1];
                                        }
                                        break;
                                    case 3:
                                        if (mBa != mBanio) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el baño\n"
                                                    + "Posición: " + posicion[2]);
                                            posicionRobot = posicion[2];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el baño que tiene " + mBa + " m\n"
                                                    + "Posición: " + posicion[2]);
                                            posicionRobot = posicion[2];
                                        }
                                        break;
                                    case 4:
                                        if (mDo1 != mDom1) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el dormitorio 1\n"
                                                    + "Posición: " + posicion[3]);
                                            posicionRobot = posicion[3];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el dormitorio1 que tiene " + mDo1 + " m\n"
                                                    + "Posición: " + posicion[3]);
                                            posicionRobot = posicion[3];
                                        }
                                        break;
                                    case 5:
                                        if (mDo2 != mDom2) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el dormitorio 2\n"
                                                    + "Posición: " + posicion[4]);
                                            posicionRobot = posicion[4];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el dormitorio2 que tiene " + mDo2 + " m\n"
                                                    + "Posición: " + posicion[4]);
                                            posicionRobot = posicion[4];
                                        }
                                        break;
                                    case 6:
                                        repetirOpDep = false;
                                        break;
                                }
                            }
                    }
                    break;
                case 2:
                    //Variable donde se guardará la elección del submenú aspiración
                    int opAspiracion2;
                    //BUcle do while para que se elija una opción de las que salen
                    JOptionPane.showMessageDialog(null, "Elige el modo de aspiración");
                    do {
                        String opAsp2 = JOptionPane.showInputDialog(null, "1.Modo "
                                + "completo\n2.Modo dependencias");
                        opAspiracion2 = Integer.parseInt(opAsp2);
                    } while (opAspiracion2 < 1 || opAspiracion2 > 2);
                    //Varibale de gasto de bateria * m² de dependencia
                    final double GASTO_BAT_ASP_FREG = 2.25;
                    //Variable del mínimo de batería para el correcto funcionamiento
                    final int MIN_BAT_2 = 5;
                    //Switch para el selección de modo de aspiración
                    switch (opAspiracion2) {
                        case 1:
                            //Variable que acumulará los m² recorridos totales
                            int acumuladorMetros;
                            //1.Algoritmo que restará 2.25% de batería * m² recorrido de cada dependencia
                            while (cargaEstablecida > MIN_BAT_2 && mCocina > mCo) {
                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mCo++;
                            }
                            //2.Preguntamos si los m² recorridos son != m² de la dependencia
                            //por si no los recorre todos, nos avise de ello el programa
                            if (mCo != mCocina) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar la cocina"
                                        + " Posición: " + posicion[0]);
                                posicionRobot = posicion[0];
                                //3.Sumamos todos los m² recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //4.Bucle if al que entra si sale de las dependencias
                                if (cargaEstablecida == MIN_BAT_2) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                        + "la cocina.\nBatería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT_2 && mSalon > mSa) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mSa++;
                            }
                            //comentario 2.
                            if (mSa != mSalon) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el salón"
                                        + " Posición: " + posicion[1]);
                                posicionRobot = posicion[1];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT_2) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                        + "el salón.\nBatería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT_2 && mBanio > mBa) {
                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mBa++;
                            }
                            //comentario 2.
                            if (mBa != mBanio) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el baño"
                                        + " Posición: " + posicion[2]);
                                posicionRobot = posicion[2];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario4
                                if (cargaEstablecida == MIN_BAT_2) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                        + "el baño.\nBatería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT_2 && mDom1 > mDo1) {
                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mDo1++;
                            }
                            //comentario 2.
                            if (mDo1 != mDom1) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el dormitorio1"
                                        + " Posición: " + posicion[3]);
                                posicionRobot = posicion[3];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT_2) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                        + "el dormitorio1.\nBatería restante " + cargaEstablecida + "%");
                            }
                            //comentario 1.
                            while (cargaEstablecida > MIN_BAT_2 && mDom2 > mDo2) {
                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mDo2++;
                            }
                            //comentario 2.
                            if (mDo2 != mDom2) {
                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el dormitorio2"
                                        + " Posición: " + posicion[4]);
                                posicionRobot = posicion[4];
                                //comentario 3
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //comentario 4
                                if (cargaEstablecida == MIN_BAT_2) {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados"
                                            + " en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Metros limpiados "
                                            + "en total " + acumuladorMetros + "m,\nmetros"
                                            + " limpiados de cocina " + mCo + "m, salón "
                                            + mSa + "m, baño " + mBa + "m, dormitorio1 "
                                            + mDo1 + "m, dormitorio2 " + mDo2 + "m\nLa "
                                            + "bateria restante es de " + cargaEstablecida
                                            + "%");
                                }
                                break;
                            } else {
                                JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                        + "el dormitorio2.\nBatería restante " + cargaEstablecida + "%");
                            }
                            posicionRobot = posicion[5];
                            break;
                        case 2:
                            //Variable opción dependencias a limpiar
                            int opDep2;
                            //Variable para salir luego del submenú dependencias al menú principal
                            boolean repetirOpDep2 = true;
                            //Bucle while que se encarga de que se limpien las dependencias hasta que la batería se agote
                            while (repetirOpDep2) {
                                //Bucle do while para que se elija una opción de las que aparecen
                                do {

                                    String op = JOptionPane.showInputDialog(null, "Introduce"
                                            + " la dependencia deseada\n1.Cocina\n2.Salón"
                                            + "\n3.Baño\n4.Dormitorio1\n5.Dormitorio2\n"
                                            + "6.MENÚ");
                                    opDep2 = Integer.parseInt(op);
                                } while (opDep2 < 1 || opDep2 > 7);
                                //Switch que determina la dependencia seleccionada
                                switch (opDep2) {
                                    case 1:
                                        while (cargaEstablecida > MIN_BAT_2 && mCocina > mCo) {
                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mCo++;
                                        }
                                        break;
                                    case 2:
                                        while (cargaEstablecida > MIN_BAT_2 && mSalon > mSa) {
                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mSa++;
                                        }
                                        break;
                                    case 3:
                                        while (cargaEstablecida > MIN_BAT_2 && mBanio > mBa) {
                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mBa++;
                                        }
                                        break;
                                    case 4:
                                        while (cargaEstablecida > MIN_BAT_2 && mDom1 > mDo1) {
                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mDo1++;
                                        }
                                        break;
                                    case 5:
                                        while (cargaEstablecida > MIN_BAT_2 && mDom2 > mDo2) {
                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mDo2++;
                                        }
                                        break;
                                }
                                //Switch anidado que comprueba si tiene suf. batería para limpiar cada dep.
                                switch (opDep2) {
                                    case 1:
                                        if (mCo != mCocina) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar la cocina\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT_2) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado"
                                                    + " la cocina que tiene " + mCo + " m\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                        }
                                        break;
                                    case 2:
                                        if (mSa != mSalon) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar el salón\n"
                                                    + "Posición: " + posicion[1]);
                                            posicionRobot = posicion[1];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT_2) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado"
                                                    + " el salón que tiene " + mSa + " m\n"
                                                    + "Posición: " + posicion[1]);
                                            posicionRobot = posicion[1];
                                        }
                                        break;
                                    case 3:
                                        if (mBa != mBanio) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar el baño\n"
                                                    + "Posición: " + posicion[2]);
                                            posicionRobot = posicion[2];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT_2) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado"
                                                    + " el baño que tiene " + mBa + " m\n"
                                                    + "Posición: " + posicion[2]);
                                            posicionRobot = posicion[2];
                                        }
                                        break;
                                    case 4:
                                        if (mDo1 != mDom1) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar el dormitorio 1\n"
                                                    + "Posición: " + posicion[3]);
                                            posicionRobot = posicion[3];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT_2) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado"
                                                    + " el dormitorio1 que tiene " + mDo1 + " m\n"
                                                    + "Posición: " + posicion[3]);
                                            posicionRobot = posicion[3];
                                        }
                                        break;
                                    case 5:
                                        if (mDo2 != mDom2) {
                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar el dormitorio 2\n"
                                                    + "Posición: " + posicion[4]);
                                            posicionRobot = posicion[4];
                                            if (cargaEstablecida < MIN_BAT) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                                posicionRobot = posicion[5];
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != MIN_BAT_2) {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado"
                                                    + " el dormitorio2 que tiene " + mDo2 + " m\n"
                                                    + "Posición: " + posicion[4]);
                                            posicionRobot = posicion[4];
                                        }
                                        break;
                                    case 6:
                                        repetirOpDep2 = false;
                                        break;
                                }
                            }
                    }
                    break;
                case 3:
                    estadoGeneral();
                    break;
                case 4:
                    cargaBateria();
                    posicionRobot = posicion[5];
                    break;
                case 5:
                    eleccionSalida();
                    break;
            }
        }

    }

    //Creación del método encargado de la elección estado general del programa
    public static void estadoGeneral() {
        //Los m² de la casa son la suma de todos
        mCuadradosCasa = mCocina + mSalon + mBanio + mDom1 + mDom2;
        JOptionPane.showMessageDialog(null, fecha + "\nEstado batería: "
                + cargaEstablecida + "%" + "\nPosición robot: " + posicionRobot
                + "\nCocina: " + mCocina + "m²\nSalón: " + mSalon + "m²" + "\nBaño: "
                + mBanio + "m²\nDormitorio1: " + mDom1 + "m²" + "\nDormitorio2: "
                + mDom2 + "m²" + "\nTotal casa: " + mCuadradosCasa + "m²");
    }

    //Creación del método encargado de la carga de la batería(MODULARIZAR)
    public static void cargaBateria() {
        double estActualBat = cargaEstablecida;
        //Bucle for para redondear y que la carga sea exacta
        for (int i = 0; i < (100 - estActualBat); i++) {
            if (cargaEstablecida % 2 != 0) {
                cargaEstablecida = Math.floor(cargaEstablecida);
            }
            cargaEstablecida++;
            System.out.println("Cargando bateria " + cargaEstablecida + "...");
        }
        JOptionPane.showMessageDialog(null, "Carga finalizada!\n"
                + cargaEstablecida + "%");
    }

    //Creación del método encargado de la elección de salida del programa
    public static boolean eleccionSalida() {
        //Con esto nos sale preguntando si queremos salir y dos botones
        confirmacion = JOptionPane.showConfirmDialog(null, "Seguro"
                + " que quieres salir?", "SALIDA DEL PROGRAMA",
                JOptionPane.YES_NO_OPTION);
        //Bucle if que determina si es false o no según la opción seleccionada
        if (confirmacion == JOptionPane.YES_OPTION) {
            repetirPrograma = false;
            JOptionPane.showMessageDialog(null, "Finalizando programa...");
        } else {
            repetirPrograma = true;
            JOptionPane.showMessageDialog(null, "Repitiendo programa...");
        }
        return repetirPrograma;
    }
}
