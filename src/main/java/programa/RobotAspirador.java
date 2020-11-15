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

    static double cargaEstablecida;

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
        JOptionPane.showMessageDialog(null, "Credenciales correctas\n"
                + "Bienvenido al Aspirador Robot\nConfigurando el sistema...");

        //Primero Configuramos el sistema antes de mostrar el menu
        JOptionPane.showMessageDialog(null, "Introduzca el número de metros"
                + " de las dependencias(1m²--100m²)");

        //Creación de un bucle while para evitar así el la introducción
        //erronea de los m² de las dependencias por parte del usuario
        String mC = JOptionPane.showInputDialog(null, "m² Cocina");
        int mCocina = Integer.parseInt(mC);
        String mS = JOptionPane.showInputDialog(null, "m² Salon");
        int mSalon = Integer.parseInt(mS);
        String mB = JOptionPane.showInputDialog(null, "m² Baño");
        int mBanio = Integer.parseInt(mB);
        String mD1 = JOptionPane.showInputDialog(null, "m² Dormitorio 1");
        int mDom1 = Integer.parseInt(mD1);
        String mD2 = JOptionPane.showInputDialog(null, "m² Dormitorio 2");
        int mDom2 = Integer.parseInt(mD2);
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

        int opcion;
        while (repetirPrograma) {
            do {
                String op = JOptionPane.showInputDialog(null, "MENU\n 1.ASPIRACIÓN\n"
                        + " 2.ASPIRACIÓN Y FREGADO\n 3.ESTADO GENERAL\n "
                        + "4.BASE DE CARGA\n 5.SALIR");
                opcion = Integer.parseInt(op); //Hacemos el parse para convertir
                //el string en un int
            } while (opcion < 1 || opcion > 5);

            //Estructura switch que determina la elección tomada 
            //Establecemos las variables donde se guardaran los 
            //metros recorridos de cada dependencia
            int mCo = 0;
            int mSa = 0;
            int mBa = 0;
            int mDo1 = 0;
            int mDo2 = 0;
            //Declaramos la variable String que guardará la posición del
            //robot en el domicilio
            String[] posicion = {"Cocina", "Salón", "Baño", "Dormitorio1",
                "Dormitorio2", "Base de carga"};
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
                            int acumuladorMetros = 0;
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
                                    JOptionPane.showMessageDialog(null, "Bateria"
                                            + " insuficiente,de vuelta a la base de"
                                            + " carga...\nPosición: " + posicion[5]);
                                    //Llamamos al método de base de carga para que 
                                    //el robot este cargado al 100% al repetir el menú
                                    cargaBateria();
                                    //sino sale todas las dependencias limpiadas y 
                                    //muestra la batería restante
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
                                    JOptionPane.showMessageDialog(null, "Bateria"
                                            + " insuficiente,de vuelta a la base de"
                                            + " carga...\nPosición: " + posicion[5]);
                                    //Llamamos al método de base de carga para que 
                                    //el robot este cargado al 100% al repetir el menú
                                    cargaBateria();
                                    //sino sale todas las dependencias limpiadas y 
                                    //muestra la batería restante
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
                                    JOptionPane.showMessageDialog(null, "Bateria"
                                            + " insuficiente,de vuelta a la base de"
                                            + " carga...\nPosición: " + posicion[5]);
                                    //Llamamos al método de base de carga para que 
                                    //el robot este cargado al 100% al repetir el menú
                                    cargaBateria();
                                    //sino sale todas las dependencias limpiadas y 
                                    //muestra la batería restante
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
                                    JOptionPane.showMessageDialog(null, "Bateria"
                                            + " insuficiente,de vuelta a la base de"
                                            + " carga...\nPosición: " + posicion[5]);
                                    //Llamamos al método de base de carga para que 
                                    //el robot este cargado al 100% al repetir el menú
                                    cargaBateria();
                                    //sino sale todas las dependencias limpiadas y 
                                    //muestra la batería restante
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
                                    JOptionPane.showMessageDialog(null, "Bateria"
                                            + " insuficiente,de vuelta a la base de"
                                            + " carga...\nPosición: " + posicion[5]);
                                    //Llamamos al método de base de carga para que 
                                    //el robot este cargado al 100% al repetir el menú
                                    cargaBateria();
                                    //sino sale todas las dependencias limpiadas y 
                                    //muestra la batería restante
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

                            break;
                        case 2:
                            //Declaración de la variable opción dependencias a limpiar
                            int opDep;
                            //Bucle while que determina que se limpien las dependencias 
                            //hasta que la batería se agote a su límite para que 
                            //el robot se vaya a su lugar de carga
                            while (cargaEstablecida != 4) {
                                //Bucle do while para filtrar la introducción erronea
                                //de un número de elección que no pertenezca a 
                                //ninguna dependencia
                                do {

                                    String op = JOptionPane.showInputDialog(null, "Introduce"
                                            + " la dependencia deseada\n1.Cocina\n2.Salón"
                                            + "\n3.Baño\n4.Dormitorio1\n5.Dormitorio2");
                                    opDep = Integer.parseInt(op);

                                } while (opDep < 1 || opDep > 6);
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

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " la cocina que tiene " + mCo + " m");
                                        }
                                        break;
                                    case 2:
                                        if (mSa != mSalon) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el salón\n"
                                                    + "Posición: " + posicion[1]);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el salón que tiene " + mSa + " m");
                                        }
                                        break;
                                    case 3:
                                        if (mBa != mBanio) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el baño\n"
                                                    + "Posición: " + posicion[2]);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el baño que tiene " + mBa + " m");
                                        }
                                        break;
                                    case 4:
                                        if (mDo1 != mDom1) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el dormitorio 1\n"
                                                    + "Posición: " + posicion[3]);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el dormitorio1 que tiene " + mDo1 + " m");
                                        }
                                        break;
                                    case 5:
                                        if (mDo2 != mDom2) {

                                            JOptionPane.showMessageDialog(null, "No se ha"
                                                    + " terminado de aspirar el dormitorio 2\n"
                                                    + "Posición: " + posicion[4]);

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Se ha aspirado"
                                                    + " el dormitorio2 que tiene " + mDo2 + " m");
                                        }
                                        break;
                                }
                                JOptionPane.showMessageDialog(null, "La bateria"
                                        + " restante es de" + cargaEstablecida + "%");

                            }
                            JOptionPane.showMessageDialog(null, "Batería "
                                    + "insuficiente.\nVolviendo a la base de carga..."
                                    + "Posición: " + posicion[5]);
                        //Llamamos al método de carga para que se cargue la batería

                    }
                    break;
                case 2:
                    //Establecemos la varibale de gasto de bateria * m² de dependencia
                    final double GASTO_BAT_ASP_FREG = 2.25;
                    //Declaramos la variable que acumulará la cantidad
                    //de metros limpiados en total
                    int acumuladorMetros;
                    //1.Establecemos el algoritmo que restará el 2.25% de
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
                                + " terminado de aspirar y fregar la cocina");

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
                                + " terminado de aspirar y fregar el salón");

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
                                + " terminado de aspirar y fregar el baño");

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
                                + " terminado de aspirar y fregar el dormitorio1");

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
                                + " terminado de aspirar y fregar el dormitorio2");

                    } else {

                        JOptionPane.showMessageDialog(null, "Se ha aspirado y fregado "
                                + "el dormitorio2.\nBatería restante " + cargaEstablecida + "%");

                    }
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
                        JOptionPane.showMessageDialog(null, "Bateria"
                                + " insuficiente,de vuelta a la base de"
                                + " carga...");
                        //sino sale todas las dependencias limpiadas y la 
                        //batería restante
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
                case 3:

                case 4:
                    cargaBateria();
                    break;
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
        }

    }

    public static void cargaBateria() {

        //Instaciamos la variable i para el bucle for
        double i;
        JOptionPane.showMessageDialog(null, "Estado de carga de batería");
        //Realizamos el bucle for con el algoritmo para cargar la bateria
        for (i = 0; i < 100; i++) {

            System.out.println("Cargando batería..." + i);
            //Bucle if para que la carga no se pase del 100%
            if (cargaEstablecida < 100) {

                i++;
            }
        }
        cargaEstablecida = i;
        JOptionPane.showMessageDialog(null, "Carga finalizada\n"
                + "Estado batería " + cargaEstablecida + "%");

    }

}
