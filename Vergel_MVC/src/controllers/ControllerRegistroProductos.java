package controllers;

import models.*;
import views.*;

/**
 *
 * @author Vicente Arteaga
 */
public class ControllerRegistroProductos {
    private ModelRegistroProductos model_registro_productos;
    private ViewRegistroProductos view_registro_productos;
    
    public void ControllerPeronas(ModelRegistroProductos model_registro_productos, ViewRegistroProductos view_registro_productos){
        this.model_registro_productos = model_registro_productos;
        this.view_registro_productos = view_registro_productos;
        this.view_registro_productos.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_productos.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_productos.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_productos.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_productos.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_productos.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_productos.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        initView();
    }
    
    public void initView(){
        model_registro_productos.conectar();
        view_registro_productos.setVisible(true);
        model_registro_productos.moverPrimero();
        getValores();
    }
    
    public void getValores(){
        view_registro_productos.jtf_producto_id.setText(""+model_registro_productos.getProducto_ID());
        view_registro_productos.jtf_nombre_producto.setText(model_registro_productos.getNombre_Producto());
        view_registro_productos.jcb_tamano.setSelectedItem(model_registro_productos.getTamaño());
        view_registro_productos.jtf_precio.setText(""+model_registro_productos.getPrecio_Unitario());
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
        model_registro_productos.guardar();
        getValores();
    }
    
    public void jbtn_agregar_clic(){
        setValores();
        model_registro_productos.modificar();
        getValores();
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_productos.eliminar();
        getValores();
    }
    
    public void jbtn_primero_clic(){
        model_registro_productos.moverPrimero();
        getValores();
    }
    
    public void jbtn_siguiente_clic(){
        model_registro_productos.moverSiguiente();
        getValores();
    }
    
    public void jbtn_ultimo_clic(){
        model_registro_productos.moverUltimo();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_registro_productos.moverAnterior();
        getValores();
    }
}
