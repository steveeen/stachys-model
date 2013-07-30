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
    @NamedQuery(name = "Zeitschrift.findAll",
            query = "SELECT z FROM Zeitschrift z"),
    @NamedQuery(name = "Zeitschrift.findByZeitschriftId",
            query = "SELECT z FROM Zeitschrift z WHERE z.zeitschriftId = :zeitschriftId"),
    @NamedQuery(name = "Zeitschrift.findByTitel",
            query = "SELECT z FROM Zeitschrift z WHERE z.titel = :titel")})
public class Zeitschrift implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zeitschrift_id")
    private Integer zeitschriftId;

    @Basic(optional = false)
    private String titel;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zeitschrift")
    private Collection<QuZeit> quZeitCollection;

    public Zeitschrift() {
    }

    public Zeitschrift(Integer zeitschriftId) {
        this.zeitschriftId = zeitschriftId;
    }

    public Zeitschrift(Integer zeitschriftId, String titel) {
        this.zeitschriftId = zeitschriftId;
        this.titel = titel;
    }

    public Integer getZeitschriftId() {
        return zeitschriftId;
    }

    public void setZeitschriftId(Integer zeitschriftId) {
        this.zeitschriftId = zeitschriftId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    @XmlTransient
    public Collection<QuZeit> getQuZeitCollection() {
        return quZeitCollection;
    }

    public void setQuZeitCollection(Collection<QuZeit> quZeitCollection) {
        this.quZeitCollection = quZeitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zeitschriftId != null ? zeitschriftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zeitschrift)) {
            return false;
        }
        Zeitschrift other = (Zeitschrift) object;
        if ((this.zeitschriftId == null && other.zeitschriftId != null) || (this.zeitschriftId != null && !this.zeitschriftId.equals(
                other.zeitschriftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zeitschrift[ zeitschriftId=" + zeitschriftId + " ]";
    }
}
