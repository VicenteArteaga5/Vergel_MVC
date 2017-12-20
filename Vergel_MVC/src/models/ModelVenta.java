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
 * @author vicente
 */
public class ModelVenta {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int orden_id;
    private String nombre_producto;
    private String tamaño;
    private int precio_unitario;
    private int cantidad;
    private int precio_total;
    
    public void setOrdenID (int orden_id){
        this.orden_id= orden_id;
    }
    
    public void setNombreProducto(String nombre_producto){
        this.nombre_producto = nombre_producto;
    }
    
    public void setTamaño(String tamaño){
        this.tamaño = tamaño;
    }
    
    public void setPrecioUnitario(int precio_unitario){
        this.precio_unitario = precio_unitario;
    }
    
    public void setCantidad(int cantidad){
        this.cantidad = cantidad;
    }
    
    public void setPrecioTotal(int precio_total){
        this.precio_total = precio_total;
    }
    
    public int getOrdenID(){
        return orden_id;
    }
    
    public String getNombreProducto(){
        return nombre_producto;
    }
    
    public String getTamaño(){
        return tamaño;
    }
    
    public int getPrecioUnitario(){
        return precio_unitario;
    }
    
    public int getCantidad(){
        return cantidad;
    }
    
    public int getPrecioTotal(){
        return precio_total;
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
            setOrdenID(rs.getInt("orden_id"));
            setNombreProducto(rs.getString("nombre_producto"));
            setTamaño(rs.getNString("tamaño"));
            setPrecioUnitario(rs.getInt("precio_unitario"));
            setCantidad(rs.getInt("cantidad"));
            setPrecioTotal(rs.getInt("precio_total"));
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
            sql="Insert into Orden(nombre_producto,tamaño,precio_unitario,cantidad,precio_total) values (?,?,?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_producto);
            ps.setString(2,tamaño);
            ps.setInt(3,precio_unitario);
            ps.setInt(4, cantidad);
            ps.setInt(5, precio_total);
            ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108");
        }
    }
    
    public void modificar(){
        try {
            sql="update Orden SET nombre_producto=?, tamaño=?, precio_unitario=?, cantidad=?, precio_total=? WHERE orden_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_producto);
            ps.setString(2,tamaño);
            ps.setInt(3,precio_unitario);
            ps.setInt(4, cantidad);
            ps.setInt(5, precio_total);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109");
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Orden where orden_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(0, orden_id);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110");
        }
    }
    
}
