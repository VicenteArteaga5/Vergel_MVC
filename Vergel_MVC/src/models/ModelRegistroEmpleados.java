
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

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
    private int telefono;
    private String genero;
    private String cargo;
    private String direccion;
    
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
    
    public void setTelefono(int telefono){
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
    
    public int getTelefono(){
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
    
    public void Conectar() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Vergel", "root", "ninoinkieto1");
            st = conexion.createStatement();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error 101");
        }
    }
    public void llenarValores(){
        try {
            setEmpleado_id(rs.getInt("empleado_id"));
            setNombre_Empleado(rs.getString("nombre_empleado"));
            setApellido_Paterno(rs.getString("apellido_paterno"));
            setApellido_Materno(rs.getString("apellido_materno"));
            setEdad(rs.getInt("edad"));
            setTelefono(rs.getInt("telefono"));
            setGenero(rs.getString("genero"));
            setCargo(rs.getString("cargo"));
            setDireccion(rs.getString("direccion"));
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
            sql="select * from Empleados;";
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 107");
        }
    }
    
    public void guardar(){
        try {
            sql="Insert into Empleados(nombre_empleado,apellido_paterno,apellido_materno,edad,telefono,cargo,genero,direccion) values (?,?,?,?,?,?,?,?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(0,nombre_empleado);
            ps.setString(1,apellido_paterno);
            ps.setString(2,apellido_materno);
            ps.setInt(3,edad);
            ps.setInt(4,telefono);
            ps.setString(5,cargo);
            ps.setString(5,genero);
            ps.setString(7,direccion);
            ps.executeQuery();
            moverPrimero();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108");
        }
    }
    
    public void modificar(){
        try {
            sql="update Empleados SET nombre_empleado=?,apellido_paterno=?,apellido_materno=?,edad=?,telefono=?,cargo=?,genero=?,direccion=? WHERE empleado_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(0,nombre_empleado);
            ps.setString(1,apellido_paterno);
            ps.setString(2,apellido_materno);
            ps.setInt(3,edad);
            ps.setInt(4,telefono);
            ps.setString(5,cargo);
            ps.setString(5,genero);
            ps.setString(7,direccion);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109");
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Empleados where empleado_id=?;";
            ps=conexion.prepareStatement(sql);
            ps.setInt(0, empleado_id);
            ps.executeUpdate();
            moverPrimero();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110");
        }
    }
}
