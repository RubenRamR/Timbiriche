/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Color;

/**
 *
 * @author rramirez
 */
public class FrmRegistro extends javax.swing.JFrame {

    /**
     * Creates new form FrmRegistro
     */
    public FrmRegistro() {
        initComponents();
    }

    public void cargarFrm() {
        setResizable(true);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPaneRegistro = new javax.swing.JPanel();
        LblRegistro = new javax.swing.JLabel();
        TxtUsuario = new javax.swing.JTextField();
        BtnRegistrarse = new javax.swing.JButton();
        ÑblFoto = new javax.swing.JLabel();
        LblFondoReg = new javax.swing.JLabel();
        LblFondo = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        JPaneRegistro.setBackground(new java.awt.Color(153, 153, 153));
        JPaneRegistro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LblRegistro.setBackground(new java.awt.Color(255, 255, 255));
        LblRegistro.setFont(new java.awt.Font("Segoe UI", 1, 60)); // NOI18N
        LblRegistro.setForeground(new java.awt.Color(255, 255, 255));
        LblRegistro.setText("Registro");
        JPaneRegistro.add(LblRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 50, 240, 100));

        TxtUsuario.setBackground(new java.awt.Color(255, 255, 255));
        TxtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        TxtUsuario.setForeground(new java.awt.Color(153, 153, 153));
        TxtUsuario.setText("Usuario");
        TxtUsuario.setToolTipText("Usuario");
        TxtUsuario.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        TxtUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        TxtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtUsuarioFocusLost(evt);
            }
        });
        JPaneRegistro.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 170, 480, 70));

        BtnRegistrarse.setBackground(new java.awt.Color(128, 30, 47));
        BtnRegistrarse.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        BtnRegistrarse.setForeground(new java.awt.Color(255, 255, 255));
        BtnRegistrarse.setText("Registrarse");
        BtnRegistrarse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnRegistrarseActionPerformed(evt);
            }
        });
        JPaneRegistro.add(BtnRegistrarse, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 800, 250, 80));

        ÑblFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons, perfil 1 (Provicional).png"))); // NOI18N
        JPaneRegistro.add(ÑblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(737, 300, 430, -1));

        LblFondoReg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Rectangle 5.png"))); // NOI18N
        LblFondoReg.setAlignmentY(0.0F);
        LblFondoReg.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        LblFondoReg.setPreferredSize(new java.awt.Dimension(623, 1000));
        JPaneRegistro.add(LblFondoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 630, 910));

        LblFondo.setForeground(new java.awt.Color(255, 255, 255));
        LblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FondoReg1.1.png"))); // NOI18N
        LblFondo.setPreferredSize(new java.awt.Dimension(1920, 1080));
        JPaneRegistro.add(LblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1920, 1080));

        jTextField1.setText("jTextField1");
        JPaneRegistro.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 30, -1, 130));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPaneRegistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtUsuarioFocusGained
        // TODO add your handling code here:
        if (TxtUsuario.getText().equals("Usuario"))
        {
            TxtUsuario.setText("");
            TxtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtUsuarioFocusGained

    private void TxtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtUsuarioFocusLost
        // TODO add your handling code here:
        if (TxtUsuario.getText().equals(""))
        {
            TxtUsuario.setText("Usuario");
            TxtUsuario.setForeground(new Color(153, 153, 153));
        }
    }//GEN-LAST:event_TxtUsuarioFocusLost

    private void BtnRegistrarseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnRegistrarseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnRegistrarseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(FrmRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnRegistrarse;
    private javax.swing.JPanel JPaneRegistro;
    private javax.swing.JLabel LblFondo;
    private javax.swing.JLabel LblFondoReg;
    private javax.swing.JLabel LblRegistro;
    private javax.swing.JTextField TxtUsuario;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel ÑblFoto;
    // End of variables declaration//GEN-END:variables
}
