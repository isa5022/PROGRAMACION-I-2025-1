package co.edu.uniquindio;

 public class VehiculoBlindado extends Vehiculo{

    private  int nivelBlindaje;

    public VehiculoBlindado(String id, String modelo, int anioFabricacion, double kilometraje, int misionesCompletadas,
                            EstadoOperativo estadoOperativo, int nivelBlindaje) {
        super(id, modelo, anioFabricacion, kilometraje, misionesCompletadas, estadoOperativo);
        this.nivelBlindaje = nivelBlindaje;
    }

    public int getNivelBlindaje() {
        return nivelBlindaje;
    }

    public void setNivelBlindaje(int nivelBlindaje) {
        this.nivelBlindaje = nivelBlindaje;
    }



}

