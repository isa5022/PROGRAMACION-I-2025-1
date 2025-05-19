import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConductorTest {
    Conductor conductor;
    Camion camion;
    Carro carro;
    Moto moto;

    @BeforeEach
    public void setUp() {
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678","12/24/42");
        camion= new Camion("21",12,12,4);
        carro= new Carro("21",12,true, false);
        moto= new Moto("21",12,210);
        conductor.asignarVehiculo(camion);
        conductor.asignarVehiculo(carro);
        conductor.asignarVehiculo(moto);
    }

    @Test
    void calcularCostoPeaje() {
        assertEquals(46300,conductor.calcularCostoPeaje());
    }

    @Test
    void obtenerVehiculosPorTipo() {
        assertNotNull(conductor.obtenerVehiculosPorTipo("Carro"));
    }

    @Test
    void asignarVehiculo() {
        conductor.asignarVehiculo(carro);
        assertNotNull(conductor.getVehiculosAsignados());
    }
}