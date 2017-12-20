
package controllers;

import models.ModelRegistroCargo;
import views.*;


public class ControllerAdmin {
        private ViewMain view_main;
        private ViewAdministrador view_admin;
        private ViewRegistroCargo view_registro_cargo;
        private ViewRegistroEmpleados view_registro_empleados;
        private ViewRegistroUsuarios view_registro_usuarios;
        private ViewRegistroProductos view_registro_productos;

    public ControllerAdmin(Object[] views){
        this.view_main = (ViewMain)views[0];
        this.view_admin = (ViewAdministrador) views[1];
        this.view_registro_cargo = (ViewRegistroCargo) views[4];
        this.view_registro_empleados =(ViewRegistroEmpleados)views[5];
        this.view_registro_productos =(ViewRegistroProductos)views[6];
        this.view_registro_usuarios =(ViewRegistroUsuarios)views[2];
        initView();
    }
    
    public void initView(){
        this.view_admin.jb_registro_cargos.addActionListener(e -> jbtn_cargos_clic());
        this.view_admin.jb_registro_empleados.addActionListener(e -> jbtn_empleados_clic());
        this.view_admin.jb_registro_productos.addActionListener(e -> jbtn_productos_clic());
        this.view_admin.jb_registro_usuarios.addActionListener(e -> jbtn_usuarios_clic());
        this.view_admin.jb_regresar.addActionListener(e -> jbtn_regresar_clic());
        
    }

    public void jbtn_productos_clic(){
        view_main.setContentPane(view_registro_productos);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jbtn_cargos_clic(){
        view_main.setContentPane(view_registro_cargo);
        view_main.revalidate();
        view_main.repaint();        
    }
    
    public void jbtn_empleados_clic(){
        view_main.setContentPane(view_registro_empleados);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jbtn_usuarios_clic(){
        view_main.setContentPane(view_registro_usuarios);
        view_main.revalidate();
        view_main.repaint();
    }
    
    public void jbtn_regresar_clic(){
        view_main.setContentPane(view_admin);
        view_main.revalidate();
        view_main.repaint();
    }

    public void jmi_salirMouseClicked(){
        System.exit(0);
    }
    
}
