package co.edu.uniquindio;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.logging.Logger;

class BatallonTest {

        private static final Logger LOG = Logger.getLogger(BatallonTest.class.getName());
        @Test
    @DisplayName("Test Asignar soldado a una misión")
    public void testAsignarSoldado() {
                LOG.info("iniciando prueba testAsignarSoldado");
            Batallon batallonTest = new Batallon("1234","Octavo Brigada");
            Mision misionTest = new Mision("345", LocalDate.of(2025,04,12),"Armenia");
            Soldado soldadoTest = new Soldado("567","Carlos",Rango.SOLDADO,Especializacion.MEDICO,22,EstadoSoldado.DISPONIBLE,misionTest);
            LinkedList <Soldado>  ListPersonal = new LinkedList<>();
            Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, misionTest);
            Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, misionTest);
            Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, misionTest);
            Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, misionTest);
            Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, misionTest);

            batallonTest.getListMisiones().add(misionTest);
            batallonTest.getListSoldados().add(soldadoTest);

            ListPersonal.add(soldado1);
            ListPersonal.add(soldado2);
            ListPersonal.add(soldado3);
            ListPersonal.add(soldado4);
            ListPersonal.add(soldado5);

            boolean result = batallonTest.asignarSoldadoMision("567","345");
            assertTrue(result);

            LOG.info("finalizando test asignarSoldado");
        }

        @Test
        @DisplayName("Test liberarSoldado")
        public void testLiberarSoldado() {
                LOG.info("iniciando prueba testLiberarSoldado");

                Batallon batalonTest = new Batallon("1234","Octavo Brigada");
                Mision misionTest = new Mision("345",LocalDate.of(2024,03,12), "Armenia");

                LinkedList <Soldado>  listpersonal = new LinkedList<>();
                Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, misionTest);
                Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, misionTest);
                Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, misionTest);
                Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, misionTest);
                Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, misionTest);

                listpersonal.add(soldado1);
                listpersonal.add(soldado2);
                listpersonal.add(soldado3);
                listpersonal.add(soldado4);
                listpersonal.add(soldado5);

                boolean result = batalonTest.liberarSoldados(listpersonal,misionTest.getFecha());
                assertTrue(result);
                assertEquals(EstadoSoldado.DISPONIBLE, soldado1.getEstadoSoldado());
                assertEquals(EstadoSoldado.DISPONIBLE, soldado2.getEstadoSoldado());
                assertEquals(EstadoSoldado.DISPONIBLE, soldado3.getEstadoSoldado());
                assertEquals(EstadoSoldado.DISPONIBLE, soldado4.getEstadoSoldado());
                assertEquals(EstadoSoldado.DISPONIBLE, soldado5.getEstadoSoldado());

                LOG.info("finalizando prueba testLiberarSoldad");
        }

        @Test
        @DisplayName("Test buscar soldado especialidad")
        public void testBuscarSoldadoEspecialidad() {

                Batallon batallonTest = new Batallon("1234","Octavo Brigada");

                Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, null);

                batallonTest.getListSoldados().add(soldado1);
                batallonTest.getListSoldados().add(soldado2);
                batallonTest.getListSoldados().add(soldado3);
                batallonTest.getListSoldados().add(soldado4);
                batallonTest.getListSoldados().add(soldado5);

                LinkedList<Soldado> resultado = batallonTest.buscarSoldadoEspecialidad(Especializacion.MEDICO);
                assertEquals(2, resultado.size(), "Deberían haber 2 soldados médicos");
                assertTrue(resultado.contains(soldado1), "Carlos debería estar en los resultados");
                assertTrue(resultado.contains(soldado3), "Ana debería estar en los resultados");

                LOG.info("Finalizando testBuscarSoldadoEspecialidad");
        }

        @Test
        @DisplayName("soldados Disponibles Rango")
        public void testSoldadosDisponibleRango() {
                Batallon batallonTest = new Batallon("1234","Octavo Brigada");

                Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, null);

                batallonTest.getListSoldados().add(soldado1);
                batallonTest.getListSoldados().add(soldado2);
                batallonTest.getListSoldados().add(soldado3);
                batallonTest.getListSoldados().add(soldado4);
                batallonTest.getListSoldados().add(soldado5);

                LinkedList<Soldado> resultado = batallonTest.soldadosDisponiblesRango(Rango.SARGENTO);

                assertEquals(2, resultado.size());
                assertTrue(resultado.contains(soldado2));
                assertTrue(resultado.contains(soldado3));

                LOG.info("Finalizando testSoldadosDisponiblesRango");



        }
        @Test
        @DisplayName("Test calcular Edad Promedio")
        public void testCalcularEdadPromedio() {
                LOG.info("Test Calcular Promedio Edad Soldados");
                Batallon batallonTest = new Batallon("1234","Octavo Brigada");

                Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, null);

                batallonTest.getListSoldados().add(soldado1);
                batallonTest.getListSoldados().add(soldado2);
                batallonTest.getListSoldados().add(soldado3);
                batallonTest.getListSoldados().add(soldado4);
                batallonTest.getListSoldados().add(soldado5);

                double promedioEsperado = 30;
                double promedioObtenido = batallonTest.calcularEdadPromedio();

                assertEquals(promedioEsperado, promedioObtenido);
                LOG.info("finalizando prueba testCalcularEdadPromedio");


        }

        @Test
        @DisplayName("buscar IdSoldado")
        public void testBuscarIdSoldado() {
                LOG.info("Test buscar idsoldados");
                Batallon batallonTest = new Batallon("1234","Octavo Brigada");
                Soldado soldado1 = new Soldado("ID001", "Carlos Ramírez", Rango.SOLDADO, Especializacion.MEDICO, 25, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado2 = new Soldado("ID002", "Luis Fernández", Rango.SARGENTO, Especializacion.LOGISTICA, 30, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado3 = new Soldado("ID003", "Ana Torres", Rango.SARGENTO, Especializacion.MEDICO, 28, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado4 = new Soldado("ID004", "Miguel Álvarez", Rango.CABO, Especializacion.COMUNICACION, 35, EstadoSoldado.NO_DISPONIBLE, null);
                Soldado soldado5 = new Soldado("ID005", "Sofía Martínez", Rango.SOLDADO, Especializacion.LOGISTICA, 32, EstadoSoldado.NO_DISPONIBLE, null);

                batallonTest.getListSoldados().add(soldado1);
                batallonTest.getListSoldados().add(soldado2);
                batallonTest.getListSoldados().add(soldado3);
                batallonTest.getListSoldados().add(soldado4);
                batallonTest.getListSoldados().add(soldado5);

                Soldado soldadoEsperado = soldado3;
                assertEquals(soldadoEsperado, batallonTest.buscarIdSoldado("ID003"));

                LOG.info("finalizando prueba testBuscarIdSoldado");



        }

//Codigo


}
