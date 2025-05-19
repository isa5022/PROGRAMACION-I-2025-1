package co.edu.uniquindio.co;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;
class CamionTest {
    private Camion camion;
    private Conductor conductor;

    @BeforeEach
    public void setUp() {
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678", LocalDate.of(2005,05,10));
        camion= new Camion("21",12,12);
        conductor.asignarVehiculo(camion);
    }
    @Test
    void calcularCostoPeaje() {
        assertEquals(92400.0,camion.calcularPeaje());
    }

    @Test
    void descripcionDetallada() {
        assertNotNull(camion.DescripcionDetallada());
    }
}
