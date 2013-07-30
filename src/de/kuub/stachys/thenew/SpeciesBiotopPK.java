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
public class SpeciesBiotopPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, name = "[biotopid]")
    private UUID biotopId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesid]", nullable = false)
    private UUID speciesId;

    public SpeciesBiotopPK() {
    }

    public SpeciesBiotopPK(UUID biotopId, UUID speciesId) {
        this.biotopId = biotopId;
        this.speciesId = speciesId;
    }

    public UUID getBiotopId() {
        return biotopId;
    }

    public void setBiotopId(UUID biotopId) {
        this.biotopId = biotopId;
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biotopId != null ? biotopId.hashCode() : 0);
        hash += (speciesId != null ? speciesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesBiotopPK)) {
            return false;
        }
        SpeciesBiotopPK other = (SpeciesBiotopPK) object;
        if ((this.biotopId == null && other.biotopId != null) || (this.biotopId != null && !this.biotopId.equals(
                other.biotopId))) {
            return false;
        }
        if ((this.speciesId == null && other.speciesId != null) || (this.speciesId != null && !this.speciesId.equals(
                other.speciesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SpeciesBiotopPK[ biotopId={0}, speciesId={1} ]", biotopId, speciesId);
    }
}
