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
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
@NamedQuery(name = "getFacturaCabecera", query = "SELECT fc FROM  FacturaCabecera fc")

public class FacturaCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private LocalDate fechaEmision;
    private double subtotal;
    private double total;
    private char estado;
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private Usuario usuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaCabecera")
    private Set<FacturaDetalle> facturaDetalle = new HashSet<FacturaDetalle>();
    
}
