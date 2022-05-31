package ec.edu.ups.beans;


import ec.edu.ups.entidades.Bodega;
import ec.edu.ups.facade.BodegaFacade;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.Optional;

@RequestScoped
@Named("sucursalConverter")
public class BodegaConverter implements Converter<Bodega> {

    @Inject
    private BodegaFacade sfacade;
            
    @Override
    public Bodega getAsObject(FacesContext context, UIComponent component, String id) {
        if (id == null) {
            return null;
        }
        Optional<Bodega> suOptional = sfacade.opcional(Long.valueOf(id));
        if (suOptional.isPresent()) {
            return suOptional.get();
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Bodega su) {
        if (su == null) {
            return "0";
        }
        return su.getId().toString();
    }
}
