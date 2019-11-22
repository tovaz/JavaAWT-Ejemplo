/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.dataManager;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import rusia.Entidades.Pronostico;
import rusia.Entidades.Usuario;
import rusia.Entidades.partido;
import rusia.Nucleo.Util;
import rusia.Nucleo.claseRetorno;

/**
 *
 * 
 */
public class manejadorPronosticos extends manejadorArchivos{
    
    public DefaultListModel<Pronostico> pronosticos;
    private static final String  nombreArchivo="Pronosticos.txt";
    private String usuarioId="";
    public manejadorPronosticos() { // contructor
     crear(nombreArchivo);   
     pronosticos=new DefaultListModel();
     obtenerRegistros();
    }
    
    public manejadorPronosticos(String _usuarioId) { // contructor
     crear(nombreArchivo);   
     pronosticos=new DefaultListModel();
     obtenerRegistros(usuarioId);
     usuarioId = _usuarioId;
    }
   
    public DefaultTableModel obtenerJTable(){
        manejadorPartidos mPartidos = new manejadorPartidos();
        manejadorUsuario mUsuarios = new manejadorUsuario();
        DefaultTableModel returnRegistros = new DefaultTableModel(0, 0) {
            public boolean isCellEditable(int row, int column) { // Desactivar edicion de las celdas.
                return false;
            }; 
        };
        
        returnRegistros.addColumn("Id");
        returnRegistros.addColumn("Usuario");
        returnRegistros.addColumn("Equipo 1");
        returnRegistros.addColumn("Equipo 2");
        returnRegistros.addColumn("Pronostico Eq 1");
        returnRegistros.addColumn("Pronostico Eq 2");
        returnRegistros.addColumn("Punteo obtenido");
        returnRegistros.addColumn("Eliminado");
        
        String[] fila = new String[8];
        if (usuarioId != "")
            pronosticos = this.obtenerRegistros(usuarioId);
        else
            pronosticos = this.obtenerRegistros();
        for (int i=0; i<pronosticos.getSize(); i++)
        {
            Usuario usr = (Usuario) mUsuarios.buscarPorID(pronosticos.getElementAt(i).getUsuario()).datos; //Obtenemos los datos del usuarios
            partido Partido = (partido) mPartidos.buscarPorID(pronosticos.getElementAt(i).getPartido()).datos; //Obtenemos los datos del partido
            
            fila[0] = pronosticos.getElementAt(i).getId();
            fila[1] = usr.getNickname();
            fila[2] = Partido.getEquipo1();
            fila[3] = Partido.getEquipo2();
            fila[4] = Integer.toString( pronosticos.getElementAt(i).getMarEquipo1() );
            fila[5] = Integer.toString( pronosticos.getElementAt(i).getMarEquipo2() );
            fila[6] = Integer.toString( pronosticos.getElementAt(i).getPuntuacion());
            fila[7] =  String.valueOf( pronosticos.getElementAt(i).getEliminado() ); 
            
            returnRegistros.addRow(fila);
        }
        return returnRegistros;
    }
    
    public DefaultListModel<Pronostico> obtenerRegistros(){ //funcion o metodo
        DefaultListModel<Pronostico> returnRegistros = new DefaultListModel();
        String lectura = leer(nombreArchivo);
        //System.out.println(cusuarios);
        String[] alectura = lectura.split("\n");
        if (lectura != "") {
            for (String rx : alectura){
                String[] splitUsr = rx.split("\u05D0");
                Pronostico pronostico = new Pronostico();
                pronostico.setId(splitUsr[0]); //Fix con string como id
                pronostico.setUsuario(splitUsr[1]);
                pronostico.setPartido(splitUsr[2]);
                pronostico.setMarEquipo1(Integer.parseInt(splitUsr[3]));
                pronostico.setMarEquipo2(Integer.parseInt(splitUsr[4]));
                pronostico.setEliminado(Boolean.parseBoolean(splitUsr[5]));
                pronostico.setPuntuacion(Integer.parseInt(splitUsr[6]));
                returnRegistros.addElement(pronostico);
            }
        }
        return pronosticos=returnRegistros;
        
    }
    
