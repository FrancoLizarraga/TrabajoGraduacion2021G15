/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autores.vistas;

import autores.modelos.ModeloTablaAlumnos;
import autores.modelos.ModeloTablaProfesores;
import interfaces.IControladorAutores;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Usuario
 */
public class VentanaAutores extends javax.swing.JDialog {

    private IControladorAutores controlador;

    public VentanaAutores(IControladorAutores controlador) {
        this.controlador = controlador;
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.tablaProfesor.setModel(new ModeloTablaProfesores());
        this.tablaAlumno.setModel(new ModeloTablaAlumnos());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtApellidosProfesor = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablaProfesor = new javax.swing.JTable();
        btnBuscarProfesor = new javax.swing.JButton();
        btnNuevoProfesor = new javax.swing.JButton();
        btnModificarProfesor = new javax.swing.JButton();
        btnBorrarProfesor = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtApellidosAlumno = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaAlumno = new javax.swing.JTable();
        btnBuscarAlumno = new javax.swing.JButton();
        btnNuevoAlumno = new javax.swing.JButton();
        btnModificarAlumno = new javax.swing.JButton();
        btnBorrarAlumno = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autores");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Profesores");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Alumnos");

        btnVolver.setMnemonic('V');
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolver(evt);
            }
        });

        jLabel5.setText("Apellidos:");

        txtApellidosProfesor.setToolTipText("Escrba sus apellidos.");
        txtApellidosProfesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosProfesorPresionarTecla(evt);
            }
        });

        tablaProfesor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tablaProfesor);

        btnBuscarProfesor.setMnemonic('B');
        btnBuscarProfesor.setText("Buscar");
        btnBuscarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarProfesor(evt);
            }
        });

        btnNuevoProfesor.setMnemonic('N');
        btnNuevoProfesor.setText("Nuevo");
        btnNuevoProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoProfesor(evt);
            }
        });

        btnModificarProfesor.setMnemonic('M');
        btnModificarProfesor.setText("Modificar");
        btnModificarProfesor.setEnabled(false);
        btnModificarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarProfesor(evt);
            }
        });

        btnBorrarProfesor.setMnemonic('B');
        btnBorrarProfesor.setText("Borrar");
        btnBorrarProfesor.setEnabled(false);
        btnBorrarProfesor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarProfesor(evt);
            }
        });

        jLabel2.setText("Apellidos:");

        txtApellidosAlumno.setToolTipText("Escriba sus apellidos.");
        txtApellidosAlumno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosAlumnoPresionarTecla(evt);
            }
        });

        tablaAlumno.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaAlumno);

        btnBuscarAlumno.setMnemonic('s');
        btnBuscarAlumno.setText("Buscar");
        btnBuscarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarAlumno(evt);
            }
        });

        btnNuevoAlumno.setMnemonic('e');
        btnNuevoAlumno.setText("Nuevo");
        btnNuevoAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoAlumno(evt);
            }
        });

        btnModificarAlumno.setMnemonic('o');
        btnModificarAlumno.setText("Modificar");
        btnModificarAlumno.setEnabled(false);
        btnModificarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarAlumno(evt);
            }
        });

        btnBorrarAlumno.setMnemonic('r');
        btnBorrarAlumno.setText("Borrar");
        btnBorrarAlumno.setEnabled(false);
        btnBorrarAlumno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarAlumno(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel1)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jLabel5)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtApellidosProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnBuscarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBuscarProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNuevoProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnModificarProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                            .addComponent(btnBorrarProfesor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnBorrarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnNuevoAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnModificarAlumno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtApellidosAlumno)))))
                        .addGap(0, 26, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellidosProfesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarProfesor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNuevoProfesor)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarProfesor)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarProfesor))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtApellidosAlumno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnBuscarAlumno))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNuevoAlumno)
                        .addGap(18, 18, 18)
                        .addComponent(btnModificarAlumno)
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrarAlumno)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevoProfesor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoProfesor
        this.controlador.btnNuevoProfesorClic(evt);
    }//GEN-LAST:event_btnNuevoProfesor

    private void btnModificarProfesor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarProfesor
        this.controlador.btnModificarProfesorClic(evt);
    }//GEN-LAST:event_btnModificarProfesor

    private void btnBorrarProfesor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarProfesor
        this.controlador.btnBorrarProfesorClic(evt);
    }//GEN-LAST:event_btnBorrarProfesor

    private void btnBuscarProfesor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarProfesor
        this.controlador.btnBuscarProfesorClic(evt);
    }//GEN-LAST:event_btnBuscarProfesor

    private void btnBuscarAlumno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarAlumno
        this.controlador.btnBuscarAlumnoClic(evt);
    }//GEN-LAST:event_btnBuscarAlumno

    private void btnNuevoAlumno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoAlumno
        this.controlador.btnNuevoAlumnoClic(evt);
    }//GEN-LAST:event_btnNuevoAlumno

    private void btnModificarAlumno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarAlumno
        this.controlador.btnModificarAlumnoClic(evt);
    }//GEN-LAST:event_btnModificarAlumno

    private void btnBorrarAlumno(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarAlumno
        this.controlador.btnBorrarAlumnoClic(evt);
    }//GEN-LAST:event_btnBorrarAlumno

    private void btnVolver(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolver
        this.controlador.btnVolverClic(evt);
    }//GEN-LAST:event_btnVolver

    private void txtApellidosProfesorPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosProfesorPresionarTecla
        this.controlador.txtApellidosProfesorPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosProfesorPresionarTecla

    private void txtApellidosAlumnoPresionarTecla(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosAlumnoPresionarTecla
        this.controlador.txtApellidosAlumnoPresionarTecla(evt);
    }//GEN-LAST:event_txtApellidosAlumnoPresionarTecla

    //PARA PROFESORES
    public JTable verTablaProfesor() {
        return this.tablaProfesor;
    }

    public JButton verBtnModificarProfesor() {
        return this.btnModificarProfesor;
    }

    public JButton verBtnBorrarProfesor() {
        return this.btnBorrarProfesor;
    }

    public JButton verBtnBuscarProfesor() {
        return this.btnBuscarProfesor;
    }

    public JTextField verTxtApellidosProfesor() {
        return this.txtApellidosProfesor;
    }

    //PARA ALUMNOS
    public JTable verTablaAlumno() {
        return this.tablaAlumno;
    }

    public JButton verBtnModificarAlumno() {
        return this.btnModificarAlumno;
    }

    public JButton verBtnBorrarAlumno() {
        return this.btnBorrarAlumno;
    }

    public JButton verBtnBuscarAlumno() {
        return this.btnBuscarAlumno;
    }

    public JTextField verTxtApellidosAlumno() {
        return this.txtApellidosAlumno;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrarAlumno;
    private javax.swing.JButton btnBorrarProfesor;
    private javax.swing.JButton btnBuscarAlumno;
    private javax.swing.JButton btnBuscarProfesor;
    private javax.swing.JButton btnModificarAlumno;
    private javax.swing.JButton btnModificarProfesor;
    private javax.swing.JButton btnNuevoAlumno;
    private javax.swing.JButton btnNuevoProfesor;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tablaAlumno;
    private javax.swing.JTable tablaProfesor;
    private javax.swing.JTextField txtApellidosAlumno;
    private javax.swing.JTextField txtApellidosProfesor;
    // End of variables declaration//GEN-END:variables
}
