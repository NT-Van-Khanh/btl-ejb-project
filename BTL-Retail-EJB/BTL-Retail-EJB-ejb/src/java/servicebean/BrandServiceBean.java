/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import dao.BrandDAO;
import dto.BrandDTO;
import entity.Brand;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.BrandMapper;
import service.BrandService;

/**
 *
 * @author ADMIN
 */
@Stateless  
public class BrandServiceBean implements BrandService{
    
    @EJB
    private BrandDAO brandDAO;
    
    @Override
    public BrandDTO findById(String id) {
        Brand b = brandDAO.findById(id);
        return (b == null) ? null : BrandMapper.toBrandDTO(b);
    }

    @Override
    public List<BrandDTO> findAll() {
       return brandDAO.findAll().stream()
                    .map(b -> BrandMapper.toBrandDTO(b))
                    .collect(Collectors.toList());
    }
}