    public DefaultListModel<Pronostico> obtenerRegistros(String usuarioId){ //funcion o metodo
        DefaultListModel<Pronostico> returnRegistros = new DefaultListModel();
        String lectura = leer(nombreArchivo);
        //System.out.println(cusuarios);
        String[] alectura = lectura.split("\n");
        if (lectura != "") {
            for (String rx : alectura){
                String[] splitUsr = rx.split("\u05D0");
                if (splitUsr[1].equals(usuarioId)){
                    Pronostico pronostico = new Pronostico();
                    pronostico.setId(splitUsr[0]); //Fix con string como id
                    pronostico.setUsuario(splitUsr[1]);
                    pronostico.setPartido(splitUsr[2]);
                    pronostico.setMarEquipo1(Integer.parseInt(splitUsr[3]));
                    pronostico.setMarEquipo2(Integer.parseInt(splitUsr[4]));
                    pronostico.setEliminado(Boolean.parseBoolean(splitUsr[5]));
                    pronostico.setPuntuacion(Integer.parseInt(splitUsr[6]));
                    returnRegistros.addElement(pronostico);
                }
                
            }
        }
        return pronosticos=returnRegistros;
    }
   
     //Verifica si existe el usuario y actualiza el archivo de registros
    public claseRetorno agregarRegistro(Pronostico rx)
    {
        
        rx.setId(Util.crearUUID());
        pronosticos.addElement(rx);
        actualizarRegistros();
        return new claseRetorno("Registro Agregado Exitosamente.", claseRetorno.codigos.Exitoso, rx);
    }
    
    //Sirve para escribir nuevamente los usuarios en el archivo.
    private void actualizarRegistros()
    {
        for (int i=0; i<=pronosticos.size()-1; i++)
            if (i==0)
                this.escribir(nombreArchivo, pronosticos.getElementAt(i).toString(),true);
            else
                this.escribir(nombreArchivo, pronosticos.getElementAt(i).toString(),false);
    }
    
    public claseRetorno editarRegistro(Pronostico rx)
    {
        claseRetorno buscarRegistro = this.buscarPorID(rx.getId());
        if (buscarRegistro.codigo == claseRetorno.codigos.Exitoso)
        {
            pronosticos.setElementAt(rx, Integer.parseInt(buscarRegistro.mensaje)); //Reemplazamos el registro de esa posicion por el nuevo
            actualizarRegistros(); //Hacemos la modificacion en el archivo
            return new claseRetorno("Registro Editado Exitosamente.", claseRetorno.codigos.Exitoso, rx);
        }
        
        return new claseRetorno("Error registro no encontrado, no modificado.", claseRetorno.codigos.Error, rx);
    }
    
    public claseRetorno buscarPorID(String id)
    {
        for (int i=0; i<=pronosticos.size()-1; i++)
            if (pronosticos.getElementAt(i).getId().equals(id)) //buscamos el registro por el ID.
                return new claseRetorno (Integer.toString(i), claseRetorno.codigos.Exitoso, pronosticos.getElementAt(i));
        return new claseRetorno ("Error pronostico no encontrado", claseRetorno.codigos.Error, null); // Si no encuentra ningun registro devuelve null.
    }
    
    public claseRetorno buscarPorPartido(String idPartido)
    {
        ArrayList<Pronostico> Lpronosticos = new ArrayList<Pronostico>();
        for (int i=0; i<=pronosticos.size()-1; i++)
            if (pronosticos.getElementAt(i).getPartido().equals(idPartido) &&
                    !pronosticos.getElementAt(i).isEliminado()) //buscamos el registro por el ID del Partido
                Lpronosticos.add(pronosticos.getElementAt(i));
               
        return new claseRetorno ("Pronosticos encontrados", claseRetorno.codigos.Exitoso, Lpronosticos);
    }
    
    public claseRetorno buscarPorUsuario(String idUsuario)
    {
        ArrayList<Pronostico> Lpronosticos = new ArrayList<Pronostico>();
        for (int i=0; i<=pronosticos.size()-1; i++)
            if (pronosticos.getElementAt(i).getUsuario().equals(idUsuario) &&
                    !pronosticos.getElementAt(i).isEliminado()) //buscamos el registro por el ID del Partido
                Lpronosticos.add(pronosticos.getElementAt(i));
               
        return new claseRetorno ("Pronosticos encontrados", claseRetorno.codigos.Exitoso, Lpronosticos);
    }
    
    public boolean existePronostico(partido _partido, Usuario usuarioLogeado)
    {
        ArrayList<Pronostico> Lpronosticos = (ArrayList<Pronostico>)this.buscarPorUsuario(usuarioLogeado.getId()).datos; //VERIFICAMOS
        boolean bandera = false;
        for (Pronostico px : Lpronosticos){
            if (px.getPartido().equals(_partido.getId()))
                return true;
        }
        return false;
    }
    
}
    

