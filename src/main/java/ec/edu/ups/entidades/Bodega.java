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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author Daniel
 */
@Entity
@NamedQuery(name = "getBodega", query = "SELECT s FROM  bodega s")
public class Bodega implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String telefono;
    private String direccion;
    private String ciudad;
    private String correo;
    @ManyToOne
    @JoinColumn(nullable = true)
    private EntidadPrincipal entidadPrincipal;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bodega")
    private Set<Producto> productos = new HashSet<Producto>();

    public Bodega() {
        super();
    }

    public Bodega(long id, String telefono, String direccion, String ciudad, String correo) {
        super();
        this.setId(id);
        this.setTelefono(telefono);
        this.setDireccion(direccion);
        this.setCiudad(ciudad);
        this.setCorreo(correo);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public EntidadPrincipal getEntidadPrincipal() {
        return entidadPrincipal;
    }

    public void setEntidadPrincipal(EntidadPrincipal entidadPrincipal) {
        this.entidadPrincipal = entidadPrincipal;
    }

    

    public Set<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Bodega categoria = (Bodega) o;
        return Objects.equals(id, categoria.id);
    }

    @Override
    public String toString() {
        return "Sucursal{" + "id=" + id + ", telefono=" + telefono + ", direccion=" + direccion + ", ciudad=" + ciudad + ", correo=" + correo + '}';
    }

}
