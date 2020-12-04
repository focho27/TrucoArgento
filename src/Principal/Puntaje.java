package Principal;

public class Puntaje {
    private int puntaje,puntajeMaximo;
    public Puntaje(int puntajeMax) {
        this.puntaje = 0;
        this.puntajeMaximo = puntajeMax;
    }
    public boolean gano() {
        boolean gano = false;
        if(puntaje>=puntajeMaximo) {
            gano = true;
        }
        return gano;
    }

    public int getPuntajeMaximo() {
        return puntajeMaximo;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void setPuntajeMaximo(int puntajeMaximo) {
        this.puntajeMaximo = puntajeMaximo;
    }

    public void aumentarPuntaje(int puntajeAagregar) {
        puntaje += puntajeAagregar;
    }
    public String toString() {
        String listadoPuntaje = "";

        listadoPuntaje = puntaje  + "\n";
        return listadoPuntaje;
    }
}
