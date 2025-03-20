/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mapper;

import dto.UnitDTO;
import entity.Unit;

/**
 *
 * @author ADMIN
 */
public class UnitMapper {
    public static UnitDTO toUnitDTO(Unit unit ){
        return (unit == null) ? null : new UnitDTO(unit.getId(), unit.getName());
//        if(unit == null) return null;
//        return new UnitDTO(unit.getId(), unit.getName());
    }

    static Unit toUnit(UnitDTO unitDTO) {
        return (unitDTO == null) ? null : new Unit(unitDTO.getId(), unitDTO.getName());
//        if(unitDTO == null) return null;
//        return new Unit(unitDTO.getId(), unitDTO.getName());
    }
        
}
