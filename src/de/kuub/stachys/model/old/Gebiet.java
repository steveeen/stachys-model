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
    @NamedQuery(name = "Gebiet.findAll", query = "SELECT g FROM Gebiet g"),
    @NamedQuery(name = "Gebiet.findByGebietId",
            query = "SELECT g FROM Gebiet g WHERE g.gebietId = :gebietId"),
    @NamedQuery(name = "Gebiet.findByGebietsname",
            query = "SELECT g FROM Gebiet g WHERE g.gebietsname = :gebietsname")})
public class Gebiet implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "gebiet_id")
    private Integer gebietId;

    @Basic(optional = false)
    private String gebietsname;

    @Lob
    private Object area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gebietId")
    private Collection<Gebietsnamen> gebietsnamenCollection;

    public Gebiet() {
    }

    public Gebiet(Integer gebietId) {
        this.gebietId = gebietId;
    }

    public Gebiet(Integer gebietId, String gebietsname) {
        this.gebietId = gebietId;
        this.gebietsname = gebietsname;
    }

    public Integer getGebietId() {
        return gebietId;
    }

    public void setGebietId(Integer gebietId) {
        this.gebietId = gebietId;
    }

    public String getGebietsname() {
        return gebietsname;
    }

    public void setGebietsname(String gebietsname) {
        this.gebietsname = gebietsname;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<Gebietsnamen> getGebietsnamenCollection() {
        return gebietsnamenCollection;
    }

    public void setGebietsnamenCollection(Collection<Gebietsnamen> gebietsnamenCollection) {
        this.gebietsnamenCollection = gebietsnamenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (gebietId != null ? gebietId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gebiet)) {
            return false;
        }
        Gebiet other = (Gebiet) object;
        if ((this.gebietId == null && other.gebietId != null) || (this.gebietId != null && !this.gebietId.equals(
                other.gebietId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Gebiet[ gebietId=" + gebietId + " ]";
    }
}
