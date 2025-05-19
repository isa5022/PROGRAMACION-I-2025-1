public class Camion extends Vehiculo {
    private int carga;
    private int ejes;

    public Camion(String placa, int numeroPeajePago, int carga, int ejes) {
        super(placa, numeroPeajePago);
        this.carga = carga;
        this.ejes = ejes;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getEjes() {
        return ejes;
    }

    public void setEjes(int ejes) {
        this.ejes = ejes;
    }

    @Override
    public String toString() {
        return "Camion{" +
                "carga=" + carga +
                ", ejes=" + ejes +
                '}';
    }

    @Override
    public double calcularCostoPeaje() {
        double costoPeaje=getEjes()*7000;
        if(getCarga()>10){
            costoPeaje=costoPeaje+costoPeaje*0.1;
        }
        return costoPeaje;
    }

    @Override
    public String DescripcionDetallada() {
            return "Camion{" + "placa='" + placa + '\'' + ", numeroPeajePago=" + numeroPeajePago + "carga=" + carga + ", ejes=" + ejes + '}';
    }

}
