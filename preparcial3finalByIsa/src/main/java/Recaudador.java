public class Recaudador extends Persona {
    private int salario;

    public Recaudador(String nombre, String apellidos, String id, String fechaNacimiento, int salario) {
        super(nombre, apellidos, id, fechaNacimiento);
        this.salario = salario;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return "Cobrador{" +
                "salario=" + salario +
                '}';
    }
}
