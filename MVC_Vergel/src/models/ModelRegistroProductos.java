/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
    
    public void conectar(){
        try{
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Vergel","postgres","12345678");
            st = conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Error 101");   
        }
        catch(ClassNotFoundException f){
            JOptionPane.showMessageDialog(null,"error al conectar");
        }
    }
    
    public void llenarValores(){
        try {
            setProducto_ID(rs.getInt("producto_id"));
            setNombre_Producto(rs.getString("nombre_producto"));
            setTamaño(rs.getString("tamaño"));
            setPrecio_Unitario(rs.getInt("precio_unitario"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 102");   
        }
    }
    
    public void moverPrimero(){
         try {
             rs.first();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 103");
         }
     }
    public void moverUltimo(){
         try {
             rs.last();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 104");
         }
     }
    
    public void moverSiguiente(){
         try{
             if(rs.isLast() ==false){
                 rs.next();
                 llenarValores();
         }} catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 105");
         }
     }
    
    public void moverAnterior(){
         try {
             if(rs.isFirst()==false){
                 rs.previous();
                 llenarValores();} 
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 106");
         }
     }
    
    public void seleccionarTodos(){
        try {
            sql="select * from Productos;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 107");
        }
    }
    
    public void guardar(){
        try {
            sql="Insert into Productos(nombre_producto,tamaño,precio_unitario) values (?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(0,nombre_producto);
            ps.setString(1,tamaño);
            ps.setInt(2,precio_unitario);
            ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108");
        }
    }
    
    public void modificar(){
        try {
            sql="update Productos SET nombre_producto=?, tamaño=?, precio_unitario=? WHERE producto_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(0,nombre_producto);
            ps.setString(1,tamaño);
            ps.setInt(2,precio_unitario);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109");
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Productos where producto_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(0, producto_id);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110");
        }
    }
}
