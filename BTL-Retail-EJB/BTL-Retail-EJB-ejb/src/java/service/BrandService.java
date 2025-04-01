/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dto.BrandDTO;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ADMIN
 */
@Remote
public interface BrandService {
    List<BrandDTO> findAll();
    BrandDTO findById( String id);
}
