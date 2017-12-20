/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import models.ModelRegistroCargo;
import models.ModelRegistroUsuario;
import views.ViewAdministrador;
import views.ViewMain;
import views.ViewRegistroUsuarios;
import views.ViewRegistroCargo;

/**
 *
 * @author vicente
 */
public class ControllerRegistroUsuarios {
    private ModelRegistroUsuario model_registro_usuario;
    private ViewRegistroUsuarios view_registro_usuario;
    private ViewAdministrador view_admin;
    private ViewMain view_main;

    public ControllerRegistroUsuarios(Object[] models, Object[] views, Object[] controllers){
        this.model_registro_usuario= (ModelRegistroUsuario)models[2];
        this.view_registro_usuario = (ViewRegistroUsuarios) views[2];
        this.view_admin = (ViewAdministrador)views[1];
        this.view_main =(ViewMain)views[0];
        this.view_registro_usuario.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_usuario.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_usuario.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_usuario.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_usuario.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_usuario.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_usuario.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        this.view_registro_usuario.jbtn_guardar.addActionListener(e->jbtn_agregar_clic());
        this.view_registro_usuario.jbtn_regresar.addActionListener(e-> jbtn_regresar_clic());
        initView();
    }
    
    public void initView(){
        model_registro_usuario.seleccionarTodos();
        model_registro_usuario.llenarValores();
        model_registro_usuario.tabla();
        view_registro_usuario.jTable1.setModel(model_registro_usuario.getTabla());
        view_registro_usuario.setVisible(true);
        model_registro_usuario.moverPrimero();
        getValores();
    }
    
    public void getValores(){
        view_registro_usuario.jtf_usuario.setText(""+model_registro_usuario.getUsuario());
        view_registro_usuario.jpf_contraseña.setText(model_registro_usuario.getContraseña());
        view_registro_usuario.jcb_rol.setSelectedItem(""+model_registro_usuario.getRol());
    }
    
    public void setValores(){
        model_registro_usuario.setUsuario(view_registro_usuario.jtf_usuario.getText());
        model_registro_usuario.setContraseña(view_registro_usuario.jpf_contraseña.getText());
        model_registro_usuario.setRol((int) view_registro_usuario.jcb_rol.getSelectedItem());
    }
    
    public void jbtn_nuevo_clic(){
        view_registro_usuario.jtf_usuario.setText("");
        view_registro_usuario.jpf_contraseña.setText("");
        view_registro_usuario.jcb_rol.setSelectedItem("1");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_registro_usuario.modificar();
        model_registro_usuario.seleccionarTodos();
        model_registro_usuario.llenarValores();
        getValores();
        model_registro_usuario.tabla();
        view_registro_usuario.jTable1.setModel(model_registro_usuario.getTabla());
        
    }
    
    public void jbtn_agregar_clic(){
        setValores();
        model_registro_usuario.guardar();
        model_registro_usuario.seleccionarTodos();
        model_registro_usuario.llenarValores();
        getValores();
        model_registro_usuario.tabla();
        view_registro_usuario.jTable1.setModel(model_registro_usuario.getTabla());
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_usuario.eliminar();
        model_registro_usuario.seleccionarTodos();
        model_registro_usuario.llenarValores();
        getValores();
        model_registro_usuario.tabla();
        view_registro_usuario.jTable1.setModel(model_registro_usuario.getTabla());
    }
    
    public void jbtn_primero_clic(){
        model_registro_usuario.moverPrimero();
        getValores();
    }
    
    public void jbtn_siguiente_clic(){
        model_registro_usuario.moverSiguiente();
        getValores();
    }
    
    public void jbtn_ultimo_clic(){
        model_registro_usuario.moverUltimo();
        getValores();
    }
    
    public void jbtn_anterior_clic(){
        model_registro_usuario.moverAnterior();
        getValores();
    }
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    public void jbtn_regresar_clic(){
        view_main.setContentPane(view_admin);
        view_main.revalidate();
        view_main.repaint();
        getValores();
    }
}

