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
public class SearchPlaceReferenceAreaPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[SearchPlaceAreaId]")
    private UUID searchPlaceAreaId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[ReferenceAreaId]")
    private UUID referenceAreaId;

    public SearchPlaceReferenceAreaPK() {
    }

    public SearchPlaceReferenceAreaPK(UUID searchPlaceAreaId, UUID referenceAreaId) {
        this.searchPlaceAreaId = searchPlaceAreaId;
        this.referenceAreaId = referenceAreaId;
    }

    public UUID getSearchPlaceAreaId() {
        return searchPlaceAreaId;
    }

    public void setSearchPlaceAreaId(UUID searchPlaceAreaId) {
        this.searchPlaceAreaId = searchPlaceAreaId;
    }

    public UUID getReferenceAreaId() {
        return referenceAreaId;
    }

    public void setReferenceAreaId(UUID referenceAreaId) {
        this.referenceAreaId = referenceAreaId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (searchPlaceAreaId != null ? searchPlaceAreaId.hashCode() : 0);
        hash += (referenceAreaId != null ? referenceAreaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchPlaceReferenceAreaPK)) {
            return false;
        }
        SearchPlaceReferenceAreaPK other = (SearchPlaceReferenceAreaPK) object;
        if ((this.searchPlaceAreaId == null && other.searchPlaceAreaId != null) || (this.searchPlaceAreaId != null && !this.searchPlaceAreaId.equals(
                other.searchPlaceAreaId))) {
            return false;
        }
        if ((this.referenceAreaId == null && other.referenceAreaId != null) || (this.referenceAreaId != null && !this.referenceAreaId.equals(
                other.referenceAreaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "de.kuub.stachys.thenew.SearchPlaceReferenceAreaPK[ searchPlaceAreaId={0}, referenceAreaId={1} ]",
                searchPlaceAreaId, referenceAreaId);
    }
}
