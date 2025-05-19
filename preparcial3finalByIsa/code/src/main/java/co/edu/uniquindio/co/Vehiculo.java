package co.edu.uniquindio.co;

public abstract class Vehiculo implements IPeajeCalculable {
    protected String placa;
    protected int numeroPeajesPagados;


    public Vehiculo(String placa) {
        this.placa = placa;
        this.numeroPeajesPagados = 0;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getNumeroPeajesPagados() {
        return numeroPeajesPagados;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", numeroPeajesPagados=" + numeroPeajesPagados +
                '}';
    }

    public void setNumeroPeajesPagados(int numeroPeajesPagados) {
        this.numeroPeajesPagados = numeroPeajesPagados;
    }

    public String getPlaca() {
        return placa;
    }


    public abstract String DescripcionDetallada();






}
