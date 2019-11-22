/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.Entidades;

/**
 *
 * @author user
 */
public class partido {
    
    private String id;
    private String clasificacion;
    private String jornda;
    private String grupo;
    private String faseGrupo;
    private String equipo1;
    private String equipo2;
    private int marEqui1;
    private int marEqui2;
    private String fecha;
    private String hora;
    private String ciudad;
    private String estadio;
    private boolean finalizado;
    public String pronostico = "";
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getJornda() {
        return jornda;
    }

    public void setJornda(String jornda) {
        this.jornda = jornda;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFaseGrupo() {
        return faseGrupo;
    }

    public void setFaseGrupo(String faseGrupo) {
        this.faseGrupo = faseGrupo;
    }

    public String getEquipo1() {
        return equipo1;
    }

    public void setEquipo1(String equipo1) {
        this.equipo1 = equipo1;
    }

    public String getEquipo2() {
        return equipo2;
    }

    public void setEquipo2(String equipo2) {
        this.equipo2 = equipo2;
    }

    public int getMarEqui1() {
        return marEqui1;
    }

    public void setMarEqui1(int marEqui1) {
        this.marEqui1 = marEqui1;
    }

    public int getMarEqui2() {
        return marEqui2;
    }

    public void setMarEqui2(int marEqui2) {
        this.marEqui2 = marEqui2;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public boolean isFinalizado() {
        return finalizado;
    }

    public void setFinalizado(boolean finalizado) {
        this.finalizado = finalizado;
    }
    
    @Override
    public String toString(){
    String cadena;
    String separador="\u05D0";
    cadena = id+separador+clasificacion+separador+jornda+separador+grupo+separador+faseGrupo+separador+equipo1+separador+equipo2+separador+marEqui1+separador+marEqui2+separador+fecha+separador+hora+separador+ciudad+separador+estadio+separador+finalizado;
    return cadena;
    }
}
