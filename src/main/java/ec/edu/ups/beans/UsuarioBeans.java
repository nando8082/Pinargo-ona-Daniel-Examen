/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.Usuario;
import ec.edu.ups.facade.ClienteFacade;
import ec.edu.ups.facade.UsuarioFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Named
@SessionScoped
public class UsuarioBeans implements Serializable {

    @EJB
    private UsuarioFacade uFacade;

    private List<Usuario> list = new ArrayList<>();
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String tipoUs;
    private String telefono;
    private String direccion;

    @PostConstruct
    public void init() {
        list = uFacade.findAll();
        
    }

  

   

    public String add() {
        uFacade.create(new Usuario(id, cedula, nombre, apellido, correo, contrasenia, tipoUs, telefono, direccion));
        list = uFacade.findAll();
        return null;
    }

    public String delete(Usuario u) {
        uFacade.remove(u);
        list = uFacade.findAll();
        return null;
    }

    public String edit(Usuario u) {
        u.setEditable(true);
        return null;
    }

    public String save(Usuario u) {
        uFacade.edit(u);
        list = uFacade.findAll();
        u.setEditable(false);
        return null;
    }

    public Usuario[] getList() {
        return list.toArray(new Usuario[0]);
    }

    public void setList(List<Usuario> list) {
        this.list = list;
    }

    public UsuarioFacade getClienteFacade() {
        return uFacade;
    }

    public void setUsuarioFacade(UsuarioFacade cFacade) {
        this.uFacade = cFacade;
    }

    public UsuarioFacade getcFacade() {
        return uFacade;
    }

    public void setcFacade(UsuarioFacade cFacade) {
        this.uFacade = cFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public UsuarioFacade getuFacade() {
        return uFacade;
    }

    public void setuFacade(UsuarioFacade uFacade) {
        this.uFacade = uFacade;
    }

    public String getTipoUs() {
        return tipoUs;
    }

    public void setTipoUs(String tipoUs) {
        this.tipoUs = tipoUs;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

}
