import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MotoTest {
    private Moto moto;
    private Conductor conductor;

    @BeforeEach
    public void setUp() {
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678","12/24/42");
        moto= new Moto("21",12,210);
        conductor.asignarVehiculo(moto);
    }

    @Test
    void calcularCostoPeaje() {
        assertEquals(7000,moto.calcularCostoPeaje());
    }

    @Test
    void descripcionDetallada() {
        assertNotNull(moto.DescripcionDetallada());
    }
}