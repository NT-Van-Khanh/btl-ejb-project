/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Employee;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class EmployeeDAO {
    @PersistenceContext
    private EntityManager em;
    
    public List<Employee> findAll() {
        return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
    }

    public Employee findById(String id) {
        return em.find(Employee.class, id);
    }

    public void add(Employee employee) {
        em.persist(employee);
    }

    public void update(Employee employee) {
        em.merge(employee);
    }

    public boolean delete(String id) {
        Employee employee = em.find(Employee.class, id);
        if (employee == null) return false;
        
        employee.setFlag(true);
        em.merge(employee);
        return true;
    }
}