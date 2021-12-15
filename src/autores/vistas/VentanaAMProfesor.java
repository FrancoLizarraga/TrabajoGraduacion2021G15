/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.Cargo;
import autores.modelos.ModeloComboCargos;
import autores.modelos.Profesor;
import interfaces.IControladorAMProfesor;
import java.awt.Dialog;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class VentanaAMProfesor extends JDialog {

    ArrayList<Profesor> profesores = new ArrayList<>();
    private IControladorAMProfesor controlador;

    public VentanaAMProfesor(IControladorAMProfesor controlador) {
        this.controlador = controlador;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.comboCargos.setModel(new ModeloComboCargos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtApellidos = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNombres = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDNI = new javax.swing.JTextField();
        txtPassClave = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        comboCargos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtRepetirPassClave = new javax.swing.JPasswordField();
        btnCancelarClic = new javax.swing.JButton();
        scrollPane = new javax.swing.JScrollPane();
        tablaGruposAutor = new javax.swing.JTable();
        labelGrupos = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Apellidos:");

        txtApellidos.setToolTipText("Apellidos del profesor");
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosPresionarTecla(evt);
            }
        });

        jLabel2.setText("Nombres:");

        txtNombres.setToolTipText("Nombres del profesor");
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresPresionarTecla(evt);
            }
        });

        btnGuardar.setMnemonic('G');
        btnGuardar.setText("Guardar");
        btnGuardar.setToolTipText("");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarClic(evt);
            }
        });

        jLabel3.setText("Cargo:");

        jLabel4.setText("Documento:");

        txtDNI.setToolTipText("Documento del profesor");
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoPresionarTecla(evt);
            }
        });

        txtPassClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passClavePresionarTecla(evt);
            }
        });

        jLabel6.setText("Clave:");

        comboCargos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Repetir clave:");

        txtRepetirPassClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passRepetirClavePresionarTecla(evt);
            }
        });

        btnCancelarClic.setMnemonic('C');
        btnCancelarClic.setText("Cancelar");
        btnCancelarClic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarClic(evt);
            }
        });

        tablaGruposAutor.setModel(new javax.swing.table.DefaultTableModel(
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
        scrollPane.setViewportView(tablaGruposAutor);

        labelGrupos.setText("Grupos:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombres)
                            .addComponent(txtDNI)
                            .addComponent(txtApellidos)
                            .addComponent(txtPassClave)
                            .addComponent(comboCargos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRepetirPassClave)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelarClic))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelGrupos)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(comboCargos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtRepetirPassClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelGrupos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 234, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar)
                    .addComponent(btnCancelarClic))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarClic
        this.controlador.btnGuardarClic(evt);
    }//GEN-LAST:event_btnGuardarClic

    private void btnCancelarClic(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarClic
        this.controlador.btnCancelarClic(evt);
    }//GEN-LAST:event_btnCancelarClic

    private void passRepetirClavePresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passRepetirClavePresionarTecla
        this.controlador.passRepetirClavePresionarTecla(evt);
    }//GEN-LAST:event_passRepetirClavePresionarTecla

    private void passClavePresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passClavePresionarTecla
        this.controlador.passClavePresionarTecla(evt);
    }//GEN-LAST:event_passClavePresionarTecla

    private void txtDocumentoPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoPresionarTecla
        this.controlador.txtDocumentoPresionarTecla(evt);
    }//GEN-LAST:event_txtDocumentoPresionarTecla

    private void txtNombresPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresPresionarTecla
        this.controlador.txtNombresPresionarTecla(evt);
    }//GEN-LAST:event_txtNombresPresionarTecla

    private void txtApellidosPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosPresionarTecla
        this.controlador.txtApellidosPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosPresionarTecla

    public JTextField verTxtDNI() {
        return this.txtDNI;
    }

    public JTextField verTxtApellidos() {
        return this.txtApellidos;
    }

    public JTextField verTxtNombres() {
        return this.txtNombres;
    }

    public JPasswordField verTxtClave() {
        return this.txtPassClave;
    }

    public JPasswordField verTxtClaveRepetida() {
        return this.txtRepetirPassClave;
    }

    public JComboBox<String> verComboCargos() {
        return this.comboCargos;
    }

    public JButton verBotonGuardar() {
        return this.btnGuardar;
    }

    public JScrollPane verScrollPane() {
        return scrollPane;
    }

    public JTable verTablaGruposAutor() {
        return tablaGruposAutor;
    }

    public JLabel verLabelGrupos() {
        return labelGrupos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelarClic;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCargos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel labelGrupos;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTable tablaGruposAutor;
    private javax.swing.JTextField txtApellidos;
    private javax.swing.JTextField txtDNI;
    private javax.swing.JTextField txtNombres;
    private javax.swing.JPasswordField txtPassClave;
    private javax.swing.JPasswordField txtRepetirPassClave;
    // End of variables declaration//GEN-END:variables
}
