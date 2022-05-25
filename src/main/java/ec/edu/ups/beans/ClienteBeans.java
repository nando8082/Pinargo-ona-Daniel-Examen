/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;



import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.facade.ClienteFacade;
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
public class ClienteBeans implements Serializable {

    @EJB
    private ClienteFacade cFacade;

    private List<Cliente> list = new ArrayList<>();

    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
 
    private String telefono;
    private String direccion;

    @PostConstruct
    public void init() {
        list = cFacade.findAll();
    }

    public String add() {
        cFacade.create(new Cliente(id, cedula,nombre,apellido,correo,contrasenia,telefono,direccion));
        list = cFacade.findAll();
        return null;
    }

    public String delete(Cliente u) {
        cFacade.remove(u);
        list = cFacade.findAll();
        return null;
    }

    public String edit(Cliente u) {
        u.setEditable(true);
        return null;
    }

    public String save(Cliente u) {
        cFacade.edit(u);
        list = cFacade.findAll();
        u.setEditable(false);
        return null;
    }

    public Cliente[] getList() {
        return list.toArray(new Cliente[0]);
    }

    public void setList(List<Cliente> list) {
        this.list = list;
    }

    public ClienteFacade getClienteFacade() {
        return cFacade;
    }

    public void setClienteFacade(ClienteFacade cFacade) {
        this.cFacade = cFacade;
    }

    public ClienteFacade getcFacade() {
        return cFacade;
    }

    public void setcFacade(ClienteFacade cFacade) {
        this.cFacade = cFacade;
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
