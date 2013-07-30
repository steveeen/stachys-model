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
    @NamedQuery(name = "Gebietsnamen.findAll",
            query = "SELECT g FROM Gebietsnamen g"),
    @NamedQuery(name = "Gebietsnamen.findByGbaliasId",
            query = "SELECT g FROM Gebietsnamen g WHERE g.gbaliasId = :gbaliasId"),
    @NamedQuery(name = "Gebietsnamen.findByGebName",
            query = "SELECT g FROM Gebietsnamen g WHERE g.gebName = :gebName"),
    @NamedQuery(name = "Gebietsnamen.findByHauptname",
            query = "SELECT g FROM Gebietsnamen g WHERE g.hauptname = :hauptname")})
public class Gebietsnamen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gbalias_id")
    private Integer gbaliasId;

    @Basic(optional = false)
    @Column(name = "geb_name")
    private String gebName;

    @Basic(optional = false)
    private boolean hauptname;

    @JoinColumn(name = "gebiet_id", referencedColumnName = "gebiet_id")
    @ManyToOne(optional = false)
    private Gebiet gebietId;

    public Gebietsnamen() {
    }

    public Gebietsnamen(Integer gbaliasId) {
        this.gbaliasId = gbaliasId;
    }

    public Gebietsnamen(Integer gbaliasId, String gebName, boolean hauptname) {
        this.gbaliasId = gbaliasId;
        this.gebName = gebName;
        this.hauptname = hauptname;
    }

    public Integer getGbaliasId() {
        return gbaliasId;
    }

    public void setGbaliasId(Integer gbaliasId) {
        this.gbaliasId = gbaliasId;
    }

    public String getGebName() {
        return gebName;
    }

    public void setGebName(String gebName) {
        this.gebName = gebName;
    }

    public boolean getHauptname() {
        return hauptname;
    }

    public void setHauptname(boolean hauptname) {
        this.hauptname = hauptname;
    }

    public Gebiet getGebietId() {
        return gebietId;
    }

    public void setGebietId(Gebiet gebietId) {
        this.gebietId = gebietId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gbaliasId != null ? gbaliasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebietsnamen)) {
            return false;
        }
        Gebietsnamen other = (Gebietsnamen) object;
        if ((this.gbaliasId == null && other.gbaliasId != null) || (this.gbaliasId != null && !this.gbaliasId.equals(
                other.gbaliasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gebietsnamen[ gbaliasId=" + gbaliasId + " ]";
    }
}
