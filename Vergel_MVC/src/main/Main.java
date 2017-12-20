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
        ModelLogin model_login = new ModelLogin(model_main);
        ModelRegistroUsuario model_registro_usuario = new ModelRegistroUsuario();
        ModelRegistroCargo model_registro_cargo = new ModelRegistroCargo();
        ModelRegistroEmpleados model_registro_empleados = new ModelRegistroEmpleados();
        ModelRegistroProductos model_registro_productos = new ModelRegistroProductos();
        ModelVenta model_venta = new ModelVenta();
        
    
        ViewMain view_main = new ViewMain();
        ViewLogin view_login = new ViewLogin();
        ViewRegistroUsuarios view_registro_usuarios = new ViewRegistroUsuarios();
        ViewRegistroCargo view_registro_cargo = new ViewRegistroCargo();
        ViewRegistroEmpleados view_registro_empleados = new ViewRegistroEmpleados();
        ViewRegistroProductos view_registro_productos = new ViewRegistroProductos();
        ViewVenta view_venta = new ViewVenta();
        ViewAdministrador view_admin = new ViewAdministrador();
        

        
        Object[] models = new Object[9];
        Object[] views = new Object[9];
        Object[] controller = new Object[9];
        
        models[0] = model_main;
        models[2] = model_registro_usuario;
        models[3] = model_login;
        models[4] = model_registro_cargo;
        models[5] = model_registro_empleados;
        models[6] = model_registro_productos;
        models[7] = model_venta;
        

        
        views[0] = view_main;
        views[1] = view_admin;
        views[2] = view_registro_usuarios;
        views[3] = view_login;
        views[4] = view_registro_cargo;
        views[5] = view_registro_empleados;
        views[6] = view_registro_productos;
        views[7] = view_venta;

        
        ControllerMain controller_main = new ControllerMain(models,views);
        controller[0] = controller_main;
        
        ControllerRegistroUsuarios controller_registro_usuarios = new ControllerRegistroUsuarios(models, views, controller);
        controller[2] = controller_registro_usuarios;
        
        ControllerLogin controller_login = new ControllerLogin(models, views, controller);
        controller[3] = controller_login;
        
        ControllerRegistroCargo controller_registro_cargo = new ControllerRegistroCargo(models, views, controller);
        controller[4] = controller_registro_cargo;
        
        ControllerRegistroEmpleados controller_registro_empleados = new ControllerRegistroEmpleados(models, views, controller);
        controller[5] = controller_registro_empleados;
        
        ControllerRegistroProductos controller_registro_productos = new ControllerRegistroProductos(models, views, controller);
        controller[6] = controller_registro_productos;
        
        ControllerVenta controller_venta = new ControllerVenta();
        controller[7] = controller_venta;
        
        ControllerAdmin controller_admin = new ControllerAdmin(views);
        controller[8] = controller_admin;
    
    }
}
