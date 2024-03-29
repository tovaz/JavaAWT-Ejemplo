/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import rusia.Entidades.Pronostico;
import rusia.Entidades.partido;
import rusia.dataManager.manejadorPartidos;
import rusia.dataManager.manejadorPronosticos;

/**
 *
 * @author Aura Marina Choxon
 */
public class PronosticosAdmin extends javax.swing.JInternalFrame {

    /**
     * Creates new form PronosticosAdmin
     */
    String SelectedId;
    private manejadorPronosticos mPronosticos;
    private manejadorPartidos mPartidos;
    private DefaultListModel pronosticos;
    private JFrame padre;
    public Administrador adminPanel;
    public PronosticosAdmin(Administrador _adminPanel) {
        initComponents();
        mPronosticos = new manejadorPronosticos();
        mPartidos = new manejadorPartidos();
        adminPanel = _adminPanel;
        
        if (_adminPanel.usuarioLogeado.getRol().equals("Administrador")){
            beditarp.setVisible(false);
            beliminarp.setVisible(false);
        }
        else{
            beditarp.setVisible(true);
            beliminarp.setVisible(true);
            mPronosticos = new manejadorPronosticos(_adminPanel.usuarioLogeado.getId());
            pbuscar.setVisible(false);
        }
     
        this.actualizarTabla();
    }
    
    public void mostrarInfo(String boton) { 
        Pronostico _pronostico = new Pronostico();
        _pronostico = (Pronostico) mPronosticos.buscarPorID(SelectedId).datos;
    }
    
    public  void filtrarporNickname(String nickname){
        tbuscar.setText(nickname);
        trsFiltro = new TableRowSorter(jtpronosticos.getModel());
        jtpronosticos.setRowSorter(trsFiltro);
        this.filtro();
    }
        
    public void actualizarTabla()
    {
        jtpronosticos.setModel(mPronosticos.obtenerJTable());
        jtpronosticos.updateUI();
    }
    
    private TableRowSorter trsFiltro;
    public void filtro()
    {
        trsFiltro.setRowFilter(RowFilter.regexFilter(tbuscar.getText(), 1));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pbuscar = new javax.swing.JPanel();
        tbuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        jButton1 = new javax.swing.JButton();
        beditarp = new javax.swing.JButton();
        beliminarp = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        binfopartido = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpronosticos = new javax.swing.JTable();

        setTitle("Pronosticos");

        tbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tbuscarKeyPressed(evt);
            }
        });

        jLabel1.setText("Buscar por nickname");

        javax.swing.GroupLayout pbuscarLayout = new javax.swing.GroupLayout(pbuscar);
        pbuscar.setLayout(pbuscarLayout);
        pbuscarLayout.setHorizontalGroup(
            pbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(tbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pbuscarLayout.setVerticalGroup(
            pbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pbuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pbuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jToolBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/iinfo2.png"))); // NOI18N
        jButton1.setText("Informacion");
        jButton1.setMaximumSize(new java.awt.Dimension(120, 39));
        jButton1.setMinimumSize(new java.awt.Dimension(100, 39));
        jButton1.setPreferredSize(new java.awt.Dimension(120, 39));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jToolBar1.add(jButton1);

        beditarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/editar3.png"))); // NOI18N
        beditarp.setActionCommand("Editar Pronostico");
        beditarp.setFocusable(false);
        beditarp.setLabel("Editar Pronostico");
        beditarp.setMaximumSize(new java.awt.Dimension(160, 57));
        beditarp.setMinimumSize(new java.awt.Dimension(160, 57));
        beditarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beditarpActionPerformed(evt);
            }
        });
        jToolBar1.add(beditarp);

        beliminarp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ieliminar2.png"))); // NOI18N
        beliminarp.setText("Eliminar Pronostico");
        beliminarp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beliminarpActionPerformed(evt);
            }
        });
        jToolBar1.add(beliminarp);
        jToolBar1.add(jSeparator1);

        binfopartido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/ipartido3.png"))); // NOI18N
        binfopartido.setActionCommand("Informacion del Partido");
        binfopartido.setFocusable(false);
        binfopartido.setLabel("Informacion del Partido");
        binfopartido.setMaximumSize(new java.awt.Dimension(160, 57));
        binfopartido.setMinimumSize(new java.awt.Dimension(160, 57));
        binfopartido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                binfopartidoActionPerformed(evt);
            }
        });
        jToolBar1.add(binfopartido);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        mostrarInfo("info");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jtpronosticosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtpronosticosMousePressed
        JTable tabla =(JTable) evt.getSource();
        Point punto = evt.getPoint();
        int row = tabla.rowAtPoint(punto);

        SelectedId = (String)tabla.getValueAt(row, 0);
        //if (evt.getClickCount() == 2 && tabla.getSelectedRow() != -1)
        //mostrarInfo("info");
    }//GEN-LAST:event_jtpronosticosMousePressed

    private void beditarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beditarpActionPerformed
        partido Partido = new partido();
        Pronostico pronostico = (Pronostico) mPronosticos.buscarPorID(SelectedId).datos;
        Partido = (partido) mPartidos.buscarPorID(pronostico.getPartido()).datos;
        
        if (!Partido.isFinalizado()){
        
            Partido.setFaseGrupo("usuario");
            Partido.pronostico = pronostico.getId();

            new partidoInfo(this.padre,true,Partido, adminPanel.usuarioLogeado).setVisible(true);
            actualizarTabla();
        }
        else
            JOptionPane.showMessageDialog(this, "El partido ya se a jugado, no puedo editar un pronostico de un partido que ya se jugo.");
    }//GEN-LAST:event_beditarpActionPerformed

    private void tbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbuscarKeyPressed
        tbuscar.addKeyListener(new KeyAdapter() {
            public void keyReleased(final KeyEvent e){
                String cadena = tbuscar.getText();
                tbuscar.setText(cadena);
                repaint();
                filtro();
            }
        });
        
        trsFiltro = new TableRowSorter(jtpronosticos.getModel());
        jtpronosticos.setRowSorter(trsFiltro);
    }//GEN-LAST:event_tbuscarKeyPressed

    private void binfopartidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_binfopartidoActionPerformed
        partido Partido = new partido();
        Pronostico pronostico = (Pronostico) mPronosticos.buscarPorID(SelectedId).datos;
        Partido = (partido) mPartidos.buscarPorID(pronostico.getPartido()).datos;
        Partido.setFaseGrupo("info");

        new partidoInfo(this.padre,true,Partido, adminPanel.usuarioLogeado).setVisible(true);
    }//GEN-LAST:event_binfopartidoActionPerformed

    private void beliminarpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beliminarpActionPerformed
        int dialogResult = JOptionPane.showConfirmDialog (null, "¿Desea realmente eliminar este pronostico ?", "Precaucion", JOptionPane.YES_NO_OPTION);
        if(dialogResult == JOptionPane.YES_OPTION){
            Pronostico pronostico = (Pronostico) mPronosticos.buscarPorID(SelectedId).datos;
            pronostico.setEliminado(true);
            mPronosticos.editarRegistro(pronostico);
            actualizarTabla();
        }
    }//GEN-LAST:event_beliminarpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton beditarp;
    private javax.swing.JButton beliminarp;
    private javax.swing.JButton binfopartido;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JTable jtpronosticos;
    private javax.swing.JPanel pbuscar;
    private javax.swing.JTextField tbuscar;
    // End of variables declaration//GEN-END:variables
}
