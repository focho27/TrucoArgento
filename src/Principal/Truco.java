package Principal;

public class Truco {

        private Carta baraja[][];
        private Carta mano[];
        private Carta manoJugador1[];
        private Carta manoJugador2[];
        private Carta manoJugadores[][];
        private Carta colocarMesa[][];
        private Jugador jugadores[];
        private int contadorCartasColocadasJugador1,contadorCartasColocadasJugador2;
        private int jugador1GanoMano,jugador2GanoMano;
        private static int turno;
        private	int contadorDeEnvido,contadorDeTruco;
        private int puntajeEnvidoMano;
        private int puntajeTrucoMano;

        public Truco(int fila , int columna) {
            baraja = new Carta[4][12];
            mano = new Carta[3];
            this.manoJugadores= new Carta[fila][columna];
            this.colocarMesa = new Carta [fila][columna];
            this.contadorCartasColocadasJugador1=0;
            this.contadorCartasColocadasJugador2=0;
            this.manoJugador1 = new Carta[3];
            this.manoJugador2 = new Carta[3];
            this.jugadores = new Jugador[2];
            this.jugador1GanoMano = 0;
            this.jugador2GanoMano=0;
            this.turno = 0;
            this.puntajeEnvidoMano=0;
            this.puntajeTrucoMano=1;
        }

        public boolean cargarCartas() {
            Carta laOne;
            int numero = 0;
            String palo = "";
            boolean sePudo = false;
            for (int i = 0; i < baraja.length; i++) {
                for (int f = 0; f < baraja[i].length; f++) {
                    if (numero <= 12 && i == 0 && baraja[i][f] == null) {
                        numero++;
                        if(numero != 8 && numero != 9) {
                            laOne = new Carta ();
                            baraja [i][f]=laOne;
                            baraja[i][f].setNumeroDeCarta(numero);
                            baraja[i][f].setPalo("ESPADA");
                        }
                        if (numero == 12) {
                            numero = 0;
                        }

                    }
                    if (numero <= 12 && i == 1 && baraja[i][f] == null) {
                        numero++;
                        if(numero != 8 && numero != 9) {
                            laOne = new Carta ();
                            baraja [i][f]=laOne;
                            baraja[i][f].setNumeroDeCarta(numero);
                            baraja[i][f].setPalo("BASTO");
                        }
                        if (numero == 12) {
                            numero = 0;

                        }
                    }
                    if (numero <= 12 && i == 2 && baraja[i][f] == null) {
                        numero++;
                        if(numero != 8 && numero != 9) {
                            laOne = new Carta ();
                            baraja [i][f]=laOne;
                            baraja[i][f].setNumeroDeCarta(numero);
                            baraja[i][f].setPalo("ORO");
                        }
                        if (numero == 12) {
                            numero = 0;

                        }
                    }
                    if (numero <= 12 && i == 3 && baraja[i][f] == null) {
                        numero++;
                        if(numero != 8 && numero != 9) {
                            laOne = new Carta ();
                            baraja [i][f]=laOne;
                            baraja[i][f].setNumeroDeCarta(numero);
                            baraja[i][f].setPalo("COPA");
                        }
                        if (numero == 12) {
                            numero = 0;
                            sePudo = true;
                        }

                    }

                }
            }
            return sePudo;
        }

