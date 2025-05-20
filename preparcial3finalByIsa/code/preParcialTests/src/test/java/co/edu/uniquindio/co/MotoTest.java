package co.edu.uniquindio.co;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MotoTest {
    private Moto moto;
    private Conductor conductor;

    @BeforeEach
    public void setUp() {
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678", LocalDate.of(1994,05,10));
        moto= new Moto("21",12);
        conductor.asignarVehiculo(moto);
    }
    @Test
    void calcularPeaje() {
        assertEquals(5000.0,moto.calcularPeaje());
    }
    @Test
    void descripcionDetallada() {
        assertNotNull(moto.DescripcionDetallada());
    }




}



