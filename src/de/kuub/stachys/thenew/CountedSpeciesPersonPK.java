/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Embeddable
public class CountedSpeciesPersonPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[persid]")
    private UUID persid;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[zd_id]", nullable = false, unique = true)
    private UUID zdId;

    public CountedSpeciesPersonPK() {
    }

    public CountedSpeciesPersonPK(UUID persid, UUID zdId) {
        this.persid = persid;
        this.zdId = zdId;
    }

    public UUID getPersid() {
        return persid;
    }

    public void setPersid(UUID persid) {
        this.persid = persid;
    }

    public UUID getZdId() {
        return zdId;
    }

    public void setZdId(UUID zdId) {
        this.zdId = zdId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persid != null ? persid.hashCode() : 0);
        hash += (zdId != null ? zdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountedSpeciesPersonPK)) {
            return false;
        }
        CountedSpeciesPersonPK other = (CountedSpeciesPersonPK) object;
        if ((this.persid == null && other.persid != null) || (this.persid != null && !this.persid.equals(
                other.persid))) {
            return false;
        }
        if ((this.zdId == null && other.zdId != null) || (this.zdId != null && !this.zdId.equals(
                other.zdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.CountedSpeciespersonsPK[ persid={0}, zdId={1} ]", persid, zdId);
    }
}
