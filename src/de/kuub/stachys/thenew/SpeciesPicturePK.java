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
public class SpeciesPicturePK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesid]", nullable = false, unique = true)
    private UUID speciesId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[pictureid]")
    private UUID pictureId;

    public SpeciesPicturePK() {
    }

    public SpeciesPicturePK(UUID speciesId, UUID pictureId) {
        this.speciesId = speciesId;
        this.pictureId = pictureId;
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public UUID getPictureId() {
        return pictureId;
    }

    public void setPictureId(UUID pictureId) {
        this.pictureId = pictureId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesId != null ? speciesId.hashCode() : 0);
        hash += (pictureId != null ? pictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesPicturePK)) {
            return false;
        }
        SpeciesPicturePK other = (SpeciesPicturePK) object;
        if ((this.speciesId == null && other.speciesId != null) || (this.speciesId != null && !this.speciesId.equals(
                other.speciesId))) {
            return false;
        }
        if ((this.pictureId == null && other.pictureId != null) || (this.pictureId != null && !this.pictureId.equals(
                other.pictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SpeciesPicturePK[ speciesId={0}, pictureId={1} ]", speciesId,
                pictureId);
    }
}
