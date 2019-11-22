/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rusia.dataManager;

import java.util.ArrayList;
import rusia.Nucleo.claseRetorno;
import rusia.Nucleo.Util;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;
import rusia.Entidades.Pronostico;
import rusia.Entidades.Usuario;

/**
 *
 * @author user
 */
public class manejadorUsuario extends manejadorArchivos{
    public DefaultListModel<Usuario> usuarios;
    public manejadorUsuario() {
     crear("usuarios.txt");   
     usuarios=new DefaultListModel();
     obtenerUsuarios();
    }
    
    public DefaultTableModel obtenerJTable(){
        DefaultTableModel returnUsuarios = new DefaultTableModel(0, 0) {
            public boolean isCellEditable(int row, int column) { // Desactivar edicion de las celdas.
                return false;
            }; 
        };

        returnUsuarios.addColumn("Id");
        returnUsuarios.addColumn("Nombre");
        returnUsuarios.addColumn("Apellido");
        returnUsuarios.addColumn("Nickname");
        returnUsuarios.addColumn("Correo");
        returnUsuarios.addColumn("Password");
        returnUsuarios.addColumn("Privilegios");
        returnUsuarios.addColumn("Puntuacion");
        
        String[] fila = new String[8];
        
        usuarios = this.obtenerUsuarios();
        for (int i=0; i<usuarios.getSize(); i++)
        {
            fila[0] = usuarios.getElementAt(i).getId();
            fila[1] = usuarios.getElementAt(i).getNombre();
            fila[2] = usuarios.getElementAt(i).getApellido();
            fila[3] = usuarios.getElementAt(i).getNickname();
            fila[4] = usuarios.getElementAt(i).getCorreo();
            fila[5] = usuarios.getElementAt(i).getPassword();
            fila[6] = usuarios.getElementAt(i).getRol();
            fila[7] = Integer.toString(usuarios.getElementAt(i).getPuntuacion());
            returnUsuarios.addRow(fila);
        }
        return returnUsuarios;
    }
    
    public DefaultTableModel obtenerJTablePuntuaciones(){
        manejadorPronosticos mPronosticos = new manejadorPronosticos();
        DefaultTableModel returnUsuarios = new DefaultTableModel(0, 0) {
            public boolean isCellEditable(int row, int column) { // Desactivar edicion de las celdas.
                return false;
            }; 
        };

        returnUsuarios.addColumn("Id");
        returnUsuarios.addColumn("Nickname");
        returnUsuarios.addColumn("Puntuacion");
        returnUsuarios.addColumn("P. Acertados");
        String[] fila = new String[8];
        
        usuarios = this.obtenerUsuarios();
        for (int i=0; i<usuarios.getSize(); i++)
        {
            fila[0] = usuarios.getElementAt(i).getId();
            fila[1] = usuarios.getElementAt(i).getNickname();
            fila[2] = String.valueOf( usuarios.getElementAt(i).getPuntuacion() );
            
            ArrayList<Pronostico> pronosticos = (ArrayList<Pronostico>)mPronosticos.buscarPorUsuario(usuarios.getElementAt(i).getId()).datos;
            int acertados = 0;
            for (Pronostico pr : pronosticos)
                if (pr.getPuntuacion() > 0) acertados ++;
            
            fila[3] = String.valueOf(acertados);
            returnUsuarios.addRow(fila);
        }
        return returnUsuarios;
    }
    
    public DefaultListModel<Usuario> obtenerUsuarios(){
        DefaultListModel<Usuario> returnUsuarios = new DefaultListModel();
        String cusuarios = leer("usuarios.txt");
        //System.out.println(cusuarios);
        String[] ausuarios = cusuarios.split("\n");
        // AGregar columnas al modelo de la tabla Usuarios
        
        if (cusuarios != "") {
            for (String usr : ausuarios){
                String[] splitUsr = usr.split("\u05D0");
                Usuario Nusuario = new Usuario();
                Nusuario.setId(splitUsr[0]); //Fix con string como id
                Nusuario.setNombre(splitUsr[1]);
                Nusuario.setApellido(splitUsr[2]);
                Nusuario.setNickname(splitUsr[3]);
                Nusuario.setCorreo(splitUsr[4]);
                Nusuario.password = splitUsr[5];
                if (splitUsr[6] == "false") Nusuario.setEliminado(false); else Nusuario.setEliminado(true);
                Nusuario.setRol(splitUsr[7]);
                Nusuario.setPuntuacion(Integer.parseInt(splitUsr[8]+""));
                returnUsuarios.addElement(Nusuario);
            }
        }
        usuarios=returnUsuarios;
        return returnUsuarios;
    }
    
