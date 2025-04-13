package co.edu.uniquindio;

    public class VehiculoTransporte extends Vehiculo{


        private int capacidadSoldados;

        public VehiculoTransporte(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas,
                                  EstadoOperativo estadoOperativo, int capacidadSoldados) {
            super(id, modelo, anioFabricacion, kilometraje, misionesCompletadas, estadoOperativo);
            this.capacidadSoldados = capacidadSoldados;
        }

        public int getCapacidadSoldados() {
            return capacidadSoldados;
        }

        public void setCapacidadSoldados(int capacidadSoldados) {
            this.capacidadSoldados = capacidadSoldados;
        }



    }

