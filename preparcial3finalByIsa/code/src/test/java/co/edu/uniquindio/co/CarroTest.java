package co.edu.uniquindio.co;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class CarroTest {
    private Carro carro;
    private Carro carro1;
    private Moto moto;
    private Conductor conductor;



    @BeforeEach
    public void setUp() {
        carro = new Carro("AAA123", TipoServicio.PUBLICO, TipoVehiculo.ELECTRICO);
        carro1 = new Carro("BBB123", TipoServicio.PUBLICO, TipoVehiculo.COMBUSTIBLE);
        conductor = new Conductor("Juan", "Perez", "123456", LocalDate.of(2000, 12, 20));
        conductor.asignarVehiculo(carro);
    }

    @Test
    void calcularPeaje() {
        assertEquals(6500, carro.calcularPeaje(), 0.01);
    }

    @Test
    void descripcionDetallada() {
        assertNotNull(carro.DescripcionDetallada());
    }
}
