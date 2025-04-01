/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.BrandDTO;
import entity.Brand;


public class BrandMapper {
    
    public static BrandDTO toBrandDTO(Brand brand ){
        if (brand == null)    return null;
        return new BrandDTO(brand.getId(), brand.getName());
    }

    public static Brand toBrand(BrandDTO brandDTO) {
        if (brandDTO == null)    return null;
        return new Brand(brandDTO.getId(),brandDTO.getName());
    }
}
