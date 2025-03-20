/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Brand;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class BrandDAO {
    @PersistenceContext
    private EntityManager em;
    
    public List<Brand> findAll() {
        return em.createNamedQuery("Brand.findAll", Brand.class).getResultList();
    }

    public Brand findById(String id) {
        return em.find(Brand.class, id);
    }

    public void add(Brand brand) {
        em.persist(brand);
    }

    public void update(Brand brand) {
        em.merge(brand);
    }

    public boolean delete(String id) {
        Brand brand = em.find(Brand.class, id);
        if (brand == null) return false;

        em.remove(brand);
        return true;
    }
}