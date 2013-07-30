/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import com.vividsolutions.jts.geom.Geometry;
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
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tk25vqu.findAll", query = "SELECT t FROM Tk25vqu t"),
    @NamedQuery(name = "Tk25vqu.findByTkvquId",
            query = "SELECT t FROM Tk25vqu t WHERE t.tkvquId = :tkvquId"),
    @NamedQuery(name = "Tk25vqu.findByQuad",
            query = "SELECT t FROM Tk25vqu t WHERE t.quad = :quad"),
    @NamedQuery(name = "Tk25vqu.findByVquad",
            query = "SELECT t FROM Tk25vqu t WHERE t.vquad = :vquad")})
public class Tk25vqu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tkvqu_id")
    private Integer tkvquId;

    @Basic(optional = false)
    private short quad;

    @Basic(optional = false)
    private short vquad;

    @Type(type = "org.hibernatespatial.GeometryUserType")
    @Column(name = "area", columnDefinition = "Geometry")
    private Geometry area;

    @JoinColumn(name = "tk_nr", referencedColumnName = "tknummer")
    @ManyToOne(optional = false)
    private Tk25 tkNr;

    public Tk25vqu() {
    }

    public Tk25vqu(Integer tkvquId) {
        this.tkvquId = tkvquId;
    }

    public Tk25vqu(Integer tkvquId, short quad, short vquad) {
        this.tkvquId = tkvquId;
        this.quad = quad;
        this.vquad = vquad;
    }

    public Integer getTkvquId() {
        return tkvquId;
    }

    public void setTkvquId(Integer tkvquId) {
        this.tkvquId = tkvquId;
    }

    public short getQuad() {
        return quad;
    }

    public void setQuad(short quad) {
        this.quad = quad;
    }

    public short getVquad() {
        return vquad;
    }

    public void setVquad(short vquad) {
        this.vquad = vquad;
    }

    public Geometry getArea() {
        return area;
    }

    public void setArea(Geometry area) {
        this.area = area;
    }

    public Tk25 getTkNr() {
        return tkNr;
    }

    public void setTkNr(Tk25 tkNr) {
        this.tkNr = tkNr;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tkvquId != null ? tkvquId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tk25vqu)) {
            return false;
        }
        Tk25vqu other = (Tk25vqu) object;
        if ((this.tkvquId == null && other.tkvquId != null) || (this.tkvquId != null && !this.tkvquId.equals(
                other.tkvquId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tk25vqu[ tkvquId=" + tkvquId + " ]";
    }
}
