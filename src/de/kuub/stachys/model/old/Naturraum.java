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
import javax.persistence.Lob;
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
    @NamedQuery(name = "Naturraum.findAll", query = "SELECT n FROM Naturraum n"),
    @NamedQuery(name = "Naturraum.findByNrname",
            query = "SELECT n FROM Naturraum n WHERE n.nrname = :nrname"),
    @NamedQuery(name = "Naturraum.findByNrId",
            query = "SELECT n FROM Naturraum n WHERE n.nrId = :nrId")})
public class Naturraum implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    private String nrname;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "nr_id")
    private Integer nrId;

    @Lob
    private Object area;

    public Naturraum() {
    }

    public Naturraum(Integer nrId) {
        this.nrId = nrId;
    }

    public Naturraum(Integer nrId, String nrname) {
        this.nrId = nrId;
        this.nrname = nrname;
    }

    public String getNrname() {
        return nrname;
    }

    public void setNrname(String nrname) {
        this.nrname = nrname;
    }

    public Integer getNrId() {
        return nrId;
    }

    public void setNrId(Integer nrId) {
        this.nrId = nrId;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nrId != null ? nrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Naturraum)) {
            return false;
        }
        Naturraum other = (Naturraum) object;
        if ((this.nrId == null && other.nrId != null) || (this.nrId != null && !this.nrId.equals(
                other.nrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Naturraum[ nrId=" + nrId + " ]";
    }
}
