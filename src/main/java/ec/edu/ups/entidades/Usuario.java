/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
@NamedQuery(name = "getUsuario", query = "SELECT u FROM  Usuario u")

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasenia;
    private String tipoUs;
    private String telefono;
    private String direccion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private Set<FacturaCabecera> facturaCabecera = new HashSet<FacturaCabecera>();
    @Transient
    private boolean editable;
     public Usuario() {
        super();
    }
    public Usuario(int id, String cedula, String nombre, String apellido, String correo, String contrasenia, String tipoUs, String telefono, String direccion) {
        super();
        this.setId(id);
        this.setCedula(cedula);
        this.setNombre(nombre); 
        this.setApellido(apellido);
        this.setCorreo(correo); 
        this.setContrasenia(contrasenia);
        this.setTipoUs(tipoUs);
        this.setTelefono(telefono); 
        this.setDireccion(direccion);
    } 

   


    public boolean isEditable() {
        return editable;
    }
    
    public void setEditable(boolean editable) {
        this.editable = editable;
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

    public Set<FacturaCabecera> getFacturaCabecera() {
        return facturaCabecera;
    }

    public void setFacturaCabecera(Set<FacturaCabecera> facturaCabecera) {
        this.facturaCabecera = facturaCabecera;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo + ", contrasenia=" + contrasenia + ", tipoUs=" + tipoUs + ", telefono=" + telefono + ", direccion=" + direccion + ", facturaCabecera=" + facturaCabecera + '}';
    }
    
    
}
