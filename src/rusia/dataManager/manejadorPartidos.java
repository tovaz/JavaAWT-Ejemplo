/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.dataManager;

import javax.swing.DefaultListModel;

import rusia.Entidades.partido;
import rusia.Nucleo.Util;
import rusia.Nucleo.claseRetorno;


import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.xml.sax.SAXException;
import rusia.Entidades.Pronostico;
import rusia.Entidades.Usuario;
/**
 *
 * @author user
 */
public class manejadorPartidos extends manejadorArchivos {
    
    public DefaultListModel<partido> partidos;
    private static final String  nombreArchivo="Partidos.txt";
    
    public manejadorPartidos() { // contructor
        
     crear(nombreArchivo);   
     partidos=new DefaultListModel();
     obtenerRegistros();
    }
    public DefaultTableModel obtenerJTable(){
        DefaultTableModel returnRegistros = new DefaultTableModel(0, 0) {
            public boolean isCellEditable(int row, int column) { // Desactivar edicion de las celdas.
                return false;
            }; 
        };
        //cadena = id+separador + clasificacion + separador + jornda + separador + grupo+separador + faseGrupo + separador + equipo1 + separador + equipo2+ s 
        //separador + marEqui1 + separador + marEqui2 + separador + fecha + separador + hora + separador + ciudad + separador + estadio + separador + finalizado;
        returnRegistros.addColumn("Id");
        returnRegistros.addColumn("Clasificacion");
        returnRegistros.addColumn("Jornada");
        returnRegistros.addColumn("Grupo");
        //returnRegistros.addColumn("FaseGrupo");
        returnRegistros.addColumn("Equipo 1");
        returnRegistros.addColumn("Equipo 2");
        returnRegistros.addColumn("Marcador E1");
        returnRegistros.addColumn("Marcador E2");
        returnRegistros.addColumn("Fecha");
        returnRegistros.addColumn("Hora");
        returnRegistros.addColumn("Ciudad");
        returnRegistros.addColumn("Estadio");
        returnRegistros.addColumn("Ya finalizado");
        
        String[] fila = new String[13];
        
        partidos = this.obtenerRegistros();
        for (int i=0; i<partidos.getSize(); i++)
        {
            fila[0] = partidos.getElementAt(i).getId();
            fila[1] = partidos.getElementAt(i).getClasificacion();
            fila[2] = partidos.getElementAt(i).getJornda();
            fila[3] = partidos.getElementAt(i).getGrupo();
            //fila[4] = partidos.getElementAt(i).getFaseGrupo();
            fila[4] = partidos.getElementAt(i).getEquipo1();
            fila[5] = partidos.getElementAt(i).getEquipo2();
            fila[6] = String.valueOf( partidos.getElementAt(i).getMarEqui1() );
            fila[7] = String.valueOf( partidos.getElementAt(i).getMarEqui2() );
            fila[8] = partidos.getElementAt(i).getFecha();
            fila[9] = partidos.getElementAt(i).getHora();
            fila[10] = partidos.getElementAt(i).getCiudad();
            fila[11] = partidos.getElementAt(i).getEstadio();
            fila[12] = String.valueOf(partidos.getElementAt(i).isFinalizado());
            returnRegistros.addRow(fila);
        }
        return returnRegistros;
    }
    
