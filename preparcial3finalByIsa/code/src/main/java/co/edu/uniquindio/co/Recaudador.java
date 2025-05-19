package co.edu.uniquindio.co;

import java.time.LocalDate;

public class Recaudador extends Persona {
    private double sueldoMensual;

    public Recaudador(String nombre, String apellido, String id, LocalDate fechaNacimiento, double sueldoMensual) {
        super(nombre, apellido, id, fechaNacimiento);
        this.sueldoMensual = sueldoMensual;
    }

    public void setSueldoMensual(double sueldoMensual) {
        this.sueldoMensual = sueldoMensual;
    }

    public double getSueldoMensual() {
        return sueldoMensual;
    }

    @Override
    public String toString() {
        return "Recaudador{" +
                "sueldoMensual=" + sueldoMensual +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", id='" + id + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}


