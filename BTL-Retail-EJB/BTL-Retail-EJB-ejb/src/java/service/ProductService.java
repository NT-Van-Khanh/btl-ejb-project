/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.ProductDTO;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

/**
 *
 * @author ADMIN
 */
//@Local
@Remote
public interface ProductService {
    void add(ProductDTO product);
    void update(ProductDTO product);
    boolean delete(String id);
    ProductDTO findById(String id);
    List<ProductDTO> findAll();
}
