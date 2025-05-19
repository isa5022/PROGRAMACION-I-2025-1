package co.edu.uniquindio.co;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Conductor extends Persona {
    private List<Vehiculo> vehiculosAsignados ;

    public Conductor(String nombre, String apellido, String id, LocalDate fechaNacimiento) {
        super(nombre, apellido, id, fechaNacimiento);
        this.vehiculosAsignados = new ArrayList<>();
    }


    public List<Vehiculo> getVehiculosAsignados() {
        return vehiculosAsignados;
    }

    public double TotalPagadoEnPeajes() {
        double total = 0;
        for (Vehiculo vehiculo : vehiculosAsignados) {
            total += vehiculo.calcularPeaje() * vehiculo.getNumeroPeajesPagados();
        }
        return total;
    }
    // Metodo para asignar un vehiculo a un conductor

    public void asignarVehiculo(Vehiculo vehiculo) {
        vehiculosAsignados.add(vehiculo);
    }

    public List<Vehiculo> obtenerVehiculosPorTipo(String tipo) {
        List<Vehiculo> vehiculosFiltrados = new LinkedList<>();

        for (Vehiculo vehiculo : vehiculosAsignados) {
            switch (tipo.toLowerCase()) {
                case "carro":
                    if (vehiculo instanceof Carro) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                case "moto":
                    if (vehiculo instanceof Moto) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                case "camion":
                    if (vehiculo instanceof Camion) {
                        vehiculosFiltrados.add(vehiculo);
                    }
                    break;
                default:
                    System.out.println(" Tipo de vehículo no reconocido: " + tipo);
                    break;
            }
        }

        return vehiculosFiltrados;
    }
}




