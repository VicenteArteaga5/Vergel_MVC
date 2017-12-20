package controllers;

import models.*;
import views.*;


public class ControllerRegistroEmpleados{
    private ModelRegistroEmpleados model_registro_empleados;
    private ViewRegistroEmpleados view_registro_empleados;
    private ViewAdministrador view_admin;
    private ViewMain view_main;
    
    public ControllerRegistroEmpleados(Object[] models, Object[] views, Object[] controllers){
        this.model_registro_empleados = (ModelRegistroEmpleados)models[5];
        this.view_admin = (ViewAdministrador)views[1];
        this.view_main =(ViewMain)views[0];
        this.view_registro_empleados = (ViewRegistroEmpleados)views[5];
        this.view_registro_empleados.jbtn_primero.addActionListener(e->jbtn_primero_clic());
        this.view_registro_empleados.jbtn_siguiente.addActionListener(e->jbtn_siguiente_clic());
        this.view_registro_empleados.jbtn_anterior.addActionListener(e->jbtn_anterior_clic());
        this.view_registro_empleados.jbtn_ultimo.addActionListener(e->jbtn_ultimo_clic());
        this.view_registro_empleados.jbtn_eliminar.addActionListener(e->jbtn_eliminar_clic());
        this.view_registro_empleados.jbtn_nuevo.addActionListener(e->jbtn_nuevo_clic());
        this.view_registro_empleados.jbtn_modificar.addActionListener(e->jbtn_modificar_clic());
        this.view_registro_empleados.jbtn_guardar.addActionListener(e-> jbtn_guardar_clic());
        this.view_registro_empleados.jbtn_regresar.addActionListener(e-> jbtn_regresar_clic());
        initView();
    }
    
    public void initView(){
        model_registro_empleados.seleccionarTodos();
        model_registro_empleados.llenarValores();
        model_registro_empleados.LlenarComboBox(view_registro_empleados.jcb_cargo);
        model_registro_empleados.tabla();
        view_registro_empleados.jt_empleados.setModel(model_registro_empleados.getTabla());
        view_registro_empleados.setVisible(true);
        model_registro_empleados.moverPrimero();
        getValores();
    }
    
    public void getValores(){
        view_registro_empleados.jtf_empleado_id.setText(""+model_registro_empleados.getEmpleado_id());
        view_registro_empleados.jtf_nombre.setText(model_registro_empleados.getNombre_Empleado());
        view_registro_empleados.jtf_apellido_paterno.setText(model_registro_empleados.getApellido_Paterno());
        view_registro_empleados.jtf_apellido_materno.setText(model_registro_empleados.getApellido_Materno());
        view_registro_empleados.jtf_edad.setText(""+model_registro_empleados.getEdad());
        view_registro_empleados.jtf_telefono.setText(""+model_registro_empleados.getTelefono());
        view_registro_empleados.jcb_genero.setSelectedItem(model_registro_empleados.getGenero());
        view_registro_empleados.jcb_cargo.setSelectedItem(model_registro_empleados.getCargo());
        view_registro_empleados.jtf_direccion.setText(model_registro_empleados.getDireccion());
    }
    
    public void setValores(){
        model_registro_empleados.setNombre_Empleado(view_registro_empleados.jtf_nombre.getText());
        model_registro_empleados.setApellido_Paterno(view_registro_empleados.jtf_apellido_paterno.getText());
        model_registro_empleados.setApellido_Materno(view_registro_empleados.jtf_apellido_materno.getText());
        model_registro_empleados.setEdad(Integer.parseInt(""+view_registro_empleados.jtf_edad.getText()));
        model_registro_empleados.setTelefono((view_registro_empleados.jtf_telefono.getText()));
        model_registro_empleados.setGenero(""+view_registro_empleados.jcb_genero.getSelectedItem());
        model_registro_empleados.setCargo(""+view_registro_empleados.jcb_cargo.getSelectedItem());
        model_registro_empleados.setDireccion(view_registro_empleados.jtf_direccion.getText());
    }
    
    public void jbtn_nuevo_clic(){
        view_registro_empleados.jtf_empleado_id.setText("");
        view_registro_empleados.jtf_nombre.setText("");
        view_registro_empleados.jtf_apellido_paterno.setText("");
        view_registro_empleados.jtf_apellido_materno.setText("");
        view_registro_empleados.jtf_edad.setText("");
        view_registro_empleados.jtf_telefono.setText("");
        view_registro_empleados.jcb_genero.setSelectedItem(this);
        view_registro_empleados.jcb_cargo.setSelectedItem(this);
        view_registro_empleados.jtf_direccion.setText("");
    }
    
    public void jbtn_modificar_clic(){
        setValores();
        model_registro_empleados.modificar();
        model_registro_empleados.seleccionarTodos();
        model_registro_empleados.llenarValores();
        model_registro_empleados.LlenarComboBox(view_registro_empleados.jcb_cargo);
        getValores();
        model_registro_empleados.tabla();
        view_registro_empleados.jt_empleados.setModel(model_registro_empleados.getTabla());
    }
    
    public void jbtn_guardar_clic(){
        setValores();
        model_registro_empleados.guardar();
        model_registro_empleados.seleccionarTodos();
        model_registro_empleados.llenarValores();
        model_registro_empleados.LlenarComboBox(view_registro_empleados.jcb_cargo);
        getValores();
        model_registro_empleados.tabla();
        view_registro_empleados.jt_empleados.setModel(model_registro_empleados.getTabla());
    }
    
    public void jbtn_eliminar_clic(){
        setValores();
        model_registro_empleados.eliminar();
        model_registro_empleados.seleccionarTodos();
        model_registro_empleados.llenarValores();
        getValores();
        model_registro_empleados.tabla();
        view_registro_empleados.jt_empleados.setModel(model_registro_empleados.getTabla());
    }
    
    public void jbtn_primero_clic(){
        model_registro_empleados.llenarValores();
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
    
    public void jbtn_regresar_clic(){
        view_main.setContentPane(view_admin);
        view_main.revalidate();
        view_main.repaint();
        getValores();
    }
    
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
}
