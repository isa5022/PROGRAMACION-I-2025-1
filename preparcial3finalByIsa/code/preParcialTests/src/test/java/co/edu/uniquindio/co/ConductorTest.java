package co.edu.uniquindio.co;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ConductorTests {


    private Conductor conductor;
    private Camion camion;
    private Moto moto;
    private Carro carro;

    @BeforeEach
    public void setUp() {
        conductor = new Conductor("Carlos", "Mejía", "321", LocalDate.of(1988, 3, 12));
        camion = new Camion ("HLV123",4,11);
        moto = new Moto("12efr",200);
        carro = new Carro("AAAA23",TipoServicio.PUBLICO, TipoVehiculo.ELECTRICO);
        conductor.asignarVehiculo(camion);
        conductor.asignarVehiculo(moto);
        conductor.asignarVehiculo(carro);

    }

    @Test
    public void testobtenerVehiculosPorTipo() {
        // Crear vehículos
        Vehiculo carro = new Carro("AAA111", TipoServicio.PRIVADO, TipoVehiculo.ELECTRICO);
        carro.setNumeroPeajesPagados(3); // Supón que calcularPeaje() = 10000 → total = 30000

        Vehiculo moto = new Moto("BBB222", 150);
        moto.setNumeroPeajesPagados(2); // Supón que calcularPeaje() = 7000 → total = 14000

        // Asignar al conductor
        conductor.asignarVehiculo(carro);
        conductor.asignarVehiculo(moto);



        assertEquals(34000,conductor.TotalPagadoEnPeajes());
    }
    @Test
    public void testTotalPagadoEnPeajes(){
        assertNotNull(conductor.TotalPagadoEnPeajes());


    }


}
