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

public class ModelRegistroCargo {
    
    private int cargo_id;
    private String cargo;
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    public void setCargo_id(int cargo_id){
        this.cargo_id = cargo_id;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public int getCargo_id(){
        return cargo_id;
    }
    
    public String getCargo(){
        return cargo;
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
            setCargo_id(rs.getInt("cargo_id"));
            setCargo(rs.getString("cargo"));
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
            sql="Insert into Cargo(cargo) values (?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,cargo);
            ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108");
        }
    }
    
    public void modificar(){
        try {
            sql="update Cargo SET cargo=? WHERE cargo_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,cargo);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109");
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Cargo where cargo_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1, cargo);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110");
        }
    }
    
    
}
