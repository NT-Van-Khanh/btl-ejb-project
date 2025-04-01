/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Unit;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class UnitDAO {
    @PersistenceContext
    private EntityManager em;
    
    public List<Unit> findAll() {
        return em.createNamedQuery("Unit.findAll", Unit.class).getResultList();
    }

    public Unit findById(String id) {
        return em.find(Unit.class, id);
    }

    public void add(Unit unit) {
        em.persist(unit);
    }

    public void update(Unit unit) {
        em.merge(unit);
    }

    public boolean delete(String id) {
        Unit unit = em.find(Unit.class, id);
        if (unit == null) return false;

        unit.setFlag(true);
        em.merge(unit);
        return true;
    }
}
