package models;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

public class ModelRegistroEmpleados {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    
    private int empleado_id;
    private String nombre_empleado;
    private String apellido_paterno;
    private String apellido_materno;
    private int edad;
    private String telefono;
    private String genero;
    private String cargo;
    private String direccion;
    private TableModel tabla;
    
    public void setEmpleado_id(int empleado_id){
        this.empleado_id = empleado_id;
    }
    
    public void setNombre_Empleado(String nombre_empleado){
        this.nombre_empleado = nombre_empleado;
    }
    
    public void setApellido_Paterno(String apellido_paterno){
        this.apellido_paterno = apellido_paterno;
    }
    
    public void setApellido_Materno(String apellido_materno){
        this.apellido_materno = apellido_materno;
    }
    
    public void setEdad(int edad){
        this.edad = edad;
    }
    
    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setGenero(String genero){
        this.genero = genero;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    public void setDireccion(String direccion){
        this.direccion = direccion;
    }
    
    public int getEmpleado_id(){
        return empleado_id;
    }
    
    public String getNombre_Empleado(){
        return nombre_empleado;
    }
    
    public String getApellido_Paterno(){
        return apellido_paterno;
    }
    
    public String getApellido_Materno(){
        return apellido_materno;
    }
    
    public int getEdad(){
        return edad;
    }
    
    public String getTelefono(){
        return telefono;
    }
    
    public String getGenero(){
        return genero;
    }
    
    public String getCargo(){
        return cargo;
    }
    
    public String getDireccion(){
        return direccion;
    }

    public TableModel getTabla() {
        return tabla;
    }
     
    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/VergelActual", "root", "ninoinkieto1");
            st = conexion.createStatement();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error 101: No conceta la base de datos Empleados"+err);
        }
    }
    public void llenarValores(){
        try {
            setEmpleado_id(rs.getInt("empleado_id"));
            setNombre_Empleado(rs.getString("nombre_empleado"));
            setApellido_Paterno(rs.getString("apellido_paterno"));
            setApellido_Materno(rs.getString("apellido_materno"));
            setEdad(rs.getInt("edad"));
            setGenero(rs.getString("genero"));
            setDireccion(rs.getString("direccion"));
            setTelefono(rs.getString("telefono"));
            setCargo(rs.getString("cargo_id"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error 102 Empledaos" + ex);
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
    
    public void seleccionarTodos(){
        try {
            Conectar();
            sql="select * from Empleado;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 107"+ex);
        }
    }
    
    public void guardar(){
        try {
            sql="Insert into Empleado(nombre_empleado,apellido_paterno,apellido_materno,edad,telefono,cargo_id,genero,direccion) values (?,?,?,?,?,?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_empleado);
            ps.setString(2,apellido_paterno);
            ps.setString(3,apellido_materno);
            ps.setInt(4,edad);
            ps.setString(5,telefono);
            ps.setString(6,cargo);
            ps.setString(7,genero);
            ps.setString(8,direccion);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108"+ex);
        }
    }
    
    public void modificar(){
        try {
            sql="update Empleado SET nombre_empleado=?,apellido_paterno=?,apellido_materno=?,edad=?,telefono=?,cargo_id=?,genero=?,direccion=? WHERE empleado_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,nombre_empleado);
            ps.setString(2,apellido_paterno);
            ps.setString(3,apellido_materno);
            ps.setInt(4,edad);
            ps.setString(5,telefono);
            ps.setString(6,genero);
            ps.setString(7,direccion);
            ps.setString(8,cargo);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109"+ex);
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Empleado where empleado_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(1, empleado_id);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110"+ex);
        }
    }
    
        public void tabla(){
    try{
        Conectar();
        rs=st.executeQuery("Select * from Empleado;");
        tabla= DbUtils.resultSetToTableModel(rs);
        seleccionarTodos();
        llenarValores();
    } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err);
        }
    }
        
        public void LlenarComboBox(javax.swing.JComboBox jcb_cargo){
            try {
                Conectar();
                sql= "select cargo from Cargo;";
                ps=conexion.prepareStatement(sql);
                rs=ps.executeQuery();
                jcb_cargo.removeAllItems();
                while(rs.next()){
                    jcb_cargo.addItem(rs.getString("cargo"));
                }
            } catch (Exception e) {
                //
            }
}
}
