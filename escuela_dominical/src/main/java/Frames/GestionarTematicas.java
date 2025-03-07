package Frames;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import escuela_dominical.Tematica;
import escuela_dominical.Leccion;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import escuela_dominical.ActividadLudica;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JTable;


public class GestionarTematicas extends javax.swing.JFrame{

    public GestionarTematicas() {
        initComponents();
        cerrar();
        
       cmb_tematicas.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String nombreTematica = (String) cmb_tematicas.getSelectedItem();
        Tematica tematicaSeleccionada = buscarTematica(nombreTematica);
        actualizarTablaActividadesLudicas(tematicaSeleccionada);
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


    
    private Tematica buscarTematica(String nombre) {
    for (Tematica tematica : listaTematicas) {
        if (tematica.titulo.equalsIgnoreCase(nombre)) {
            return tematica;
        }
    }
    return null;
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop_borrar = new javax.swing.JPopupMenu();
        pop_eliminar = new javax.swing.JMenuItem();
        lbl_titulo = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre_tematica = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        cmb_tematicas = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_lecciones = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        table_actividades = new javax.swing.JTable();
        btn_volver = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_agregar_act = new javax.swing.JButton();
        cmb_tematicas_act = new javax.swing.JComboBox<>();
        txt_actividad = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        pop_eliminar.setText("jMenuItem1");
        pop_borrar.add(pop_eliminar);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));

        lbl_titulo.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        lbl_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_titulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-elective-100 (1).png"))); // NOI18N
        lbl_titulo.setText("Gestionar Tematicas");
        lbl_titulo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbl_tituloPropertyChange(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Temáticas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel2.setText("Nombre temática:");

        txt_nombre_tematica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nombre_tematicaActionPerformed(evt);
            }
        });

        btn_agregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-plus-48 (1).png"))); // NOI18N
        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_agregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nombre_tematica, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre_tematica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(btn_agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        cmb_tematicas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmb_tematicas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una temática" }));
        cmb_tematicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tematicasActionPerformed(evt);
            }
        });

        tbl_lecciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Lecciones"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_lecciones.setComponentPopupMenu(pop_borrar);
        tbl_lecciones.setPreferredSize(new java.awt.Dimension(80, 20));
        jScrollPane5.setViewportView(tbl_lecciones);

        table_actividades.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Actividades Ludicas"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_actividades.setComponentPopupMenu(pop_borrar);
        jScrollPane6.setViewportView(table_actividades);

        btn_volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-back-32.png"))); // NOI18N
        btn_volver.setText("Volver");
        btn_volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_volverActionPerformed(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Actividades Lúdicas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel3.setText("Nombre temática:");

        btn_agregar_act.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/icons8-plus-48 (1).png"))); // NOI18N
        btn_agregar_act.setText("Agregar");
        btn_agregar_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregar_actActionPerformed(evt);
            }
        });

        cmb_tematicas_act.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Elige una temática" }));
        cmb_tematicas_act.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_tematicas_actActionPerformed(evt);
            }
        });

        txt_actividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_actividadActionPerformed(evt);
            }
        });

        jLabel4.setText("Descripción:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_agregar_act, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_actividad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmb_tematicas_act, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 207, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_tematicas_act, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_actividad)
                .addGap(18, 18, 18)
                .addComponent(btn_agregar_act)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(lbl_titulo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_volver)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmb_tematicas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_titulo)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cmb_tematicas, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58)
                        .addComponent(btn_volver)
                        .addGap(6, 6, 6))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
// </editor-fold>                        

private void actualizarTablaActividadesLudicas(Tematica tematicaSeleccionada) {
    DefaultTableModel model = (DefaultTableModel) table_actividades.getModel();
    model.setRowCount(0); // Limpiar la tabla antes de llenarla

    if (tematicaSeleccionada == null) {
        System.out.println("No hay temática seleccionada.");
        return;
    }

    System.out.println("Llenando tabla de actividades para la temática: " + tematicaSeleccionada.titulo);

    for (ActividadLudica actividad : tematicaSeleccionada.actividadesLudicas) {
        Object[] fila = {actividad.descripcion};
        model.addRow(fila);
    }
    
    
}


    private void txt_nombre_tematicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nombre_tematicaActionPerformed
 
        String nombre = txt_nombre_tematica.getText().trim();

        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Tematica nuevaTematica = new Tematica(nombre);
        listaTematicas.add(nuevaTematica); // Suponiendo que tienes una lista global
        cmb_tematicas.addItem(nombre);
        cmb_tematicas_act.addItem(nombre);

        JOptionPane.showMessageDialog(null, "Temática agregada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_txt_nombre_tematicaActionPerformed

    private void cmb_tematicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tematicasActionPerformed

// Verificar que haya un elemento seleccionado
    String nombreTematica = (String) cmb_tematicas.getSelectedItem();
    if (nombreTematica == null || listaTematicas == null || listaTematicas.isEmpty()) {
        return; // No hay selección o la lista está vacía, no hacemos nada
    }

    // Buscar la temática en la lista
    Tematica tematicaSeleccionada = listaTematicas.stream()
            .filter(t -> nombreTematica.equalsIgnoreCase(t.titulo))
            .findFirst()
            .orElse(null);

    // Si encontramos la temática, llenamos la tabla con sus lecciones
    if (tematicaSeleccionada != null) {
        llenarTablaLecciones(tematicaSeleccionada);
    } else {
        JOptionPane.showMessageDialog(this.cmb_tematicas, "No se encontró la temática seleccionada.");
    }


    }//GEN-LAST:event_cmb_tematicasActionPerformed
