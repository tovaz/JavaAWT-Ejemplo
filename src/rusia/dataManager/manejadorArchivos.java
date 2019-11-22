/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.dataManager;

import java.io.BufferedWriter;
import java.io.*;

/**
 *
 * @author user
 */
public class manejadorArchivos {
    
 public void crear(String nombre){   
     File archivo= new File(nombre);
     try{
        if(!archivo.exists()){
            System.out.println("Archivo creado");
            archivo.createNewFile();
        }
     
     }catch(IOException e){
     }    
 }
 
 public void escribir(String nombreArchivo, String datos, boolean primeraLinea){
     File archivo= new File(nombreArchivo);
     BufferedWriter bw;
     
     try{
     if(archivo.exists()){
        System.out.println("Escribiendo: "+datos);
        if (primeraLinea)
            bw = new BufferedWriter(new FileWriter(archivo));
        else
            bw = new BufferedWriter(new FileWriter(archivo, true));
        
        bw.write(datos);
        bw.newLine();
        bw.close();
     }
     
     }catch(IOException e){
     }
     
     
 
 }
 
 public String leer(String archivo){
     String cadena="";
     String cadena2="";
     try {
        FileReader f= new FileReader(archivo);
        BufferedReader b=new BufferedReader (f);
        
        
        while((cadena=b.readLine())!= null){
            cadena2 +=cadena+"\n";
        }      
        //System.out.println("Lectura: " + cadena2);
        b.close();
     } catch (IOException e) {}
     return cadena2;
     }
}
