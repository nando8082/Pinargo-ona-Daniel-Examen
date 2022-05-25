/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.facade;

import ec.edu.ups.entidades.Cliente;
import ec.edu.ups.entidades.Usuario;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import java.util.List;

/**
 *
 * @author Jonny,Daniel,Elvis,Edisson
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

    @PersistenceContext(name = "TestJpa")
    private EntityManager em;

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Usuario iniciarSesion(Usuario u) {
        Usuario usuario = null;
        String consulta;
        try {
            consulta = "SELECT u FROM Usuario u WHERE u.correo = ?1 and u.contrasenia= ?2";
            Query query;
            query = em.createQuery(consulta);
            query.setParameter(1, u.getCorreo());
            query.setParameter(2, u.getContrasenia());
            List<Usuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
        } catch (Exception e) {
            throw e;
        }
        return usuario;
    }

}
