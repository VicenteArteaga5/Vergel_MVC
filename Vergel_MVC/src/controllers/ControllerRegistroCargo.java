
package controllers;

import views.*;
import models.*;

public class ControllerRegistroCargo {
    
        private ModelRegistroCargo model_registro_cargo;
        private ViewRegistroCargo view_registro_cargo;
        private ViewAdministrador view_admin;
        private ViewMain view_main;

    public ControllerRegistroCargo(Object[] models, Object[] views, Object[] controllers){
        this.model_registro_cargo = (ModelRegistroCargo)models[4];
        this.view_registro_cargo = (ViewRegistroCargo) views[4];
        this.view_admin = (ViewAdministrador)views[1];
        this.view_main =(ViewMain)views[0];;
        this.view_registro_cargo.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_cargo.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_cargo.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_cargo.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_cargo.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_cargo.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_cargo.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        this.view_registro_cargo.jbtn_guardar.addActionListener(e->jbtn_agregar_clic());
        this.view_registro_cargo.jbtn_regresar.addActionListener(e-> jbtn_regresar_clic());
        initView();
    }
    
    public void initView(){
        model_registro_cargo.seleccionarTodos();
        model_registro_cargo.llenarValores();
        model_registro_cargo.tabla();
        view_registro_cargo.jTable1.setModel(model_registro_cargo.getTabla());
        view_registro_cargo.setVisible(true);
        model_registro_cargo.moverPrimero();
        getValores();
        
    }
    
    public void getValores(){
        view_registro_cargo.jtf_cargo_id.setText(""+model_registro_cargo.getCargo_id());
        view_registro_cargo.jtf_cargo.setText(model_registro_cargo.getCargo());
    }
    
    public void setValores(){
        model_registro_cargo.setCargo(view_registro_cargo.jtf_cargo.getText());
    }
    
    public void jbtn_nuevo_clic(){
        view_registro_cargo.jtf_cargo_id.setText("");
        view_registro_cargo.jtf_cargo.setText("");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_registro_cargo.modificar();
        model_registro_cargo.seleccionarTodos();
        model_registro_cargo.llenarValores();
        getValores();
        model_registro_cargo.tabla();
        view_registro_cargo.jTable1.setModel(model_registro_cargo.getTabla());
        
    }
    
    public void jbtn_agregar_clic(){
        setValores();
        model_registro_cargo.guardar();
        model_registro_cargo.seleccionarTodos();
        model_registro_cargo.llenarValores();
        getValores();
        model_registro_cargo.tabla();
        view_registro_cargo.jTable1.setModel(model_registro_cargo.getTabla());
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_cargo.eliminar();
        model_registro_cargo.seleccionarTodos();
        model_registro_cargo.llenarValores();
        getValores();
        model_registro_cargo.tabla();
        view_registro_cargo.jTable1.setModel(model_registro_cargo.getTabla());
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
    
    public void jbtn_regresar_clic(){
        view_main.setContentPane(view_admin);
        view_main.revalidate();
        view_main.repaint();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_registro_cargo.moverAnterior();
        getValores();
    }
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    
}
