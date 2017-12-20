
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
 * @author vicente
 */
public class ModelRegistroUsuario {
    private String usuario;
    private String contraseña;
    private int rol;
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    private PreparedStatement ps;
    private String sql;
    private TableModel tabla;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
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
            setUsuario(rs.getString("usuario"));
            setContraseña(rs.getString("contraseña"));
            setRol(rs.getInt("rol"));
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 102" + ex);   
        }
    }
    public void seleccionarTodos(){
        try {
            conectar();
            sql="select * from Usuarios;";
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
        rs=st.executeQuery("Select * from Usuarios;");
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
            sql="Insert into Usuarios(usuario,contraseña,rol) values (?,md5('?'),?);";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, contraseña);
            ps.setInt(3, rol);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 108"+ex);
        }
    }
    
    public void modificar(){
        try {
            sql="update Usuario SET contraseña=md5('?') rol=? WHERE usuario=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1,contraseña);
            ps.setInt(2, rol);
            ps.setString(3, usuario);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 109"+ex);
        }
    }
    
    public void eliminar(){
        try {
            sql="delete from Usuarios where usuario=?;";
            ps=conexion.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.executeUpdate();
            seleccionarTodos();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error 110"+ex);
        }
    }
}
