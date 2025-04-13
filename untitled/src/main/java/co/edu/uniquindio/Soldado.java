package co.edu.uniquindio;

public class Soldado {

        private String identificador;
        private String nombre;
        private Rango rango;
        private Especializacion especializacion;
        private int edad;
        private EstadoSoldado estadoSoldado;
        private Mision theMision;


        public Soldado(String identificador, String nombre, Rango rango, Especializacion especializacion, int edad,
                       EstadoSoldado estadoSoldado, Mision theMision) {
            this.identificador = identificador;
            this.nombre = nombre;
            this.rango = rango;
            this.especializacion = especializacion;
            this.edad = edad;
            this.estadoSoldado = estadoSoldado;
            this.theMision = theMision;
        }


        public String getIdentificador() {
            return identificador;
        }


        public void setIdentificador(String identificador) {
            this.identificador = identificador;
        }


        public String getNombre() {
            return nombre;
        }


        public void setNombre(String nombre) {
            this.nombre = nombre;
        }


        public Rango getRango() {
            return rango;
        }


        public void setRango(Rango rango) {
            this.rango = rango;
        }


        public Especializacion getEspecializacion() {
            return especializacion;
        }


        public void setEspecializacion(Especializacion especializacion) {
            this.especializacion = especializacion;
        }


        public int getEdad() {
            return edad;
        }


        public void setEdad(int edad) {
            this.edad = edad;
        }


        public EstadoSoldado getEstadoSoldado() {
            return estadoSoldado;
        }


        public void setEstadoSoldado(EstadoSoldado estadoSoldado) {
            this.estadoSoldado = estadoSoldado;
        }


        public Mision getTheMision() {
            return theMision;
        }


        public void setTheMision(Mision theMision) {
            this.theMision = theMision;
        }



}
