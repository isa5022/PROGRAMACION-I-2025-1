package co.edu.uniquindio.co;

public class Camion extends Vehiculo {
    private int numeroEjes;
    private double capacidadToneladas;

    public Camion(String placa, int numeroEjes, double capacidadToneladas) {
        super(placa);
        this.numeroEjes = numeroEjes;
        this.capacidadToneladas = capacidadToneladas;
    }

    public double getCapacidadToneladas() {
        return capacidadToneladas;
    }

    public void setCapacidadToneladas(double capacidadToneladas) {
        this.capacidadToneladas = capacidadToneladas;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        this.numeroEjes = numeroEjes;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "numeroEjes=" + numeroEjes +
                ", capacidadToneladas=" + capacidadToneladas +
                ", placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                '}';
    }

    @Override
    public double calcularPeaje() {
        double valor = 7000 * numeroEjes;
        if (capacidadToneladas > 10) {
            valor = valor + valor * 0.10;
        }
        return valor;
    }


    @Override
    public String DescripcionDetallada() {
        return "Camion{" +
                "placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                ", numeroEjes=" + numeroEjes +
                ", capacidadToneladas=" + capacidadToneladas +
                '}';
    }





}


