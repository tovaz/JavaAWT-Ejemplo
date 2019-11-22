/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.Nucleo;

/**
 *
 * 
 */
public class claseRetorno {
    public enum codigos {Error, Faltan_datos, Exitoso, Ya_existe}
    
    public String mensaje;
    public Object datos;
    public claseRetorno.codigos codigo;
    public claseRetorno(String msj, claseRetorno.codigos cod, Object dato)
    {
        mensaje = msj;
        codigo = cod;
        datos = dato;
    }
}