        public boolean repartirCartas(int numeroJugador) {
            boolean sePudo = false;
            int i = 0;
            int f = 0;
            int contador = 0;
            boolean manoLista = false;
            while (contador < 3) {

                i = (int) Math.floor(Math.random() * 4);
                f = (int) Math.floor(Math.random() * 12);
                if (baraja[i][f] != null && baraja[i][f].isUtilizada() == false) {
                    switch (contador) {
                        case 0:
                            mano[contador++] = baraja[i][f];
                            baraja[i][f].setUtilizada(true);
                            break;
                        case 1:

                            if ((mano[0].getNumeroDeCarta() == baraja[i][f].getNumeroDeCarta()
                                    && mano[0].getPalo() != baraja[i][f].getPalo())
                                    || (mano[0].getNumeroDeCarta() != baraja[i][f].getNumeroDeCarta()
                                    && mano[0].getPalo() == baraja[i][f].getPalo())) {
                                mano[contador++] = baraja[i][f];
                                baraja[i][f].setUtilizada(true);
                            }
                            break;
                        case 2:

                            if (((mano[0].getNumeroDeCarta() == baraja[i][f].getNumeroDeCarta()
                                    && mano[0].getPalo() != baraja[i][f].getPalo())
                                    || (mano[0].getNumeroDeCarta() != baraja[i][f].getNumeroDeCarta()
                                    && mano[0].getPalo() == baraja[i][f].getPalo()))
                                    && ((mano[1].getPalo() == baraja[i][f].getPalo()
                                    && mano[1].getNumeroDeCarta() != baraja[i][f].getNumeroDeCarta())
                                    || (mano[1].getPalo() != baraja[i][f].getPalo()
                                    && mano[1].getNumeroDeCarta() == baraja[i][f].getNumeroDeCarta()))) {
                                mano[contador++] = baraja[i][f];
                                baraja[i][f].setUtilizada(true);
                            }
                            break;

                    }

                }

            }
            if (contador == 3) {
                sePudo = true;
            }
            if (numeroJugador == 1 && sePudo == true) {
                for (int h = 0; h < 3; h++) {

                    if (manoJugadores[1][h] == null) {
                        manoJugadores[0][h] = mano[h];
                        manoJugador1[h] = manoJugadores[0][h];
                    }

                }
            }
            if (numeroJugador == 2 && sePudo == true) {
                for (int h = 0; h < 3; h++) {
                    if (manoJugadores[1][h] == null) {
                        manoJugadores[1][h] = mano[h];
                        manoJugador2[h] = manoJugadores[1][h];
                    }
                }
            }

            return sePudo;
        }



    public void vaciarManos(){
        for (int i = 0; i < manoJugadores.length; i++) {
            for (int j = 0; j < manoJugadores[i].length; j++) {
                if(manoJugadores[i][j]!=null){
                    manoJugadores[i][j]=null;
                }
            }
        }
    }

