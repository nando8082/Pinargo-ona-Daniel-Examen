/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;


import ec.edu.ups.entidades.Producto;
import ec.edu.ups.entidades.Bodega;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Daniel
 */
@Stateless
public class BodegaFacade extends AbstractFacade<Bodega> {

    @PersistenceContext(name = "examenInterciclo")
    private EntityManager em;

    public BodegaFacade() {
        super(Bodega.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
   
    public List<Bodega> listar(){
       return em.createQuery("SELECT u FROM Bodega u", Bodega.class).getResultList();
              
    }
    public Optional<Bodega> opcional(Long id) {
        return Optional.ofNullable(porId(id));
    }
    public Bodega porId(Long id) {
        return em.find(Bodega.class, id);
    }
    
    
    public void guardar(Bodega bodega) {
       
            em.merge(bodega);
        
    }
    
    public void eliminar(Long id) {
        Bodega bodega = porId(id);
        em.remove(bodega);
    }
    
    
}
