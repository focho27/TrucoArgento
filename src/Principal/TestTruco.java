package Principal;



import org.junit.Test;
import static org.junit.Assert.*;
public class TestTruco {

    @Test
    public void analizarCargaDeCartas(){
        Truco argento=new Truco(3,2);
    Carta cartaPrueba[][];
    Carta auxiliar= new Carta();
    auxiliar.setNumeroDeCarta(1);
    auxiliar.setPalo("ESPADA");


    cartaPrueba = argento.getBaraja();
    assertNull(cartaPrueba[0][0]);
    argento.cargarCartas();
    cartaPrueba = argento.getBaraja();
    assertNotNull(cartaPrueba[0][0]);
    }
    @Test
    public void queSeRepartanCartas(){
        Truco argentina=new Truco(3,2);


        argentina.cargarCartas();

        assertTrue(argentina.repartirCartas(1));
        assertTrue(argentina.repartirCartas(2));






    }
}
