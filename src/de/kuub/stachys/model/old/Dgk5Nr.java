/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "dgk5_nr", catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dgk5Nr.findAll", query = "SELECT d FROM Dgk5Nr d"),
    @NamedQuery(name = "Dgk5Nr.findByDgkNr",
            query = "SELECT d FROM Dgk5Nr d WHERE d.dgkNr = :dgkNr"),
    @NamedQuery(name = "Dgk5Nr.findByDgkId",
            query = "SELECT d FROM Dgk5Nr d WHERE d.dgkId = :dgkId"),
    @NamedQuery(name = "Dgk5Nr.findByTransId",
            query = "SELECT d FROM Dgk5Nr d WHERE d.transId = :transId"),
    @NamedQuery(name = "Dgk5Nr.findByDoppelt",
            query = "SELECT d FROM Dgk5Nr d WHERE d.doppelt = :doppelt")})
public class Dgk5Nr implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "dgk_nr")
    private Integer dgkNr;

    @Column(name = "dgk_id")
    private Integer dgkId;

    @Basic(optional = false)
    @Column(name = "trans_id")
    private int transId;

    @Basic(optional = false)
    private boolean doppelt;

    @Lob
    private Object area;

    public Dgk5Nr() {
    }

    public Dgk5Nr(Integer dgkNr) {
        this.dgkNr = dgkNr;
    }

    public Dgk5Nr(Integer dgkNr, int transId, boolean doppelt) {
        this.dgkNr = dgkNr;
        this.transId = transId;
        this.doppelt = doppelt;
    }

    public Integer getDgkNr() {
        return dgkNr;
    }

    public void setDgkNr(Integer dgkNr) {
        this.dgkNr = dgkNr;
    }

    public Integer getDgkId() {
        return dgkId;
    }

    public void setDgkId(Integer dgkId) {
        this.dgkId = dgkId;
    }

    public int getTransId() {
        return transId;
    }

    public void setTransId(int transId) {
        this.transId = transId;
    }

    public boolean getDoppelt() {
        return doppelt;
    }

    public void setDoppelt(boolean doppelt) {
        this.doppelt = doppelt;
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
        hash += (dgkNr != null ? dgkNr.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dgk5Nr)) {
            return false;
        }
        Dgk5Nr other = (Dgk5Nr) object;
        if ((this.dgkNr == null && other.dgkNr != null) || (this.dgkNr != null && !this.dgkNr.equals(
                other.dgkNr))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Dgk5Nr[ dgkNr=" + dgkNr + " ]";
    }
}
