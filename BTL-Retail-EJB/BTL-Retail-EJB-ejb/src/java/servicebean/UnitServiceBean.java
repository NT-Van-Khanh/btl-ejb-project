/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicebean;

import dao.UnitDAO;
import dto.UnitDTO;
import entity.Unit;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import mapper.UnitMapper;
import service.UnitService;

@Stateless  
public class UnitServiceBean implements UnitService{

    @EJB 
    private UnitDAO unitDAO;
     
    @Override
    public List<UnitDTO> findAll() {
       return unitDAO.findAll().stream()
               .map(p -> UnitMapper.toUnitDTO(p))
               .collect(Collectors.toList());
    }

    @Override
    public UnitDTO findById(String id) {
        Unit unit = unitDAO.findById(id);
        return (unit == null) ? null : UnitMapper.toUnitDTO(unit);
    }
    
}
