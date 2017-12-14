
package controllers;

import models.ModelAdministrador;
import models.ModelLogin;
import models.ModelMain;
import views.ViewAdministrador;
import views.ViewEmpleados;
import views.ViewLogin;
import views.ViewMain;
import views.*;
import models.*;


public class ControllerAdministrador {
    
    private final ModelMain model_main;
    private final ModelLogin model_login;
    private final ModelAdministrador model_admnistrador;
    private final ModelRegistroCargo model_registro_cargo;
    private final ModelRegistroEmpleados model_registro_empleados;
    private final ModelRegistroProductos model_registro_producto;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ViewAdministrador view_administrador;
    private final ViewRegistroCargo view_registro_cargo;
    private final ViewRegistroEmpleados view_registro_empleados;
    private final ViewRegistroProductos view_registro_productos;
    
    public ControllerAdministrador(Object[] models, Object[] views){
        this.model_main = (ModelMain)models[0];
        this.model_login = (ModelLogin)models[3];
        this.model_admnistrador = (ModelAdministrador) models[1];
        this.model_registro_cargo = (ModelRegistroCargo)models[4];
        this.model_registro_empleados = (ModelRegistroEmpleados) models[5];
        this.model_registro_producto = (ModelRegistroProductos) models[6];
        this.view_main = (ViewMain)views[0];
        this.view_login = (ViewLogin)views[3];
        this.view_administrador = (ViewAdministrador)views[1];
        this.view_registro_cargo = (ViewRegistroCargo) views[4];
        this.view_registro_empleados = (ViewRegistroEmpleados) views[5];
        this.view_registro_productos = (ViewRegistroProductos) views[6];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
        view_administrador.setTitle("Administrador");
        view_administrador.jmi_registro_productos.setVisible(false);
        view_administrador.jmi_registro_empleados.setVisible(false);
        view_administrador.jmi_registro_cargo.setVisible(false);
        view_main.setLocationRelativeTo(null);
        view_main.setVisible(true);
    } 
    
    public void Definir_Action_Listeners(){
        view_administrador.jmi_registro_empleados.addActionListener(e -> jmi_empleadosMouseClicked());
        view_administrador.jmi_registro_cargo.addActionListener(e -> jmi_cargoMouseClicked());
        view_administrador.jmi_registro_productos.addActionListener(e -> jmi_productosMouseClicked());
        view_main.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
    }
    
    public void jmi_productosMouseClicked(){
        view_administrador.setContentPane(view_registro_productos);
        view_administrador.revalidate();
        view_administrador.repaint();
    }
    
    public void jmi_cargoMouseClicked(){
        view_administrador.setContentPane(view_registro_cargo);
        view_administrador.revalidate();
        view_administrador.repaint();
    }
    
    public void jmi_empleadosMouseClicked(){
        view_administrador.setContentPane(view_registro_empleados);
        view_administrador.revalidate();
        view_administrador.repaint();
    }
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    
}