        public boolean valoresCartas() {
            Carta laOne;
            int numero = 1;
            String palo = "";
            boolean sePudo = false;
            for (int i = 0; i < baraja.length; i++) {
                for (int f = 0; f < baraja[i].length; f++) {
                    if (i == 0 && baraja[i][f] != null && baraja[i][f].getPalo().equals("ESPADA")) {

                        if(f != 7 && f != 8 ) {
                            switch(f) {
                                case 0:
                                    baraja[i][f].setValorDeCarta(14);

                                    break;
                                case 1:
                                    baraja[i][f].setValorDeCarta(9);

                                    break;
                                case 2:
                                    baraja[i][f].setValorDeCarta(10);

                                    break;
                                case 3:
                                    baraja[i][f].setValorDeCarta(1);
                                    break;
                                case 4:
                                    baraja[i][f].setValorDeCarta(2);
                                    break;
                                case 5:
                                    baraja[i][f].setValorDeCarta(3);
                                    break;
                                case 6:
                                    baraja[i][f].setValorDeCarta(12);
                                    break;
                                case 9:
                                    baraja[i][f].setValorDeCarta(5);
                                    break;
                                case 10:
                                    baraja[i][f].setValorDeCarta(6);
                                    break;
                                case 11:
                                    baraja[i][f].setValorDeCarta(7);
                                    break;

                            }
                        }


                    }
                    if (i == 1 && baraja[i][f] != null&& baraja[i][f].getPalo().equals("BASTO")) {

                        if(f != 7 && f != 8 ) {

                            switch(f) {
                                case 0:
                                    baraja[i][f].setValorDeCarta(13);
                                    break;
                                case 1:
                                    baraja[i][f].setValorDeCarta(9);
                                    break;
                                case 2:
                                    baraja[i][f].setValorDeCarta(10);
                                    break;

                                case 3:
                                    baraja[i][f].setValorDeCarta(1);
                                    break;
                                case 4:
                                    baraja[i][f].setValorDeCarta(2);
                                    break;
                                case 5:
                                    baraja[i][f].setValorDeCarta(3);
                                    break;
                                case 6:
                                    baraja[i][f].setValorDeCarta(4);
                                    break;
                                case 9:
                                    baraja[i][f].setValorDeCarta(5);
                                    break;
                                case 10:
                                    baraja[i][f].setValorDeCarta(6);
                                    break;
                                case 11:
                                    baraja[i][f].setValorDeCarta(7);
                                    break;


                            }

                        }
                    }
                    if (i == 2 && baraja[i][f] != null&& baraja[i][f].getPalo().equals("ORO")) {

                        if(f != 7 && f != 8) {
                            switch(f) {
                                case 0:
                                    baraja[i][f].setValorDeCarta(8);
                                    break;
                                case 1:
                                    baraja[i][f].setValorDeCarta(9);
                                    break;
                                case 2:
                                    baraja[i][f].setValorDeCarta(10);
                                    break;

                                case 3:
                                    baraja[i][f].setValorDeCarta(1);
                                    break;
                                case 4:
                                    baraja[i][f].setValorDeCarta(2);
                                    break;
                                case 5:
                                    baraja[i][f].setValorDeCarta(3);
                                    break;
                                case 6:
                                    baraja[i][f].setValorDeCarta(11);
                                    break;
                                case 9:
                                    baraja[i][f].setValorDeCarta(5);
                                    break;
                                case 10:
                                    baraja[i][f].setValorDeCarta(6);
                                    break;
                                case 11:
                                    baraja[i][f].setValorDeCarta(7);
                                    break;


                            }

                        }

                    }
                    if (i == 3 && baraja[i][f] != null&& baraja[i][f].getPalo().equals("COPA")) {

                        if(f != 7 && f != 8) {
                            switch(f) {
                                case 0:
                                    baraja[i][f].setValorDeCarta(8);
                                    break;
                                case 1:
                                    baraja[i][f].setValorDeCarta(9);
                                    break;
                                case 2:
                                    baraja[i][f].setValorDeCarta(10);
                                    break;

                                case 3:
                                    baraja[i][f].setValorDeCarta(1);
                                    break;
                                case 4:
                                    baraja[i][f].setValorDeCarta(2);
                                    break;
                                case 5:
                                    baraja[i][f].setValorDeCarta(3);
                                    break;
                                case 6:
                                    baraja[i][f].setValorDeCarta(4);
                                    break;
                                case 9:
                                    baraja[i][f].setValorDeCarta(5);
                                    break;
                                case 10:
                                    baraja[i][f].setValorDeCarta(6);
                                    break;
                                case 11:
                                    baraja[i][f].setValorDeCarta(7);
                                    break;


                            }

                        }



                    }
                    if(i==3&&f==12){
                        sePudo = true;
                    }
                }

            }
            return sePudo;
        }

