/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Product_nutrient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Productnutrient.findAll", query = "SELECT p FROM Productnutrient p"),
    @NamedQuery(name = "Productnutrient.findById", query = "SELECT p FROM Productnutrient p WHERE p.id = :id"),
    @NamedQuery(name = "Productnutrient.findByNutrientId", query = "SELECT p FROM Productnutrient p WHERE p.nutrientId = :nutrientId"),
    @NamedQuery(name = "Productnutrient.findByFlag", query = "SELECT p FROM Productnutrient p WHERE p.flag = :flag")})
public class Productnutrient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    
    @JoinColumn(name = "nutrient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Nutrient nutrientId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag")
    private boolean flag;

    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public Productnutrient() {
    }

    public Productnutrient(String id) {
        this.id = id;
    }

    public Productnutrient(String id,  boolean flag) {
        this.id = id;
        this.flag = flag;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Nutrient getNutrientId() {
        return nutrientId;
    }

    public void setNutrientId(Nutrient nutrientId) {
        this.nutrientId = nutrientId;
    }



    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }



    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
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
        if (!(object instanceof Productnutrient)) {
            return false;
        }
        Productnutrient other = (Productnutrient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Productnutrient[ id=" + id + " ]";
    }
    
}
