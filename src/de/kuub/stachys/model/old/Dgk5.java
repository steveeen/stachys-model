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
    @NamedQuery(name = "Dgk5.findAll", query = "SELECT d FROM Dgk5 d"),
    @NamedQuery(name = "Dgk5.findByDgkId",
            query = "SELECT d FROM Dgk5 d WHERE d.dgkId = :dgkId"),
    @NamedQuery(name = "Dgk5.findByDgkname",
            query = "SELECT d FROM Dgk5 d WHERE d.dgkname = :dgkname"),
    @NamedQuery(name = "Dgk5.findByTkqunr",
            query = "SELECT d FROM Dgk5 d WHERE d.tkqunr = :tkqunr")})
public class Dgk5 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dgk_id")
    private Integer dgkId;

    @Basic(optional = false)
    private String dgkname;

    @Basic(optional = false)
    private short tkqunr;

    @JoinColumn(name = "tk_nr", referencedColumnName = "tknummer")
    @ManyToOne(optional = false)
    private Tk25 tkNr;

    public Dgk5() {
    }

    public Dgk5(Integer dgkId) {
        this.dgkId = dgkId;
    }

    public Dgk5(Integer dgkId, String dgkname, short tkqunr) {
        this.dgkId = dgkId;
        this.dgkname = dgkname;
        this.tkqunr = tkqunr;
    }

    public Integer getDgkId() {
        return dgkId;
    }

    public void setDgkId(Integer dgkId) {
        this.dgkId = dgkId;
    }

    public String getDgkname() {
        return dgkname;
    }

    public void setDgkname(String dgkname) {
        this.dgkname = dgkname;
    }

    public short getTkqunr() {
        return tkqunr;
    }

    public void setTkqunr(short tkqunr) {
        this.tkqunr = tkqunr;
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
        hash += (dgkId != null ? dgkId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dgk5)) {
            return false;
        }
        Dgk5 other = (Dgk5) object;
        if ((this.dgkId == null && other.dgkId != null) || (this.dgkId != null && !this.dgkId.equals(
                other.dgkId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dgk5[ dgkId=" + dgkId + " ]";
    }
}