        public boolean colocarCartaEnMesa(int numeroDeJugador,Carta cartaAColocar) {
            boolean seColoco = false;
            for (int i = 0; i <manoJugadores.length ; i++) {
                for (int j = 0; j < manoJugadores[i].length; j++) {
                    if(manoJugadores[i][j]!=null){
                        if((manoJugadores[i][j].getNumeroDeCarta()==cartaAColocar.getNumeroDeCarta()&& manoJugadores[i][j].getPalo().equals(cartaAColocar.getPalo()))){
                            cartaAColocar=manoJugadores[i][j];
                    }
                    }
                }
            }
            if(numeroDeJugador == 1) {

                for (int j = 0; j < 3; j++) {
                    if(manoJugadores[0][j]!=null) {
                        if(manoJugadores[0][j].equals(cartaAColocar)) {
                            colocarMesa[0][contadorCartasColocadasJugador1++]=cartaAColocar;
                            manoJugadores[0][j]=null;
                            seColoco = true;
                        }
                    }
                }

            }
            if (numeroDeJugador == 2) {
                for (int j = 0; j < 3; j++) {
                    if(manoJugadores[1][j]!=null) {
                        if(manoJugadores[1][j].equals(cartaAColocar)) {
                            colocarMesa[1][contadorCartasColocadasJugador2++] = cartaAColocar;
                            manoJugadores[1][j]=null;
                            seColoco = true;
                        }
                    }
                }
            }
            return seColoco;
        }
        public Carta[] getMano() {


            return mano;

        }
        public Carta[][] getJugador() {

            return manoJugadores;
        }
        public int envido(int numeroDeJugador) {
            int envido = 0;
            int resultado1=0,resultado2=0,resultado3=0;

            int numeroJ =0;
            if(numeroDeJugador == 1) {
                numeroJ = 0;
            }else if(numeroDeJugador ==2) {
                numeroJ = 1;
            }
            if(numeroJ==1) {
                if(manoJugador2[0].getPalo().equals(manoJugador2[1].getPalo())) {
                    if(manoJugador2[0].getNumeroDeCarta()<=7&&manoJugador2[1].getNumeroDeCarta()<=7) {
                        resultado1=manoJugador2[0].getNumeroDeCarta() + manoJugador2[1].getNumeroDeCarta()+20;

                    }
                    if((manoJugador2[0].getNumeroDeCarta()<=12&&manoJugador2[0].getNumeroDeCarta()>=10)&&manoJugador2[1].getNumeroDeCarta()<=7) {
                        resultado1= manoJugador2[1].getNumeroDeCarta()+20;

                    }
                    if(manoJugador2[0].getNumeroDeCarta()<=7&&(manoJugador2[1].getNumeroDeCarta()<=12&&manoJugador2[1].getNumeroDeCarta()>=10)) {
                        resultado1=manoJugador2[0].getNumeroDeCarta() + 20;

                    }
                    if((manoJugador2[0].getNumeroDeCarta()>=10&&manoJugador2[0].getNumeroDeCarta()<=12)&&(manoJugador2[1].getNumeroDeCarta()<=12&&manoJugador2[1].getNumeroDeCarta()>=10)) {
                        resultado1= 20;

                    }


                    if(manoJugador2[1].getPalo().equals(manoJugador2[2].getPalo())) {
                        if(manoJugador2[1].getNumeroDeCarta()<=7&&manoJugador2[2].getNumeroDeCarta()<=7) {
                            resultado2=manoJugador2[1].getNumeroDeCarta() + manoJugador2[2].getNumeroDeCarta()+20;

                        }
                        if((manoJugador2[1].getNumeroDeCarta()<=12&&manoJugador2[1].getNumeroDeCarta()>=10)&&manoJugador2[2].getNumeroDeCarta()<=7) {
                            resultado2= manoJugador2[2].getNumeroDeCarta()+20;

                        }
                        if(manoJugador2[1].getNumeroDeCarta()<=7&&(manoJugador2[2].getNumeroDeCarta()<=12&&manoJugador2[2].getNumeroDeCarta()>=10)) {
                            resultado2=manoJugador2[1].getNumeroDeCarta() + 20;

                        }
                        if((manoJugador2[1].getNumeroDeCarta()>=10&&manoJugador2[1].getNumeroDeCarta()<=12)&&(manoJugador2[2].getNumeroDeCarta()<=12&&manoJugador2[2].getNumeroDeCarta()>=10)) {
                            resultado2= 20;

                        }
                    }
                    if(manoJugador2[0].getPalo().equals(manoJugador2[2].getPalo())) {
                        if(manoJugador2[0].getNumeroDeCarta()<=7&&manoJugador2[2].getNumeroDeCarta()<=7) {
                            resultado3=manoJugador2[0].getNumeroDeCarta() + manoJugador2[2].getNumeroDeCarta()+20;

                        }
                        if((manoJugador2[0].getNumeroDeCarta()<=12&&manoJugador2[0].getNumeroDeCarta()>=10)&&manoJugador2[2].getNumeroDeCarta()<=7) {
                            resultado3= manoJugador2[2].getNumeroDeCarta()+20;

                        }
                        if(manoJugador2[0].getNumeroDeCarta()<=7&&(manoJugador2[2].getNumeroDeCarta()<=12&&manoJugador2[2].getNumeroDeCarta()>=10)) {
                            resultado3=manoJugador2[0].getNumeroDeCarta() + 20;

                        }
                        if((manoJugador2[0].getNumeroDeCarta()>=10&&manoJugador2[0].getNumeroDeCarta()<=12)&&(manoJugador2[2].getNumeroDeCarta()<=12&&manoJugador2[2].getNumeroDeCarta()>=10)) {
                            resultado3= 20;

                        }
                    }

                    if(resultado1>resultado2) {
                        if(resultado1>resultado3) {
                            envido = resultado1;
                        }else {envido = resultado3;}
                    }else {
                        if(resultado2>resultado3) {
                            envido = resultado2;
                        }else {
                            envido = resultado3;
                        }
                    }

                }
                if((manoJugador2[0].getPalo().equals(manoJugador2[2].getPalo())==false)&&(manoJugador2[1].getPalo().equals(manoJugador2[2].getPalo())==false)&&(manoJugador2[0].getPalo().equals(manoJugador2[1].getPalo())==false)) {
                    for (int i = 0; i<3; i++) {
                        if(manoJugador2[i].getNumeroDeCarta()>envido&&manoJugador2[i].getNumeroDeCarta()<=7) {
                            envido = manoJugador2[i].getNumeroDeCarta();

                        }
                    }
                }
            }
            if(numeroJ==0) {
                if(manoJugador1[0].getPalo().equals(manoJugador1[1].getPalo())) {
                    if(manoJugador1[0].getNumeroDeCarta()<=7&&manoJugador1[1].getNumeroDeCarta()<=7) {
                        resultado1=manoJugador1[0].getNumeroDeCarta() + manoJugador1[1].getNumeroDeCarta()+20;

                    }
                    if((manoJugador1[0].getNumeroDeCarta()<=12&&manoJugador1[0].getNumeroDeCarta()>=10)&&manoJugador1[1].getNumeroDeCarta()<=7) {
                        resultado1= manoJugador1[1].getNumeroDeCarta()+20;

                    }
                    if(manoJugador1[0].getNumeroDeCarta()<=7&&(manoJugador1[1].getNumeroDeCarta()<=12&&manoJugador1[1].getNumeroDeCarta()>=10)) {
                        resultado1=manoJugador1[0].getNumeroDeCarta() + 20;

                    }
                    if((manoJugador1[0].getNumeroDeCarta()>=10&&manoJugador1[0].getNumeroDeCarta()<=12)&&(manoJugador1[1].getNumeroDeCarta()<=12&&manoJugador1[1].getNumeroDeCarta()>=10)) {
                        resultado1= 20;

                    }


                    if(manoJugador1[1].getPalo().equals(manoJugador1[2].getPalo())) {
                        if(manoJugador1[1].getNumeroDeCarta()<=7&&manoJugador1[2].getNumeroDeCarta()<=7) {
                            resultado2=manoJugador1[1].getNumeroDeCarta() + manoJugador1[2].getNumeroDeCarta()+20;

                        }
                        if((manoJugador1[1].getNumeroDeCarta()<=12&&manoJugador1[1].getNumeroDeCarta()>=10)&&manoJugador1[2].getNumeroDeCarta()<=7) {
                            resultado2= manoJugador1[2].getNumeroDeCarta()+20;

                        }
                        if(manoJugador1[1].getNumeroDeCarta()<=7&&(manoJugador1[2].getNumeroDeCarta()<=12&&manoJugador1[2].getNumeroDeCarta()>=10)) {
                            resultado2=manoJugador1[1].getNumeroDeCarta() + 20;

                        }
                        if((manoJugador1[1].getNumeroDeCarta()>=10&&manoJugador1[1].getNumeroDeCarta()<=12)&&(manoJugador1[2].getNumeroDeCarta()<=12&&manoJugador1[2].getNumeroDeCarta()>=10)) {
                            resultado2= 20;

                        }
                    }
                    if(manoJugador1[0].getPalo().equals(manoJugador1[2].getPalo())) {
                        if(manoJugador1[0].getNumeroDeCarta()<=7&&manoJugador1[2].getNumeroDeCarta()<=7) {
                            resultado3=manoJugador1[0].getNumeroDeCarta() + manoJugador1[2].getNumeroDeCarta()+20;

                        }
                        if((manoJugador1[0].getNumeroDeCarta()<=12&&manoJugador1[0].getNumeroDeCarta()>=10)&&manoJugador1[2].getNumeroDeCarta()<=7) {
                            resultado3= manoJugador1[2].getNumeroDeCarta()+20;

                        }
                        if(manoJugador1[0].getNumeroDeCarta()<=7&&(manoJugador1[2].getNumeroDeCarta()<=12&&manoJugador1[2].getNumeroDeCarta()>=10)) {
                            resultado3=manoJugador1[0].getNumeroDeCarta() + 20;

                        }
                        if((manoJugador1[0].getNumeroDeCarta()>=10&&manoJugador1[0].getNumeroDeCarta()<=12)&&(manoJugador1[2].getNumeroDeCarta()<=12&&manoJugador1[2].getNumeroDeCarta()>=10)) {
                            resultado3= 20;

                        }
                    }

                    if(resultado1>resultado2) {
                        if(resultado1>resultado3) {
                            envido = resultado1;
                        }else {envido = resultado3;}
                    }else {
                        if(resultado2>resultado3) {
                            envido = resultado2;
                        }else {
                            envido = resultado3;
                        }
                    }

                }
                if((manoJugador1[0].getPalo().equals(manoJugador1[2].getPalo())==false)&&(manoJugador1[1].getPalo().equals(manoJugador1[2].getPalo())==false)&&(manoJugador1[0].getPalo().equals(manoJugador1[1].getPalo())==false)) {
                    for (int i = 0; i<3; i++) {
                        if(manoJugador1[i].getNumeroDeCarta()>envido&&manoJugador1[i].getNumeroDeCarta()<=7) {
                            envido = manoJugador1[i].getNumeroDeCarta();

                        }
                    }
                }
            }


            return envido;
        }

