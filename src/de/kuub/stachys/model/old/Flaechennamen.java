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
    @NamedQuery(name = "Flaechennamen.findAll",
            query = "SELECT f FROM Flaechennamen f"),
    @NamedQuery(name = "Flaechennamen.findByFlaliasId",
            query = "SELECT f FROM Flaechennamen f WHERE f.flaliasId = :flaliasId"),
    @NamedQuery(name = "Flaechennamen.findByFlName",
            query = "SELECT f FROM Flaechennamen f WHERE f.flName = :flName"),
    @NamedQuery(name = "Flaechennamen.findByHauptname",
            query = "SELECT f FROM Flaechennamen f WHERE f.hauptname = :hauptname")})
public class Flaechennamen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "flalias_id")
    private Integer flaliasId;

    @Basic(optional = false)
    @Column(name = "fl_name")
    private String flName;

    @Basic(optional = false)
    private boolean hauptname;

    @JoinColumn(name = "fl_id", referencedColumnName = "fl_id")
    @ManyToOne(optional = false)
    private Flaechen flId;

    public Flaechennamen() {
    }

    public Flaechennamen(Integer flaliasId) {
        this.flaliasId = flaliasId;
    }

    public Flaechennamen(Integer flaliasId, String flName, boolean hauptname) {
        this.flaliasId = flaliasId;
        this.flName = flName;
        this.hauptname = hauptname;
    }

    public Integer getFlaliasId() {
        return flaliasId;
    }

    public void setFlaliasId(Integer flaliasId) {
        this.flaliasId = flaliasId;
    }

    public String getFlName() {
        return flName;
    }

    public void setFlName(String flName) {
        this.flName = flName;
    }

    public boolean getHauptname() {
        return hauptname;
    }

    public void setHauptname(boolean hauptname) {
        this.hauptname = hauptname;
    }

    public Flaechen getFlId() {
        return flId;
    }

    public void setFlId(Flaechen flId) {
        this.flId = flId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (flaliasId != null ? flaliasId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Flaechennamen)) {
            return false;
        }
        Flaechennamen other = (Flaechennamen) object;
        if ((this.flaliasId == null && other.flaliasId != null) || (this.flaliasId != null && !this.flaliasId.equals(
                other.flaliasId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Flaechennamen[ flaliasId=" + flaliasId + " ]";
    }
}
