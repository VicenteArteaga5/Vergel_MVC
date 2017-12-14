
package controllers;

import models.*;
import views.*;

public class ControllerMain {
    
    private final ModelMain model_main;
    private final ModelLogin model_login;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ViewAdministrador view_administrador;
    private final ViewEmpleados view_empleados;
    
    public ControllerMain(Object[] models, Object[] views){
        this.model_main = (ModelMain)models[0];
        this.model_login = (ModelLogin)models[3];
        this.view_main = (ViewMain)views[0];
        this.view_login = (ViewLogin)views[3];
        this.view_administrador = (ViewAdministrador)views[1];
        this.view_empleados = (ViewEmpleados)views[2];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
        view_main.setTitle("Login");
        view_main.jmi_empleados.setVisible(false);
        view_main.jmi_admnistrador.setVisible(false);
        view_main.setLocationRelativeTo(null);
        view_main.setVisible(true);
    } 
    
    public void Definir_Action_Listeners(){
        view_main.jmi_login.addActionListener(e -> jmi_loginMouseClicked());
        view_main.jmi_admnistrador.addActionListener(e -> jmi_administardorMouseClicked());
        view_main.jmi_empleados.addActionListener(e -> jmi_empleadosMouseClicked());
        view_main.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
    }
    
    public void jmi_loginMouseClicked(){
        view_main.setContentPane(view_login);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_administardorMouseClicked(){
        view_main.setContentPane(view_administrador);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_empleadosMouseClicked(){
        view_main.setContentPane(view_empleados);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
}
