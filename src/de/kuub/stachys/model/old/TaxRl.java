/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "tax_rl", catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaxRl.findAll", query = "SELECT t FROM TaxRl t"),
    @NamedQuery(name = "TaxRl.findByArtId",
            query = "SELECT t FROM TaxRl t WHERE t.taxRlPK.artId = :artId"),
    @NamedQuery(name = "TaxRl.findByRlId",
            query = "SELECT t FROM TaxRl t WHERE t.taxRlPK.rlId = :rlId"),
    @NamedQuery(name = "TaxRl.findByStatus",
            query = "SELECT t FROM TaxRl t WHERE t.status = :status")})
public class TaxRl implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected TaxRlPK taxRlPK;

    @Basic(optional = false)
    private String status;

    @JoinColumn(name = "art_id", referencedColumnName = "art_id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Taxonomisch taxonomisch;

    @JoinColumn(name = "rl_id", referencedColumnName = "rl_id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Roteliste roteliste;

    public TaxRl() {
    }

    public TaxRl(TaxRlPK taxRlPK) {
        this.taxRlPK = taxRlPK;
    }

    public TaxRl(TaxRlPK taxRlPK, String status) {
        this.taxRlPK = taxRlPK;
        this.status = status;
    }

    public TaxRl(int artId, int rlId) {
        this.taxRlPK = new TaxRlPK(artId, rlId);
    }

    public TaxRlPK getTaxRlPK() {
        return taxRlPK;
    }

    public void setTaxRlPK(TaxRlPK taxRlPK) {
        this.taxRlPK = taxRlPK;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Taxonomisch getTaxonomisch() {
        return taxonomisch;
    }

    public void setTaxonomisch(Taxonomisch taxonomisch) {
        this.taxonomisch = taxonomisch;
    }

    public Roteliste getRoteliste() {
        return roteliste;
    }

    public void setRoteliste(Roteliste roteliste) {
        this.roteliste = roteliste;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxRlPK != null ? taxRlPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaxRl)) {
            return false;
        }
        TaxRl other = (TaxRl) object;
        if ((this.taxRlPK == null && other.taxRlPK != null) || (this.taxRlPK != null && !this.taxRlPK.equals(
                other.taxRlPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TaxRl[ taxRlPK=" + taxRlPK + " ]";
    }
}
