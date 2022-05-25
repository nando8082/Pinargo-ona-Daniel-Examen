/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.bean.ViewScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Jonny
 */
@Named
@SessionScoped
public class IndexController implements Serializable {

    @EJB
    private UsuarioFacade uFacade;
    private Usuario usuario;

    @PostConstruct
    public void init() {
        usuario = new Usuario();

    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
        System.out.println("VERIFICANDO INICIARSESION");
        String redireccion = null;
        Usuario u;
        FacesContext context = FacesContext.getCurrentInstance();

        try {
            u = this.uFacade.iniciarSesion(usuario);
            if (u != null) {
                context.getExternalContext().getSessionMap().put("usuario", u);
                redireccion = "productoCRUD";
            } else {
                FacesMessage message;
                message = new FacesMessage("Usuarioy/ocontraseña incorrectos.");
                context.addMessage(null, message);
                redireccion = "index";
            }

        } catch (Exception e) {

        }
        return redireccion;
    }
}
