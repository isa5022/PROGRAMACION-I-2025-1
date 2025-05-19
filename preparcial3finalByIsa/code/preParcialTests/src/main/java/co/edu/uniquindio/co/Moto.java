package co.edu.uniquindio.co;

public class Moto extends Vehiculo {
    private int cilindraje;

    public Moto(String placa, int cilindraje) {
        super(placa);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public double calcularPeaje() {
        double valor = 5000;
        if (getCilindraje() > 200) {
            valor = valor + 2000;
        }
        return valor;
    }

    @Override
    public String DescripcionDetallada() {
        return "Moto{" +
                "cilindraje=" + cilindraje +
                ", placa=" + placa +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                '}';

    }
}
