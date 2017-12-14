
package controllers;

import views.ViewMain;
import views.ViewLogin;
import models.ModelLogin;


public final class ControllerLogin {
    private final ModelLogin model_login;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ControllerMain controller_main; 
    
    public ControllerLogin(Object[] models, Object[] views, Object[] controllers){
        this.model_login = (ModelLogin)models[3];
        this.view_main = (ViewMain)views[0];
        this.view_login = (ViewLogin)views[3];
        this.controller_main = (ControllerMain)controllers[0];
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
        model_login.Verificar_Tipo_Usuario();
        if(model_login.getTipo_Usuario().equals("Administrador")){
            view_main.jmi_admnistrador.setVisible(true);
            view_main.jmi_empleados.setVisible(false);
        }
        else{
            view_main.jmi_empleados.setVisible(true);
            view_main.jmi_admnistrador.setVisible(false);
        }
        view_login.jtf_usuario.setText("");
        view_login.jpf_contraseña.setText("");
    }
}
