package vista;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import conexion.Conexion;
import controlador.Ctrl_Categoria;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelo.Categoria;


public class InterGestionarCategoria extends javax.swing.JInternalFrame {
    
    private int idCategoria;
    
    public InterGestionarCategoria() {
        initComponents();
        
        setSize(new Dimension(600,400));
        this.setTitle("Gestionar Categorias");
        
        this.CargarTablaCategotia();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_categorias = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_descripcion = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 130, 80));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Administrar Categorias");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 230, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categorias.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_categorias);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Descripcion:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_descripcion.setFont(new java.awt.Font("Trebuchet MS", 2, 12)); // NOI18N
        jPanel3.add(txt_descripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 190, 80));

        jLabel_wallpaper.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo3.jpg"))); // NOI18N
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(-3, -4, 600, 370));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        
        if(!txt_descripcion.getText().isEmpty()){
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
            categoria.setDescripcion(txt_descripcion.getText().trim());
            
            if(controlCategoria.actualizar(categoria, idCategoria)){
                JOptionPane.showMessageDialog(null,"Categoria actualizada correctamente");
                txt_descripcion.setText("");
                this.CargarTablaCategotia();
            }else{
                JOptionPane.showMessageDialog(null,"Error al actualizar categoria");
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Selecione una categoria");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        
        if(!txt_descripcion.getText().isEmpty()){
            Categoria categoria = new Categoria();
            Ctrl_Categoria controlCategoria = new Ctrl_Categoria();
            categoria.setDescripcion(txt_descripcion.getText().trim());
            if(!controlCategoria.eliminar(idCategoria)){
                JOptionPane.showMessageDialog(null,"Categoria eliminada correctamente");
                txt_descripcion.setText("");
                this.CargarTablaCategotia();
            }else{
                JOptionPane.showMessageDialog(null,"Error al eliminar categoria");

            }
        }else{
            JOptionPane.showMessageDialog(null,"Selecione una categoria");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_categorias;
    private javax.swing.JTextField txt_descripcion;
    // End of variables declaration//GEN-END:variables

    /*
    * Metodo para mostrar todas las categorias registradas
    *
    */
    
    private void CargarTablaCategotia() {
        Connection con = (Connection) Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select idCategoria, descripcion, estado from tb_categoria";
        Statement st;
        try {
            st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarCategoria.jTable_categorias = new JTable(model);
            InterGestionarCategoria.jScrollPane1.setViewportView(InterGestionarCategoria.jTable_categorias);
            model.addColumn("idCategoria");
            model.addColumn("descripcion");
            model.addColumn("estado");
            while (rs.next()) {
                Object fila[] = new Object[3];

                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro al guardar la tabla categorias" + e);
        }

        jTable_categorias.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked (MouseEvent e){
                int fila_point = jTable_categorias.rowAtPoint(e.getPoint());
                int columnta_point = 0;
                
                if(fila_point >  -1 ){
                    idCategoria = (int) model.getValueAt(fila_point, columnta_point);
                    EnviarDatosCategoriaSeleccionada(idCategoria);
                }
            }

        });
    

        
    }

    
    private void EnviarDatosCategoriaSeleccionada (int idCategoria){
        try{
            Connection con = (Connection) Conexion.conectar();
            PreparedStatement pst = (PreparedStatement) con.prepareStatement("select * from tb_categoria where idCategoria = '"+idCategoria + "'");
            ResultSet rs = pst.executeQuery();
            if(rs.next()){
                txt_descripcion.setText(rs.getString("descripcion"));
            }
            con.close();
            
        } catch(SQLException e){
            System.out.println("Error al seleccionar categoria: "+ e);
        }
        
    }

}
