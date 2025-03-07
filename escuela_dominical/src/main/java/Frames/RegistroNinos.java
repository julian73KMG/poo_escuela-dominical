package Frames;

import com.toedter.calendar.JDateChooser;
import escuela_dominical.Nino;
import javax.swing.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.Period;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.table.TableRowSorter;

public class RegistroNinos extends javax.swing.JFrame {
    public ArrayList<Nino> listaNinos;
    public DefaultTableModel modeloTabla;
    public int indiceSeleccionado = -1;

    public RegistroNinos() {
        setTitle("Registro de Niños");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        initComponents();
        cerrar();
        
        listaNinos = new ArrayList<>();
        modeloTabla = new DefaultTableModel(new String[]
        {"Nombre","Genero","Fecha de Nacimiento", "Edad", "Acudiente", "Contacto", "Grupo", "Fecha de Ingreso", "Asistencias", "Observaciones" },  0);
        tabla_ninos.setModel(modeloTabla);
        
        tabla_ninos.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                seleccionarNino();
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
    
    
    private void guardarNino(){
        String nombre = txtNombre.getText();
        String genero = cbGenero.getSelectedItem().toString();
        String acudiente = txtAcudiente.getText();
        String contacto = txtcontacto.getText();
        String grupo = cbGrupo.getSelectedItem().toString();
        String asistencia = txtAsistencias.getText();
        String observaciones = txtObservaciones.getText();
        
        //Validar y convertir la fecha
        Date fechaNacimientoSeleccionada = jDateChooser1.getDate();
        Date fechaIngresoSeleccionada = jDateChooser2.getDate();
        
       if(fechaNacimientoSeleccionada == null || fechaIngresoSeleccionada == null){
            JOptionPane.showMessageDialog(this, "Selecciona una fecha válida.");
            return;
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaN = formato.format(fechaNacimientoSeleccionada);
        String fechaI = formato.format(fechaIngresoSeleccionada);

        if(nombre.isEmpty() || contacto.isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        
       LocalDate fechaNacimiento = fechaNacimientoSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();

        Nino nuevoNino = new Nino(nombre, genero, fechaNacimiento.getYear(), fechaNacimiento.getMonthValue(), fechaNacimiento.getDayOfMonth(), contacto, acudiente);
        listaNinos.add(nuevoNino);
        modeloTabla.addRow(new Object[]{
           nombre, genero, fechaN, edad, acudiente, contacto, grupo, fechaI, asistencia, observaciones
        });
        limpiar();
        
    }
    
    
    private void actualizarNino(){
        if(indiceSeleccionado == -1){
            JOptionPane.showMessageDialog(this, "Seleccione un Niño para actualizar.");
            return;
        }
        String nombre = txtNombre.getText();
        String genero = cbGenero.getSelectedItem().toString();
        String acudiente = txtAcudiente.getText();
        String contacto = txtcontacto.getText();
        String grupo = cbGrupo.getSelectedItem().toString();
        String asistencia = txtAsistencias.getText();
        String observaciones = txtObservaciones.getText();
            
        //Validar y convertir la fecha
        Date fechaNacimientoSeleccionada = jDateChooser1.getDate();
        Date fechaIngresoSeleccionada = jDateChooser2.getDate();
        
        if(fechaNacimientoSeleccionada == null || fechaIngresoSeleccionada == null){
            JOptionPane.showMessageDialog(this, "Selecciona una fecha válida.");
            return;
        }

        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaN = formato.format(fechaNacimientoSeleccionada);
        String fechaI = formato.format(fechaIngresoSeleccionada);

        if(nombre.isEmpty() || contacto.isEmpty()){
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.");
            return;
        }
        
        LocalDate fechaNacimiento = fechaNacimientoSeleccionada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // Calcular la edad
        int edad = Period.between(fechaNacimiento, LocalDate.now()).getYears();
        
        Nino nino = listaNinos.get(indiceSeleccionado);
        nino.actualizarContacto(contacto);
        int asistenciasPrevias = Integer.parseInt(modeloTabla.getValueAt(indiceSeleccionado, 8).toString());
        int nuevasAsistencias = asistenciasPrevias + 1;
        
        modeloTabla.setValueAt(nombre, indiceSeleccionado, 0);
        modeloTabla.setValueAt(genero, indiceSeleccionado, 1);
        modeloTabla.setValueAt(fechaN, indiceSeleccionado, 2);
        modeloTabla.setValueAt(edad, indiceSeleccionado, 3);
        modeloTabla.setValueAt(acudiente, indiceSeleccionado, 4);
        modeloTabla.setValueAt(contacto, indiceSeleccionado, 5);
        modeloTabla.setValueAt(grupo, indiceSeleccionado, 6);
        modeloTabla.setValueAt(fechaI, indiceSeleccionado, 7);
        modeloTabla.setValueAt(asistencia, indiceSeleccionado, 8);
        modeloTabla.setValueAt(observaciones, indiceSeleccionado, 9);
        
        limpiar();
        indiceSeleccionado = -1;
        
    }
    
    private void seleccionarNino(){
        int fila = tabla_ninos.getSelectedRow();
        if(fila != -1){
            indiceSeleccionado = fila;
            txtNombre.setText(modeloTabla.getValueAt(fila, 0).toString()); //Nombre 0 
            cbGenero.setSelectedItem(modeloTabla.getValueAt(fila, 1).toString()); //Genero 1
            
            try {
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                Date fechaNac = formato.parse(modeloTabla.getValueAt(fila, 2).toString());
                jDateChooser1.setDate(fechaNac);
                Date fechaIng = formato.parse(modeloTabla.getValueAt(fila, 7).toString());
                jDateChooser2.setDate(fechaIng);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Error al convertir la fecha.");
            }//Fecha de Nacimiento 2
            
            //edad.setText(modeloTabla.getValueAt(ERROR, fila));//Edad 3
            txtAcudiente.setText(modeloTabla.getValueAt(fila, 4).toString());
            txtcontacto.setText(modeloTabla.getValueAt(fila, 5).toString());
            cbGrupo.setSelectedItem(modeloTabla.getValueAt(fila, 6).toString());
            txtAsistencias.setText(modeloTabla.getValueAt(fila, 8).toString());
            txtObservaciones.setText(modeloTabla.getValueAt(fila, 9).toString());
        }
    }
    
    private void buscarNino(){
        String textoBusqueda = txtbusqueda.getText().toLowerCase();
        int coincidencias = 0;
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(modeloTabla);
        tabla_ninos.setRowSorter(sorter);
        sorter.setRowFilter(RowFilter.regexFilter("(?i)" + textoBusqueda, 0));

        for (int i = 0; i < modeloTabla.getRowCount(); i++) {
            if (modeloTabla.getValueAt(i, 0).toString().toLowerCase().contains(textoBusqueda)) {
                coincidencias++;
            }
        }
        jTextField15.setText(String.valueOf(coincidencias));
    }

    void limpiar() {
        txtNombre.setText("");
        cbGenero.setSelectedIndex(0);
        jDateChooser1.setDate(null);
        txtAcudiente.setText("");
        txtcontacto.setText("");
        cbGrupo.setSelectedIndex(0);
        jDateChooser2.setDate(null);
        txtAsistencias.setText("");
        txtObservaciones.setText("");
        
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
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        cbGenero = new javax.swing.JComboBox<>();
        txtcontacto = new javax.swing.JTextField();
        txtAcudiente = new javax.swing.JTextField();
        cbGrupo = new javax.swing.JComboBox<>();
        txtAsistencias = new javax.swing.JTextField();
        txtObservaciones = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_ninos = new javax.swing.JTable();
        jLabel19 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Nirmala UI", 1, 36)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/student_837825 (1).png"))); // NOI18N
        jLabel1.setText("Registrar Niños");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Registrar niño", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Historic", 1, 18))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel3.setText("Nombre Completo:");

        jLabel4.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel4.setText("G:énero");

        jLabel5.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento:");

        jLabel8.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel8.setText("Contacto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel9.setText("Acudiente:");

        jLabel10.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel10.setText("Grupo:");

        jLabel11.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel11.setText("Fecha de Ingreso:");

        jLabel13.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel13.setText("Asistencias:");

        jLabel14.setFont(new java.awt.Font("Segoe UI Historic", 1, 14)); // NOI18N
        jLabel14.setText("Observaciones:");

        cbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Escoja", "Femenino", "Masculino", "No binario", "Otro", "No responde" }));
        cbGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGeneroActionPerformed(evt);
            }
        });

        cbGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jButton1.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-plus-48 (1).png"))); // NOI18N
        jButton1.setText(" Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        jButton4.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-32.png"))); // NOI18N
        jButton4.setText("Volver");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtObservaciones, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(txtAsistencias, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtcontacto, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(txtAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbGenero, cbGrupo, jDateChooser1, jDateChooser2, txtAcudiente, txtAsistencias, txtNombre, txtObservaciones, txtcontacto});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtAcudiente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtcontacto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbGrupo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtAsistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnGuardar)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabla_ninos.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tabla_ninos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Género", "Fecha de Nacimiento", "Edad", "Acudiente", "Contacto", "Grupo", "Fecha de Ingreso", "Asistencias", "Observaciones"
            }
        ));
        tabla_ninos.setDragEnabled(true);
        tabla_ninos.setName(""); // NOI18N
        tabla_ninos.setShowGrid(false);
        tabla_ninos.setShowHorizontalLines(true);
        jScrollPane1.setViewportView(tabla_ninos);

        jLabel19.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel19.setText("Buscar:");

        txtbusqueda.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Segoe UI Historic", 0, 18)); // NOI18N
        jLabel20.setText("Cantidad: ");

        jTextField15.setEditable(false);
        jTextField15.setFont(new java.awt.Font("Segoe UI Historic", 0, 14)); // NOI18N
        jTextField15.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jTextField15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel19)
                                .addGap(18, 18, 18)
                                .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(58, 58, 58)
                                .addComponent(jLabel20)
                                .addGap(76, 76, 76)
                                .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 89, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(392, 392, 392)
                        .addComponent(jLabel1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20)
                            .addComponent(jTextField15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusquedaActionPerformed

    }//GEN-LAST:event_txtbusquedaActionPerformed

    private void jTextField15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField15ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Principal volver = new Principal();
        volver.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarNino();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbGeneroActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
    actualizarNino();
    }//GEN-LAST:event_btnActualizarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroNinos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroNinos().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cbGenero;
    private javax.swing.JComboBox<String> cbGrupo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTable tabla_ninos;
    private javax.swing.JTextField txtAcudiente;
    private javax.swing.JTextField txtAsistencias;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtObservaciones;
    private javax.swing.JTextField txtbusqueda;
    private javax.swing.JTextField txtcontacto;
    // End of variables declaration//GEN-END:variables

    //void mostrarTabla(String valor) {
