/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.BrandDTO;
import dto.CategoryDTO;
import dto.EmployeeDTO;
import dto.ProductDTO;
import dto.UnitDTO;
import entity.Product;
/**
 *
 * @author ADMIN
 */
public class ProductMapper {
       
    public static ProductDTO toProductDTO(Product product){
        if(product == null) return null;
        
        UnitDTO unitDTO = UnitMapper.toUnitDTO(product.getUnitId());
        CategoryDTO categoryDTO = CategoryMapper.toCategoryDTO(product.getCategoryId());
        BrandDTO brandDTO = BrandMapper.toBrandDTO(product.getBrandId());
        EmployeeDTO employeeDTO = EmployeeMapper.toEmployeeDTO(product.getEmployeeId());
        
        return new ProductDTO(product.getId(), product.getName(), product.getDetail(), 
                product.getPrice(), unitDTO, product.getQuantity(), product.getLastUpdate(),
                product.getCreatedAt(), brandDTO, categoryDTO,employeeDTO);
    }
    
    public static Product toProduct(ProductDTO productDTO){
        if(productDTO == null) return null;
        
        Product p = new Product(productDTO.getId(),productDTO.getName(), productDTO.getQuantity(), 
                    productDTO.getPrice() ,productDTO.getLastUpdate(),productDTO.getCreatedAt(),false);
        
        p.setUnitId(UnitMapper.toUnit(productDTO.getUnit()));
        p.setBrandId(BrandMapper.toBrand(productDTO.getBrand()));
        p.setCategoryId(CategoryMapper.toCategory(productDTO.getCategory()));
        p.setEmployeeId(EmployeeMapper.toEmployee(productDTO.getEmployee()));
        return p;
    }
}
