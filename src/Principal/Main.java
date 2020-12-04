package Principal;

import java.util.Scanner;

public class Main {

    private static Carta prueba;
    private static Puntaje puntaje[];
    private static Carta mano1[], mano2[];
    private static Jugador jugadores[];
    private static Carta jugador[][];
    private static Truco truquito;
    private static int mano = 2;
    private static int opcionElegida =0;
    private static boolean turnoDeJugador2 =true;
    private static int ganadorDeEnvido=3;
    private static int puntosGanadosJ1=0;
    private static int puntosGanadosJ2=0;
    private static boolean reinicioDeMano = false;



    public static void main(String args[]) {
        String nombre = "";
        int opcionDeseada = 0;
        truquito = new Truco(2, 3);
        Jugador auxiliares;
        int numeroDeJugador = 0;
        mano1 = new Carta[3];
        mano2 = new Carta[3];
        puntaje = new Puntaje[2];
        jugadores = new Jugador[2];

        Scanner teclado = new Scanner(System.in);
        seleccionPuntaje();
        System.out.println("Ingresar nombre del Jugador 1: ");
        nombre = teclado.next();
        auxiliares = new Jugador(1, truquito, nombre);
        jugadores[0] = auxiliares;
        System.out.println("Ingresar nombre del Jugador 2: ");
        nombre = teclado.next();
        auxiliares = new Jugador(2, truquito, nombre);
        jugadores[1] = auxiliares;
        System.out.println("Nombre J1: "+jugadores[0].getNombre());
        System.out.println("Nombre J2: "+jugadores[1].getNombre());

        if (truquito.cargarCartas()) {
            System.out.println("Se pudo padre");
            if (truquito.valoresCartas()) {
            System.out.println("Se agregaron los valores a las cartas");
            }
        } else {
            System.out.println("No se pudo");
        }

            System.out.println(truquito.toString());

        while(puntaje[0].gano()==false && puntaje[1].gano()==false) {
            if (truquito.getTurno() == 0|| reinicioDeMano==true) {
                reinicioDeMano = false;
                repartirCartas(truquito);
                if (mano == 2 && reinicioDeMano==false) {
                        turnoDeJugador2 = true;
                        while (truquito.getContadorCartasColocadasJugador2() == 0&& reinicioDeMano==false) {
                            System.out.println("\nTurno de: " + jugadores[1].getNombre());

                       if(truquito.getContadorDeEnvido()==0&& reinicioDeMano==false &&truquito.getContadorDeTruco()==0 ) {
                           primeraMano(2);}
                       else if(truquito.getContadorDeTruco()>=0&& reinicioDeMano==false){
                           segundayTercerMano(2);
                       }
                    }
                    turnoDeJugador2 = false;
                    while (truquito.getContadorCartasColocadasJugador1() == 0&& reinicioDeMano==false) {
                        turnoDeJugador2 = false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        //CREAR PRIMERAMANO SIN ENVIDO
                        //VEO POSIBILIDAD DE QUE NO HAYA CANTADO ENVIDO EL OTRO JUGADOR Y QUE YA HAYA CANTADO
                        if(truquito.getContadorDeEnvido()==0&& reinicioDeMano==false&&truquito.getContadorDeTruco()==0 ){
                        primeraMano(1);
                        }else if(truquito.getContadorDeTruco()==0&& reinicioDeMano==false){

                            segundayTercerMano(1);
                        }
                        else if(truquito.getContadorDeTruco()==1&& reinicioDeMano==false){

                            segundayTercerMano(1);
                        }else if(truquito.getContadorDeTruco()==2&& reinicioDeMano==false){

                            segundayTercerMano(1);
                        }
                    }
                } else if (mano == 1&& reinicioDeMano==false) {
                    turnoDeJugador2 = false;
                    while (truquito.getContadorCartasColocadasJugador1() == 0&& reinicioDeMano==false) {
                        turnoDeJugador2 = false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        if(truquito.getContadorDeEnvido()==0&& reinicioDeMano==false&&truquito.getContadorDeTruco()==0) {
                            primeraMano(1);}
                        else if(truquito.getContadorDeTruco()>=0&& reinicioDeMano==false){
                            segundayTercerMano(1);
                        }
                    }
                    turnoDeJugador2 = true;
                    while (truquito.getContadorCartasColocadasJugador2() ==0 && reinicioDeMano==false) {
                        turnoDeJugador2 = true;
                        //CREAR PRIMERAMANO SIN ENVIDO
                        System.out.println("\nTurno de: " + jugadores[1].getNombre());
                        if(truquito.getContadorDeEnvido()==0&& reinicioDeMano==false&&truquito.getContadorDeTruco()==0){
                            primeraMano(2);
                        }else if(truquito.getContadorDeTruco()==0&& reinicioDeMano==false){

                            segundayTercerMano(2);
                        }
                        else if(truquito.getContadorDeTruco()==1&& reinicioDeMano==false){

                            segundayTercerMano(2);
                        }else if(truquito.getContadorDeTruco()==2&& reinicioDeMano==false){

                            segundayTercerMano(2);
                        }
                    }
                }
                if(reinicioDeMano==false){
                if (truquito.ganadorDePunto() == 1) {
                    puntosGanadosJ1++;
                    System.out.println("\nGano punto el jugador 1");
                } else if (truquito.ganadorDePunto() == 2) {
                    puntosGanadosJ2++;
                    System.out.println("\nGano punto el jugador 2");
                } else if (truquito.ganadorDePunto() == 0) {
                    System.out.println("\nNo se ha ganado puntos");
                }}


            }
            if(truquito.getTurno()!=1&& truquito.getTurno()!=2 && reinicioDeMano ==false){
            truquito.aumentarTurno();}
            if (truquito.getTurno() == 1&&reinicioDeMano ==false) {

                if (puntosGanadosJ1 == 1 && truquito.getTurno() == 1&& reinicioDeMano==false) {
                    //arranca a jugar jugador 1
                    turnoDeJugador2 = false;
                    while (truquito.getContadorCartasColocadasJugador1() == 1&&reinicioDeMano ==false) {
                        turnoDeJugador2 = false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        segundayTercerMano(1);
                    }
                    turnoDeJugador2 = true;
                    while (truquito.getContadorCartasColocadasJugador2() == 1&&reinicioDeMano ==false) {
                        turnoDeJugador2 = true;
                        System.out.println("\nTurno de: " + jugadores[1].getNombre());
                        segundayTercerMano(2);
                    }

                }
                if (puntosGanadosJ2 == 1 && truquito.getTurno() == 1&& reinicioDeMano==false) {
                    turnoDeJugador2 = true;
                    while (truquito.getContadorCartasColocadasJugador2() == 1&&reinicioDeMano ==false) {
                        turnoDeJugador2 = true;
                        System.out.println("\nTurno de: " + jugadores[1].getNombre());
                        segundayTercerMano(2);
                    }
                    turnoDeJugador2 = false;
                    while (truquito.getContadorCartasColocadasJugador1() == 1&&reinicioDeMano ==false) {
                        turnoDeJugador2 = false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        segundayTercerMano(1);
                    }
                    //arranca a jugar jugador 2
                }
                // fijarme si gana el primero o segundo
                // para que arranque a jugar y si hay empate que arranque la mano
                // agregar parda a la mejor
                if (truquito.ganadorDePunto() == 1 && truquito.getTurno() == 1&& reinicioDeMano==false) {
                    puntosGanadosJ1++;
                } else if (truquito.ganadorDePunto() == 2 && truquito.getTurno() == 1&& reinicioDeMano==false) {
                    puntosGanadosJ2++;
                }
                if (puntosGanadosJ1 == 2 && truquito.getTurno() == 1&&reinicioDeMano ==false) {
                    puntaje[0].aumentarPuntaje(truquito.getPuntajeTrucoMano());
                    verPuntajeActual();
                    truquito.refrescarMano();
                    if (reiniciarMano()) {
                        System.out.println("\nSE HA RENICIADO MANO PADRE 4");
                    }
                } else if (puntosGanadosJ2 == 2 && truquito.getTurno() == 1&&reinicioDeMano ==false) {
                    puntaje[1].aumentarPuntaje(truquito.getPuntajeTrucoMano());
                    verPuntajeActual();
                    truquito.refrescarMano();
                    if (reiniciarMano()) {
                        System.out.println("\nSE HA RENICIADO MANO PADRE 5");
                    }
                }
                System.out.println("\nSe pudo");
            }if(truquito.getTurno()!=0&&reinicioDeMano ==false){
            truquito.aumentarTurno();}




            if (truquito.getTurno() == 2&&reinicioDeMano ==false) {
                System.out.println("\nUltimo turno");
                if(turnoDeJugador2 == true && truquito.getTurno()==2&&reinicioDeMano ==false){
                    turnoDeJugador2 =true;
                    while (truquito.getContadorCartasColocadasJugador1()<3&&reinicioDeMano ==false) {
                        turnoDeJugador2 =true;
                        System.out.println("\nTurno de: " + jugadores[1].getNombre());
                        segundayTercerMano(2);
                    }
                    turnoDeJugador2 =false;
                    while (truquito.getContadorCartasColocadasJugador2() < 3&&reinicioDeMano ==false) {
                        turnoDeJugador2 =false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        segundayTercerMano(1);
                    }
                }else if(turnoDeJugador2 == false && truquito.getTurno()==2&&reinicioDeMano ==false){
                    turnoDeJugador2 =false;
                    while (truquito.getContadorCartasColocadasJugador1() < 3&&reinicioDeMano ==false) {
                        turnoDeJugador2 =false;
                        System.out.println("\nTurno de: " + jugadores[0].getNombre());
                        segundayTercerMano(1);
                    }
                    turnoDeJugador2 =true;
                    while (truquito.getContadorCartasColocadasJugador2() < 3&&reinicioDeMano ==false) {
                        turnoDeJugador2 =true;
                        System.out.println("\nTurno de: " + jugadores[1].getNombre());
                        segundayTercerMano(2);
                    }
                }
                if (truquito.ganadorDePunto() == 1 && truquito.getTurno() == 2&&reinicioDeMano ==false) {
                    puntosGanadosJ1++;
                } else if (truquito.ganadorDePunto() == 2 && truquito.getTurno() == 2&&reinicioDeMano ==false) {
                    puntosGanadosJ2++;
                }
                if (puntosGanadosJ1 == 2 && truquito.getTurno() == 2&&reinicioDeMano ==false) {
                    puntaje[0].aumentarPuntaje(truquito.getPuntajeTrucoMano());
                    verPuntajeActual();
                    truquito.refrescarMano();
                    if (reiniciarMano()) {
                        System.out.println("\nSE HA RENICIADO MANO PADRE 6");
                    }
                } else if (puntosGanadosJ2 == 2 && truquito.getTurno() == 2&&reinicioDeMano ==false) {
                    puntaje[1].aumentarPuntaje(truquito.getPuntajeTrucoMano());
                    verPuntajeActual();
                    truquito.refrescarMano();
                    if (reiniciarMano()) {
                        System.out.println("\nSE HA RENICIADO MANO PADRE 7");
                    }
                }
            }

    }
        ganoJuego();

    }
    public static void ganoJuego(){
        if(puntaje[0].gano()){
            System.out.println(jugadores[0].getNombre()+"\n Felicidades GANASTE! ");
        }else if(puntaje[1].gano()){
            System.out.println(jugadores[1].getNombre()+"\n Felicidades GANASTE! ");
        }
    }
    public static void segundayTercerMano(int numeroDeJugador){
        int opcionDeseada=0;
        String nombre ="";
        if(truquito.getContadorDeTruco()==0){
            accionesEnJuegoDos();
            nombre = "TRUCO";
        }
        else if(truquito.getContadorDeTruco()==1){
            accionesEnJuegoTres();
            nombre = "RE TRUCO";

        }else if(truquito.getContadorDeTruco()==2){
            accionesEnJuegoCuatro();
            nombre = "VALE CUATRO";
        }
        opcionDeseada = seleccionarOpcionInicio();


        switch (opcionDeseada) {
            case 1:

                colocarCarta(truquito, numeroDeJugador);
                break;
            case 2:
                cantarTruco(truquito,nombre);
                break;
            case 3:
                irseAlMazo();
                if(truquito.refrescarMano()){
                    System.out.println("SE REINICIO MANO \n");
                }
                if(reiniciarMano()){
                    System.out.println("SE HA RENICIADO MANO PADRE");
                }
                verPuntajeActual();
                //irse al mazo
                break;

            case 8:
                verPuntajeActual();
                break;
        }
    }
    public static void primeraMano(int numeroDeJugador){
        String nombreEnvido = "";
        int opcionDeseada=0;
        String nombre ="";
        accionesEnJuego();
        opcionDeseada = seleccionarOpcionInicio();
        if(truquito.getContadorDeTruco()==0){
            accionesEnJuegoDos();
            nombre = "TRUCO";
        }
        else if(truquito.getContadorDeTruco()==1){
            accionesEnJuegoTres();
            nombre = "RE TRUCO";

        }else if(truquito.getContadorDeTruco()==2){
            accionesEnJuegoCuatro();
            nombre = "VALE CUATRO";
        }
        switch (opcionDeseada) {
            case 1:
                colocarCarta(truquito, numeroDeJugador);
                break;
            case 2:
                cantarEnvido(truquito,"ENVIDO");
                puntaje[ganadorDeEnvido].aumentarPuntaje(truquito.getPuntajeEnvidoMano());

                break;
            case 3:
                cantarEnvido(truquito,"REAL ENVIDO");
                puntaje[ganadorDeEnvido].aumentarPuntaje(truquito.getPuntajeEnvidoMano());
                break;
            case 4:
                cantarEnvido(truquito,"FALTA ENVIDO");
                puntaje[ganadorDeEnvido].aumentarPuntaje(truquito.getPuntajeEnvidoMano());
                break;
            case 5:
                cantarTruco(truquito,nombre);
                break;
            case 7:
                irseAlMazo();
                if(truquito.refrescarMano()){
                    System.out.println("SE REINICIO MANO 1 \n");
                }
                if(reiniciarMano()){
                    System.out.println("SE HA RENICIADO MANO PADRE 1");
                }
                verPuntajeActual();
                //irse al mazo
                break;
            case 9:
                verPuntajeActual();
                break;
        }
    }
    public static boolean  reiniciarMano(){
        if(mano==1){

            ganadorDeEnvido=3;
            puntosGanadosJ2=0;
            puntosGanadosJ1=0;
            mano=2;
            turnoDeJugador2 = true;
            truquito.vaciarManos();
            truquito.vaciarBaraja();
            truquito.cargarCartas();

            truquito.valoresCartas();

            reinicioDeMano=true;

            return true;
        }else if(mano ==2){
            ganadorDeEnvido=3;
            puntosGanadosJ2=0;
            puntosGanadosJ1=0;
            mano=1;
            turnoDeJugador2 = false;
            truquito.vaciarManos();
            truquito.vaciarBaraja();
            truquito.cargarCartas();
            truquito.valoresCartas();

            reinicioDeMano=true;

            return true;
        }

        return false;
    }
    public static void accionesEnJuegoCuatro(){
        System.out.println("1. Colocar carta");
        System.out.println("2. Cantar Vale Cuatro");
        System.out.println("3. Irse al mazo");
    }
    public static void accionesEnJuegoTres(){
        System.out.println("1. Colocar carta");
        System.out.println("2. Cantar Re Juego.Truco");
        System.out.println("3. Irse al mazo");
    }
    public static void accionesEnJuegoDos(){
        System.out.println("1. Colocar carta");
        System.out.println("2. Cantar truco");
        System.out.println("3. Irse al mazo");


    }
    public static void accionesEnJuego(){
        System.out.println("1. Colocar carta");
        System.out.println("2. Cantar Envido");
        System.out.println("3. Cantar Real Envido");
        System.out.println("4. Cantar Falta Envido");
        System.out.println("5. Cantar truco");
        System.out.println("7. Irse al mazo");
        System.out.println("9. Ver puntaje actual");


    }