    //Verifica si existe el usuario y actualiza el archivo de registros
    public claseRetorno agregarUsuario(Usuario usr)
    {
        for (int i=0; i<=usuarios.size()-1; i++)
        {
            if ( usr.getNickname().equals(usuarios.elementAt(i).getNickname()) )
                return new claseRetorno("Nickname ya existe", claseRetorno.codigos.Ya_existe, usr);
            if ( usr.getCorreo().equals(usuarios.elementAt(i).getCorreo()) )
                return new claseRetorno("Correo ya existe", claseRetorno.codigos.Ya_existe, usr);
        }
        
        usr.setId(Util.crearUUID());
        usuarios.addElement(usr);
        actualizarUsuarios();
        return new claseRetorno("Usuario Agregado Exitosamente.", claseRetorno.codigos.Exitoso, usr);
    }
    
    //Sirve para escribir nuevamente los usuarios en el archivo.
    private void actualizarUsuarios()
    {
        for (int i=0; i<=usuarios.size()-1; i++)
            if (i==0)
                this.escribir("usuarios.txt", usuarios.getElementAt(i).toString(),true);
            else
                this.escribir("usuarios.txt", usuarios.getElementAt(i).toString(),false);
    }
    
    public claseRetorno editarUsuario(Usuario usr)
    {
        claseRetorno buscarUsuario = this.buscarPorID(usr.getId());
        if (buscarUsuario.codigo == claseRetorno.codigos.Exitoso)
        {
            usuarios.setElementAt(usr, Integer.parseInt(buscarUsuario.mensaje)); //Reemplazamos el usuario de esa posicion por el nuevo
            actualizarUsuarios(); //Hacemos la modificacion en el archivo
            return new claseRetorno("Usuario Editado Exitosamente.", claseRetorno.codigos.Exitoso, usr);
        }
        
        return new claseRetorno("Error usuario no encontrado, no modificado.", claseRetorno.codigos.Error, usr);
    }
    
    public claseRetorno buscarPorID(String id)
    {
        for (int i=0; i<=usuarios.size()-1; i++)
            if (usuarios.getElementAt(i).getId().equals(id)) //buscamos el usuario por el ID.
                return new claseRetorno (Integer.toString(i), claseRetorno.codigos.Exitoso, usuarios.getElementAt(i));
        return new claseRetorno ("Error usuario no encontrado", claseRetorno.codigos.Error, null); // Si no encuentra ningun usuario devuelve null.
    }
    
    public claseRetorno buscarPorNickname(String nickname)
    {
        for (int i=0; i<=usuarios.size()-1; i++)
            if (usuarios.getElementAt(i).getNickname().equals(nickname)) //buscamos el usuario por el ID.
                return new claseRetorno (Integer.toString(i), claseRetorno.codigos.Exitoso, usuarios.getElementAt(i));
        return new claseRetorno ("Error usuario no encontrado", claseRetorno.codigos.Error, null); // Si no encuentra ningun usuario devuelve null.
    }
    
    public claseRetorno checkLogin(String nickname, String password)
    {
        claseRetorno buscarUsuario = buscarPorNickname(nickname);
        Usuario usr = (Usuario)buscarUsuario.datos;
        if (buscarUsuario.codigo == claseRetorno.codigos.Exitoso)
            if (usr.getPassword().equals(Util.getMD5(password)))
                return new claseRetorno("Nick name y Clave correcta.", claseRetorno.codigos.Exitoso, usr);
            else
                return new claseRetorno("Contraseña incorrecta, verifica y vuelve a intentar.", claseRetorno.codigos.Error, usr);
        else
            return new claseRetorno("Usuario no encontrado.", claseRetorno.codigos.Error, null);
    }
}
