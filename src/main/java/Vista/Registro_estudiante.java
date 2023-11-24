/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.controladorEstudiante;
import Modelo.Registrar_Estudiante;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import javax.swing.plaf.synth.Region;

/**
 *
 * @author CATA
 */
public class Registro_estudiante extends javax.swing.JFrame {
    
    int largoCamara = 0;
    int anchoCamara = 0;
    Dimension dimension = new Dimension(176, 144);
    // Dimension dimsensioncamara = WebcamResolution.VGA.getSize();
    Webcam webcam = Webcam.getDefault();
    WebcamPanel webcamPanel = new WebcamPanel(webcam, dimension, false);
    
    BufferedImage ruta;
    int contador = 0;

    /**
     *
     *
     *
     * Creates new form Registro_estudiante
     */
    public Registro_estudiante() {
        initComponents();
        initializeWebcam();
        setLocationRelativeTo(null);
        
    }
    
    private void initializeWebcam() {
        
        Dimension dimension = new Dimension(320, 240);
        webcam = Webcam.getDefault();
        webcam.setViewSize(dimension);
        webcamPanel = new WebcamPanel(webcam, dimension, false);
        
        pnlCamara.setLayout(new FlowLayout());
        pnlCamara.add(webcamPanel);
        webcamPanel.setFillArea(true);

        // Configura el evento de cierre de la ventana para liberar recursos de la cámara
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                webcamPanel.stop();
                webcam.close();
            }
        });
    }
    
    
    
    
     public void captureAndSaveImage(String numeroDocumento ) {
        BufferedImage image = webcam.getImage();
        try {
            // Cambia la ruta según donde quieras guardar la imagen
            File folder = new File("src\\main\\java\\fotos");
          
            
             if (!folder.exists()) {
            folder.mkdirs(); // Asegurar que todos los directorios padres se creen
             }
             
             
         String fileName = numeroDocumento +".jpg";
         
            System.out.println(folder.getAbsolutePath());

        // Crear el objeto File con la ruta completa del archivo
        File file = new File(folder, fileName);

        // Guardar la imagen en el archivo
           
            ImageIO.write(image, "JPG", file);
            
        } catch (IOException e) {
            e.printStackTrace();
            
        }
    }
    

    
    private void startCamera() {
        Thread cameraThread = new Thread(() -> webcamPanel.start());
        cameraThread.setDaemon(true);
        cameraThread.start();
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
        panel_registro = new javax.swing.JPanel();
        btnguardar2 = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbEstado = new javax.swing.JComboBox<>();
        cbBeneficio = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtGrado = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtnumEstu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbTipo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtnomEstu = new javax.swing.JTextField();
        txtapeEstu = new javax.swing.JTextField();
        pnlCamara = new javax.swing.JPanel();
        btnCapturar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);

        panel_registro.setBackground(new java.awt.Color(255, 255, 255));
        panel_registro.setPreferredSize(new java.awt.Dimension(900, 600));
        panel_registro.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnguardar2.setText("GUARDAR");
        btnguardar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar2ActionPerformed(evt);
            }
        });
        panel_registro.add(btnguardar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, -1, -1));

        btnmenu.setText("MENU");
        panel_registro.add(btnmenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 460, -1, -1));

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("ESTADO:");
        panel_registro.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, -1));

        cbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "ACTIVO ", "INACTIVO" }));
        panel_registro.add(cbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 116, -1));

        cbBeneficio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE", "BENEFICIO UNICO", "DOBLE BENEFICIO" }));
        panel_registro.add(cbBeneficio, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 310, -1, -1));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("BENEFICIO:");
        panel_registro.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        jLabel7.setBackground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("GRADO:");
        panel_registro.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));
        panel_registro.add(txtGrado, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, 75, -1));
        panel_registro.add(txtEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 75, -1));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("EDAD:");
        panel_registro.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, -1, -1));

        txtnumEstu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnumEstuActionPerformed(evt);
            }
        });
        panel_registro.add(txtnumEstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, 155, -1));

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("N° DOCUMENTO:");
        panel_registro.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, -1, -1));

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECIONE ", "C.C", "T.I" }));
        panel_registro.add(cbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 180, 94, -1));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("TIPO DOCUMENTO:");
        panel_registro.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, -1, -1));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("APELLIDOS:");
        panel_registro.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("NOMBRES:");
        panel_registro.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, -1, -1));
        panel_registro.add(txtnomEstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 155, -1));
        panel_registro.add(txtapeEstu, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 150, 155, -1));

        pnlCamara.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnlCamaraLayout = new javax.swing.GroupLayout(pnlCamara);
        pnlCamara.setLayout(pnlCamaraLayout);
        pnlCamaraLayout.setHorizontalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 257, Short.MAX_VALUE)
        );
        pnlCamaraLayout.setVerticalGroup(
            pnlCamaraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        panel_registro.add(pnlCamara, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 120, -1, -1));

        btnCapturar.setText("Capturar");
        btnCapturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapturarActionPerformed(evt);
            }
        });
        panel_registro.add(btnCapturar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 370, 129, -1));

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        panel_registro.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 600));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("ESTUDIANTES");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(338, 338, 338)
                .addComponent(jLabel1)
                .addContainerGap(475, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panel_registro.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 1050, 90));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_registro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnumEstuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnumEstuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnumEstuActionPerformed

    private void btnCapturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapturarActionPerformed
    
    }//GEN-LAST:event_btnCapturarActionPerformed

    private void btnguardar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar2ActionPerformed
       
    }//GEN-LAST:event_btnguardar2ActionPerformed

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
            java.util.logging.Logger.getLogger(Registro_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_estudiante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        SwingUtilities.invokeLater(() -> {
            Registrar_Estudiante e = new Registrar_Estudiante();
            Registro_estudiante Reg = new Registro_estudiante();
            controladorEstudiante con = new controladorEstudiante(e, Reg);
            Reg.setVisible(true);

            // Inicia la cámara al abrir la ventana
            Reg.startCamera();
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCapturar;
    public javax.swing.JButton btnguardar2;
    public javax.swing.JButton btnmenu;
    public javax.swing.JComboBox<String> cbBeneficio;
    public javax.swing.JComboBox<String> cbEstado;
    public javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel panel_registro;
    public javax.swing.JPanel pnlCamara;
    public javax.swing.JTextField txtEdad;
    public javax.swing.JTextField txtGrado;
    public javax.swing.JTextField txtapeEstu;
    public javax.swing.JTextField txtnomEstu;
    public javax.swing.JTextField txtnumEstu;
    // End of variables declaration//GEN-END:variables
}