    public void setContadorDeEnvido(int contadorDeEnvido) {
        this.contadorDeEnvido = contadorDeEnvido;
    }

    public static void aumentarTurno() {
            turno++;
        }
        public static void reiniciarTurno() {
            turno =0;
        }
        public int ganadorDePunto() {
            int ganadorDelPunto = 0;


            if(colocarMesa[0][turno]!=null && colocarMesa[1][turno]!=null) {
                if(colocarMesa[0][turno].getValorDeCarta()>colocarMesa[1][turno].getValorDeCarta()) {
                    ganadorDelPunto = 1;
                }else if(colocarMesa[1][turno].getValorDeCarta()>colocarMesa[0][turno].getValorDeCarta()) {

                    ganadorDelPunto = 2;
                }
                if(turno==1) {
                    if(colocarMesa[0][0].getValorDeCarta()==colocarMesa[1][0].getValorDeCarta()) {
                        // se define en la proxima mano
                        ganadorDelPunto=3;
                    }}
                if(turno ==2) {
                    if(colocarMesa[0][1].getValorDeCarta()==colocarMesa[1][1].getValorDeCarta()) {
                        // se define en la proxima mano
                        ganadorDelPunto=4;
                    }
                }

            }

            return ganadorDelPunto;
        }
        public boolean refrescarMano() {
                jugador2GanoMano=0;
                jugador1GanoMano=0;
                contadorDeEnvido=0;
                puntajeEnvidoMano=0;
                contadorDeTruco=0;
                puntajeTrucoMano=1;
                contadorCartasColocadasJugador1=0;
                contadorCartasColocadasJugador2=0;
                turno = 0;
                return true;
        }
        public void agregarPuntoAJugador(int puntoJugador) {
            if(puntoJugador ==3 &&jugador1GanoMano==0 &&jugador2GanoMano==0  ) {
                jugador1GanoMano ++;
                jugador2GanoMano ++;
            }

            if(puntoJugador ==1 ) {
                jugador1GanoMano ++;

            }else if(puntoJugador ==2) {
                jugador2GanoMano ++;

            }
        }
        public int analizarQuienGanoMano() {
            int ganoMano=0;
            if(jugador1GanoMano ==2) {
                //Juego.Jugador 1
                ganoMano = 1;

            }else if(jugador2GanoMano ==2) {
                //Juego.Jugador 2
                ganoMano =2;
            }
            return ganoMano;
        }
        public void cantarEnvido(String orden,boolean quiero) {
            if(turno ==0) {
                if(orden.equals("ENVIDO") && quiero == true) {
                    contadorDeEnvido++;
                    if(contadorDeEnvido==1){
                    puntajeEnvidoMano=2;}
                    if(contadorDeEnvido ==2) {
                        puntajeEnvidoMano =4;
                    }
                }else if(orden.equals("ENVIDO") && quiero == false && contadorDeEnvido==0){
                    puntajeEnvidoMano = 1;
                    contadorDeEnvido++;


                }else if(orden.equals("ENVIDO") && quiero == false && contadorDeEnvido==1){
                    puntajeEnvidoMano = 2;
                }
                if(orden.equals("REAL ENVIDO")&& quiero == true) {
                    puntajeEnvidoMano+=3;
                    contadorDeEnvido++;
                }
                if(orden.equals("FALTA ENVIDO")&& quiero==true){
                    puntajeEnvidoMano=30;

                }
            }
        }
        public void cantarTruco(String orden,boolean quiero) {
            if(orden.equals("TRUCO")&& quiero == true) {
                puntajeTrucoMano += 1;
                contadorDeTruco++;
            }else if(orden.equals("TRUCO")&& quiero == false) {
                puntajeTrucoMano =1;
            }
            if(orden.equals("RE TRUCO")&& quiero == true) {
                puntajeTrucoMano +=1;
                contadorDeTruco++;
            }else if(orden.equals("RE TRUCO")&& quiero == false) {
                puntajeTrucoMano =2;
            }
            if(orden.equals("VALE CUATRO")&& quiero == true) {
                puntajeTrucoMano = 4;
                contadorDeTruco++;
            }
            else if(orden.equals("VALE CUATRO")&& quiero == false) {
                puntajeTrucoMano = 3;
            }

        }