//    DefaultTableModel modelo = (DefaultTableModel) tabla_ninos.getModel();
//    modelo.setRowCount(0); // Limpiar tabla antes de cargar los datos filtrados
//
//    String sql = "SELECT * FROM ninos WHERE nombre LIKE ? OR acudiente LIKE ?";
//
//    try (Connection conn = Conectar.conectar();
//         PreparedStatement pst = conn.prepareStatement(sql)) {
//        
//        pst.setString(1, "%" + valor + "%");
//        pst.setString(2, "%" + valor + "%");
//        ResultSet rs = pst.executeQuery();
//
//        while (rs.next()) {
//            Object[] fila = {
//                rs.getInt("id"),
//                rs.getString("nombre"),
//                rs.getString("genero"),
//                rs.getString("fecha_nacimiento"),
//                rs.getInt("edad"),
//                rs.getString("contacto"),
//                rs.getString("acudiente"),
//                rs.getString("grupo"),
//                rs.getString("fecha_ingreso"),
//                rs.getString("asistencias"),
//                rs.getString("observaciones")
//            };
//            modelo.addRow(fila);
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
//    }
//}
//
//
//public final void cargarTabla() {
//    DefaultTableModel modelo = (DefaultTableModel) tabla_ninos.getModel();
//    modelo.setRowCount(0); // Limpiar tabla antes de cargar datos
//
//    String sql = "SELECT * FROM ninos"; // Sin filtros, carga todo
//
//    try (Connection conn = Conectar.conectar();
//         PreparedStatement pst = conn.prepareStatement(sql);
//         ResultSet rs = pst.executeQuery()) {
//
//        while (rs.next()) {
//            Object[] fila = {
//                rs.getInt("id"),
//                rs.getString("nombre"),
//                rs.getString("genero"),
//                rs.getString("fecha_nacimiento"),
//                rs.getInt("edad"),
//                rs.getString("contacto"),
//                rs.getString("acudiente"),
//                rs.getString("grupo"),
//                rs.getString("fecha_ingreso"),
//                rs.getString("asistencias"),
//                rs.getString("observaciones")
//            };
//            modelo.addRow(fila);
//        }
//    } catch (SQLException e) {
//        JOptionPane.showMessageDialog(this, "Error al cargar los datos: " + e.getMessage());
//    }
//}
//
}
