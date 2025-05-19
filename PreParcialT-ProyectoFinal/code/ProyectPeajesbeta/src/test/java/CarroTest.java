import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {
    private Carro carro;
    private Conductor conductor;
    @BeforeEach
    public void setUp() {
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678","12/24/42");
        carro= new Carro("21",12,true, false);
        conductor.asignarVehiculo(carro);
    }

    @Test
    void calcularCostoPeaje() {
        assertEquals(8500,carro.calcularCostoPeaje());
    }

    @Test
    void descripcionDetallada() {
        assertNotNull(carro.DescripcionDetallada());
    }
}