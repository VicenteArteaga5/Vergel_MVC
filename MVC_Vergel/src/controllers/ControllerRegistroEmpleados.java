package controllers;

import models.*;
import views.*;

/**
 *
 * @author Vicente Arteaga
 */
public class ControllerRegistroEmpleados {
    private ModelRegistroEmpleados model_registro_empleados;
    private ViewRegistroEmpleados view_registro_empleados;
    
    public void ControllerPeronas(ModelRegistroEmpleados model_registro_empleados, ViewRegistroEmpleados view_registro_empleados){
        this.model_registro_empleados = model_registro_empleados;
        this.view_registro_empleados = view_registro_empleados;
        this.view_registro_empleados.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_empleados.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_empleados.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_empleados.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_empleados.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_empleados.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_empleados.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        this.view_registro_empleados.jbtn_guardar.addActionListener(e-> jbtn_guardar_clic());
        initView();
    }
    
    public void initView(){
        model_registro_empleados.conectar();
        view_registro_empleados.setVisible(true);
        model_registro_empleados.moverPrimero();
        getValores();
    }
    
    public void getValores(){
        view_registro_empleados.jtf_empleado_id.setText(""+model_registro_empleados.getEmpleado_id());
        view_registro_empleados.jtf_nombre_producto.setText(model_registro_productos.getNombre_Producto());
        view_registro_empleados.jcb_tamano.setSelectedItem(model_registro_productos.getTamaño());
        view_registro_empleados.jtf_precio.setText(""+model_registro_productos.getPrecio_Unitario());
    }
    
    public void setValores(){
        model_registro_productos.setProducto_ID(Integer.parseInt(view_registro_productos.jtf_producto_id.getText()));
        model_registro_productos.setNombre_Producto(view_registro_productos.jtf_nombre_producto.getText());
        model_registro_productos.setTamaño(""+view_registro_productos.jcb_tamano.getSelectedItem());
        model_registro_productos.setPrecio_Unitario(Integer.parseInt(view_registro_productos.jtf_precio.getText()));
    }
    
    public void jbtn_nuevo_clic(){
        view_registro_productos.jtf_producto_id.setText("");
        view_registro_productos.jtf_nombre_producto.setText("");
        view_registro_productos.jcb_tamano.setSelectedItem("Chico");
        view_registro_productos.jtf_precio.setText("");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_registro_empleados.modificar();
        getValores();
    }
    
    public void jbtn_guardar_clic(){
        setValores();
        model_registro_empleados.modificar();
        getValores();
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_empleados.eliminar();
        getValores();
    }
    
    public void jbtn_primero_clic(){
        model_registro_empleados.moverPrimero();
        getValores();
    }
    
    public void jbtn_siguiente_clic(){
        model_registro_empleados.moverSiguiente();
        getValores();
    }
    
    public void jbtn_ultimo_clic(){
        model_registro_empleados.moverUltimo();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_registro_empleados.moverAnterior();
        getValores();
    }
}
