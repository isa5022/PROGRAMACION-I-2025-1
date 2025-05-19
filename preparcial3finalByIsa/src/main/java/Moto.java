public class Moto extends Vehiculo {
    int cilindraje;

    public Moto(String placa, int numeroPeajePago, int cilindraje) {
        super(placa, numeroPeajePago);
        this.cilindraje = cilindraje;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }

    @Override
    public String toString() {
        return "Moto{" +
                "cilindraje=" + cilindraje +
                '}';
    }

    @Override
    public double calcularCostoPeaje() {
        double costoPeaje=5000;
        if(getCilindraje()>200){
            costoPeaje=costoPeaje+2000;
        }
        return costoPeaje;
    }
    @Override
    public String DescripcionDetallada() {
        return "Carro{" + "placa='" + placa + '\'' + ", numeroPeajePago=" + numeroPeajePago + "cilindraje=" + cilindraje + '}';
    }

}
