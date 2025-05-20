package co.edu.uniquindio.co;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstacionPeajeTest {
    EstacionPeaje EstacionPeaje;
    Conductor conductor;
    Conductor conductor2;
    Camion camion;
    Camion camion2;
    Camion camion3;
    Recaudador  cobrador;

    // Test de la clase EstacionPeaje

    @BeforeEach
    void setUp() {
        EstacionPeaje = new EstacionPeaje("pereira","risaralda");
        conductor= new Conductor("JUAN MANUEL","CARDOZO","31143641678",LocalDate.of(1989,03,12));
        conductor2=new Conductor("pedro","juan","1234", LocalDate.of(2000,12,11));
        camion= new Camion("21",12,12);
        camion2= new Camion("22",12,8);
        camion3= new Camion("23",12,11);
        conductor2.asignarVehiculo(camion3);
        conductor.asignarVehiculo(camion);
        conductor.asignarVehiculo(camion2);
        conductor.asignarVehiculo(camion3);
        EstacionPeaje.getListaConductores().add(conductor);
        EstacionPeaje.getListaConductores().add(conductor2);
    }

    @Test
    void imprimirVehiculos() {
        assertNotNull(EstacionPeaje);
    }

    @Test
    void buscarCobrador() {
        cobrador=new Recaudador("pedro","radamel","1032156",LocalDate.of(2006,12,24),50000);
        EstacionPeaje.getRecaudadoresPeajes().add(cobrador);
        assertNotNull(EstacionPeaje.buscarRecaudador("pedro","radamel"));
    }

    @Test
    void identificarConductoresConCamionesMayoresA10Toneladas() {
            List<Conductor> resultado= EstacionPeaje.conductoresConCamionMayor10Toneladas();
        assertEquals(2,resultado.size());

    }


}