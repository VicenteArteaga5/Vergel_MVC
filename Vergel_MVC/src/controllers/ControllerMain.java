
package controllers;

import models.*;
import views.*;

public class ControllerMain {
    
    private final ModelMain model_main;
    private final ViewMain view_main;
    private final ViewLogin view_login;
    private final ViewRegistroCargo view_registro_cargo;
    private final ViewRegistroEmpleados view_registro_empleados;
    private final ViewRegistroProductos view_registro_productos;
    private final ViewVenta view_venta;
    
    public ControllerMain(Object[] models, Object[] views){
        this.model_main = (ModelMain)models[0];
        this.view_main = (ViewMain)views[0];
        this.view_login = (ViewLogin)views[3];
        this.view_registro_cargo=(ViewRegistroCargo)views[4];
        this.view_registro_empleados=(ViewRegistroEmpleados)views[5];
        this.view_registro_productos=(ViewRegistroProductos)views[6];
        this.view_venta=(ViewVenta)views[7];
        initView();
    }
    
    public void initView(){
        view_main.setTitle("Bienvenido");
        view_main.jmi_login.addActionListener(e -> jmi_loginMouseClicked());
        view_main.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        view_main.jmi_cargo.addActionListener(e -> jmi_cargoMouseClicked());
        view_main.jmi_empleados.addActionListener(e -> jmi_empleadosMouseClicked());
        view_main.jmi_productos.addActionListener(e -> jmi_productosMouseClicked());
        view_main.jmi_ventas.addActionListener(e -> jmi_ventasMouseClicked());
        view_main.setLocationRelativeTo(null);
        view_main.setVisible(true);
        view_main.jmi_cargo.setVisible(false);
        view_main.jmi_empleados.setVisible(false);
        view_main.jmi_productos.setVisible(false);
        view_main.jmi_ventas.setVisible(false);
    } 
    
    public void jmi_loginMouseClicked(){
        view_main.setContentPane(view_login);
        view_login.revalidate();
        view_login.repaint();
    }
    
    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    
    public void jmi_cargoMouseClicked(){
        view_main.setContentPane(view_registro_cargo);
        view_main.revalidate();
        view_main.repaint();
    }
 
    public void jmi_empleadosMouseClicked(){
        view_main.setContentPane(view_registro_empleados);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_productosMouseClicked(){
        view_main.setContentPane(view_registro_productos);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jmi_ventasMouseClicked(){
        view_main.setContentPane(view_venta);
        view_main.revalidate();
        view_main.repaint();
    }
    
}
