package Principal;

public class Jugador {
    String nombre = "";
    int numeroJugador = 0;
    Truco auxiliar;
    Carta mano[];

    public Jugador(int numeroDeJugador,Truco truquito,String nombre) {
        this.nombre = nombre;
        this.numeroJugador = numeroDeJugador;
        this.mano = new Carta [3];
        auxiliar = truquito;
    }
    public String getNombre() {
        return nombre;
    }
    public void cargarManosEnJugadores( int numeroDeJugador){
        if(numeroDeJugador ==1){
            mano= auxiliar.getManoJugador1();
        }else if(numeroDeJugador==2){
            mano= auxiliar.getManoJugador2();
        }
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNumeroJugador() {
        return numeroJugador;
    }
    public void setNumeroJugador(int numeroJugador) {
        this.numeroJugador = numeroJugador;
    }
    @Override
    public String toString() {
        return "Jugadores [nombre=" + nombre + ", numeroJugador=" + numeroJugador + "]";
    }

}