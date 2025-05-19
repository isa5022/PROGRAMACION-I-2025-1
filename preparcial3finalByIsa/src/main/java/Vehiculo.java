public abstract class Vehiculo {
    protected String placa;
    protected int numeroPeajePago;

    public Vehiculo(String placa, int numeroPeajePago) {
        this.placa = placa;
        this.numeroPeajePago = numeroPeajePago;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeajePago() {
        return numeroPeajePago;
    }

    public void setNumeroPeajePago(int numeroPeajePago) {
        this.numeroPeajePago = numeroPeajePago;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", numeroPeajePago=" + numeroPeajePago +
                '}';
    }

    public abstract double calcularCostoPeaje();
    public abstract String DescripcionDetallada();

}
