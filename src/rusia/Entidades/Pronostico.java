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
public class Pronostico {
    private String id;
    private String usuario;
    private String partido;
    private int marEquipo1;
    private int marEquipo2;
    private boolean eliminado;
    private int puntuacion;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getMarEquipo1() {
        return marEquipo1;
    }

    public void setMarEquipo1(int marEquipo1) {
        this.marEquipo1 = marEquipo1;
    }

    public int getMarEquipo2() {
        return marEquipo2;
    }

    public void setMarEquipo2(int marEquipo2) {
        this.marEquipo2 = marEquipo2;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public boolean getEliminado() {
        return eliminado;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
     @Override
    public String toString(){
    String cadena;
    String separador="\u05D0";
    cadena=id+separador+usuario+separador+partido+separador+Integer.toString(marEquipo1)+separador+Integer.toString(marEquipo2)+separador+Boolean.toString(eliminado)+separador+Integer.toString(puntuacion);
    return cadena;
    
}
}