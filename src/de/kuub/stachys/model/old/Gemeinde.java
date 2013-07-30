/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bonke
 */
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gemeinde.findAll", query = "SELECT g FROM Gemeinde g"),
    @NamedQuery(name = "Gemeinde.findByGemId",
            query = "SELECT g FROM Gemeinde g WHERE g.gemId = :gemId"),
    @NamedQuery(name = "Gemeinde.findByGemeindename",
            query = "SELECT g FROM Gemeinde g WHERE g.gemeindename = :gemeindename"),
    @NamedQuery(name = "Gemeinde.findByGemNr",
            query = "SELECT g FROM Gemeinde g WHERE g.gemNr = :gemNr")})
public class Gemeinde implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gem_id")
    private Integer gemId;

    @Basic(optional = false)
    private String gemeindename;

    @Lob
    private Object area;

    @Column(name = "gem_nr")
    private Integer gemNr;

    @JoinColumn(name = "kreis_id", referencedColumnName = "kreis_id")
    @ManyToOne
    private Kreise kreisId;

    public Gemeinde() {
    }

    public Gemeinde(Integer gemId) {
        this.gemId = gemId;
    }

    public Gemeinde(Integer gemId, String gemeindename) {
        this.gemId = gemId;
        this.gemeindename = gemeindename;
    }

    public Integer getGemId() {
        return gemId;
    }

    public void setGemId(Integer gemId) {
        this.gemId = gemId;
    }

    public String getGemeindename() {
        return gemeindename;
    }

    public void setGemeindename(String gemeindename) {
        this.gemeindename = gemeindename;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    public Integer getGemNr() {
        return gemNr;
    }

    public void setGemNr(Integer gemNr) {
        this.gemNr = gemNr;
    }

    public Kreise getKreisId() {
        return kreisId;
    }

    public void setKreisId(Kreise kreisId) {
        this.kreisId = kreisId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gemId != null ? gemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gemeinde)) {
            return false;
        }
        Gemeinde other = (Gemeinde) object;
        if ((this.gemId == null && other.gemId != null) || (this.gemId != null && !this.gemId.equals(
                other.gemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gemeinde[ gemId=" + gemId + " ]";
    }
}
