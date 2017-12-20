
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Vicente Arteaga
 */
public class ModelRegistroProductos {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int producto_id;
    private String nombre_producto;
    private String tamaño;
    private int precio_unitario;
    private TableModel tabla;
    
    public void setProducto_ID(int producto_id){
        this.producto_id = producto_id;
    }
    
    public void setNombre_Producto(String nombre_producto){
        this.nombre_producto = nombre_producto;
    }
    
    public void setTamaño(String tamaño){
        this.tamaño = tamaño;
    }
    
    public void setPrecio_Unitario(int precio_unitario){
        this.precio_unitario = precio_unitario;
    }
    
    public int getProducto_ID(){
        return producto_id;
    }
    
    public String getNombre_Producto(){
        return nombre_producto;
    }
    
    public String getTamaño(){
        return tamaño;
    }
    
    public int getPrecio_Unitario(){
        return precio_unitario;
    }

    public TableModel getTabla() {
        return tabla;
    }
    
        
    public void conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/VergelActual", "root", "ninoinkieto1");
            st = conexion.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 101 Prodcutos" + ex);
        }
    }
    
    public void llenarValores(){
        try {
            setProducto_ID(rs.getInt("producto_id"));
            setNombre_Producto(rs.getString("nombre_producto"));
            setTamaño(rs.getString("tamaño"));
            setPrecio_Unitario(rs.getInt("precio_unitario"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 102 Prodcutos");   
        }
    }
    
    public void tabla(){
    try{
        conectar();
        rs=st.executeQuery("Select * from Productos;");
        tabla= DbUtils.resultSetToTableModel(rs);
        seleccionarTodos();
        llenarValores();
    } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err);
        }
    }
    
    public void moverPrimero(){
         try {
             rs.first();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 103 Prodcutos"+ex);
         }
     }
    public void moverUltimo(){
         try {
             rs.last();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 104 Prodcutos"+ex);
         }
     }
    
    public void moverSiguiente(){
         try{
             if(rs.isLast() ==false){
                 rs.next();
                 llenarValores();
         }} catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 105 Prodcutos"+ex);
         }
     }
    
    public void moverAnterior(){
         try {
             if(rs.isFirst()==false){
                 rs.previous();
                 llenarValores();} 
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 106 Prodcutos"+ex);
         }
     }
    
    public void seleccionarTodos(){
        try {
            conectar();
            sql="select * from Productos;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 107 Prodcutos"+ex);
        }
    }
    
    public void guardar(){
        try {
            sql="Insert into Productos(nombre_producto,tamaño,precio_unitario) values (?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_producto);
            ps.setString(2,tamaño);
            ps.setInt(3,precio_unitario);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108 Prodcutos"+ex);
        }
    }
    
    public void modificar(){
        try {
            sql="update Productos SET nombre_producto=?, tamaño=?, precio_unitario=? WHERE producto_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_producto);
            ps.setString(2,tamaño);
            ps.setInt(3,precio_unitario);
            ps.setInt(4, producto_id);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109 Prodcutos"+ex);
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Productos where producto_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(1, producto_id);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110 Prodcutos"+ex);
        }
    }
}
