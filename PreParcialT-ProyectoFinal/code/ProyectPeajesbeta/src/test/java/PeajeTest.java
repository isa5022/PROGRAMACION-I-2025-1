import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeajeTest {
    Peaje peaje;
    Conductor conductor;
    Conductor conductor2;
    Camion camion;
    Camion camion2;
    Camion camion3;
    Recaudador cobrador;
    Carro carro;
    @BeforeEach

    void setUp() {
        peaje=new Peaje("pereira","risaralda", 12000);
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678","12/24/42");
        conductor2=new Conductor("pedro","juan","1234","12/24/42");
        camion= new Camion("21",12,12,4);
        camion2= new Camion("22",12,8,7);
        camion3= new Camion("23",12,11,5);
        conductor2.asignarVehiculo(camion3);
        conductor.asignarVehiculo(camion);
        conductor.asignarVehiculo(camion2);
        conductor.asignarVehiculo(camion3);
        peaje.getConductoresPasaronPeajes().add(conductor);
        peaje.getConductoresPasaronPeajes().add(conductor2);
    }
    @Test
    void imprimirVehiculos() {
        assertNotNull(peaje);
    }

    @Test
    void buscarCobrador() {
        cobrador=new Recaudador("pedro","radamel","1032156","12/21/14",50000);
        peaje.getCobradoresPeajes().add(cobrador);
        assertNotNull(peaje.buscarCobrador("pedro"));
    }

    @Test
    void identificarConductoresConCamionesMayoresA10Toneladas() {
        List<Conductor> resultado= peaje.identificarConductoresConCamionesMayoresA10Toneladas();
        assertEquals(2,resultado.size());

    }

    @Test
    void testCalcularValorPeajeVehiculoX() {
        carro=new Carro("123jkh",12,true,false);
        assertEquals(20500,peaje.calcularValorPeajeVehiculoX(carro));
    }
}