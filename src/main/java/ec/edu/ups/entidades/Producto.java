/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Transient;
import java.io.Serializable;

/**
 *
 * @author Daniel
 */
@Entity
@NamedQuery(name = "getProducto", query = "SELECT p FROM  Producto p")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String descripcion;
    private String marca;
    private int stock;
    private String estado;
    private Double precio;

    
    @ManyToOne
    @JoinColumn(nullable = true)
    private Bodega bodega;
    
   

    public Producto() {
      
    }

    public Producto(long id, String nombre, String descripcion, String marca, int stock, String estado, Double precio, Bodega bodega) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.marca = marca;
        this.stock = stock;
        this.estado = estado;
        this.precio = precio;
        this.bodega = bodega;
    }

    

   

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega sucursal) {
        this.bodega = bodega;
    }

  

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca + 
                ", stock=" + stock + ", estado=" + estado + ", precio=" + precio +  '}';
    }

    
    
    
    
    
    
    
}
