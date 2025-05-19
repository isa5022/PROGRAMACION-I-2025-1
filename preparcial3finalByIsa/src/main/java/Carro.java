public class Carro extends Vehiculo {
    protected boolean publico;
    protected boolean electrico;

    public Carro(String placa, int numeroPeajePago, boolean publico, boolean electrico) {
        super(placa, numeroPeajePago);
        this.publico = publico;
        this.electrico = electrico;
    }

    public boolean isPublico() {
        return publico;
    }

    public void setPublico(boolean publico) {
        this.publico = publico;
    }

    public boolean isElectrico() {
        return electrico;
    }

    public void setElectrico(boolean electrico) {
        this.electrico = electrico;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "publico=" + publico +
                ", electrico=" + electrico +
                '}';
    }

    public double calcularCostoPeaje() {
        double costoPeaje = 10000;
        if(isElectrico()&&isPublico()){
            costoPeaje= 10000-(costoPeaje*0.35);
        }else if(isElectrico()){
            costoPeaje= 10000-(costoPeaje*0.20);
        }else if(isPublico()){
            costoPeaje= 10000-(costoPeaje*0.15);
        }
        return costoPeaje;
        }
    @Override
    public String DescripcionDetallada() {
        return "Carro{" + "placa='" + placa + '\'' + ", numeroPeajePago=" + numeroPeajePago + "publico=" + publico + ", electrico=" + electrico + '}';
    }

}

