package Principal;

public class Carta {
    String palo;
    public Carta() {

        this.palo = "";
        this.numeroDeCarta = 0;
        this.utilizada = false;
        this.valorDeCarta =0;
    }
    public int getValorDeCarta() {
        return valorDeCarta;
    }

    public void setValorDeCarta(int valorDeCarta) {
        this.valorDeCarta = valorDeCarta;
    }
    int numeroDeCarta;
    boolean utilizada ;
    int valorDeCarta;


    public boolean isUtilizada() {
        return utilizada;
    }

    public void setUtilizada(boolean utilizada) {
        this.utilizada = utilizada;
    }

    public String getPalo() {
        return palo;
    }
    public void setPalo(String palo) {
        this.palo = palo;
    }

    public int getNumeroDeCarta() {
        return numeroDeCarta;
    }
    public void setNumeroDeCarta(int numeroDeCarta) {
        this.numeroDeCarta = numeroDeCarta;
    }
    public String toString() {
        String listaDeCartas = "";
        listaDeCartas += " "+ palo + " " + numeroDeCarta;

        return  listaDeCartas;
    }
}
