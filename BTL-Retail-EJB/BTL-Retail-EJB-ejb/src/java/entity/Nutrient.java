/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Nutrient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nutrient.findAll", query = "SELECT n FROM Nutrient n"),
    @NamedQuery(name = "Nutrient.findById", query = "SELECT n FROM Nutrient n WHERE n.id = :id"),
    @NamedQuery(name = "Nutrient.findByName", query = "SELECT n FROM Nutrient n WHERE n.name = :name"),
    @NamedQuery(name = "Nutrient.findByFlag", query = "SELECT n FROM Nutrient n WHERE n.flag = :flag")})
public class Nutrient implements Serializable {

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
    @Lob
    @Size(max = 2147483647)
    @Column(name = "detail")
    private String detail;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag")
    private boolean flag;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nutrientId")
    private Collection<Productnutrient> productnutrientCollection;

    public Nutrient() {
    }

    public Nutrient(String id) {
        this.id = id;
    }

    public Nutrient(String id, String name, boolean flag) {
        this.id = id;
        this.name = name;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nutrient)) {
            return false;
        }
        Nutrient other = (Nutrient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Nutrient[ id=" + id + " ]";
    }
    
}
