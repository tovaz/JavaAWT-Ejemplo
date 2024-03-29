/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Point;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import rusia.Entidades.Pronostico;
import rusia.Entidades.Usuario;
import rusia.Entidades.partido;
import rusia.dataManager.manejadorUsuario;

/**
 *
 * @author megan
 */
public class Puntuaciones extends javax.swing.JInternalFrame {

    /**
     * Creates new form Puntuaciones
     */
    public static String SelectedId;
    private manejadorUsuario mUsuarios;
    public Usuario usuarioLogeado;
    public Administrador adminPanel;
    public Puntuaciones(Administrador _adminPanel, Usuario _usr) {
        initComponents();
        mUsuarios = new manejadorUsuario();
        actualizarTabla();
        
        adminPanel = _adminPanel;
        usuarioLogeado = _usr;
    }

    public void actualizarTabla()
    {
        jtpronosticos.setModel(mUsuarios.obtenerJTablePuntuaciones());
        jtpronosticos.updateUI();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpronosticos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setTitle("Tabla de Puntuaciones");

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iinfo2.png"))); // NOI18N
        jButton1.setText("Ver Pronosticos");
        jButton1.setMaximumSize(new java.awt.Dimension(140, 39));
        jButton1.setMinimumSize(new java.awt.Dimension(140, 39));
        jButton1.setPreferredSize(new java.awt.Dimension(140, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        jtpronosticos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtpronosticos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jtpronosticosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(jtpronosticos);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 102, 255));
        jLabel2.setText("Tabla de Puntuaciones");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtpronosticosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpronosticosMousePressed
        JTable tabla =(JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);

        SelectedId = (String)tabla.getValueAt(row, 0);
    }//GEN-LAST:event_jtpronosticosMousePressed

    PronosticosAdmin pronosticoAdmin;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        manejadorUsuario mUsuario = new manejadorUsuario();
        Usuario usr = (Usuario) mUsuario.buscarPorID(SelectedId).datos;
        if (pronosticoAdmin == null || !pronosticoAdmin.isVisible()) // PARA NO ABRIR VARIOS FORMULARIOS DE PRONOSTICOS
        {
            pronosticoAdmin = new PronosticosAdmin(adminPanel);
            pronosticoAdmin.setResizable(true);
            pronosticoAdmin.setMaximizable(true);
            pronosticoAdmin.setIconifiable(true);
            pronosticoAdmin.setClosable(true);
            adminPanel.agregarForm(pronosticoAdmin);
        }
        pronosticoAdmin.filtrarporNickname(usr.getNickname());
        pronosticoAdmin.setVisible(true);
        pronosticoAdmin.setFocusable(true);
        
        try {  pronosticoAdmin.setSelected(true);  } catch (Exception e) {}
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public void AbrirPronostico() throws Exception{
        
        
        
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtpronosticos;
    // End of variables declaration//GEN-END:variables
}
