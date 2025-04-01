/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.CategoryDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ADMIN
 */
@Remote
public interface CategoryService {
    List<CategoryDTO> findAll();
    CategoryDTO findById(String id);
}