    public Carta[][] getBaraja() {
        return baraja;
    }

    public Carta[][] getManoJugadores() {
        return manoJugadores;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public Carta[][] getColocarMesa() {
        return colocarMesa;
    }

    public int getContadorCartasColocadasJugador1() {
        return contadorCartasColocadasJugador1;
    }

    public int getContadorCartasColocadasJugador2() {
        return contadorCartasColocadasJugador2;
    }

    public int getJugador1GanoMano() {
        return jugador1GanoMano;
    }

    public Carta[] getManoJugador1() {
        return manoJugador1;
    }

    public Carta[] getManoJugador2() {
        return manoJugador2;
    }

    public int getJugador2GanoMano() {
        return jugador2GanoMano;
    }

    public static int getTurno() {
        return turno;
    }

    public int getContadorDeEnvido() {
        return contadorDeEnvido;
    }

    public int getContadorDeTruco() {
        return contadorDeTruco;
    }

    public int getPuntajeEnvidoMano() {
        return puntajeEnvidoMano;
    }

    public int getPuntajeTrucoMano() {
        return puntajeTrucoMano;
    }
    public void vaciarBaraja(){
        for (int i = 0; i < baraja.length; i++) {
            for (int j = 0; j < baraja[i].length; j++) {
              if(baraja[i][j]!=null){
                  baraja[i][j]=null;
              }
            }
        }
    }

    public String toString() {
            String listaDeCartas = "";

            for (int i=0;i<baraja.length;i++) {
                for(int f=0;f<baraja[i].length;f++) {

                    if(f!=11 && baraja[i][f]!= null) {
                        listaDeCartas +="|" +baraja[i][f].getNumeroDeCarta() + "|" + " " + baraja[i][f].getPalo() + "\t";
                    }

                    if(f==11&& baraja[i][f]!= null) {
                        listaDeCartas +="|" +baraja[i][f].getNumeroDeCarta() + "|" + " " + baraja[i][f].getPalo() + "\n";
                    }

                }
            }
            return listaDeCartas;
        }




}
