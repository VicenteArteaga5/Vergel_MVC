
package controllers;

import views.*;
import models.*;

public class ControllerRegistroCargo {
    
    private ModelRegistroCargo model_registro_cargo;
    private ViewRegistroCargo view_registro_cargo;
    
    public void initView(){
        model_registro_cargo.conectar();
        view_registro_cargo.setVisible(true);
        model_registro_cargo.moverPrimero();
        getValores();
    }
    
    public void ControllerCargo(ModelRegistroCargo model_registro_cargo, ViewRegistroCargo view_registro_cargo){
        this.model_registro_cargo = model_registro_cargo;
        this.view_registro_cargo = view_registro_cargo;
        this.view_registro_cargo.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_cargo.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_cargo.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_cargo.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_cargo.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_cargo.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_cargo.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        initView();
    }
    
    public void getValores(){
        view_registro_cargo.jtf_cargo_id.setText(""+model_registro_cargo.getCargo_id());
        view_registro_cargo.jtf_cargo.setText(model_registro_cargo.getCargo());
    }
    
    public void setValores(){
        model_registro_cargo.setCargo_id(Integer.parseInt(view_registro_cargo.jtf_cargo_id.getText()));
        model_registro_cargo.setCargo(view_registro_cargo.jtf_cargo.getText());
    }
    
    public void jbtn_nuevo_clic(){
        view_registro_cargo.jtf_cargo.setText("");
        view_registro_cargo.jtf_cargo.setText("");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_registro_cargo.modificar();
        getValores();
    }
    
    public void jbtn_agregar_clic(){
        setValores();
        model_registro_cargo.guardar();
        getValores();
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_cargo.eliminar();
        getValores();
    }
    
    public void jbtn_primero_clic(){
        model_registro_cargo.moverPrimero();
        getValores();
    }
    
    public void jbtn_siguiente_clic(){
        model_registro_cargo.moverSiguiente();
        getValores();
    }
    
    public void jbtn_ultimo_clic(){
        model_registro_cargo.moverUltimo();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_registro_cargo.moverAnterior();
        getValores();
    }
    
}
