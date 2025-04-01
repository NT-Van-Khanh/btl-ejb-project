/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.countAll", query = "SELECT COUNT(p) FROM Product p"),
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByDetail", query = "SELECT p FROM Product p WHERE p.detail = :detail"),
    @NamedQuery(name = "Product.findByQuantity", query = "SELECT p FROM Product p WHERE p.quantity = :quantity"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByLastUpdate", query = "SELECT p FROM Product p WHERE p.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Product.findByCreatedAt", query = "SELECT p FROM Product p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Product.findByFlag", query = "SELECT p FROM Product p WHERE p.flag = :flag")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 2147483647)
    @Column(name = "detail")
    private String detail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private Integer price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_update")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull    
    @Column(name = "flag")
    private boolean flag;
    @OneToMany( mappedBy = "productId")
    private Collection<Productnutrient> productnutrientCollection;
    @OneToMany(mappedBy = "productId")
    private Collection<Orderitem> orderitemCollection;
    
    @JoinColumn(name = "brand_id", referencedColumnName = "id")
    @ManyToOne
    private Brand brandId;
    
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Category categoryId;
    
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Employee employeeId;
    
    @JoinColumn(name = "unit_id", referencedColumnName = "id")
    @ManyToOne
    private Unit unitId;

    public Product() {
    }

    public Product(String id) {
        this.id = id;
    }

    public Product(String id, String name, short quantity, Integer price, Date lastUpdate, Date createdAt, boolean flag) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.lastUpdate = lastUpdate;
        this.createdAt = createdAt;
        this.flag = flag;
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

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
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

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @XmlTransient
    public Collection<Productnutrient> getProductnutrientCollection() {
        return productnutrientCollection;
    }

    public void setProductnutrientCollection(Collection<Productnutrient> productnutrientCollection) {
        this.productnutrientCollection = productnutrientCollection;
    }

    @XmlTransient
    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
    }

    public Unit getUnitId() {
        return unitId;
    }

    public void setUnitId(Unit unitId) {
        this.unitId = unitId;
    }

    public boolean isFlag() {
        return flag;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Product[ id=" + id + " ]";
    }
    
}