    public DefaultListModel<partido> obtenerRegistros(){ //funcion o metodo
        DefaultListModel<partido> returnRegistros = new DefaultListModel();
        String lectura = leer(nombreArchivo);
        
        String[] alectura = lectura.split("\n");
        if (lectura != "") {
            for (String rx : alectura){
                String[] splitUsr = rx.split("\u05D0");
                partido _partido = new partido();
                 
                
            //cadena = id+ +clasificacion+ +jornda+ +grupo+ +faseGrupo+ +equipo1+ +equipo2+ +marEqui1+ +marEqui2+ +fecha+ +hora+ +ciudad+separador+estadio+separador+finalizado;
                _partido.setId(splitUsr[0]); //Fix con string como id
                _partido.setClasificacion(splitUsr[1]);
                _partido.setJornda(splitUsr[2]);
                _partido.setGrupo(splitUsr[3]);
                _partido.setFaseGrupo(splitUsr[4]);
                _partido.setEquipo1(splitUsr[5]);
                _partido.setEquipo2(splitUsr[6]);
                _partido.setMarEqui1(Integer.parseInt(splitUsr[7]));
                _partido.setMarEqui2(Integer.parseInt(splitUsr[8]));
                _partido.setFecha(splitUsr[9]);
                _partido.setHora(splitUsr[10]);
                _partido.setCiudad(splitUsr[11]);
                _partido.setEstadio(splitUsr[12]);
                _partido.setFinalizado(Boolean.parseBoolean(splitUsr[13]));
                returnRegistros.addElement(_partido);
            }
        }
        return partidos=returnRegistros;
        
    }
   
    //******************************************************************************************
    //********************************* FINALIZAR PARTIDO *************************************
    //******************************************************************************************
    public void FinalizarPartido(partido _partido, int mEquipo1, int mEquipo2){
        manejadorPronosticos mPronosticos = new manejadorPronosticos();
        ArrayList<Pronostico> Lpronosticos = (ArrayList<Pronostico>)mPronosticos.buscarPorPartido(_partido.getId()).datos;
        manejadorUsuario mUsuarios = new manejadorUsuario();
        
        for (Pronostico pr : Lpronosticos){
            int punteo = 0;
            if (pr.getMarEquipo1() == mEquipo1) punteo += 1;
            if (pr.getMarEquipo2() == mEquipo2) punteo += 1;
            
            if (( pr.getMarEquipo1() > pr.getMarEquipo2() && mEquipo1 > mEquipo2) || ( pr.getMarEquipo1() < pr.getMarEquipo2() && mEquipo1 < mEquipo2 ) )
                punteo += 3;            
            
            
            
            //Editamos el pronostico con su puntuacion
            pr.setPuntuacion(punteo); // Asignamos el punteo al pronostico
            mPronosticos.editarRegistro(pr); //Guardamos el pronostico con el punteo
            
            //Asignamos el punteo al usuario
            Usuario usr = (Usuario) mUsuarios.buscarPorID(pr.getUsuario()).datos; // Seleccionamos el usuario que pronostico
            usr.setPuntuacion(usr.getPuntuacion() + punteo); // Sumamos la puntuacion con el punteo obtenido
            mUsuarios.editarUsuario(usr); // Guardamos el usuario con su nueva puntuacion
        }
        
        //Finalizamos el partido
        _partido.setFinalizado(true);
        _partido.setMarEqui1(mEquipo1);
        _partido.setMarEqui2(mEquipo2);
        editarRegistro(_partido);
        
    }
            
     //Verifica si existe el usuario y actualiza el archivo de registros
    public claseRetorno agregarRegistro(partido rx)
    {
        
        rx.setId(Util.crearUUID());
        partidos.addElement(rx);
        actualizarRegistros();
        return new claseRetorno("Registro Agregado Exitosamente.", claseRetorno.codigos.Exitoso, rx);
    }
    
    //Sirve para escribir nuevamente los usuarios en el archivo.
    private void actualizarRegistros()
    {
        for (int i=0; i<=partidos.size()-1; i++)
            if (i==0)
                this.escribir(nombreArchivo, partidos.getElementAt(i).toString(),true);
            else
                this.escribir(nombreArchivo, partidos.getElementAt(i).toString(),false);
    }
    
