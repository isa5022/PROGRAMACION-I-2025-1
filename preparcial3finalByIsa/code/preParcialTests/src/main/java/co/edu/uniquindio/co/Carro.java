package co.edu.uniquindio.co;

public class Carro extends Vehiculo {

    private TipoVehiculo tipoVehiculo;
    private TipoServicio tipoServicio;// COMBUSTIBLE o ELECTRICO

    public Carro(String placa, TipoServicio tipoServicio, TipoVehiculo tipoVehiculo) {
        super(placa);
        this.tipoVehiculo = tipoVehiculo;
        this.tipoServicio = tipoServicio;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public TipoServicio getTipoServicio() {
        return tipoServicio;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "tipoVehiculo=" + tipoVehiculo +
                ", tipoServicio=" + tipoServicio +
                ", placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                '}';
    }

    @Override
    public double calcularPeaje() {
        double valor = 10000;

        if (getTipoVehiculo() == TipoVehiculo.ELECTRICO && getTipoServicio() == TipoServicio.PUBLICO) {
            valor = valor - (valor * 0.35);
        } else if (getTipoServicio() == TipoServicio.PUBLICO) {
            valor = valor + (valor * 0.15);
        } else if (getTipoVehiculo() == TipoVehiculo.ELECTRICO) {
            valor = valor - (valor * 0.20);
        }

        return valor;
    }

    @Override
    public String DescripcionDetallada() {
        return "Carro{" +
                "tipoVehiculo=" + tipoVehiculo +
                ", tipoServicio=" + tipoServicio +
                ", placa=" + placa +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                '}';

    }
}



