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
public class TaxRlPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "art_id")
    private int artId;

    @Basic(optional = false)
    @Column(name = "rl_id")
    private int rlId;

    public TaxRlPK() {
    }

    public TaxRlPK(int artId, int rlId) {
        this.artId = artId;
        this.rlId = rlId;
    }

    public int getArtId() {
        return artId;
    }

    public void setArtId(int artId) {
        this.artId = artId;
    }

    public int getRlId() {
        return rlId;
    }

    public void setRlId(int rlId) {
        this.rlId = rlId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) artId;
        hash += (int) rlId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxRlPK)) {
            return false;
        }
        TaxRlPK other = (TaxRlPK) object;
        if (this.artId != other.artId) {
            return false;
        }
        if (this.rlId != other.rlId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TaxRlPK[ artId=" + artId + ", rlId=" + rlId + " ]";
    }
}
