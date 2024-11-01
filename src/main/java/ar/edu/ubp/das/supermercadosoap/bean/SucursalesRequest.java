package ar.edu.ubp.das.supermercadosoap.bean;

public class SucursalesRequest {
    private int nroSucursal;
    private String calle;
    private int nroCalle;
    private String telefonos;
    private String coordLatitud;
    private String coordLongitud;
    private boolean habilitada;
    private String nomLocalidad;
    private String nomProvincia;
    private String horarios;
    private String tipos_servicios;

    public int getNroSucursal() {
        return nroSucursal;
    }

    public void setNroSucursal(int nroSucursal) {
        this.nroSucursal = nroSucursal;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNroCalle() {
        return nroCalle;
    }

    public void setNroCalle(int nroCalle) {
        this.nroCalle = nroCalle;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getCoordLatitud() {
        return coordLatitud;
    }

    public void setCoordLatitud(String coordLatitud) {
        this.coordLatitud = coordLatitud;
    }

    public String getCoordLongitud() {
        return coordLongitud;
    }

    public void setCoordLongitud(String coordLongitud) {
        this.coordLongitud = coordLongitud;
    }

    public boolean isHabilitada() {
        return habilitada;
    }

    public void setHabilitada(boolean habilitada) {
        this.habilitada = habilitada;
    }

    public String getNomLocalidad() {
        return nomLocalidad;
    }

    public void setNomLocalidad(String nomLocalidad) {
        this.nomLocalidad = nomLocalidad;
    }

    public String getNomProvincia() {
        return nomProvincia;
    }

    public void setNomProvincia(String nomProvincia) {
        this.nomProvincia = nomProvincia;
    }

    public String getHorarios() {
        return horarios;
    }

    public void setHorarios(String horarios) {
        this.horarios = horarios;
    }

    public String getTipos_servicios() {
        return tipos_servicios;
    }

    public void setTipos_servicios(String tipos_servicios) {
        this.tipos_servicios = tipos_servicios;
    }
}
