/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author GP63
 */
@Entity
@Table(name = "DVDCART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dvdcart.findAll", query = "SELECT d FROM Dvdcart d"),
    @NamedQuery(name = "Dvdcart.findById", query = "SELECT d FROM Dvdcart d WHERE d.id = :id"),
    @NamedQuery(name = "Dvdcart.findByQuantity", query = "SELECT d FROM Dvdcart d WHERE d.quantity = :quantity"),
    @NamedQuery(name = "Dvdcart.findByIdCatalog", query = "SELECT d FROM Dvdcart d WHERE d.idCatalog = :idCatalog"),})
public class Dvdcart implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "QUANTITY")
    private Integer quantity;
    @JoinColumn(name = "ID_CATALOG", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Dvdcatalog idCatalog;

    public Dvdcart() {
    }

    public Dvdcart(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Dvdcatalog getIdCatalog() {
        return idCatalog;
    }

    public void setIdCatalog(Dvdcatalog idCatalog) {
        this.idCatalog = idCatalog;
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
        if (!(object instanceof Dvdcart)) {
            return false;
        }
        Dvdcart other = (Dvdcart) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dvdcart[ id=" + id + " ]";
    }
    
}
