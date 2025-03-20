/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ADMIN
 */
@Entity
@Table(name = "Order_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderitem.findAll", query = "SELECT o FROM Orderitem o"),
    @NamedQuery(name = "Orderitem.findById", query = "SELECT o FROM Orderitem o WHERE o.id = :id"),
    @NamedQuery(name = "Orderitem.findByQuantity", query = "SELECT o FROM Orderitem o WHERE o.quantity = :quantity"),
    @NamedQuery(name = "Orderitem.findByPrice", query = "SELECT o FROM Orderitem o WHERE o.price = :price"),
    @NamedQuery(name = "Orderitem.findByTotalCost", query = "SELECT o FROM Orderitem o WHERE o.totalCost = :totalCost"),
    @NamedQuery(name = "Orderitem.findByCreatedAt", query = "SELECT o FROM Orderitem o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Orderitem.findByFlag", query = "SELECT o FROM Orderitem o WHERE o.flag = :flag")})
public class Orderitem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private short quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "flag")
    private boolean flag;
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Orderproduct orderId;
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Product productId;

    public Orderitem() {
    }

    public Orderitem(Integer id) {
        this.id = id;
    }

    public Orderitem(Integer id, short quantity, BigDecimal price, Date createdAt, boolean flag) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.createdAt = createdAt;
        this.flag = flag;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public short getQuantity() {
        return quantity;
    }

    public void setQuantity(short quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
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

    public Orderproduct getOrderId() {
        return orderId;
    }

    public void setOrderId(Orderproduct orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof Orderitem)) {
            return false;
        }
        Orderitem other = (Orderitem) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderitem[ id=" + id + " ]";
    }
    
}
