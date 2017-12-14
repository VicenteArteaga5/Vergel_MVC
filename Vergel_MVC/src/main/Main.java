package main;

import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author Vicente Arteaga
 */
public class Main {
    public static void main (String VAR[]){
        ModelMain model_main = new ModelMain();
        ModelAdministrador model_administrador = new ModelAdministrador();
        ModelEmpleados model_empleado = new ModelEmpleados();
        ModelLogin model_login = new ModelLogin(model_main);
        ModelRegistroCargo model_registro_cargo = new ModelRegistroCargo();
        ModelRegistroEmpleados model_registro_empleados = new ModelRegistroEmpleados();
        ModelRegistroProductos model_registro_productos = new ModelRegistroProductos();
        
    
        ViewMain view_main = new ViewMain();
        ViewAdministrador view_administrador = new ViewAdministrador();
        ViewEmpleados view_empleados = new ViewEmpleados();
        ViewLogin view_login = new ViewLogin();
        ViewRegistroCargo view_registro_cargo = new ViewRegistroCargo();
        ViewRegistroEmpleados view_registro_empleados = new ViewRegistroEmpleados();
        ViewRegistroProductos view_registro_productos = new ViewRegistroProductos();
        

        
        Object[] models = new Object[7];
        Object[] views = new Object[7];
        Object[] controller = new Object[7];
        
        models[0] = model_main;
        models[1] = model_administrador;
        models[2] = model_empleado;
        models[3] = model_login;
        models[4] = model_registro_cargo;
        models[5] = model_registro_empleados;
        models[6] = model_registro_productos;
        

        
        views[0] = view_main;
        views[1] = view_administrador;
        views[2] = view_empleados;
        views[3] = view_login;
        views[4] = view_registro_cargo;
        views[5] = view_registro_empleados;
        views[6] = view_registro_productos;

        
        ControllerMain controller_main = new ControllerMain(models,views);
        controller[0] = controller_main;
        
        ControllerAdministrador controller_administrador = new ControllerAdministrador(models, views);
        controller[1] = controller_administrador;
        
        ControllerEmpleados controller_empleados = new ControllerEmpleados();
        controller[2] = controller_empleados;
        
        ControllerLogin controller_login = new ControllerLogin(models, views, controller);
        controller[3] = controller_login;
        
        ControllerRegistroCargo controller_registro_cargo = new ControllerRegistroCargo();
        controller[4] = controller_registro_cargo;
        
        ControllerRegistroEmpleados controller_registro_empleados = new ControllerRegistroEmpleados();
        controller[5] = controller_registro_empleados;
        
        ControllerRegistroProductos controller_registro_productos = new ControllerRegistroProductos();
        controller[6] = controller_registro_productos;

    }
    
}
