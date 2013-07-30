/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Bonke
 */
@Embeddable
public class QuZeitPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "zeitschrift_id")
    private int zeitschriftId;

    @Basic(optional = false)
    @Column(name = "quell_id")
    private int quellId;

    public QuZeitPK() {
    }

    public QuZeitPK(int zeitschriftId, int quellId) {
        this.zeitschriftId = zeitschriftId;
        this.quellId = quellId;
    }

    public int getZeitschriftId() {
        return zeitschriftId;
    }

    public void setZeitschriftId(int zeitschriftId) {
        this.zeitschriftId = zeitschriftId;
    }

    public int getQuellId() {
        return quellId;
    }

    public void setQuellId(int quellId) {
        this.quellId = quellId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) zeitschriftId;
        hash += (int) quellId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuZeitPK)) {
            return false;
        }
        QuZeitPK other = (QuZeitPK) object;
        if (this.zeitschriftId != other.zeitschriftId) {
            return false;
        }
        if (this.quellId != other.quellId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.QuZeitPK[ zeitschriftId=" + zeitschriftId + ", quellId=" + quellId + " ]";
    }
}
