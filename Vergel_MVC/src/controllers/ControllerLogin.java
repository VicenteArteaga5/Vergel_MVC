
package controllers;

import views.*;
import models.*;


public final class ControllerLogin {
    private final ModelLogin model_login;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ControllerMain controller_main;
    private final ViewRegistroEmpleados view_registro_empleados;
    private final ViewAdministrador view_admin;
    
    public ControllerLogin(Object[] models, Object[] views, Object[] controllers){
        this.model_login = (ModelLogin)models[3];
        this.view_main = (ViewMain)views[0];
        this.view_login = (ViewLogin)views[3];
        this.controller_main = (ControllerMain)controllers[0];
        this.view_registro_empleados = (ViewRegistroEmpleados)views[5];
        this.view_admin = (ViewAdministrador)views[1];
        initView();
    }
    
    public void initView(){
        Definir_Action_Listeners();
    }
    
    public void Definir_Action_Listeners(){
        view_login.jbtn_entrar.addActionListener(e -> jbtn_iniciarMouseClicked());
    }
    
    public void setDatos(){
        model_login.setUsuario(view_login.jtf_usuario.getText());
        model_login.setContraseña_Usuario(view_login.jpf_contraseña.getPassword());
    }
    
    public void jbtn_iniciarMouseClicked(){
        setDatos();
        model_login.Verificar_Usuario();
        if(model_login.getTipo_Usuario().equals("Administrador")){
            view_main.setContentPane(view_admin);
        }
        else{
            //
        }
        view_login.jtf_usuario.setText("");
        view_login.jpf_contraseña.setText("");
    }
}
