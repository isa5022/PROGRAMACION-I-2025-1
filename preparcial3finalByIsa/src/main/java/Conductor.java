import java.util.ArrayList;
import java.util.List;

public class Conductor extends Persona {
    private List<Vehiculo> VehiculosAsignados;

    public Conductor(String nombre, String apellidos, String id, String fechaNacimiento) {
        super(nombre, apellidos, id, fechaNacimiento);
        VehiculosAsignados = new ArrayList<Vehiculo>();
    }

    public List<Vehiculo> getVehiculosAsignados() {
        return VehiculosAsignados;
    }

    public void setVehiculosAsignados(List<Vehiculo> vehiculosAsignados) {
        VehiculosAsignados = vehiculosAsignados;
    }
    public void asignarVehiculo(Vehiculo vehiculo) {
        VehiculosAsignados.add(vehiculo);
    }

    @Override
    public String toString() {
        return "Conductor{" +
                "VehiculosAsignados=" + VehiculosAsignados +
                '}';

    }
    public int calcularCostoPeaje() {
        int costoTotal = 0;

        for (Vehiculo vehiculo : VehiculosAsignados) {
            int costo = (int) vehiculo.calcularCostoPeaje();
            costoTotal += costo;
        }

        return costoTotal;
    }
    public ArrayList<Vehiculo> obtenerVehiculosPorTipo(String tipo) {
        ArrayList<Vehiculo> vehiculosFiltrados = new ArrayList<>();

        for (Vehiculo vehiculo : VehiculosAsignados) {
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
