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
public class RedlistSpeciesPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesid]", nullable = false)
    private UUID speciesId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[redlistid]", nullable = false)
    private UUID redListId;

    public RedlistSpeciesPK() {
    }

    public RedlistSpeciesPK(UUID speciesId, UUID redListId) {
        this.speciesId = speciesId;
        this.redListId = redListId;
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public UUID getRedListId() {
        return redListId;
    }

    public void setRedListId(UUID redListId) {
        this.redListId = redListId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesId != null ? speciesId.hashCode() : 0);
        hash += (redListId != null ? redListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedlistSpeciesPK)) {
            return false;
        }
        RedlistSpeciesPK other = (RedlistSpeciesPK) object;
        if ((this.speciesId == null && other.speciesId != null) || (this.speciesId != null && !this.speciesId.equals(
                other.speciesId))) {
            return false;
        }
        if ((this.redListId == null && other.redListId != null) || (this.redListId != null && !this.redListId.equals(
                other.redListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.RedlistSpeciesPK[ speciesId={0}, redListId={1} ]", speciesId,
                redListId);
    }
}
