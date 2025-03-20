/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.CategoryDTO;
import entity.Category;

/**
 *
 * @author ADMIN
 */
public class CategoryMapper {
    static CategoryDTO toCategoryDTO(Category category ){
        if (category == null) return null;
        return new CategoryDTO(category.getId(), category.getName());
    }

    static Category toCategory(CategoryDTO categoryDTO) {
        if (categoryDTO == null) return null;
        return new Category(categoryDTO.getId(),categoryDTO.getName());
    }
}
