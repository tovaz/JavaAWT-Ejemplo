
package rusia;

import rusia.Entidades.Usuario;
import rusia.dataManager.manejadorUsuario;
import rusia.Nucleo.claseRetorno;
import javax.swing.DefaultListModel;
import rusia.Entidades.partido;
import rusia.dataManager.manejadorPartidos;



public class Rusia {

    public static void main(String[] args) {
        manejadorPartidos mp = new manejadorPartidos();
        claseRetorno rx = mp.cargarXml("xml.txt");
        System.out.println(rx.mensaje);
        
        DefaultListModel<partido> partidos = mp.obtenerRegistros();
        //for (int i=0; i<partidos.size()-1; i++)
        //    System.out.println("Partido: " + partidos.elementAt(i).getEquipo1() + " vs " + partidos.elementAt(i).getEquipo2());
    }
    
   
    private static void testUsuarios()
    {
        manejadorUsuario Musuarios=new manejadorUsuario();
        
        Usuario usuario = new Usuario();
        usuario.setId("2a162c7b-2ec8-4419-8b38-20fa310d7975");
        usuario.setNombre("Walter");
        usuario.setApellido("Canu");
        usuario.setNickname("knu");
        usuario.setCorreo("walterkanu@gmail.com");
        usuario.setPassword("123");
        usuario.setEliminado(false);
        usuario.setRol("admin");

        claseRetorno rn = Musuarios.checkLogin("tovaz", "123");
        
        System.out.println(rn.mensaje);

        DefaultListModel<Usuario> Usuarios = Musuarios.obtenerUsuarios();
        for (int i=0; i<=Usuarios.size()-1; i++)
            System.out.println(Usuarios.elementAt(i).getNombre());
    }
    
}
