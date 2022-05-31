/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.beans;

import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.facade.BodegaFacade;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Model;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Daniel
 */
@Model
public class BodegaBeans implements Serializable {

    @EJB
    private BodegaFacade sFacade;
    private long id;
    private Bodega sucursal;

    @Produces
    @Model

   
    @PostConstruct
    public void init() {
        this.sucursal = new Bodega();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Bodega getSucursal() {
        return sucursal;
    }

    public void setSucursal(Bodega sucursal) {
        this.sucursal = sucursal;
    }

    @Produces
    @RequestScoped
    @Named("listadoSucursales")
    public List<Bodega> listadoSucursales() {
        List<Bodega> prod = sFacade.listar();
        return prod;
    }

    public String guardar() {
        try {
            this.sFacade.guardar(sucursal);
            sucursal = new Bodega();
        } catch (Exception e) {
        }
        return "sucursalCRUD.xhtml?faces-redirect=true";
    }

    public String eliminar(Long id) {
        sFacade.eliminar(id);
        return "sucursalCRUD.xhtml?faces-redirect=true";
    }

    public String editar(Long id) {
        this.id = id;

        if (id != null && id > 0) {
            sFacade.opcional(id).ifPresent(p -> {
                this.sucursal = p;
            });
        }
        return "formSucursal.xhtml";
    }
}
