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
public class SearchPlacePicturePK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[searchPlacesid]")
    private UUID searchPlaceid;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[pictureid]")
    private UUID pictureid;

    public SearchPlacePicturePK() {
    }

    public SearchPlacePicturePK(UUID searchPlaceid, UUID pictureid) {
        this.searchPlaceid = searchPlaceid;
        this.pictureid = pictureid;
    }

    public UUID getSearchPlaceid() {
        return searchPlaceid;
    }

    public void setSearchPlaceid(UUID searchPlaceid) {
        this.searchPlaceid = searchPlaceid;
    }

    public UUID getPictureid() {
        return pictureid;
    }

    public void setPictureid(UUID pictureid) {
        this.pictureid = pictureid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (searchPlaceid != null ? searchPlaceid.hashCode() : 0);
        hash += (pictureid != null ? pictureid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchPlacePicturePK)) {
            return false;
        }
        SearchPlacePicturePK other = (SearchPlacePicturePK) object;
        if ((this.searchPlaceid == null && other.searchPlaceid != null) || (this.searchPlaceid != null && !this.searchPlaceid.equals(
                other.searchPlaceid))) {
            return false;
        }
        if ((this.pictureid == null && other.pictureid != null) || (this.pictureid != null && !this.pictureid.equals(
                other.pictureid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SearchPlacePicturePK[ searchPlaceid={0}, pictureid={1} ]",
                searchPlaceid, pictureid);
    }
}
