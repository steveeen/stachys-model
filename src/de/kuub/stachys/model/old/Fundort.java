/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import com.vividsolutions.jts.geom.Geometry;
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
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fundort.findAll", query = "SELECT f FROM Fundort f"),
    @NamedQuery(name = "Fundort.findByFoId",
            query = "SELECT f FROM Fundort f WHERE f.foId = :foId"),
    @NamedQuery(name = "Fundort.findByTransId",
            query = "SELECT f FROM Fundort f WHERE f.transId = :transId"),
    @NamedQuery(name = "Fundort.findByRaster",
            query = "SELECT f FROM Fundort f WHERE f.raster = :raster"),
    @NamedQuery(name = "Fundort.findByTrusteduser",
            query = "SELECT f FROM Fundort f WHERE f.trusteduser = :trusteduser")})
public class Fundort implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fo_id")
    private Integer foId;

    @Column(name = "trans_id")
    private Integer transId;

    @Basic(optional = false)
    private short raster;

    @Type(type = "org.hibernatespatial.GeometryUserType")
    @Column(name = "area", columnDefinition = "Geometry")
    private Geometry area;

    @Basic(optional = false)
    private boolean trusteduser;
    //  @Type(type = "org.hibernatespatial.GeometryUserType")

    private Byte[] areahull;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "foId")
    private Collection<Zaehldaten> zaehldatenCollection;

    public Fundort() {
    }

    public Fundort(Integer foId) {
        this.foId = foId;
    }

    public Fundort(Integer foId, short raster, boolean trusteduser) {
        this.foId = foId;
        this.raster = raster;
        this.trusteduser = trusteduser;
    }

    public Integer getFoId() {
        return foId;
    }

    public void setFoId(Integer foId) {
        this.foId = foId;
    }

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public short getRaster() {
        return raster;
    }

    public void setRaster(short raster) {
        this.raster = raster;
    }

    public Geometry getArea() {
        return area;
    }

    public void setArea(Geometry area) {
        this.area = area;
    }

    public boolean getTrusteduser() {
        return trusteduser;
    }

    public void setTrusteduser(boolean trusteduser) {
        this.trusteduser = trusteduser;
    }

    public Byte[] getAreahull() {
        return areahull;
    }

    public void setAreahull(Byte[] areahull) {
        this.areahull = areahull;
    }

    @XmlTransient
    public Collection<Zaehldaten> getZaehldatenCollection() {
        return zaehldatenCollection;
    }

    public void setZaehldatenCollection(Collection<Zaehldaten> zaehldatenCollection) {
        this.zaehldatenCollection = zaehldatenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (foId != null ? foId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fundort)) {
            return false;
        }
        Fundort other = (Fundort) object;
        if ((this.foId == null && other.foId != null) || (this.foId != null && !this.foId.equals(
                other.foId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fundort[ foId=" + foId + " ]";
    }
}
