/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dao.BrandDAO;
import dto.BrandDTO;
import entity.Brand;
import javax.ejb.EJB;

/**
 *
 * @author ADMIN
 */
public class BrandMapper {
    
    static BrandDTO toBrandDTO(Brand brand ){
        if (brand == null)    return null;
        return new BrandDTO(brand.getId(), brand.getName());
    }

    static Brand toBrand(BrandDTO brandDTO) {
        if (brandDTO == null)    return null;
        return new Brand(brandDTO.getId(),brandDTO.getName());
    }
}
