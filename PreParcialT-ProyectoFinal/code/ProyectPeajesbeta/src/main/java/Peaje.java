import java.util.ArrayList;

public class Peaje {
    private String nombre;
    private String departamento;
    private int costoTotal;
    private ArrayList<Vehiculo> vehiculosPasaronPeaje;
    private ArrayList<Recaudador> cobradoresPeajes;
    private ArrayList<Conductor> ConductoresPasaronPeajes;

    public Peaje(String nombre, String departamento, int valorTotal) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.costoTotal = valorTotal;
        this.vehiculosPasaronPeaje = new ArrayList<>();
        this.cobradoresPeajes = new ArrayList<>();
        this.ConductoresPasaronPeajes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public ArrayList<Vehiculo> getVehiculosPasaronPeaje() {
        return vehiculosPasaronPeaje;
    }

    public void setVehiculosPasaronPeaje(ArrayList<Vehiculo> vehiculosPasaronPeaje) {
        this.vehiculosPasaronPeaje = vehiculosPasaronPeaje;
    }

    public ArrayList<Recaudador> getCobradoresPeajes() {
        return cobradoresPeajes;
    }

    public void setCobradoresPeajes(ArrayList<Recaudador> cobradoresPeajes) {
        this.cobradoresPeajes = cobradoresPeajes;
    }

    public ArrayList<Conductor> getConductoresPasaronPeajes() {
        return ConductoresPasaronPeajes;
    }

    public void setConductoresPasaronPeajes(ArrayList<Conductor> conductoresPasaronPeajes) {
        ConductoresPasaronPeajes = conductoresPasaronPeajes;
    }

    @Override
    public String toString() {
        return "Peaje{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", valorTotal='" + costoTotal + '\'' +
                '}';

    }

    public void imprimirVehiculos() {
        ArrayList<Carro> CarrosQuePasaronPeaje = new ArrayList<>();
        ArrayList<Camion> CamionesQuePasaronPeaje = new ArrayList<>();
        ArrayList<Moto> MotosQuePasaronPeaje = new ArrayList<>();
        for (Vehiculo vehiculo : vehiculosPasaronPeaje) {
            if (vehiculo instanceof Carro) {
                CarrosQuePasaronPeaje.add((Carro) vehiculo);
            }
            if (vehiculo instanceof Camion) {
                CamionesQuePasaronPeaje.add((Camion) vehiculo);
            }
            if (vehiculo instanceof Moto) {
                MotosQuePasaronPeaje.add((Moto) vehiculo);
            }
        }
        double totalRecaudado = 0;
        System.out.println("📋 Total de Vehículos que pasaron el peaje:" + vehiculosPasaronPeaje.size());

        System.out.println("🚗 Carros:");
        for (Carro carro : CarrosQuePasaronPeaje) {
            double costo = carro.calcularCostoPeaje();
            totalRecaudado += costo;
            System.out.println("el costo del peaje para las carros se hace con una valor base de 10000 y se hace un descuento del 20% si es electrico y de un 10% si es publico por lo que es costo de todas las motos es de" + costo);
        }
        System.out.println("🏍️ Motos:");
        for (Moto moto : MotosQuePasaronPeaje) {
            double costo = moto.calcularCostoPeaje();
            totalRecaudado += costo;
            System.out.println("el costo del peaje para las motos tiene un valor base de $5,000, pero si la moto tiene un cilindraje mayor a 200 cc, se aplica un recargo adicional de $2,000" + costo);

        }
        System.out.println("🛻 Camiones:");
        for (Camion camion : CamionesQuePasaronPeaje.toArray(new Camion[0])) {
            double costo = camion.calcularCostoPeaje();
            totalRecaudado += costo;
            System.out.println("el valor base del peaje es de $5,000, pero si la moto tiene un cilindraje mayor a 200 cc, se aplica un recargo adicional de $2,000.\n" +
                    "Camión: el valor del peaje depende de los ejes y la carga. Se cobra un valor base de $7,000 por eje. Si la capacidad de carga del camión supera las 10 toneladas, se aplica un recargo del 10% sobre el total calculado por eje.Entonces el costo total es" + costo);
        }
        ;
        System.out.println("el total recaudado es de: " + totalRecaudado);
        System.out.println("los carros que pasaron fueron:" + CarrosQuePasaronPeaje);
        System.out.println("las motos que pasaron el peaje:" + MotosQuePasaronPeaje);
        System.out.println("los camiones que pasaron el peaje fueron:" + CamionesQuePasaronPeaje);
    }


    public Recaudador buscarCobrador(String nombre) {
        for (Recaudador cobrador : cobradoresPeajes) {
            if (cobrador.getNombre().trim().equalsIgnoreCase(nombre.trim())) {
                return cobrador;
            }
        }
        return null;
    }

    public ArrayList<Conductor> identificarConductoresConCamionesMayoresA10Toneladas() {
        ArrayList<Conductor> conductoresConCamionesMayoresA10Toneladas = new ArrayList<>();
        for (Conductor conductor : ConductoresPasaronPeajes) {
            for (Vehiculo vehiculo : conductor.getVehiculosAsignados()) {
                if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    if (camion.getCarga() > 10) {
                        conductoresConCamionesMayoresA10Toneladas.add(conductor);
                        break;
                    }
                }
            }
        }
        return conductoresConCamionesMayoresA10Toneladas;
    }
    public double calcularValorPeajeVehiculoX(Vehiculo vehiculo) {
        double costoPeajeNuevo = vehiculo.calcularCostoPeaje();
        vehiculosPasaronPeaje.add(vehiculo);
        setCostoTotal(costoTotal + (int) costoPeajeNuevo);
        return getCostoTotal();
    }
}
