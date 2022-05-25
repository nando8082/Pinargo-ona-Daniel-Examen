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
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Entity
@NamedQuery(name = "getFacturaDetalle", query = "SELECT fd FROM  FacturaDetalle fd")

public class FacturaDetalle implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private double subtotal;
    private double total;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaDetalle")
    private Set<Pedido> pedidos = new HashSet<Pedido>();
    
    @ManyToOne
    @JoinColumn(nullable = true)
    private FacturaCabecera facturaCabecera;

}
