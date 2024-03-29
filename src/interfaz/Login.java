/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import rusia.Entidades.Usuario;
import rusia.Nucleo.claseRetorno;
import rusia.dataManager.manejadorUsuario;

/**
 *
 * @author Aura Marina Choxon
 */
public class Login extends javax.swing.JDialog {

    /**
     * Creates new form Login
     */
    public static Administrador adminPanel;
    public Login(java.awt.Frame parent, Administrador ad, boolean modal) {
        super(parent, modal);
        adminPanel = ad;
        initComponents();
        //this.show();
        this.setVisible(true);
        centrar();
    }
    
    public void centrar() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int w = this.getSize().width;
        int h = this.getSize().height;

        int x = (dim.width - w) / 2;
        int y = (dim.height - h) / 2;

        this.setLocation(x, y);
    }
   
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tnickname = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        biniciar = new javax.swing.JButton();
        tpassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setIconImage(null);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Nickname");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 86, -1, -1));

        tnickname.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(tnickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 150, 40));

        jLabel2.setText("Contraseña");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 132, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Bienvenido");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(82, 22, 217, -1));

        biniciar.setBackground(new java.awt.Color(0, 102, 204));
        biniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        biniciar.setForeground(new java.awt.Color(240, 240, 240));
        biniciar.setText("Iniciar Sesion");
        biniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                biniciarActionPerformed(evt);
            }
        });
        getContentPane().add(biniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 131, 34));

        tpassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(tpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 150, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo4.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 230));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        adminPanel.dispose();
    }//GEN-LAST:event_formWindowClosed

    private manejadorUsuario mUsuarios;
    private void biniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_biniciarActionPerformed
        mUsuarios = new manejadorUsuario();
        claseRetorno cr = mUsuarios.checkLogin(tnickname.getText(), tpassword.getText());
        if (cr.codigo == claseRetorno.codigos.Error)
            JOptionPane.showMessageDialog(this, cr.mensaje);
        else if (cr.codigo == claseRetorno.codigos.Exitoso){
                adminPanel.logearUsuario((Usuario) cr.datos);
                this.setVisible(false);
                
        }
    }//GEN-LAST:event_biniciarActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Login dialog = new Login(new javax.swing.JFrame(), adminPanel, true);
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
    private javax.swing.JButton biniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField tnickname;
    private javax.swing.JPasswordField tpassword;
    // End of variables declaration//GEN-END:variables
}
