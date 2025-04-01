/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import dao.CategoryDAO;
import dto.CategoryDTO;
import entity.Category;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.CategoryMapper;
import service.CategoryService;

@Stateless  
public class CategoryServiceBean implements CategoryService{
    @EJB
    private CategoryDAO categoryDAO;

    @Override
    public List<CategoryDTO> findAll() {
        return categoryDAO.findAll().stream()
                .map(c -> CategoryMapper.toCategoryDTO(c))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO findById(String id) {
        Category category  = categoryDAO.findById(id);
        return (category == null) ? null : CategoryMapper.toCategoryDTO(category);
    }
}
