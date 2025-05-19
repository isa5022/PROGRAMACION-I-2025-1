package co.edu.uniquindio.co;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EstacionPeaje {
    private String nombre;
    private String departamento;
    private double totalRecaudado;
    private List<Vehiculo> vehiculosQuePasaron;
    private  List<Recaudador> recaudadoresPeajes;
    private List<Conductor> listaConductores;

    public EstacionPeaje(String nombre, String departamento) {
        this.nombre = nombre;
        this.departamento = departamento;
        this.totalRecaudado = 0;
        this.vehiculosQuePasaron = new LinkedList<>();
        this.recaudadoresPeajes = new ArrayList<>();
        this.listaConductores=new ArrayList<>();
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public List<Vehiculo> getVehiculosQuePasaron() {
        return vehiculosQuePasaron;
    }

    public void setVehiculosQuePasaron(List<Vehiculo> vehiculosQuePasaron) {
        this.vehiculosQuePasaron = vehiculosQuePasaron;
    }

    public List<Recaudador> getRecaudadoresPeajes() {
        return recaudadoresPeajes;
    }

    public void setRecaudadoresPeajes(List<Recaudador> recaudadoresPeajes) {
        this.recaudadoresPeajes = recaudadoresPeajes;
    }

    public List<Conductor> getListaConductores() {
        return listaConductores;
    }

    public void setListaConductores(List<Conductor> listaConductores) {
        this.listaConductores = listaConductores;
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

    public double getTotalRecaudado() {
        return totalRecaudado;
    }

    public void setTotalRecaudado(double totalRecaudado) {
        this.totalRecaudado = totalRecaudado;
    }

    public List<Vehiculo> getVehiculosPasados() {
        return vehiculosQuePasaron;
    }

    public void setVehiculosPasados(List<Vehiculo> vehiculosPasados) {
        this.vehiculosQuePasaron = vehiculosPasados;
    }

    @Override
    public String toString() {
        return "EstacionPeaje{" +
                "nombre='" + nombre + '\'' +
                ", departamento='" + departamento + '\'' +
                ", totalRecaudado=" + totalRecaudado +
                ", vehiculosQuePasaron=" + vehiculosQuePasaron +
                ", recaudadoresPeajes=" + recaudadoresPeajes +
                ", listaConductores=" + listaConductores +
                '}';
    }

    public void imprimirVehiculos() {
        List<Carro> carrosQuePasaronPeaje = new LinkedList<>();
        List<Camion> camionesQuePasaronPeaje = new LinkedList<>();
        List<Moto> motosQuePasaronPeaje = new LinkedList<>();

        for (Vehiculo vehiculo : vehiculosQuePasaron) {
            if (vehiculo instanceof Carro) {
                carrosQuePasaronPeaje.add((Carro) vehiculo);
            } else if (vehiculo instanceof Camion) {
                camionesQuePasaronPeaje.add((Camion) vehiculo);
            } else if (vehiculo instanceof Moto) {
                motosQuePasaronPeaje.add((Moto) vehiculo);
            }
        }

        double totalRecaudado = 0;
        System.out.println("Total de vehículos que pasaron el peaje: " + vehiculosQuePasaron.size());
        System.out.println();

        System.out.println(" Carros:");
        for (Carro carro : carrosQuePasaronPeaje) {
            double costo = carro.calcularPeaje();
            totalRecaudado += costo;
            System.out.printf("Carro %s → Costo peaje: %.2f\n", carro, costo);
            System.out.println("   - Valor base: $10,000");
            System.out.println("   - Descuento 20% si es eléctrico, 10% si es público");
            System.out.println();
        }

        System.out.println(" Motos:");
        for (Moto moto : motosQuePasaronPeaje) {
            double costo = moto.calcularPeaje();
            totalRecaudado += costo;
            System.out.printf("Moto %s → Costo peaje: %.2f\n", moto, costo);
            System.out.println("   - Valor base: $5,000");
            System.out.println("   - Recargo de $2,000 si el cilindraje > 200 cc");
            System.out.println();
        }

        System.out.println("Camiones:");
        for (Camion camion : camionesQuePasaronPeaje) {
            double costo = camion.calcularPeaje();
            totalRecaudado += costo;
            System.out.printf("Camión %s → Costo peaje: %.2f\n", camion, costo);
            System.out.println("   - Valor base: $7,000 por eje");
            System.out.println("   - Recargo 10% si la carga > 10 toneladas");
            System.out.println();
        }

        System.out.printf(" Total recaudado en peajes: %.2f\n", totalRecaudado);
        System.out.println();

        System.out.println(" Resumen:");
        System.out.println("   - Carros que pasaron: " + carrosQuePasaronPeaje.size());
        System.out.println("   - Motos que pasaron: " + motosQuePasaronPeaje.size());
        System.out.println("   - Camiones que pasaron: " + camionesQuePasaronPeaje.size());
    }


    public Recaudador buscarRecaudador(String nombre, String apellido) {
        String nombreBuscado = (nombre + apellido).replaceAll("\\s+", "").toLowerCase();
        for (Recaudador recaudador : recaudadoresPeajes) {
            String nombreCompleto = (recaudador.getNombre() + recaudador.getApellido())
                    .replaceAll("\\s+", "").toLowerCase();
            if (nombreCompleto.equals(nombreBuscado)) {
                return recaudador;
            }
        }

        return null;
    }

    public List<Conductor> conductoresConCamionMayor10Toneladas() {
        List<Conductor> conductoresResultantes = new LinkedList<>();
        for (Conductor conductor : listaConductores) {
            for (Vehiculo vehiculo : conductor.getVehiculosAsignados()) {
                if (vehiculo instanceof Camion) {
                    Camion camion = (Camion) vehiculo;
                    if (camion.getCapacidadToneladas() > 10) {
                        conductoresResultantes.add(conductor);
                        break;
                    }
                }
            }
        }
        return conductoresResultantes ;
    }

    public ArrayList<Conductor> CamionMayorA10Toneladas() {
        ArrayList<Conductor> conductoresResultantes = new ArrayList<>();
        for (Conductor conductor : listaConductores) {
            for(Vehiculo vehiculo: conductor.getVehiculosAsignados()) {
                Camion camion = (Camion) vehiculo;
                if (camion.getCapacidadToneladas() > 10) {
                    conductoresResultantes.add(conductor);
                    break;
                }
            }
        }


   return conductoresResultantes;
}
}





