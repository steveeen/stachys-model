/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bonke
 */
@Entity(name = "Biotopi")
@Table(catalog = "pflanzenorg", name = "biotop", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biotopi.findAll", query = "SELECT b FROM Biotopi b"),
    @NamedQuery(name = "Biotopi.findByBiotopId",
            query = "SELECT b FROM Biotopi b WHERE b.biotopId = :biotopId"),
    @NamedQuery(name = "Biotopi.findByBiotoptyp",
            query = "SELECT b FROM Biotopi b WHERE b.biotoptyp = :biotoptyp")})
public class Biotop implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "`biotop_id`")
    private Integer biotopId;

    @Basic(optional = false)
    private String biotoptyp;

    @JoinTable(name = "tax_biotop", joinColumns = {
        @JoinColumn(name = "`biotop_id´", referencedColumnName = "`biotop_id`")},
            inverseJoinColumns = {
        @JoinColumn(name = "arte_id", referencedColumnName = "art_id")})
    @ManyToMany
    private Collection<Taxonomisch> taxonomischCollection;

    public Biotop() {
    }

    public Biotop(Integer biotopId) {
        this.biotopId = biotopId;
    }

    public Biotop(Integer biotopId, String biotoptyp) {
        this.biotopId = biotopId;
        this.biotoptyp = biotoptyp;
    }

    public Integer getBiotopId() {
        return biotopId;
    }

    public void setBiotopId(Integer biotopId) {
        this.biotopId = biotopId;
    }

    public String getBiotoptyp() {
        return biotoptyp;
    }

    public void setBiotoptyp(String biotoptyp) {
        this.biotoptyp = biotoptyp;
    }

    @XmlTransient
    public Collection<Taxonomisch> getTaxonomischCollection() {
        return taxonomischCollection;
    }

    public void setTaxonomischCollection(Collection<Taxonomisch> taxonomischCollection) {
        this.taxonomischCollection = taxonomischCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biotopId != null ? biotopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biotop)) {
            return false;
        }
        Biotop other = (Biotop) object;
        if ((this.biotopId == null && other.biotopId != null) || (this.biotopId != null && !this.biotopId.equals(
                other.biotopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Biotop[ biotopId=" + biotopId + " ]";
    }
}
