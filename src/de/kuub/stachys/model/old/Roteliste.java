/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bonke
 */
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Roteliste.findAll", query = "SELECT r FROM Roteliste r"),
    @NamedQuery(name = "Roteliste.findByRlId",
            query = "SELECT r FROM Roteliste r WHERE r.rlId = :rlId"),
    @NamedQuery(name = "Roteliste.findByLand",
            query = "SELECT r FROM Roteliste r WHERE r.land = :land"),
    @NamedQuery(name = "Roteliste.findByJahr",
            query = "SELECT r FROM Roteliste r WHERE r.jahr = :jahr"),
    @NamedQuery(name = "Roteliste.findByTransId",
            query = "SELECT r FROM Roteliste r WHERE r.transId = :transId")})
public class Roteliste implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "rl_id")
    private Integer rlId;

    @Basic(optional = false)
    private String land;

    @Basic(optional = false)
    private short jahr;

    @Column(name = "trans_id")
    private Integer transId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roteliste")
    private Collection<TaxRl> taxRlCollection;

    public Roteliste() {
    }

    public Roteliste(Integer rlId) {
        this.rlId = rlId;
    }

    public Roteliste(Integer rlId, String land, short jahr) {
        this.rlId = rlId;
        this.land = land;
        this.jahr = jahr;
    }

    public Integer getRlId() {
        return rlId;
    }

    public void setRlId(Integer rlId) {
        this.rlId = rlId;
    }

    public String getLand() {
        return land;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public short getJahr() {
        return jahr;
    }

    public void setJahr(short jahr) {
        this.jahr = jahr;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    @XmlTransient
    public Collection<TaxRl> getTaxRlCollection() {
        return taxRlCollection;
    }

    public void setTaxRlCollection(Collection<TaxRl> taxRlCollection) {
        this.taxRlCollection = taxRlCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rlId != null ? rlId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roteliste)) {
            return false;
        }
        Roteliste other = (Roteliste) object;
        if ((this.rlId == null && other.rlId != null) || (this.rlId != null && !this.rlId.equals(
                other.rlId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Roteliste[ rlId=" + rlId + " ]";
    }
}