    public static void verMenu(){
        System.out.println("Bienvenido al Juego.Truco Argento ");
        System.out.println("----------------------------");
        System.out.println("1. Seleccionar modo de juego (15 o 30 pts)");
        System.out.println("2. Repartir cartas");
        System.out.println("3. Ver puntaje actual");
        System.out.println("4. Consultar reglas del juego");
        System.out.println("7. Salir e ingresar al juego");
        System.out.println("8. Volver a jugar");
        System.out.println("------------------------");

    }
    public static void seleccionPuntaje() {
        int opcion = 0, opcionAEnviar = 0;
        Scanner teclado = new Scanner(System.in);
        Puntaje auxiliar;
        auxiliar = new Puntaje(30);
        puntaje[0]=auxiliar;
        auxiliar = new Puntaje(30);
        puntaje[1]=auxiliar;
        System.out.println("Ingrese 1 si quiere que sea de 15 pts y 2 si quiere que sea de 30 pts el partido");
        opcion = teclado.nextInt();
        if (opcion == 1) {
            opcionAEnviar = 15;
            puntaje[0].setPuntajeMaximo(opcionAEnviar);
            puntaje[1].setPuntajeMaximo(opcionAEnviar);
        } else if (opcion == 2) {
            opcionAEnviar = 30;
            puntaje[0].setPuntajeMaximo(opcionAEnviar);
            puntaje[1].setPuntajeMaximo(opcionAEnviar);
        }




    }
    public static int seleccionarOpcionInicio(){
        int opcion=0;
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese la opcion que quiere elegir");
        opcion = teclado.nextInt();
        return opcion;
    }
    public static void repartirCartas(Truco truquito){

        if(truquito.repartirCartas(1)) {
            mano1 =truquito.getMano();
            String manoJugador = "";
            for(int i= 0 ; i<3;i++) {
                if(mano1[i]!=null) {
                    manoJugador += mano1[i].getNumeroDeCarta()+" "+mano1[i].getPalo()+"\t" + " ";

                }
            }
            jugadores[0].cargarManosEnJugadores(1);
            System.out.println(manoJugador);
            System.out.println("Se repartieron " +jugadores[0].getNombre() + " <--tu mano");
        }
        if(truquito.repartirCartas(2)) {
            mano2 =truquito.getMano();
            String manoJugador2 = "";
            for(int i= 0 ; i<3;i++) {
                if(mano2[i]!=null) {
                    manoJugador2 += mano2[i].getNumeroDeCarta()+" "+mano2[i].getPalo()+"\t" + " ";
                }

            }
            jugadores[1].cargarManosEnJugadores(2);
            System.out.println(manoJugador2);
            System.out.println("Se repartieron "+jugadores[1].getNombre() + " <--tu mano");}
    }
    public static void verPuntajeActual(){
        for (int i = 0; i < puntaje.length; i++) {

                System.out.println(jugadores[i].getNombre()+" "+puntaje[i].toString()+"\n");



        }

        }
    static public void verManos(Truco truquito){
        String listaDeCarta="";
        jugador = new Carta[2][3];
        jugador = truquito.getJugador();
        for (int i = 0; i < jugador.length; i++) {
            for (int j = 0; j < jugador[i].length; j++) {
                if(jugador[i][j]!=null)

                    listaDeCarta += jugador[i][j].getNumeroDeCarta() +" "+ jugador[i][j].getPalo() + "\t ";
                if(j==2) {
                    listaDeCarta +=" \n";
                }
            }
        }
        System.out.println(listaDeCarta);
    }
    public static void colocarCarta(Truco truquito,int numeroJugador){

        int numeroCarta=0;
        Scanner teclado = new Scanner(System.in);
        String palo="";
        verManos(truquito);

        System.out.println("Ingrese el numero de carta");
        numeroCarta=teclado.nextInt();
        System.out.println("Palo de carta");
        palo = teclado.next();
        prueba = new Carta();
        prueba.setNumeroDeCarta(numeroCarta);
        prueba.setPalo(palo);

        if(truquito.colocarCartaEnMesa(numeroJugador,prueba)) {
            System.out.println("Se coloco");
        }else {System.out.println("No se pudo colocar");}

        verManos(truquito);

    }
    public static void ganadorDeEnvido(){
        if (truquito.envido(1) > truquito.envido(2)) {
            System.out.println("Gano: "+ jugadores[0].getNombre());
            ganadorDeEnvido = 0;
        }
        if (mano == 1 && truquito.envido(1) == truquito.envido(2)) {
            System.out.println("Gano de mano: "+ jugadores[0].getNombre());
            ganadorDeEnvido = 0;

        } else if (truquito.envido(2) > truquito.envido(1)) {
            System.out.println("Gano: "+ jugadores[1].getNombre());
            ganadorDeEnvido = 1;

        }
        if (mano == 2 && truquito.envido(1) == truquito.envido(2)) {
            System.out.println("Gano de mano: "+ jugadores[1].getNombre());
            ganadorDeEnvido = 1;

        }
    }
    public static int cantarEnvido(Truco truquito,String nombre) {
        int opcionAnterior=0;
        Scanner teclado = new Scanner(System.in);
        int puntoEnvido =0;
        boolean terminoEnvido=false;
        String nombreAnterior="";
        boolean accion = false;
        switch (truquito.getContadorDeEnvido()){
            case 0:
                nombreAnterior = nombre;
                //primeraVez que se canta envido
                turnoDeJugador2=!turnoDeJugador2;
                if(nombre.equals("ENVIDO")){
                if(turnoDeJugador2){
                System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n" + "3. Envido!! \n"+ "4. Real Envido\n" + "5.Falta Envido\n"+"\n ");
                }else{
                    System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n" + "3. Envido!! \n"+ "4. Real Envido\n" + "5.Falta Envido\n"+"\n ");
                }}else if(nombre.equals("REAL ENVIDO")){
                    if(turnoDeJugador2){
                        System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                    }else{
                        System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                    }
                }
                if(nombre.equals("FALTA ENVIDO")){
                    if(turnoDeJugador2){
                        System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n");
                    }else{
                        System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +" elegi opcion \n" +"1. Quiero \n"+"2. No quiero \n" );
                    }
                }
                opcionElegida = teclado.nextInt();
                if(opcionElegida>=3){
                    opcionAnterior=opcionElegida;
                    opcionElegida=3;
                }
                switch (opcionElegida) {
                    case 1:
                        turnoDeJugador2 = !turnoDeJugador2;

                        accion = true;
                        truquito.cantarEnvido(nombre, accion);
                        ganadorDeEnvido(); // metodo que analiza quien gano
                        puntoEnvido = truquito.getPuntajeEnvidoMano();
                        terminoEnvido = true;
                        if(nombre.equals("FALTA ENVIDO")){
                            ganoJuego();
                        }
                        break;
                    case 2:
                        turnoDeJugador2=!turnoDeJugador2;
                        if(turnoDeJugador2){
                            ganadorDeEnvido=1;
                        }else {
                            ganadorDeEnvido =0;
                        }
                        truquito.cantarEnvido(nombre,accion);
                        puntoEnvido = truquito.getPuntajeEnvidoMano();
                        terminoEnvido = true;
                        break;
                    case 3:
                        accion = true;
                        truquito.cantarEnvido(nombreAnterior, accion);
                        opcionElegida = 0;
                        break;

                }
                if(terminoEnvido==true){
                break;}

            case 1:
                if(terminoEnvido==false){

                    if(nombreAnterior.equals("ENVIDO")&&opcionAnterior==3){

                        nombre = "ENVIDO";
                        nombreAnterior = nombre;
                    if(turnoDeJugador2){
                        System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1. Quiero \n"+"2. No quiero \n" + "3. Real Envido!! \n"+ "4.Falta envido \n ");
                    }else{
                        System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1. Quiero \n"+"2. No quiero \n" + "3. Real Envido!! \n "+"4. Falta envido\n");
                    }

                        opcionElegida = teclado.nextInt();
                        if(opcionElegida==3){
                            nombre = "REAL ENVIDO";
                        }
                        if(opcionElegida==4){
                            nombre = "FALTA ENVIDO";
                        }
                    }

                    else if(nombreAnterior.equals("ENVIDO")&& opcionAnterior==4){

                        nombre = "REAL ENVIDO";
                        nombreAnterior = nombre;
                        if(turnoDeJugador2){
                            System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1. Quiero \n"+"2. No quiero  \n "+"3.Falta envido\n");
                        }else{
                            System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1. Quiero \n"+"2. No quiero \n "+"3.Falta envido\n");
                        }
                        opcionElegida = teclado.nextInt();

                        if(opcionElegida==3){
                            nombre = "FALTA ENVIDO";
                        }
                    }
                    else if(nombreAnterior.equals("ENVIDO")&& opcionAnterior==5){
                        nombre = "FALTA ENVIDO";
                        if(turnoDeJugador2){
                            System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1. Quiero \n"+"2. No quiero  \n ");
                        }else{
                            System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1. Quiero \n"+"2. No quiero \n ");
                        }
                        opcionElegida = teclado.nextInt();

                    }
                    else if(nombreAnterior.equals("REAL ENVIDO")&& opcionAnterior==3){
                        nombre = "FALTA ENVIDO";
                        if(turnoDeJugador2){
                            System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1. Quiero \n"+"2. No quiero  \n ");
                        }else{
                            System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1. Quiero \n"+"2. No quiero \n ");
                        }
                        opcionElegida = teclado.nextInt();

                    }
                    if(opcionElegida>=3){
                        opcionAnterior=opcionElegida;
                        opcionElegida=3;
                    }

                switch (opcionElegida){
                    case 1:
                        turnoDeJugador2=!turnoDeJugador2;
                        accion = true;
                        truquito.cantarEnvido(nombre, accion);
                        ganadorDeEnvido(); // metodo que analiza quien gano
                        puntoEnvido = truquito.getPuntajeEnvidoMano();
                        terminoEnvido = true;
                        if(nombre.equals("FALTA ENVIDO")){
                            ganoJuego();
                        }
                        break;
                    case 2:
                        accion = false;
                        truquito.cantarEnvido(nombre, accion);
                        turnoDeJugador2=!turnoDeJugador2;
                        if(turnoDeJugador2){
                            ganadorDeEnvido=1;
                        }else {
                            ganadorDeEnvido =0;
                        }
                        puntoEnvido = truquito.getPuntajeEnvidoMano();
                        terminoEnvido = true;
                        break;
                    case 3:
                        accion = true;
                        if(nombreAnterior.equals("ENVIDO")||nombreAnterior.equals("REAL ENVIDO")){
                        truquito.cantarEnvido(nombreAnterior, accion);
                        }
                        turnoDeJugador2=!turnoDeJugador2;
                        opcionElegida = 0;
                        break;


                }
                }
                if(terminoEnvido==true){
                    break;}

            case 2:
                if(terminoEnvido==false){
                    if(nombre.equals("REAL ENVIDO")){
                    nombreAnterior = "REAL ENVIDO";
                    if(turnoDeJugador2){
                        System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                    }else{
                        System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                    }

                    }
                    if(nombre.equals("FALTA ENVIDO")){
                        if(turnoDeJugador2){
                            System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                        }else{
                            System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" + "3. Falta Envido!! \n ");
                        }
                    }
                    opcionElegida = teclado.nextInt();
                    switch (opcionElegida){
                        case 1:
                            turnoDeJugador2=!turnoDeJugador2;
                            accion = true;
                            truquito.cantarEnvido(nombre, accion);
                            ganadorDeEnvido(); // metodo que analiza quien gano
                            puntoEnvido = truquito.getPuntajeEnvidoMano();
                            terminoEnvido = true;
                            break;
                        case 2:
                            accion = false;
                            truquito.cantarEnvido(nombre, accion);
                            turnoDeJugador2=!turnoDeJugador2;
                            if(turnoDeJugador2){
                                ganadorDeEnvido=1;
                            }else {
                                ganadorDeEnvido =0;
                            }
                            puntoEnvido = truquito.getPuntajeEnvidoMano();
                            terminoEnvido = true;
                            break;

                        case 3:

                            nombre = "FALTA ENVIDO";

                            turnoDeJugador2=!turnoDeJugador2;
                            if(turnoDeJugador2){
                                System.out.println(jugadores[1].getNombre()+ " canto: "+nombre + " \n" + jugadores[0].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" );
                            }else{
                                System.out.println(jugadores[0].getNombre()+ " canto: "+nombre + " \n" + jugadores[1].getNombre() +"\n1 Quiero \n"+"2. No quiero \n" );
                            }
                            opcionElegida=teclado.nextInt();
                            switch (opcionElegida){
                                case 1:
                                    accion = true;
                                    truquito.cantarEnvido(nombre,accion);
                                    ganadorDeEnvido();
                                    puntoEnvido = truquito.getPuntajeEnvidoMano();
                                    ganoJuego();
                                    terminoEnvido = true;
                                    break;
                                case 2:
                                    accion = true;
                                    if(nombreAnterior.equals("REAL ENVIDO")){
                                        truquito.cantarEnvido(nombreAnterior, accion);
                                    }
                                    accion = false;
                                    truquito.cantarEnvido(nombre,accion);
                                    if(turnoDeJugador2){
                                        ganadorDeEnvido=1;
                                    }else {
                                        ganadorDeEnvido =0;
                                    }
                                    puntoEnvido = truquito.getPuntajeEnvidoMano();
                                    terminoEnvido = true;
                                    break;
                            }



                            break;
                    }
                }

                if(terminoEnvido==true){
                    break;}

            case 3:
                if(terminoEnvido==false){
                    if(turnoDeJugador2){
                        System.out.println(jugadores[1].getNombre()+" Quiero \n"+"2. No quiero \n");
                    }else{
                        System.out.println(jugadores[0].getNombre()+" Quiero \n"+"2. No quiero \n");
                    }
                    opcionElegida = teclado.nextInt();
                    switch (opcionElegida){
                        case 1:
                            turnoDeJugador2=!turnoDeJugador2;
                            accion = true;
                            truquito.cantarEnvido(nombre, accion);
                            ganadorDeEnvido(); // metodo que analiza quien gano
                            puntoEnvido = truquito.getPuntajeEnvidoMano();
                            ganoJuego();
                            // poner opciones para volver a jugar o que termine directamente el juego
                            terminoEnvido = true;
                            break;
                        case 2:
                            accion = false;
                            truquito.cantarEnvido(nombre, accion);
                            turnoDeJugador2=!turnoDeJugador2;
                            if(turnoDeJugador2){
                                ganadorDeEnvido=1;
                            }else {
                                ganadorDeEnvido =0;
                            }
                            puntoEnvido = truquito.getPuntajeEnvidoMano();
                            terminoEnvido = true;
                            break;

                    }
                }
                break;
        }

        return puntoEnvido;
    }
    public static void cantarTruco(Truco truquito,String nombre){
        int opcionElegida=0;
        boolean accion=false;
        Scanner teclado = new Scanner(System.in);
        System.out.println(nombre+"!!!!!");


        if(turnoDeJugador2){
            System.out.println(jugadores[1].getNombre()+" Canto: "+ nombre);

        }else {
            System.out.println(jugadores[0].getNombre()+" Canto: "+ nombre);
        }
        turnoDeJugador2=!turnoDeJugador2;
        if(turnoDeJugador2){
            System.out.println(jugadores[1].getNombre()+" Ingrese 1 si quiere y 2 si no quiere");
        }else{
            System.out.println(jugadores[0].getNombre()+" Ingrese 1 si quiere y 2 si no quiere");
        }

        opcionElegida = teclado.nextInt();
        if(opcionElegida==1){
            accion = true;
            truquito.cantarTruco(nombre,accion);
        }else if(opcionElegida==2){

            accion = false;
            truquito.cantarTruco(nombre,accion);

            if(turnoDeJugador2){
                puntaje[0].aumentarPuntaje(truquito.getPuntajeTrucoMano());
            }else {
                puntaje[1].aumentarPuntaje(truquito.getPuntajeTrucoMano());
            }
            turnoDeJugador2=!turnoDeJugador2;
            if(truquito.refrescarMano()){
                System.out.println("SE REINICIO MANO \n");
            }
            if(reiniciarMano()){
                System.out.println("SE HA RENICIADO MANO PADRE");
            }
            verPuntajeActual();
        }


    }

    public static void irseAlMazo(){

            if(turnoDeJugador2){
                if(truquito.getContadorCartasColocadasJugador1()>0){
                    puntaje[0].aumentarPuntaje(truquito.getPuntajeTrucoMano());
                    truquito.refrescarMano();

                }
                if(truquito.getContadorCartasColocadasJugador1()==0){
                    // posibilidad que no se hayan jugado cartas y se vaya en primera mano
                    if(truquito.getContadorDeEnvido()==0 && mano==2){
                     puntaje[0].aumentarPuntaje(2);
                    }
                }
            }else {
                //turno jugador 1
                if(truquito.getContadorCartasColocadasJugador2()>0){
                    puntaje[1].aumentarPuntaje(truquito.getPuntajeTrucoMano());

                }
                if(truquito.getContadorCartasColocadasJugador2()==0){
                    // posibilidad que no se hayan jugado cartas y se vaya en primera mano
                    if(truquito.getContadorDeEnvido()==0&& mano ==1){
                        puntaje[1].aumentarPuntaje(2);
                    }
                }
            }
            //aumenta punto el jugador 2
            //analiza si se canto primero envido si se va en primera mano

            //aumenta punto el jugador 1
            //analiza si se canto primero envido si se va en primera mano
    }

}
