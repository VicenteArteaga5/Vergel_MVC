package main;

import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author Vicente Arteaga
 */
public class Main {
    public static void Main (String VAR[]){
        ModelMain model_main = new ModelMain();
        ModelAdministrador model_administrador = new ModelAdministrador();
        ModelEmpleados model_empleado = new ModelEmpleados();
        ModelLogin model_login = new ModelLogin();
    
        ViewMain view_main = new ViewMain();
        ViewLogin view_login = new ViewLogin();
        ViewAdministrador view_administrador = new ViewAdministrador();
        ViewEmpleados view_empleados = new ViewEmpleados();
        
        Object[] models = new Object[4];
        Object[] views = new Object[4];
        Object[] controller = new Object[4];
        
        models[0] = model_main;
        models[1] = model_login;
        models[2] = model_administrador;
        models[3] = model_empleado;
        
        views[0] = view_main;
        views[1] = view_login;
        views[2] = view_administrador;
        views[3] = view_empleados;
        
        ControllerMain controller_main = new ControllerMain(models,views);
        controller[0] = controller_main;
        
        ControllerLogin controller_login = new ControllerLogin(models,views,controllers);
        controller[1] = controller_login;
        
        ControllerAdministrador controller_administrador = new ControllerAdministrador(models,views,controllers);
        controller[2] = controller_administrador;
        
        ControllerEmpleados controller_empleados = new ControllerEmpleados(views,models,controllers);
        controller[3] = controller_empleados;

    }
    
}
