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

    static double cargaEstablecida;
    static int confirmacion;
    //Declaración del boolean para la función de salida del programa
    static boolean repetirPrograma = true;
    static int mCuadradosCasa;
    static int mCocina;
    static int mSalon;
    static int mBanio;
    static int mDom1;
    static int mDom2;
    //Declaramos la variable String que guardará la posición del
    //robot en el domicilio
    static String posicionRobot;
    //Le damos variables a las posiciones de memoria del array posicion
    static String[] posicion = {"Cocina", "Salón", "Baño", "Dormitorio1",
        "Dormitorio2", "Base de carga"};
    //Creamos objeto fecha con el constructor Date para poder
    //mostrar feche luego con el JOptionPane con el resto de datos
    static Date fecha = new Date();

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
        final String CONTRASENIA = "password";
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
        JOptionPane.showMessageDialog(null, "Credenciales correctas\n"
                + "Bienvenido al Aspirador Robot\nConfigurando el sistema...");
        //Primero Configuramos el sistema antes de mostrar el menu
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
        //0% y 100% e instanciamos nivelCarga para guardar la variable y 
        //establecemos un bucle while para filtrar posibles errores.
        String C = JOptionPane.showInputDialog(null, "Indica el nivel "
                + "de carga del robot aspirador\n 0% --- 100%");
        cargaEstablecida = Double.parseDouble(C);

        while (cargaEstablecida < 0 || cargaEstablecida > 100) {

            C = JOptionPane.showInputDialog(null, "Indica de nuevo el nivel "
                    + "de carga del robot aspirador\n 0% --- 100%",
                    "Error!", JOptionPane.ERROR_MESSAGE);
            cargaEstablecida = Double.parseDouble(C);

        }
        //La posición predeterminada del robot al iniciar el menú
        posicionRobot = posicion[5];
        //Bucle while que repite el menú mientras no se elija salir del mismo.
        int opcion;
        while (repetirPrograma) {
            do {
                String op = JOptionPane.showInputDialog(null, "MENU\n 1.ASPIRACIÓN\n"
                        + " 2.ASPIRACIÓN Y FREGADO\n 3.ESTADO GENERAL\n "
                        + "4.BASE DE CARGA\n 5.SALIR");
                opcion = Integer.parseInt(op); //Hacemos el parse para convertir
                //el string en un int
            } while (opcion < 1 || opcion > 5);
            //Establecemos las variables donde se guardaran los 
            //metros recorridos de cada dependencia
            int mCo = 0;
            int mSa = 0;
            int mBa = 0;
            int mDo1 = 0;
            int mDo2 = 0;
            //Estructura switch que determina la elección tomada 
            switch (opcion) {
                case 1:
                    //Variable donde se guardará la elección del submenú de
                    //la opción 1.aspiración
                    int opAspiracion;
                    //Estructura do while para evitar que el usuario no introduzca
                    //una de las 2 opciones indicadas.
                    JOptionPane.showMessageDialog(null, "Elige el modo de aspiración");
                    do {
                        String opAsp = JOptionPane.showInputDialog(null, "1.Modo "
                                + "completo\n2.Modo dependencias");
                        opAspiracion = Integer.parseInt(opAsp);
                    } while (opAspiracion < 1 || opAspiracion > 2);
                    //Establecemos la varibale de gasto de bateria * m² de dependencia
                    final double GASTO_BAT_ASP = 1.5;
                    //Estructura switch para el selección de modo de aspiración
                    switch (opAspiracion) {

                        case 1:
                            //Declaramos la variable que acumulará la cantidad
                            //de metros limpiados en total
                            int acumuladorMetros;
                            //1.Establecemos el algoritmo que restará el 1.5% de
                            //batería por cada metro recorrido de cada dependencia
                            while (cargaEstablecida > 4 && mCocina > mCo) {

                                cargaEstablecida -= GASTO_BAT_ASP;
                                mCo++;
                            }
                            //2.Preguntamos si los metros recorridos son diferentes
                            //a los metros de la dependencia para asegurarnos de
                            //que si no la ha recorrido entera, que lo comunique
                            //el programa.
                            if (mCo != mCocina) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar la cocina\n"
                                        + "Posición: " + posicion[0]);
                                posicionRobot = posicion[0];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 4) {

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
                            while (cargaEstablecida > 4 && mSalon > mSa) {

                                cargaEstablecida -= GASTO_BAT_ASP;
                                mSa++;
                            }
                            //comentario 2.
                            if (mSa != mSalon) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el salón\n"
                                        + "Posición: " + posicion[1]);
                                posicionRobot = posicion[1];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 4) {

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
                            while (cargaEstablecida > 4 && mBanio > mBa) {

                                cargaEstablecida -= GASTO_BAT_ASP;
                                mBa++;
                            }
                            //comentario 2.
                            if (mBa != mBanio) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el baño\n"
                                        + "Posición: " + posicion[2]);
                                posicionRobot = posicion[2];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 4) {

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
                            while (cargaEstablecida > 4 && mDom1 > mDo1) {

                                cargaEstablecida -= GASTO_BAT_ASP;
                                mDo1++;
                            }
                            //comentario 2.
                            if (mDo1 != mDom1) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el dormitorio 1\n"
                                        + "Posición: " + posicion[3]);
                                posicionRobot = posicion[3];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 4) {

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
                            while (cargaEstablecida > 4 && mDom2 > mDo2) {

                                cargaEstablecida -= GASTO_BAT_ASP;
                                mDo2++;
                            }
                            //comentario 2.
                            if (mDo2 != mDom2) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar el dormitorio 2\n"
                                        + "Posición: " + posicion[4]);
                                posicionRobot = posicion[4];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 4) {

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
                            //Declaración de la variable opción dependencias a limpiar
                            int opDep;
                            boolean repetirOpDep = true;
                            while (repetirOpDep) {
                                //Bucle while que determina que se limpien las dependencias 
                                //hasta que la batería se agote a su límite para que 
                                //el robot se vaya a su lugar de carga
                                //while (cargaEstablecida != 4) {
                                //Bucle do while para filtrar la introducción erronea
                                //de un número de elección que no pertenezca a 
                                //ninguna dependencia
                                do {

                                    String op = JOptionPane.showInputDialog(null, "Introduce"
                                            + " la dependencia deseada\n1.Cocina\n2.Salón"
                                            + "\n3.Baño\n4.Dormitorio1\n5.Dormitorio2\n"
                                            + "6.MENÚ");
                                    opDep = Integer.parseInt(op);

                                } while (opDep < 1 || opDep > 7);
                                //Bucle switch que determina la dependencia seleccionada
                                switch (opDep) {

                                    case 1:
                                        while (cargaEstablecida > 4 && mCocina > mCo) {

                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mCo++;
                                        }
                                        break;
                                    case 2:
                                        while (cargaEstablecida > 4 && mSalon > mSa) {

                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mSa++;
                                        }
                                        break;
                                    case 3:
                                        while (cargaEstablecida > 4 && mBanio > mBa) {

                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mBa++;
                                        }
                                        break;
                                    case 4:
                                        while (cargaEstablecida > 4 && mDom1 > mDo1) {

                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mDo1++;
                                        }
                                        break;
                                    case 5:
                                        while (cargaEstablecida > 4 && mDom2 > mDo2) {

                                            cargaEstablecida -= GASTO_BAT_ASP;
                                            mDo2++;
                                        }
                                        break;
                                }
                                //Bucle switch anidado que comprueba en cada caso
                                //de la dependencia a limpiar si el robot tiene
                                //suficiente batería para ello o no.
                                switch (opDep) {
                                    case 1:
                                        if (mCo != mCocina) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar la cocina\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 4) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 4) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 4) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 4) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 4) {
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
                    //Variable donde se guardará la elección del submenú de
                    //la opción 1.aspiración
                    int opAspiracion2;
                    //Estructura do while para evitar que el usuario no introduzca
                    //una de las 2 opciones indicadas.
                    JOptionPane.showMessageDialog(null, "Elige el modo de aspiración");
                    do {
                        String opAsp2 = JOptionPane.showInputDialog(null, "1.Modo "
                                + "completo\n2.Modo dependencias");
                        opAspiracion2 = Integer.parseInt(opAsp2);
                    } while (opAspiracion2 < 1 || opAspiracion2 > 2);
                    //Establecemos la varibale de gasto de bateria * m² de dependencia
                    final double GASTO_BAT_ASP_FREG = 2.25;
                    //Estructura switch para el selección de modo de aspiración
                    switch (opAspiracion2) {

                        case 1:
                            //Declaramos la variable que acumulará la cantidad
                            //de metros limpiados en total
                            int acumuladorMetros;
                            //1.Establecemos el algoritmo que restará el 1.5% de
                            //batería por cada metro recorrido de cada dependencia
                            while (cargaEstablecida > 5 && mCocina > mCo) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mCo++;
                            }
                            //2.Preguntamos si los metros recorridos son diferentes
                            //a los metros de la dependencia para asegurarnos de
                            //que si no la ha recorrido entera, que lo comunique
                            //el programa.
                            if (mCo != mCocina) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar la cocina"
                                        + " Posición: " + posicion[0]);
                                posicionRobot = posicion[0];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 5) {

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
                            while (cargaEstablecida > 5 && mSalon > mSa) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mSa++;
                            }
                            //comentario 2.
                            if (mSa != mSalon) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el salón"
                                        + " Posición: " + posicion[1]);
                                posicionRobot = posicion[1];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 5) {

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
                            while (cargaEstablecida > 5 && mBanio > mBa) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mBa++;
                            }
                            //comentario 2.
                            if (mBa != mBanio) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el baño"
                                        + " Posición: " + posicion[2]);
                                posicionRobot = posicion[2];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 5) {

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
                            while (cargaEstablecida > 5 && mDom1 > mDo1) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mDo1++;
                            }
                            //comentario 2.
                            if (mDo1 != mDom1) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el dormitorio1"
                                        + " Posición: " + posicion[3]);
                                posicionRobot = posicion[3];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 5) {

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
                            while (cargaEstablecida > 5 && mDom2 > mDo2) {

                                cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                mDo2++;
                            }
                            //comentario 2.
                            if (mDo2 != mDom2) {

                                JOptionPane.showMessageDialog(null, "No se ha"
                                        + " terminado de aspirar y fregar el dormitorio2"
                                        + " Posición: " + posicion[4]);
                                posicionRobot = posicion[4];
                                //Sumamos todos los metros recorridos
                                acumuladorMetros = mCo + mSa + mBa + mDo1 + mDo2;
                                //entra al if si se ha salido de las dependencias para
                                //volver a la base de carga con su 3% batería
                                if (cargaEstablecida == 5) {

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
                            //Declaración de la variable opción dependencias a limpiar
                            int opDep2;
                            boolean repetirOpDep2 = true;
                            while (repetirOpDep2) {
                                //Bucle while que determina que se limpien las dependencias 
                                //hasta que la batería se agote a su límite para que 
                                //el robot se vaya a su lugar de carga
                                //while (cargaEstablecida != 4) {
                                //Bucle do while para filtrar la introducción erronea
                                //de un número de elección que no pertenezca a 
                                //ninguna dependencia
                                do {

                                    String op = JOptionPane.showInputDialog(null, "Introduce"
                                            + " la dependencia deseada\n1.Cocina\n2.Salón"
                                            + "\n3.Baño\n4.Dormitorio1\n5.Dormitorio2\n"
                                            + "6.MENÚ");
                                    opDep2 = Integer.parseInt(op);

                                } while (opDep2 < 1 || opDep2 > 7);
                                //Bucle switch que determina la dependencia seleccionada
                                switch (opDep2) {

                                    case 1:
                                        while (cargaEstablecida > 5 && mCocina > mCo) {

                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mCo++;
                                        }
                                        break;
                                    case 2:
                                        while (cargaEstablecida > 5 && mSalon > mSa) {

                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mSa++;
                                        }
                                        break;
                                    case 3:
                                        while (cargaEstablecida > 5 && mBanio > mBa) {

                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mBa++;
                                        }
                                        break;
                                    case 4:
                                        while (cargaEstablecida > 5 && mDom1 > mDo1) {

                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mDo1++;
                                        }
                                        break;
                                    case 5:
                                        while (cargaEstablecida > 5 && mDom2 > mDo2) {

                                            cargaEstablecida -= GASTO_BAT_ASP_FREG;
                                            mDo2++;
                                        }
                                        break;
                                }
                                //Bucle switch anidado que comprueba en cada caso
                                //de la dependencia a limpiar si el robot tiene
                                //suficiente batería para ello o no.
                                switch (opDep2) {
                                    case 1:
                                        if (mCo != mCocina) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar y fregar la cocina\n"
                                                    + "Posición: " + posicion[0]);
                                            posicionRobot = posicion[0];
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 5) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 5) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 5) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 5) {
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
                                            if (cargaEstablecida < 4) {
                                                JOptionPane.showMessageDialog(null, "Batería "
                                                        + "insuficiente.\nVolviendo a la base de carga..."
                                                        + "Posición: " + posicion[5]);
                                            }
                                        }
                                        posicionRobot = posicion[5];
                                        if (cargaEstablecida != 5) {
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

    //Creación del método encargado de la carga de la batería
    //MODULARIZAR
    public static void cargaBateria() {

        double estActualBat = cargaEstablecida;

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

        /*Al escribir 5 que corresponde a salir entramos aqui y nos
                    pregunta que si estamos seguros de salir si le damos si este
                    valor se guarda en un int y se compara con los JOption YES
                    o con JOption NO y con el bucle if según la repsuesta, se 
                    ejecuta de nuevo el programa o no*/
        confirmacion = JOptionPane.showConfirmDialog(null, "Seguro"
                + " que quieres salir?", "SALIDA DEL PROGRAMA",
                JOptionPane.YES_NO_OPTION);

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
