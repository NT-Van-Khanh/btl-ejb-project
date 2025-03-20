/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

import entity.Orderitem;
import entity.Product;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class ProductDTO {
    private String id;
    private String name;
    private String detail;
    private BigDecimal price;
    private UnitDTO unit;
    private Short quantity;
    private Date lastUpdate;
    private Date createdAt;
    private BrandDTO brand;
    private CategoryDTO category;
    private Collection<Orderitem> orderitemCollection;
    private EmployeeDTO employee;
    
    public ProductDTO() {}

    public ProductDTO(String id, String name, String detail, BigDecimal price, UnitDTO unit, Short quantity, Date lastUpdate, Date createdAt, BrandDTO brand, CategoryDTO category, EmployeeDTO employee) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.unit = unit;
        this.quantity = quantity;
        this.lastUpdate = lastUpdate;
        this.createdAt = createdAt;
        this.brand = brand;
        this.category = category;
        this.employee = employee;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    

    public Short getQuantity() {
        return quantity;
    }

    public void setQuantity(Short quantity) {
        this.quantity = quantity;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    public UnitDTO getUnit() {
        return unit;
    }

    public void setUnit(UnitDTO unit) {
        this.unit = unit;
    }

    public BrandDTO getBrand() {
        return brand;
    }

    public void setBrand(BrandDTO brand) {
        this.brand = brand;
    }

    public CategoryDTO getCategory() {
        return category;
    }

    public void setCategory(CategoryDTO category) {
        this.category = category;
    }

    public EmployeeDTO getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeDTO employee) {
        this.employee = employee;
    }


}
