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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Flaechen.findAll", query = "SELECT f FROM Flaechen f"),
    @NamedQuery(name = "Flaechen.findByFlId",
            query = "SELECT f FROM Flaechen f WHERE f.flId = :flId"),
    @NamedQuery(name = "Flaechen.findByFlaechenname",
            query = "SELECT f FROM Flaechen f WHERE f.flaechenname = :flaechenname")})
public class Flaechen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fl_id")
    private Integer flId;

    private String flaechenname;

    @Lob
    private Object area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "flId")
    private Collection<Flaechennamen> flaechennamenCollection;

    public Flaechen() {
    }

    public Flaechen(Integer flId) {
        this.flId = flId;
    }

    public Integer getFlId() {
        return flId;
    }

    public void setFlId(Integer flId) {
        this.flId = flId;
    }

    public String getFlaechenname() {
        return flaechenname;
    }

    public void setFlaechenname(String flaechenname) {
        this.flaechenname = flaechenname;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<Flaechennamen> getFlaechennamenCollection() {
        return flaechennamenCollection;
    }

    public void setFlaechennamenCollection(Collection<Flaechennamen> flaechennamenCollection) {
        this.flaechennamenCollection = flaechennamenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flId != null ? flId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flaechen)) {
            return false;
        }
        Flaechen other = (Flaechen) object;
        if ((this.flId == null && other.flId != null) || (this.flId != null && !this.flId.equals(
                other.flId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Flaechen[ flId=" + flId + " ]";
    }
}
