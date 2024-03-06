/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Configuracion.Conexion;
import Controlador.controladorEstudiante;
import Modelo.Registrar_Estudiante;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author CATA
 */
public class Estudiantes extends javax.swing.JFrame {

    Connection coneccion;
    Conexion conexionbasededatos = new Conexion();
    int fila;

    controladorEstudiante controladorestudiante = new controladorEstudiante();
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> trsfiltro;

    int Id_estudiante;

    public Estudiantes() {
        initComponents();
        listar();
        setLocationRelativeTo(null);
    }

    public Registrar_Estudiante buscarpornombre(String numeDocumento, String NomEstudiante, String ApeEstudiante) {

        Registrar_Estudiante estudiantes = new Registrar_Estudiante();

        coneccion = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Registrar_Estudiante where numeDocumento like %?% or NomEstudiante like %?% or ApeEstudiante like %?%  ";
        String[] titulostabla = {"ID_Estudiantes", "Nombre", "Apellidos", "Tipo", "N°Documento", "Edad", "Grado", "Beneficio", "Estado"};
        modelo.setColumnIdentifiers(titulostabla);

        try {
            ps = coneccion.prepareStatement(sql);
            ps.setString(1, numeDocumento);
            ps.setString(2, NomEstudiante);
            ps.setString(3, ApeEstudiante);
            rs = ps.executeQuery();
            while (rs.next()) {
                estudiantes.setId_estudiante(rs.getInt(1));
                estudiantes.setNomEstudiante(rs.getString(2));
                estudiantes.setApeEstudiante(rs.getString(3));
                estudiantes.setTipoDocu(rs.getString(4));
                estudiantes.setNumeDocumento(rs.getString(5));
                estudiantes.setEdad(rs.getString(6));
                estudiantes.setGrado(rs.getString(7));
                estudiantes.setTipoBeneficio(rs.getString(8));
                estudiantes.setEstado(rs.getString(9));
                return estudiantes;
            }

        } catch (Exception e) {
            System.out.println(e);
        }

        return estudiantes;
    }

    public void limpiarformulario() {

    }

    public void listar() {

        List<Registrar_Estudiante> listaestudiantes = controladorestudiante.listar();
        modelo = (DefaultTableModel) tbEstudiantes.getModel();

        for (Registrar_Estudiante estudiantes : listaestudiantes) {
            modelo.addRow(new Object[]{
                estudiantes.getId_estudiante(),
                estudiantes.getNomEstudiante(),
                estudiantes.getApeEstudiante(),
                estudiantes.getTipoDocu(),
                estudiantes.getNumeDocumento(),
                estudiantes.getEdad(),
                estudiantes.getGrado(),
                estudiantes.getTipoBeneficio(),
                estudiantes.getEstado()
            });
        }
        tbEstudiantes.setModel(modelo);
    }

