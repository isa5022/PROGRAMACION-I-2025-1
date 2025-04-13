package co.edu.uniquindio;

 import java.time.LocalDate;
 import java.util.LinkedList;

    public class Batallon {

        private String id;
        private String nombre;
        private LinkedList<Mision> listMisiones;
        private LinkedList<VehiculoTransporte> listVehiculosTransporte;
        private LinkedList<VehiculoBlindado> listVehiculosBlindados;
        private LinkedList<VehiculoApoyo> listVehiculosApoyo;
        private LinkedList<Vehiculo> listVehiculos;
        private LinkedList<Soldado> listSoldados;



        // Constructor
        public Batallon(String id, String nombre) {
            this.id = id;
            this.nombre = nombre;
            listMisiones = new LinkedList<>();
            listVehiculosApoyo = new LinkedList<>();
            listVehiculosBlindados = new LinkedList<>();
            listVehiculosTransporte = new LinkedList<>();
            listVehiculos = new LinkedList<>();
            listSoldados = new LinkedList<>();

        }

        public LinkedList<Vehiculo> getListVehiculos() {
            return listVehiculos;
        }

        public LinkedList<Soldado> getListSoldados() {
            return listSoldados;
        }

        public void setListSoldados(LinkedList<Soldado> listSoldados) {
            this.listSoldados = listSoldados;
        }

        public double kilometrajePromedioTransporte() {
            double sumaTransporte = 0;
            double promedioTropas = 0;
            for (Vehiculo vehiculoTransporte : listVehiculosTransporte) {
                sumaTransporte = vehiculoTransporte.getKilometraje() + sumaTransporte;
            }
            promedioTropas = sumaTransporte / listVehiculosTransporte.size();
            return promedioTropas;
        }

        public double kilometrajePromedioBlindado() {
            double sumaBlindados = 0;
            double promedioBlindados = 0;
            for (Vehiculo vehiculoBlindado : listVehiculosBlindados) {
                sumaBlindados = vehiculoBlindado.getKilometraje() + sumaBlindados;
            }
            sumaBlindados = sumaBlindados / listVehiculosBlindados.size();
            return promedioBlindados;
        }

        public double kilometrajePromedioApoyo() {
            double sumaApoyo = 0;
            double promedioApoyo = 0;
            for (Vehiculo vehiculoApoyo : listVehiculosApoyo) {
                sumaApoyo = vehiculoApoyo.getKilometraje() + sumaApoyo;
            }
            promedioApoyo = sumaApoyo / listVehiculosApoyo.size();
            return promedioApoyo;
        }

        // Metodo para obtener el vehiculo con mas misiones completadas
        public Vehiculo vehiculoMayorCantMisiones() {
            Vehiculo vehiculoMasMisiones = null;
            int cantMaxMisiones = 0;
            for (Vehiculo vehiculo : listVehiculos) {
                if (vehiculo.getMisionesCompletadas() > cantMaxMisiones) {
                    cantMaxMisiones = vehiculo.getMisionesCompletadas();
                    vehiculoMasMisiones = vehiculo;
                }
            }

            return vehiculoMasMisiones;
        }

        // Metodo para obtener los vehiculos con mas de 50 misiones completadas
        public LinkedList<Vehiculo> obtenerVehiculosCantMisiones() {
            LinkedList<Vehiculo> vehiculosMisionesCompletadas = new LinkedList<>();

            for (VehiculoApoyo vehiculo : listVehiculosApoyo) {
                if (vehiculo.getMisionesCompletadas() > 50) {
                    vehiculosMisionesCompletadas.add(vehiculo);
                }
            }

            for (VehiculoBlindado vehiculo : listVehiculosBlindados) {
                if (vehiculo.getMisionesCompletadas() > 50) {
                    vehiculosMisionesCompletadas.add(vehiculo);
                }
            }

            for (VehiculoTransporte vehiculo : listVehiculosTransporte) {
                if (vehiculo.getMisionesCompletadas() > 50) {
                    vehiculosMisionesCompletadas.add(vehiculo);
                }
            }

            return vehiculosMisionesCompletadas;
        }

        // Metodo para registrar las misiones de cada vehiculo
        public boolean registrarMision(LocalDate fechaMision, String ubicacionMision, LinkedList<String> listPersonal,
                                       String idVehiculoMision) {

            boolean flag = false;

            String cantMisionesActuales = String.valueOf(listMisiones.size() + 1);
            Mision newMision = new Mision(cantMisionesActuales, fechaMision, ubicacionMision);
            for (Vehiculo vehiculo : listVehiculos) {
                if (vehiculo.getId().equals(idVehiculoMision)) {
                    newMision.setTheVehiculo(vehiculo);

                    LinkedList<Mision> listTempo = vehiculo.getListMisiones();
                    listTempo.add(newMision);

                    vehiculo.setListMisiones(listTempo);
                    flag = true;
                    break;
                }
            }

            return flag;

        }

        //CRUD para vehiculo
        public boolean crearVehiculo(Vehiculo newVehiculo) {
            for (Vehiculo newvehiculo : listVehiculos) {
                if (verificarVehiculo(newvehiculo.getId())) {
                    listVehiculos.add(newvehiculo);
                    return true;
                }
            }
            return false;
        }

        public boolean verificarVehiculo(String idVerificar) {
            for (Vehiculo vehiculo : listVehiculos) {
                if (vehiculo.getId().equals(idVerificar)) {
                    return false;
                }
            }
            return true;
        }

        //CRUD para vehiculo de apoyo
        public boolean crearVehiculoApoyo(VehiculoApoyo newVehiculoApoyo) {
            for (VehiculoApoyo newvehiculoApoyo : listVehiculosApoyo) {
                if (verificarVehiculo(newvehiculoApoyo.getId())) {
                    listVehiculos.add(newvehiculoApoyo);
                    return true;
                }
            }
            return false;
        }

        //CRUD para vehiculo de Transporte
        public boolean crearVehiculoTransporte(VehiculoTransporte newVehiculoTransporte) {
            for (VehiculoTransporte newvehiculoTransporte : listVehiculosTransporte) {
                if (verificarVehiculo(newvehiculoTransporte.getId())) {
                    listVehiculos.add(newvehiculoTransporte);
                    return true;
                }
            }
            return false;
        }

        //CRUD para vehiculo blindado
        public boolean crearVehiculoBlindado(VehiculoBlindado newVehiculoBlindado) {
            for (VehiculoBlindado newvehiculoBlindado : listVehiculosBlindados) {
                if (verificarVehiculo(newvehiculoBlindado.getId())) {
                    listVehiculos.add(newvehiculoBlindado);
                    return true;
                }
            }
            return false;
        }


        //CRUD para mision
        public boolean registrarMision() {
            for (Mision newMision : listMisiones) {
                if (verificarId(newMision.getId())) {
                    listMisiones.add(newMision);
                    return true;
                }
            }
            return false;
        }

        public boolean verificarId(String idVerificar) {
            for (Mision mision : listMisiones) {
                if (mision.getId().equals(idVerificar)) {
                    return false;
                }
            }
            return true;
        }

        // Getters y setters
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public LinkedList<Mision> getListMisiones() {
            return listMisiones;
        }

        public void setListMisiones(LinkedList<Mision> listMisiones) {
            this.listMisiones = listMisiones;
        }

        public LinkedList<VehiculoTransporte> getListVehiculosTransporte() {
            return listVehiculosTransporte;
        }

        public void setListVehiculosTransporte(LinkedList<VehiculoTransporte> listVehiculosTransporte) {
            this.listVehiculosTransporte = listVehiculosTransporte;
        }

        public LinkedList<VehiculoBlindado> getListVehiculosBlindados() {
            return listVehiculosBlindados;
        }

        public void setListVehiculosBlindados(LinkedList<VehiculoBlindado> listVehiculosBlindados) {
            this.listVehiculosBlindados = listVehiculosBlindados;
        }

        public LinkedList<VehiculoApoyo> getListVehiculosApoyo() {
            return listVehiculosApoyo;
        }

        public void setListVehiculosApoyo(LinkedList<VehiculoApoyo> listVehiculosApoyo) {
            this.listVehiculosApoyo = listVehiculosApoyo;
        }

        public LinkedList<Vehiculo> getlistVehiculos() {
            return listVehiculos;
        }

        public void setListVehiculos(LinkedList<Vehiculo> listVehiculos) {
            this.listVehiculos = listVehiculos;
        }

        // Asigna Mision al Soldado
        public boolean asignarSoldadoMision (String identificadorSoldado, String idMision){
            boolean asignar = false;
            Mision newMision = null;
            Soldado newSoldado1 = null;

            for(Mision newMision1 : listMisiones){
                if(newMision1.getId().equals(idMision)){
                    newMision = newMision1;
                    break;
                }
            }

            for (Soldado newSoldado : listSoldados){
                if(newSoldado.getIdentificador().equals(identificadorSoldado)&&newSoldado.getEstadoSoldado().equals(EstadoSoldado.DISPONIBLE)){
                    newSoldado1= newSoldado;
                }
            }if(newMision!=null&&newSoldado1!=null){
                newMision.getPersonal().add(newSoldado1);
                newSoldado1.setEstadoSoldado(EstadoSoldado.NO_DISPONIBLE);
                asignar = true;
            }
            return asignar;

        }

        public boolean liberarSoldados(LinkedList<Soldado> listPersonal, LocalDate fechaMision) {
            LocalDate fechaActual = LocalDate.now();
            boolean soldadosLiberados = false;

            if (fechaMision.isBefore(fechaActual)) {
                for (Soldado soldado : listPersonal) {
                    soldado.setEstadoSoldado(EstadoSoldado.DISPONIBLE);
                    soldadosLiberados = true;
                }
            }

            return soldadosLiberados;
        }

        // Buscar soldado por especializacion
        public LinkedList<Soldado> buscarSoldadoEspecialidad(Especializacion especializacionBuscar) {
            LinkedList<Soldado> listSoldadosEspecialidad = new LinkedList<>();
            for (Soldado soldado : listSoldados) {
                if (soldado.getEspecializacion().equals(especializacionBuscar)) {
                    listSoldadosEspecialidad.add(soldado);
                }
            }
            return listSoldadosEspecialidad;
        }

        //Obtener soldados disponibles por rango
        public LinkedList<Soldado> soldadosDisponiblesRango(Rango indexRango) {
            LinkedList<Soldado> listSoldadosRango = new LinkedList<>();
            for (Soldado soldado : listSoldados) {
                if (soldado.getRango().equals(indexRango)) {
                    listSoldadosRango.add(soldado);
                }
            }
            return listSoldadosRango;
        }

        public double calcularEdadPromedio(){
            double sumaEdades = 0;
            double promedioEdades = 0;
            for(Soldado newSoldado : listSoldados){
                sumaEdades += newSoldado.getEdad();
            }

            promedioEdades = sumaEdades/listSoldados.size();
            return promedioEdades;
        }



        //Buscar soldado por id
        public Soldado buscarIdSoldado(String idBuscar) {
            for (Soldado soldado : listSoldados) {
                if (soldado.getIdentificador().equals(idBuscar)) {
                    return soldado;
                }
            }
            return null;
        }










    }


