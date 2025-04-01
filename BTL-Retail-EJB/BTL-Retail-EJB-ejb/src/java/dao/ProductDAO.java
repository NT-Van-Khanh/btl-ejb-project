/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Product;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author ADMIN
 */
// Đánh dấu ProductDAO là một Stateless Session Bean (EJB),
//giúp quản lý truy vấn dữ liệu mà không lưu trạng thái,
// giúp container quản lý vòng đời, tối ưu tài nguyên.
@Stateless
public class ProductDAO {
    @PersistenceContext
    private EntityManager em;
    
     public List<Product> findAll() {
        return em.createNamedQuery("Product.findAll", Product.class).getResultList();
    }
     
    public Product findById(String id){
        return em.find(Product.class, id);
    }
     
    public List<Product> findByName(String name){
        return em.createNamedQuery("Product.findByName",Product.class)
                .setParameter("name", "%" + name + "%")
                .getResultList();
    }
    
    public void add(Product product) {
        em.persist(product);
    }
    @Transactional
    public void update(Product product) {
        Product existingProduct = em.find(Product.class, product.getId());
        if (existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDetail(product.getDetail());
            existingProduct.setQuantity(product.getQuantity());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setLastUpdate(product.getLastUpdate()); // Cập nhật thời gian chỉnh sửa
            existingProduct.setBrandId(product.getBrandId());
            existingProduct.setCategoryId(product.getCategoryId());
            existingProduct.setEmployeeId(product.getEmployeeId());
            existingProduct.setUnitId(product.getUnitId());
            em.merge(existingProduct);
        }
//        em.merge(product);
    }
    
    public boolean delete(String id){
        Product product = em.find(Product.class, id);
        if (product == null)    return false;
        product.setFlag(true);
        em.merge(product);
        return true;
    }
    
    public Long count(){
        return em.createNamedQuery("Product.countAll",Long.class)
                .getSingleResult();
    }
//    public boolean delete(String id) {
//        Product product = em.find(Product.class, id);
//        if (product == null)    return false;
//        
//        em.remove(product);
//        return true;
//            
//    }
}
