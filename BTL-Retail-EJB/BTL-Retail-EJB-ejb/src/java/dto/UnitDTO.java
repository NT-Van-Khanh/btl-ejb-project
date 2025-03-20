/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entity.Unit;

/**
 *
 * @author ADMIN
 */
public class UnitDTO {
    private String id;
    private String name;

    public UnitDTO() {}

    public UnitDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
//    public UnitDTO toDTO(Unit unit){
//        return new UnitDTO(unit.getId(), unit.getName());
//    }
}
