/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import javax.swing.JOptionPane;
import rusia.Entidades.Usuario;
import rusia.dataManager.manejadorUsuario;

/**
 *
 * @author Aura Marina Choxon
 */
public class JDEditarU extends javax.swing.JDialog {

    /**
     * Creates new form JDEditarU
     */
    public static Usuario usuario;
    public Usuario usuarioLogeado;
    public JDEditarU(java.awt.Frame parent, boolean modal,  Usuario usr) {
        super(parent, modal);
        initComponents();
        usuario = usr;
        usuarioLogeado = ((Administrador) this.getParent()).usuarioLogeado;
        this.CargarInfoUsuario();
        this.setVisible(true);
    }

    private void CargarInfoUsuario()
    {
        tnombre.setText(usuario.getNombre());
        tapellido.setText(usuario.getApellido());
        tnickname.setText(usuario.getNickname());
        tcorreo.setText(usuario.getCorreo());
        cbrol.setSelectedItem(usuario.getRol());
        if (!usuarioLogeado.getRol().equals("Administrador"))
            pprivilegios.setVisible(false);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pprivilegios = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbrol = new javax.swing.JComboBox<>();
        tnombre = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        tcorreo = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tapellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tnickname = new javax.swing.JTextField();
        tpassword1 = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(320, 380));
        setMinimumSize(new java.awt.Dimension(320, 380));
        setPreferredSize(new java.awt.Dimension(320, 400));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pprivilegios.setBackground(new java.awt.Color(155, 236, 44));
        pprivilegios.setOpaque(false);

        jLabel9.setText("Privilegios");

        cbrol.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Usuario", "Administrador" }));

        javax.swing.GroupLayout pprivilegiosLayout = new javax.swing.GroupLayout(pprivilegios);
        pprivilegios.setLayout(pprivilegiosLayout);
        pprivilegiosLayout.setHorizontalGroup(
            pprivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(cbrol, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pprivilegiosLayout.setVerticalGroup(
            pprivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pprivilegiosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pprivilegiosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(cbrol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pprivilegios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, 40));
        getContentPane().add(tnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 150, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 2, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Editar Usuario");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 25, 240, -1));

        jLabel4.setText("Correo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 153, 90, -1));

        jButton1.setText("Editar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, 40));
        getContentPane().add(tcorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 150, 150, -1));

        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, 40));

        jLabel5.setText("Nueva Contraseña");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 182, -1, -1));

        jLabel2.setText("Apellidos");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 104, 90, -1));
        getContentPane().add(tapellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 150, -1));

        jLabel3.setText("Nickname");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 130, 90, -1));

        jLabel1.setText("Nombre");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 78, 90, -1));
        getContentPane().add(tnickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 150, -1));
        getContentPane().add(tpassword1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 180, 150, -1));

        jScrollPane1.setToolTipText("");

        jTextPane1.setEditable(false);
        jTextPane1.setBorder(null);
        jTextPane1.setForeground(new java.awt.Color(204, 0, 0));
        jTextPane1.setText("Si no desea cambiar la contraseña dejela en blanco");
        jTextPane1.setAutoscrolls(false);
        jTextPane1.setFocusable(false);
        jScrollPane1.setViewportView(jTextPane1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 225, 43));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 320, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        manejadorUsuario mUsuarios = new manejadorUsuario();
        usuario.setNombre(tnombre.getText());
        usuario.setApellido(tapellido.getText());
        usuario.setNickname(tnickname.getText());
        usuario.setCorreo(tcorreo.getText());
        if (!tpassword1.getText().equals("")) //Si la contraseña es otra, se cambia y se guarda.
            usuario.setPassword(tpassword1.getText());
        usuario.setRol((String)cbrol.getSelectedItem());

        mUsuarios.editarUsuario(usuario);
        
        JOptionPane.showMessageDialog(null, "Usuario editado exitosamente.");
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JDEditarU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JDEditarU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JDEditarU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JDEditarU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                JDEditarU dialog = new JDEditarU(new javax.swing.JFrame(), true, usuario);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbrol;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JPanel pprivilegios;
    private javax.swing.JTextField tapellido;
    private javax.swing.JTextField tcorreo;
    private javax.swing.JTextField tnickname;
    private javax.swing.JTextField tnombre;
    private javax.swing.JPasswordField tpassword1;
    // End of variables declaration//GEN-END:variables
}
