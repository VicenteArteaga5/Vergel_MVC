
package controllers;

import models.*;
import views.*;

public class ControllerVenta {
    private ModelVenta model_venta;
    private ViewVenta view_venta;
    
    public void ControllerVentas(ModelVenta model_venta, ViewVenta view_Venta){
        this.model_venta = model_venta;
        this.view_venta = view_Venta;
        this.view_venta.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_venta.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_venta.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_venta.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_venta.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_venta.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_venta.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        this.view_venta.jbtn_guardar.addActionListener(e->jbtn_guardar_clic());
        initView();
    }
    
    public void initView(){
        model_venta.conectar();
        view_venta.setVisible(true);
        model_venta.moverPrimero();
        getValores();
    }
    
    public void getValores(){
        view_venta.jtf_ordenID.setText(""+model_venta.getOrdenID());
        view_venta.jcb_platillos.setSelectedItem(model_venta.getNombreProducto());
        view_venta.jtf_precio_unitario.setText(""+model_venta.getPrecioUnitario());
        view_venta.jtf_cantidad.setText(""+model_venta.getCantidad());
        view_venta.jtf_precio_total.setText(""+model_venta.getPrecioTotal());
    }
    
    public void setValores(){
        model_venta.setOrdenID(Integer.parseInt(view_venta.jtf_ordenID.getText()));
        model_venta.setNombreProducto(""+view_venta.jcb_platillos.getSelectedItem());
        model_venta.setPrecioUnitario(Integer.parseInt(view_venta.jtf_precio_unitario.getText()));
        model_venta.setCantidad(Integer.parseInt(view_venta.jtf_cantidad.getText()));
        model_venta.setPrecioTotal(Integer.parseInt(view_venta.jtf_precio_total.getText()));
    }
    
    public void jbtn_nuevo_clic(){
        view_venta.jtf_ordenID.setText("");
        view_venta.jcb_platillos.setSelectedItem("");
        view_venta.jtf_precio_unitario.setText("");
        view_venta.jtf_cantidad.setText("");
        view_venta.jtf_precio_unitario.setText("");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_venta.modificar();
        getValores();
    }
    
    public void jbtn_guardar_clic(){
        setValores();
        model_venta.guardar();
        getValores();
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_venta.eliminar();
        getValores();
    }
    
    public void jbtn_primero_clic(){
        model_venta.moverPrimero();
        getValores();
    }
    
    public void jbtn_siguiente_clic(){
        model_venta.moverSiguiente();
        getValores();
    }
    
    public void jbtn_ultimo_clic(){
        model_venta.moverUltimo();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_venta.moverAnterior();
        getValores();
    }
}
