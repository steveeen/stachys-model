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
    @NamedQuery(name = "Kreise.findAll", query = "SELECT k FROM Kreise k"),
    @NamedQuery(name = "Kreise.findByKreisId",
            query = "SELECT k FROM Kreise k WHERE k.kreisId = :kreisId"),
    @NamedQuery(name = "Kreise.findByKreisname",
            query = "SELECT k FROM Kreise k WHERE k.kreisname = :kreisname"),
    @NamedQuery(name = "Kreise.findByKreisNr",
            query = "SELECT k FROM Kreise k WHERE k.kreisNr = :kreisNr")})
public class Kreise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kreis_id")
    private Integer kreisId;

    @Basic(optional = false)
    private String kreisname;

    @Lob
    private Object area;

    @Basic(optional = false)
    @Column(name = "kreis_nr")
    private int kreisNr;

    @OneToMany(mappedBy = "kreisId")
    private Collection<Gemeinde> gemeindeCollection;

    public Kreise() {
    }

    public Kreise(Integer kreisId) {
        this.kreisId = kreisId;
    }

    public Kreise(Integer kreisId, String kreisname, int kreisNr) {
        this.kreisId = kreisId;
        this.kreisname = kreisname;
        this.kreisNr = kreisNr;
    }

    public Integer getKreisId() {
        return kreisId;
    }

    public void setKreisId(Integer kreisId) {
        this.kreisId = kreisId;
    }

    public String getKreisname() {
        return kreisname;
    }

    public void setKreisname(String kreisname) {
        this.kreisname = kreisname;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public int getKreisNr() {
        return kreisNr;
    }

    public void setKreisNr(int kreisNr) {
        this.kreisNr = kreisNr;
    }

    @XmlTransient
    public Collection<Gemeinde> getGemeindeCollection() {
        return gemeindeCollection;
    }

    public void setGemeindeCollection(Collection<Gemeinde> gemeindeCollection) {
        this.gemeindeCollection = gemeindeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kreisId != null ? kreisId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kreise)) {
            return false;
        }
        Kreise other = (Kreise) object;
        if ((this.kreisId == null && other.kreisId != null) || (this.kreisId != null && !this.kreisId.equals(
                other.kreisId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Kreise[ kreisId=" + kreisId + " ]";
    }
}
