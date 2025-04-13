package co.edu.uniquindio;

    public class VehiculoApoyo extends Vehiculo {

        private TipoFuncion tipoFuncion;

        public VehiculoApoyo(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas,
                             EstadoOperativo estadoOperativo, TipoFuncion tipoFuncion) {
            super(id, modelo, anioFabricacion, kilometraje, misionesCompletadas, estadoOperativo);
            this.tipoFuncion = tipoFuncion;
        }

        public TipoFuncion getTipoFuncion() {
            return tipoFuncion;
        }

        public void setTipoFuncion(TipoFuncion tipoFuncion) {
            this.tipoFuncion = tipoFuncion;
        }




    }
