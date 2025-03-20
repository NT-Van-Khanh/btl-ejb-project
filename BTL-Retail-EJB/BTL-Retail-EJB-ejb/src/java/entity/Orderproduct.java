/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "Order_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Orderproduct.findAll", query = "SELECT o FROM Orderproduct o"),
    @NamedQuery(name = "Orderproduct.findById", query = "SELECT o FROM Orderproduct o WHERE o.id = :id"),
    @NamedQuery(name = "Orderproduct.findByTotalCost", query = "SELECT o FROM Orderproduct o WHERE o.totalCost = :totalCost"),
    @NamedQuery(name = "Orderproduct.findByPayStatus", query = "SELECT o FROM Orderproduct o WHERE o.payStatus = :payStatus"),
    @NamedQuery(name = "Orderproduct.findByShipStatus", query = "SELECT o FROM Orderproduct o WHERE o.shipStatus = :shipStatus"),
    @NamedQuery(name = "Orderproduct.findByAddress", query = "SELECT o FROM Orderproduct o WHERE o.address = :address"),
    @NamedQuery(name = "Orderproduct.findByLastUpdate", query = "SELECT o FROM Orderproduct o WHERE o.lastUpdate = :lastUpdate"),
    @NamedQuery(name = "Orderproduct.findByCreatedAt", query = "SELECT o FROM Orderproduct o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "Orderproduct.findByFlag", query = "SELECT o FROM Orderproduct o WHERE o.flag = :flag"),
    @NamedQuery(name = "Orderproduct.findByNote", query = "SELECT o FROM Orderproduct o WHERE o.note = :note")})
public class Orderproduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "id")
    private String id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_cost")
    private BigDecimal totalCost;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "pay_status")
    private String payStatus;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ship_status")
    private String shipStatus;
    @Size(max = 150)
    @Column(name = "address")
    private String address;
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
    @Size(max = 2147483647)
    @Column(name = "note")
    private String note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<Orderitem> orderitemCollection;
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Customer customerId;
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne
    private Employee employeeId;

    public Orderproduct() {
    }

    public Orderproduct(String id) {
        this.id = id;
    }

    public Orderproduct(String id, BigDecimal totalCost, String payStatus, String shipStatus, Date lastUpdate, Date createdAt, boolean flag) {
        this.id = id;
        this.totalCost = totalCost;
        this.payStatus = payStatus;
        this.shipStatus = shipStatus;
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

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getShipStatus() {
        return shipStatus;
    }

    public void setShipStatus(String shipStatus) {
        this.shipStatus = shipStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<Orderitem> getOrderitemCollection() {
        return orderitemCollection;
    }

    public void setOrderitemCollection(Collection<Orderitem> orderitemCollection) {
        this.orderitemCollection = orderitemCollection;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Employee getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employeeId = employeeId;
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
        if (!(object instanceof Orderproduct)) {
            return false;
        }
        Orderproduct other = (Orderproduct) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Orderproduct[ id=" + id + " ]";
    }
    
}