    public void limpiartabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void filtro() {

        String filtro = txtfiltro.getText();

        if (RbID.isSelected()) {
            int columna = 4;
            trsfiltro.setRowFilter(RowFilter.regexFilter(filtro, columna));
        } else if (RbNom.isSelected()) {
            int columna = 1;
            trsfiltro.setRowFilter(RowFilter.regexFilter(filtro, columna));
        } else if (RbApe.isSelected()) {
            int columna = 2;
            trsfiltro.setRowFilter(RowFilter.regexFilter(filtro, columna));
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgfiltrar = new javax.swing.ButtonGroup();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEstudiantes = new javax.swing.JTable();
        RbID = new javax.swing.JRadioButton();
        RbNom = new javax.swing.JRadioButton();
        RbApe = new javax.swing.JRadioButton();
        txtfiltro = new javax.swing.JTextField();
        btnActualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        txtgrado = new javax.swing.JTextField();
        cbTipo = new javax.swing.JComboBox<>();
        cbBeneficio = new javax.swing.JComboBox<>();
        cbEst = new javax.swing.JComboBox<>();
        btnEliminar = new javax.swing.JButton();
        btnmenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jInternalFrame1.setClosable(true);
        jInternalFrame1.setMaximizable(true);
        jInternalFrame1.setVisible(true);

        jLabel2.setText("Filtrar:");

        tbEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID_Estudiante", "Nombres", "Apellidos", "Tipo ", "N° Documento", "Edad", "Grado", "Beneficio", "Estado"
            }
        ));
        tbEstudiantes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEstudiantesMouseClicked(evt);
            }
        });
        tbEstudiantes.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbEstudiantesPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tbEstudiantes);

        bgfiltrar.add(RbID);
        RbID.setText("Identificacion");

        bgfiltrar.add(RbNom);
        RbNom.setText("Nombres");

        bgfiltrar.add(RbApe);
        RbApe.setText("Apellido");

        txtfiltro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtfiltroKeyTyped(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        jLabel1.setText("Grado:");

        jLabel3.setText("Nombres:");

        jLabel4.setText("Apellidos:");

        jLabel5.setText("Tipo Documento:");

        jLabel6.setText("N° Documento:");

        jLabel7.setText("Edad");

        jLabel8.setText("Beneficio:");

        jLabel9.setText("Estado:");

        txtApellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtApellidoActionPerformed(evt);
            }
        });

        cbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "C.C", "T.I", " " }));

        cbBeneficio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "BENEFICIO UNICO", "DOBLE BENEFICIO" }));

        cbEst.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SELECCIONAR", "ACTIVO", "INACTIVO" }));

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnmenu.setText("Menu");
        btnmenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnmenuMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 472, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(37, 37, 37)
                            .addComponent(RbID)
                            .addGap(29, 29, 29)
                            .addComponent(RbNom)
                            .addGap(38, 38, 38)
                            .addComponent(RbApe))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnmenu))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5)
                    .addComponent(jLabel9)
                    .addComponent(btnActualizar))
                .addGap(33, 33, 33)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEliminar)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(cbEst, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbBeneficio, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtgrado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addComponent(txtedad, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(196, 196, 196))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(RbID)
                    .addComponent(RbNom)
                    .addComponent(RbApe))
                .addGap(25, 25, 25)
                .addComponent(txtfiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtgrado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(cbBeneficio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(cbEst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnActualizar)
                            .addComponent(btnEliminar)
                            .addComponent(btnmenu))
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jInternalFrame1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jInternalFrame1)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEstudiantesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEstudiantesMouseClicked
        fila = tbEstudiantes.getSelectedRow();

        int Id_estudiante = Integer.parseInt(tbEstudiantes.getValueAt(fila, 0).toString());
        String Nombres = tbEstudiantes.getValueAt(fila, 1).toString();
        String Apellidos = tbEstudiantes.getValueAt(fila, 2).toString();
        String Tipo = tbEstudiantes.getValueAt(fila, 3).toString();
        String NDocumento = tbEstudiantes.getValueAt(fila, 4).toString();
        String Edad = tbEstudiantes.getValueAt(fila, 5).toString();
        String Grado = tbEstudiantes.getValueAt(fila, 6).toString();
        String Beneficio = tbEstudiantes.getValueAt(fila, 7).toString();
        String Estados = tbEstudiantes.getValueAt(fila, 8).toString();

        txtNombre.setText(Nombres);
        txtApellido.setText(Apellidos);
        cbTipo.setSelectedItem(Tipo);
        txtNumero.setText(NDocumento);
        txtedad.setText(Edad);
        txtgrado.setText(Grado);
        cbBeneficio.setSelectedItem(Beneficio);
        cbEst.setSelectedItem(Estados);


    }//GEN-LAST:event_tbEstudiantesMouseClicked

    private void txtfiltroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltroKeyTyped
        if (bgfiltrar.getSelection() == null) {

            evt.consume();
            JOptionPane.showMessageDialog(this, "Debe seleccionar una opción del filtro", "Menaje de Error", JOptionPane.ERROR_MESSAGE);
        } else {

            txtfiltro.addKeyListener(new KeyAdapter() {

                @Override
                public void keyTyped(final KeyEvent e) {
                    filtro();
                }
            });

            trsfiltro = new TableRowSorter(modelo);

            tbEstudiantes.setRowSorter(trsfiltro);

        }
    }//GEN-LAST:event_txtfiltroKeyTyped

       
    
    
    
    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        int Id_estudiante = Integer.parseInt(tbEstudiantes.getValueAt(fila, 0).toString());
        String Nombres = txtNombre.getText();
        String Apellidos = txtApellido.getText();
        String Tipo = cbTipo.getSelectedItem().toString();
        String NDocumento = txtNumero.getText();
        String Edad = txtedad.getText();
        String Grado = txtgrado.getText();
        String Beneficio = cbBeneficio.getSelectedItem().toString();
        String Estado = cbEst.getSelectedItem().toString();

        coneccion = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "UPDATE Registrar_Estudiante SET  NomEstudiante=?, ApeEstudiante=?, TipoDocu=?, numeDocumento=?, Edad=?, Grado=?, tipoBeneficio=?, Estado=? WHERE Id_estudiante=?";

        try {
            ps = coneccion.prepareStatement(sql);

            ps.setString(1, Nombres);
            ps.setString(2, Apellidos);
            ps.setString(3, Tipo);
            ps.setString(4, NDocumento);
            ps.setString(5, Edad);
            ps.setString(6, Grado);
            ps.setString(7, Beneficio);
            ps.setString(8, Estado);
            ps.setInt(9, Id_estudiante);

            if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Actualizacion con exito");
                limpiartabla();
                listar();
                limpiarformulario();
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }

        } catch (Exception e) {
            System.out.println(e);
        }


    }//GEN-LAST:event_btnActualizarActionPerformed

    private void tbEstudiantesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbEstudiantesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_tbEstudiantesPropertyChange

    private void txtApellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtApellidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtApellidoActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      
        int Id_estudiante = Integer.parseInt(tbEstudiantes.getValueAt(fila, 0).toString());
        coneccion = conexionbasededatos.getconeccionbasedatos();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM Registrar_Estudiante WHERE Id_estudiante=?";
        System.out.println(Id_estudiante);
        try {
            ps = coneccion.prepareStatement(sql);
            ps.setInt(1, Id_estudiante);

             if (ps.executeUpdate() == 1) {
                JOptionPane.showMessageDialog(null, "Datos eliminados con exito");
                limpiartabla();
                listar();
                limpiarformulario();
                
            } else {
                JOptionPane.showMessageDialog(null, "Error");
            }
            
        } catch (SQLException ex) {
            
        }
       
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnmenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmenuMouseClicked
Panel_Principal pp = new Panel_Principal();
pp.setVisible(true);
this.setVisible(false);
    }//GEN-LAST:event_btnmenuMouseClicked

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
            java.util.logging.Logger.getLogger(Estudiantes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Estudiantes.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Estudiantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton RbApe;
    private javax.swing.JRadioButton RbID;
    private javax.swing.JRadioButton RbNom;
    public javax.swing.ButtonGroup bgfiltrar;
    public javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnmenu;
    public javax.swing.JComboBox<String> cbBeneficio;
    public javax.swing.JComboBox<String> cbEst;
    public javax.swing.JComboBox<String> cbTipo;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tbEstudiantes;
    public javax.swing.JTextField txtApellido;
    public javax.swing.JTextField txtNombre;
    public javax.swing.JTextField txtNumero;
    public javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtfiltro;
    public javax.swing.JTextField txtgrado;
    // End of variables declaration//GEN-END:variables
}