private void llenarTablaLecciones(Tematica tematica) {
    limpiarTabla(tbl_lecciones);
    DefaultTableModel model1 = (DefaultTableModel) tbl_lecciones.getModel();
    model1.setRowCount(0); // Limpiar la tabla antes de agregar datos

    // Iteramos sobre los valores del HashMap (las lecciones)
    for (Leccion leccion : tematica.lecciones.values()) {
        model1.addRow(new Object[]{leccion.nombre, leccion.fecha});
    }
}
private void limpiarTabla(JTable tabla) {
    DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
    modelo.setRowCount(0); // Elimina todas las filas
}

public void actualizarTematica(JComboBox<String> cmb_tematicas, DefaultTableModel modelo, ArrayList<Tematica> tematicas) {
    // Obtener el índice seleccionado en el JComboBox
    int indiceSeleccionado = cmb_tematicas.getSelectedIndex();
    
    if (indiceSeleccionado != -1) { // Verificar que haya algo seleccionado
        String nuevoTitulo = JOptionPane.showInputDialog("Ingrese el nuevo título:");

        if (nuevoTitulo != null && !nuevoTitulo.trim().isEmpty()) {
            // Actualizar el objeto en el ArrayList
            tematicas.get(indiceSeleccionado).actualizarDatos(nuevoTitulo);

            // Actualizar el JComboBox con el nuevo título
            cmb_tematicas.removeItemAt(indiceSeleccionado);
            cmb_tematicas.insertItemAt(nuevoTitulo, indiceSeleccionado);
            cmb_tematicas.setSelectedIndex(indiceSeleccionado);

            // Actualizar la tabla si existe
            if (modelo != null) {
                modelo.setValueAt(nuevoTitulo, indiceSeleccionado, 0); // Suponiendo que el título está en la columna 0
            }

            JOptionPane.showMessageDialog(null, "Temática actualizada correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "El título no puede estar vacío.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Seleccione una temática para actualizar.");
    }
}
private void actualizarComboBox() {
    cmb_tematicas.removeAllItems(); // Limpiar el JComboBox
    cmb_tematicas_act.removeAllItems(); // Limpiar el segundo JComboBox

    for (Tematica tematica : listaTematicas) {
        cmb_tematicas.addItem(tematica.titulo);
        cmb_tematicas_act.addItem(tematica.titulo); 
    }
}

private void agregarTematica() {
    String nombre = txt_nombre_tematica.getText().trim();

    if (nombre.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Todos los campos deben estar llenos", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Verificar si la temática ya existe en la lista
    for (Tematica tematica : listaTematicas) {
        if (tematica.titulo.equalsIgnoreCase(nombre)) {
            JOptionPane.showMessageDialog(this, "Esta temática ya existe", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    // Crear y agregar la nueva temática
    Tematica nuevaTematica = new Tematica(nombre);
    listaTematicas.add(nuevaTematica);

    // Actualizar el JComboBox
    actualizarComboBox();

    // Limpiar los campos
    txt_nombre_tematica.setText("");

    JOptionPane.showMessageDialog(this, "Temática agregada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
}
private void agregarActividadLudica() {
    // Obtener la temática seleccionada en el ComboBox
    String nombreTematica = (String) cmb_tematicas_act.getSelectedItem();
    String descripcion = txt_actividad.getText().trim();

    // Validar que los campos no estén vacíos
    if (nombreTematica == null || nombreTematica.isEmpty() || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una temática y escribir una descripción.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar la temática en la lista
    Tematica tematicaSeleccionada = listaTematicas.stream()
            .filter(t -> t.titulo.equalsIgnoreCase(nombreTematica))
            .findFirst()
            .orElse(null);

    if (tematicaSeleccionada == null) {
        JOptionPane.showMessageDialog(this, "No se encontró la temática seleccionada.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // **Verificar si la actividad ya existe en la lista de la temática**
    boolean existe = tematicaSeleccionada.actividadesLudicas.stream()
            .anyMatch(act -> act.descripcion.equalsIgnoreCase(descripcion));

    if (existe) {
        JOptionPane.showMessageDialog(this, "Actividad agregada con éxito.", "Error", JOptionPane.PLAIN_MESSAGE);
        return;
    }

    // **Si no existe, agregar la nueva actividad**
    ActividadLudica nuevaActividad = new ActividadLudica(tematicaSeleccionada);
    nuevaActividad.actualizarDescripcion(descripcion);
    tematicaSeleccionada.agregarActividadLudica(nuevaActividad);

    // **Actualizar la tabla**
    actualizarTablaActividadesLudicas(tematicaSeleccionada);

    // Limpiar el campo de texto
    txt_actividad.setText("");

    JOptionPane.showMessageDialog(this, "Actividad agregada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
}




    private void lbl_tituloPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbl_tituloPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_lbl_tituloPropertyChange

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
    String nombreTematica = txt_nombre_tematica.getText().trim();
    

    if (nombreTematica == null) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una temática", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar la temática y agregar la actividad lúdica
    for (Tematica tematica : listaTematicas) {
        if (tematica.titulo.equalsIgnoreCase(nombreTematica)) {
            ActividadLudica act = new ActividadLudica(tematica);
            tematica.agregarActividadLudica(act);
            break;
        }
    }
    
    // Limpiar el campo de texto
    txt_actividad.setText("");
    agregarTematica();
    
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void btn_volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_volverActionPerformed
       Principal volver = new Principal();
        volver.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_volverActionPerformed

    private void btn_agregar_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregar_actActionPerformed
    
    String nombreTematica = (String) cmb_tematicas_act.getSelectedItem();
    String descripcion = txt_actividad.getText().trim();
    

    if (nombreTematica == null || descripcion.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una temática y escribir una descripción.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Buscar la temática
    for (Tematica tematica : listaTematicas) {
        if (tematica.titulo.equalsIgnoreCase(nombreTematica)) {
            ActividadLudica act;
            act = new ActividadLudica(tematica);
            tematica.agregarActividadLudica(act);
            act.actualizarDescripcion(descripcion);
            break;
        }
    }

    
    agregarActividadLudica();
    // Limpiar el campo de texto
    txt_actividad.setText("");
    
    }//GEN-LAST:event_btn_agregar_actActionPerformed

    private void cmb_tematicas_actActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_tematicas_actActionPerformed
     // Verificar que haya un elemento seleccionado
    String nombreTematica = (String) cmb_tematicas_act.getSelectedItem();
    if (nombreTematica == null || listaTematicas == null || listaTematicas.isEmpty()) {
        return; // No hay selección o la lista está vacía, no hacemos nada
    }

    // Buscar la temática en la lista
    Tematica tematicaSeleccionada = listaTematicas.stream()
            .filter(t -> nombreTematica.equalsIgnoreCase(t.titulo))
            .findFirst()
            .orElse(null);

    // Si encontramos la temática, llenamos la tabla con sus lecciones
    if (tematicaSeleccionada != null) {
        llenarTablaLecciones(tematicaSeleccionada);
    } else {
        JOptionPane.showMessageDialog(this.cmb_tematicas_act, "No se encontró la temática seleccionada.");
    }


    }//GEN-LAST:event_cmb_tematicas_actActionPerformed

    private void txt_actividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_actividadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_actividadActionPerformed
private HashMap<String, ArrayList<String>> actividadesPorTematica;
ArrayList<Tematica> listaTematicas = new ArrayList<>();
ArrayList<Leccion> listaLecciones = new ArrayList<>();
public static void main(String[] args) {
        // Iniciar la ventana principal
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionarTematicas().setVisible(true);
            }
        });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_agregar_act;
    private javax.swing.JButton btn_volver;
    public javax.swing.JComboBox<String> cmb_tematicas;
    public javax.swing.JComboBox<String> cmb_tematicas_act;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbl_titulo;
    private javax.swing.JPopupMenu pop_borrar;
    private javax.swing.JMenuItem pop_eliminar;
    public javax.swing.JTable table_actividades;
    public javax.swing.JTable tbl_lecciones;
    public javax.swing.JTextField txt_actividad;
    public javax.swing.JTextField txt_nombre_tematica;
    // End of variables declaration//GEN-END:variables
}