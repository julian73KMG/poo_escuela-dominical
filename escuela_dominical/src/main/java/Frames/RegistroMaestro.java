package Frames;
import escuela_dominical.Maestro;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.ArrayList;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class RegistroMaestro extends javax.swing.JFrame {
    public ArrayList<Maestro> listaMaestros;
    public DefaultTableModel modeloTabla;
    public int indiceSeleccionado = -1;


    
        public RegistroMaestro() {
        setTitle("Registro de Maestros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initComponents();
        cerrar();
        
        listaMaestros = new ArrayList<>();
        modeloTabla = new DefaultTableModel(new String[]{"Nombre", "Género" ,"Grupo", "Lección", "Contacto", "Fecha"}, 0);
        jTable1.setModel(modeloTabla);

        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                seleccionarMaestro();
            }
        });
        }
        
         public void cerrar(){
            
        try {
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
            addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent e){
                    confirmarSalida();
                }
            });
            
        } catch (Exception e) {
        }
    }
    
    public void confirmarSalida(){
        int valor = JOptionPane.showConfirmDialog
        (this, "¿Deseas salir de la aplicacion?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(valor == JOptionPane.YES_OPTION){
            JOptionPane.showMessageDialog(null, "Hasta pronto!","" , JOptionPane.INFORMATION_MESSAGE );
            System.exit(0);
        }
    }

    
       private void guardarMaestro() {
        String nombre = txtNombre.getText();
        String genero = selectGenero1.getSelectedItem().toString();
        String grupo = selectGrupo.getSelectedItem().toString();
        String leccion = selectLecciones.getSelectedItem().toString();
        String contacto = txtContacto.getText();
    
        // Validar y convertir la fecha
        Date fechaSeleccionada = jDateChooser1.getDate();
        if (fechaSeleccionada == null) {
        JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
        return;
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = formato.format(fechaSeleccionada);

        if (nombre.isEmpty() || contacto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
        return;
    }

    Maestro nuevoMaestro = new Maestro(nombre, genero, 1, 1, 1, contacto);
    listaMaestros.add(nuevoMaestro);
    modeloTabla.addRow(new Object[]{nombre, genero ,grupo, leccion, contacto, fecha});
    limpiar();
}
        
        
        private void actualizarMaestro() {
    if (indiceSeleccionado == -1) {
        JOptionPane.showMessageDialog(this, "Seleccione un maestro para actualizar.");
        return;
    }

    String nombre = txtNombre.getText();
    String genero = selectGenero1.getSelectedItem().toString();
    String grupo = selectGrupo.getSelectedItem().toString();
    String leccion = selectLecciones.getSelectedItem().toString();
    String contacto = txtContacto.getText();
    
    // Validar y convertir la fecha
    Date fechaSeleccionada = jDateChooser1.getDate();
    if (fechaSeleccionada == null) {
        JOptionPane.showMessageDialog(this, "Seleccione una fecha válida.");
        return;
    }
    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = formato.format(fechaSeleccionada);

    if (nombre.isEmpty() || contacto.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
        return;
    }

    Maestro maestro = listaMaestros.get(indiceSeleccionado);
    maestro.actualizarContacto(contacto);
    modeloTabla.setValueAt(nombre, indiceSeleccionado, 0);
    modeloTabla.setValueAt(genero, indiceSeleccionado, 1);
    modeloTabla.setValueAt(grupo, indiceSeleccionado, 2);
    modeloTabla.setValueAt(leccion, indiceSeleccionado, 3);
    modeloTabla.setValueAt(contacto, indiceSeleccionado, 4);
    modeloTabla.setValueAt(fecha, indiceSeleccionado, 5);
    limpiar();
    indiceSeleccionado = -1;
}

        
        
        private void seleccionarMaestro() {
    int fila = jTable1.getSelectedRow();
    if (fila != -1) {
        indiceSeleccionado = fila;
        txtNombre.setText(modeloTabla.getValueAt(fila, 0).toString()); // Nombre
        selectGenero1.setSelectedItem(modeloTabla.getValueAt(fila, 1).toString()); // Genero
        selectGrupo.setSelectedItem(modeloTabla.getValueAt(fila, 2).toString()); // Grupo
        selectLecciones.setSelectedItem(modeloTabla.getValueAt(fila, 3).toString()); // Lecciones
        txtContacto.setText(modeloTabla.getValueAt(fila, 4).toString()); // Contacto
        
        // Convertir String a Date y asignarlo a jDateChooser1
        String fechaTexto = modeloTabla.getValueAt(fila, 5).toString();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fecha = formato.parse(fechaTexto);
            jDateChooser1.setDate(fecha);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "Error al convertir la fecha: " + e.getMessage());
        }
    }
}
        
        private void limpiar() {
    txtNombre.setText("");
    selectGenero1.setSelectedIndex(0);
    jDateChooser1.setDate(null); // Reiniciar la fecha
    selectGrupo.setSelectedIndex(0);
    selectLecciones.setSelectedIndex(0);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Grupo = new javax.swing.JLabel();
        Tematica = new javax.swing.JLabel();
        Textobiblico = new javax.swing.JLabel();
        selectGrupo = new javax.swing.JComboBox<>();
        txtContacto = new javax.swing.JTextField();
        Auxilair = new javax.swing.JLabel();
        selectLecciones = new javax.swing.JComboBox<>();
        Nombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        btnNuevo = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        Tematica1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        selectGenero1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/teacher_6454416 (1).png"))); // NOI18N
        jLabel1.setText("Registro de Maestros");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Maestro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Nirmala UI", 1, 14))); // NOI18N

        Grupo.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Grupo.setText("Grupo");

        Tematica.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Tematica.setText("Contacto");

        Textobiblico.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Textobiblico.setText("Género");

        selectGrupo.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        selectGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ovejitas del Saber", "Soldaditos de Dios", "Campanas de Belén", "Ninguno" }));
        selectGrupo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGrupoActionPerformed(evt);
            }
        });

        txtContacto.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtContacto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtContactoActionPerformed(evt);
            }
        });

        Auxilair.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Auxilair.setText("Lecciones");

        selectLecciones.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        selectLecciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectLecciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectLeccionesActionPerformed(evt);
            }
        });

        Nombre.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Nombre.setText("Nombre(s)");

        txtNombre.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N

        btnNuevo.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-plus-48 (1).png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnGuardar.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        btnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-save-32.png"))); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-update-30.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        Tematica1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        Tematica1.setText("Fecha");

        selectGenero1.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        selectGenero1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", "No binario", "Otro" }));
        selectGenero1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectGenero1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Auxilair)
                            .addComponent(Tematica)
                            .addComponent(Grupo)
                            .addComponent(Textobiblico)
                            .addComponent(Nombre))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtContacto, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(selectLecciones, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectGrupo, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(selectGenero1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Tematica1)
                                .addGap(50, 50, 50)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnGuardar)
                                .addGap(18, 18, 18)
                                .addComponent(btnActualizar)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(30, 30, 30))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnActualizar, btnGuardar, btnNuevo});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Textobiblico)
                    .addComponent(selectGenero1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Grupo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Auxilair)
                    .addComponent(selectLecciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Tematica)
                    .addComponent(txtContacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tematica1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nombre(s)", "Género", "Grupo", "Lecciones", "Contacto", "Fecha"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnVolver.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-32.png"))); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(388, 388, 388)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtContactoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        Principal volver = new Principal();
        volver.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiar();
        indiceSeleccionado = -1;
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
         guardarMaestro();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void selectGrupoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGrupoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectGrupoActionPerformed

    private void selectLeccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectLeccionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectLeccionesActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizarMaestro();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void selectGenero1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectGenero1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_selectGenero1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroMaestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroMaestro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Auxilair;
    private javax.swing.JLabel Grupo;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel Tematica;
    private javax.swing.JLabel Tematica1;
    private javax.swing.JLabel Textobiblico;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> selectGenero1;
    private javax.swing.JComboBox<String> selectGrupo;
    private javax.swing.JComboBox<String> selectLecciones;
    private javax.swing.JTextField txtContacto;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
