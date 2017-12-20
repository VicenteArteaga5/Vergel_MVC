
package models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelMain {
     private Connection conexion;
    private Statement st;
    private PreparedStatement ps;
    private ResultSet rs;
    private String sql;
    
    private MessageDigest md5;
    private StringBuilder string_builder;
    
    public void Conectar(){
         try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/VergelActual", "root", "ninoinkieto1");
            st = conexion.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error 101: No conceta la base de datos Cargo"+e);
        }
    }
    
    public void Ejecutar_Consulta() {
        try {
            Conectar();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " + e);
        }
    }
    
    public void Ejecutar_Consulta_PS() {
        try {
            rs = ps.executeQuery();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar consulta: " + e);
        }
    }

    public void Ejecutar_Actualizacion() {
        try {
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al ejecutar actualización: " + e);
        }
    }

    public void Ejecutar_Sentencia() {
        try {
            Conectar();
            st.execute(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "nel carnal" + e);
        }
    }

    public void Preparar_Statement() {
        try {
            Conectar();
            ps = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al preparar statement: " + e);
        }
    }
    
    public String Cifrar(String texto, String tipo_cifrado){
        try{
            md5 = MessageDigest.getInstance(tipo_cifrado);
            byte[] auxiliar_cifrado = md5.digest(texto.getBytes());
            string_builder = new StringBuilder();
            for(int x = 0; x < auxiliar_cifrado.length; x ++){
                string_builder.append(Integer.toHexString((auxiliar_cifrado[x] & 0xFF) | 0x100).substring(1,3));
            }
            return string_builder.toString();
        }
        catch(NoSuchAlgorithmException e){
            JOptionPane.showMessageDialog(null, "Error al cifrar la información" + e);
        }
        return "";
    }

    public Connection getSql_connection() {
        return conexion;
    }

    public void setSql_connection(Connection sql_connection) {
        this.conexion = conexion;
    }

    public Statement getSql_statement() {
        return st;
    }

    public void setSql_statement(Statement sql_statement) {
        this.st = st;
    }

    public PreparedStatement getSql_prepared_statement() {
        return ps;
    }

    public void setSql_prepared_statement(PreparedStatement sql_prepared_statement) {
        this.ps = ps;
    }

    public ResultSet getSql_result_set() {
        return rs;
    }

    public void setSql_result_set(ResultSet sql_result_set) {
        this.rs = rs;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }
}
