import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CamionTest {
    private Camion camion;
    private Conductor conductor;
    @BeforeEach
    public void setUp() {
         conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678","12/24/42");
         camion= new Camion("21",12,12,4);
         conductor.asignarVehiculo(camion);
    }
    @Test
    void calcularCostoPeaje() {
        assertEquals(30800,camion.calcularCostoPeaje());
    }

    @Test
    void descripcionDetallada() {
        assertNotNull(camion.DescripcionDetallada());
    }
}