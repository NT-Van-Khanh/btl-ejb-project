/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Category;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class CategoryDAO {
    @PersistenceContext
    private EntityManager em;
    
    public List<Category> findAll() {
        return em.createNamedQuery("Category.findAll", Category.class).getResultList();
    }

    public Category findById(String id) {
        return em.find(Category.class, id);
    }

    public void add(Category category) {
        em.persist(category);
    }

    public void update(Category category) {
        em.merge(category);
    }

    public boolean delete(String id) {
        Category category = em.find(Category.class, id);
        if (category == null) return false;

        em.remove(category);
        return true;
    }
}
