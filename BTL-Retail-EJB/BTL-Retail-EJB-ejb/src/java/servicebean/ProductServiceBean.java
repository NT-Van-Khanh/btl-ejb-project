/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import dao.ProductDAO;
import dto.ProductDTO;
import entity.Product;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import mapper.ProductMapper;
import service.ProductService;

/**
 *
 * @author ADMIN
 */
@Stateless  
public class ProductServiceBean implements ProductService{

     // Do ProductServiceBean không có trạng thái (state) giữa các request,
    // Stateless giúp cải thiện hiệu suất bằng cách cho phép container quản lý các instance.
//    @Inject  // Inject ProductDAO vào để sử dụng mà không cần tự khởi tạo
    @EJB  // Inject DAO đã là EJB
    private ProductDAO productDAO;

    @Override
    public void add(ProductDTO product){
        Product p = ProductMapper.toProduct(product);
        productDAO.add(p);
    }

    @Override
    public void update(ProductDTO product) {
        Product p = ProductMapper.toProduct(product);
        productDAO.update(p);
    }

    @Override
    public boolean delete(String id) {
        return productDAO.delete(id);
    }

    @Override
    public ProductDTO findById(String id) {
        Product p = productDAO.findById(id);
        return (p == null) ? null : ProductMapper.toProductDTO(p);
    }

    @Override
    public List<ProductDTO> findAll() {
       return productDAO.findAll().stream()
                    .map(p -> ProductMapper.toProductDTO(p))
                    .collect(Collectors.toList());
    }
    
}
