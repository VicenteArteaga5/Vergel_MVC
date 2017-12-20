
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

public class ModelRegistroCargo {
    
    private int cargo_id;
    private String cargo;
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    private TableModel tabla;
    
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

    public TableModel getTabla() {
        return tabla;
    }
    
    public void conectar(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/VergelActual", "root", "ninoinkieto1");
            st = conexion.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101: No conceta la base de datos Cargo"+e);
        }
    }
    
    public void llenarValores(){
        try {
            setCargo_id(rs.getInt("cargo_id"));
            setCargo(rs.getString("cargo"));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 102" + ex);   
        }
    }
    public void seleccionarTodos(){
        try {
            conectar();
            sql="select * from Cargo;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 107"+ex);
        }
    }
    
        public void tabla(){
    try{
        conectar();
        rs=st.executeQuery("Select * from Cargo;");
        tabla= DbUtils.resultSetToTableModel(rs);
    } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err);
        }
    }
    
    public void moverPrimero(){
         try {
             rs.first();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 103"+ex);
         }
     }
    public void moverUltimo(){
         try {
             rs.last();
             llenarValores();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 104"+ex);
         }
     }
    
    public void moverSiguiente(){
         try{
             if(rs.isLast() ==false){
                 rs.next();
                 llenarValores();
                 
         }} catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 105"+ex);
         }
     }
    
    public void moverAnterior(){
         try {
             if(rs.isFirst()==false){
                 rs.previous();
                 llenarValores();} 
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error 106"+ex);
         }
     }
    
    
    
    public void guardar(){
        try {
            sql="Insert into Cargo(cargo) values (?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,cargo);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108"+ex);
        }
    }
    
    public void modificar(){
        try {
            sql="update Cargo SET cargo=? WHERE cargo_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,cargo);
            ps.setInt(2, cargo_id);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109"+ex);
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Cargo where cargo_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(1, cargo_id);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110"+ex);
        }
    }
    
    
}