    public claseRetorno editarRegistro(partido rx)
    {
        claseRetorno buscarRegistro = this.buscarPorID(rx.getId());
        if (buscarRegistro.codigo == claseRetorno.codigos.Exitoso)
        {
            partidos.setElementAt(rx, Integer.parseInt(buscarRegistro.mensaje)); //Reemplazamos el registro de esa posicion por el nuevo
            actualizarRegistros(); //Hacemos la modificacion en el archivo
            return new claseRetorno("Registro Editado Exitosamente.", claseRetorno.codigos.Exitoso, rx);
        }
        
        return new claseRetorno("Error registro no encontrado, no modificado.", claseRetorno.codigos.Error, rx);
    }
    
    public claseRetorno buscarPorID(String id)
    {
        for (int i=0; i<=partidos.size()-1; i++)
            if (partidos.getElementAt(i).getId().equals(id)) //buscamos el registro por el ID.
                return new claseRetorno (Integer.toString(i), claseRetorno.codigos.Exitoso, (partido)partidos.getElementAt(i));
        return new claseRetorno ("Error registro no encontrado", claseRetorno.codigos.Error, null); // Si no encuentra ningun registro devuelve null.
    }
    
    
    public claseRetorno cargarXml(String ruta){
        if (partidos.size() > 0) return new claseRetorno("Error, ya existen datos...", claseRetorno.codigos.Error, null);
        partidos = new DefaultListModel(); //Elimina posibles registros existentes.
        
          try{
            File fXmlFile = new File(ruta);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);

            doc.getDocumentElement().normalize();

            NodeList padre = doc.getElementsByTagName("Partido");    
            for (int i = 0; i < padre.getLength(); i++) {
                String raiz = padre.item(i).getParentNode().getParentNode().getParentNode().getNodeName();
                // Atributos del Partido
                String _clasificacion = "";
                String _grupo = "";
                String _jornada = "";
                String _equipo1="";
                String _equipo2="";
                String _fecha="";
                String _hora="";
                String _ciudad="";
                String _estadio="";

                Element _npartido = (Element)padre.item(i);
                if (raiz.equals("FaseGrupos"))
                {   
                    _clasificacion = "FaseGrupos";
                    _grupo = padre.item(i).getParentNode().getParentNode().getNodeName();
                    _jornada = padre.item(i).getParentNode().getNodeName();
                }
                else if (raiz.equals("#document")) // Partidos de clasificaciones
                {
                    _clasificacion = padre.item(i).getParentNode().getNodeName();
                }

                _equipo1 = _npartido.getElementsByTagName("Equipo1").item(0).getTextContent();
                _equipo2 = _npartido.getElementsByTagName("Equipo2").item(0).getTextContent();
                _fecha = _npartido.getElementsByTagName("Fecha").item(0).getTextContent();
                _hora = _npartido.getElementsByTagName("Hora").item(0).getTextContent();
                _ciudad = _npartido.getElementsByTagName("Ciudad").item(0).getTextContent();
                _estadio = _npartido.getElementsByTagName("Estadio").item(0).getTextContent();

                //Agregar Partido
                partido _partido = new partido();
                _partido.setClasificacion(_clasificacion);
                _partido.setJornda(_jornada);
                _partido.setGrupo(_grupo);
                _partido.setFaseGrupo("");
                _partido.setEquipo1(_equipo1);
                _partido.setEquipo2(_equipo2);
                _partido.setMarEqui1(0);
                _partido.setMarEqui2(0);
                _partido.setFecha(_fecha);
                _partido.setHora(_hora);
                _partido.setCiudad(_ciudad);
                _partido.setEstadio(_estadio);
                _partido.setFinalizado(false);

                this.agregarRegistro(_partido);
            }
        } 
        catch (IOException | ParserConfigurationException | DOMException | SAXException e) { 
            return new claseRetorno("Error: " + e.getMessage(), claseRetorno.codigos.Error, null);
        }
        
        return new claseRetorno("Informacion cargada con exito.", claseRetorno.codigos.Exitoso, partidos);
    }
    
    
    
}



    

