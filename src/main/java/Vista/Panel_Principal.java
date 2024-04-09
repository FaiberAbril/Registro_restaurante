/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.Comida;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Panel_Principal extends javax.swing.JFrame {

    int largoCamara = 0;
    int anchoCamara = 0;
    Dimension dimension = new Dimension(176, 144);
    // Dimension dimsensioncamara = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam, dimension, false);

    /**
     * Creates new form Panel_Principal
     */
    public Panel_Principal() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p4 = new javax.swing.JPanel();
        Panelprincipal = new javax.swing.JPanel();
        panellateral = new javax.swing.JPanel();
        txtinforme = new javax.swing.JLabel();
        txtregistro1 = new javax.swing.JLabel();
        txtestudiantes = new javax.swing.JLabel();
        btniconoestudiante = new javax.swing.JButton();
        btnregistro = new javax.swing.JButton();
        btnactualizacion = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLcasa = new javax.swing.JLabel();

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panelprincipal.setBackground(new java.awt.Color(255, 255, 255));
        Panelprincipal.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        Panelprincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panellateral.setBackground(new java.awt.Color(255, 204, 102));
        panellateral.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtinforme.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtinforme.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtinforme.setText("ACTUALIZACION");
        panellateral.add(txtinforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 430, -1, -1));

        txtregistro1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtregistro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtregistro1.setText("REGISTRO");
        panellateral.add(txtregistro1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, -1, -1));

        txtestudiantes.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtestudiantes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtestudiantes.setText("ESTUDIANTES");
        panellateral.add(txtestudiantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, -1, -1));

        btniconoestudiante.setBackground(new java.awt.Color(255, 153, 0));
        btniconoestudiante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btniconoestudianteMouseClicked(evt);
            }
        });
        panellateral.add(btniconoestudiante, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, 110, 80));

        btnregistro.setBackground(new java.awt.Color(255, 153, 0));
        btnregistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnregistroMouseClicked(evt);
            }
        });
        btnregistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistroActionPerformed(evt);
            }
        });
        panellateral.add(btnregistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 210, 110, 90));

        btnactualizacion.setBackground(new java.awt.Color(255, 153, 0));
        btnactualizacion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnactualizacionMouseClicked(evt);
            }
        });
        panellateral.add(btnactualizacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 330, 110, 90));

        Panelprincipal.add(panellateral, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 570, 500));

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel3.setFont(new java.awt.Font("Showcard Gothic", 0, 30)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("RESTAURANTE ESCOLAR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLcasa, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Panelprincipal.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 110));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelprincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panelprincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void onClick(JPanel panel) {
        panel.setBackground(new Color(120, 120, 120));
    }

    private void onleaveClick(JPanel panel) {
        panel.setBackground(new Color(102, 102, 102));
    }

    private void btniconoestudianteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btniconoestudianteMouseClicked
       Comida comida = new Comida();
       comida.limpiarRegistrosAntiguos();
       

        Entrada ent = new Entrada();
        ent.setVisible(true);
        this.setVisible(false);// TODO add your handling code here:
    }//GEN-LAST:event_btniconoestudianteMouseClicked

    private void btnregistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnregistroMouseClicked
        Registro_estudiante res = new Registro_estudiante();
        res.startCamera();
        res.setVisible(true);
        this.setVisible(false);


    }//GEN-LAST:event_btnregistroMouseClicked

    private void btnactualizacionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnactualizacionMouseClicked
        Estudiantes est = new Estudiantes();
        est.setVisible(true);
        this.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btnactualizacionMouseClicked

    private void btnregistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnregistroActionPerformed

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
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel_Principal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panelprincipal;
    private javax.swing.JButton btnactualizacion;
    private javax.swing.JButton btniconoestudiante;
    private javax.swing.JButton btnregistro;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLcasa;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel panellateral;
    private javax.swing.JLabel txtestudiantes;
    private javax.swing.JLabel txtinforme;
    private javax.swing.JLabel txtregistro1;
    // End of variables declaration//GEN-END:variables

}
