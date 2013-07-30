/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.UUID;
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
@Table(name = "`searchPlace_pictures´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchPlacePicture.findAll",
            query = "SELECT s FROM SearchPlacePicture s"),
    @NamedQuery(name = "SearchPlacePicture.findBySyslogcreatedOn",
            query = "SELECT s FROM SearchPlacePicture s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SearchPlacePicture.findBySyslogcreatedby",
            query = "SELECT s FROM SearchPlacePicture s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SearchPlacePicture.findBySysloglastChangedOn",
            query = "SELECT s FROM SearchPlacePicture s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SearchPlacePicture.findBySysloglastChangedBy",
            query = "SELECT s FROM SearchPlacePicture s WHERE s.sysloglastChangedBy = :sysloglastChangedBy")
})
public class SearchPlacePicture extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SearchPlacePicturePK searchPlacePicturePK;

    @JoinColumn(name = "[searchPlacesid]", referencedColumnName = "[Areaid]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private SearchPlace searchPlace;

    @JoinColumn(name = "[pictureid]", referencedColumnName = "[pictureid]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private Pictures picture;

    public SearchPlacePicture() {
    }

    public SearchPlacePicture(SearchPlacePicturePK searchPlacePicturePK) {
        this.searchPlacePicturePK = searchPlacePicturePK;
    }

    public SearchPlacePicture(SearchPlacePicturePK searchPlacePicturePK, SearchPlace searchPlace, Pictures picture) {
        this.searchPlacePicturePK = searchPlacePicturePK;
        this.searchPlace = searchPlace;
        this.picture = picture;
    }

    public SearchPlacePicture(UUID searchPlacesid, UUID pictureid) {
        this.searchPlacePicturePK = new SearchPlacePicturePK(searchPlacesid, pictureid);
    }

    public SearchPlacePicturePK getSearchPlacePicturesPK() {
        return searchPlacePicturePK;
    }

    public void setSearchPlacePicturesPK(SearchPlacePicturePK searchPlacePicturesPK) {
        this.searchPlacePicturePK = searchPlacePicturesPK;
    }

    public SearchPlace getSearchPlace() {
        return searchPlace;
    }

    public void setSearchPlace(SearchPlace searchPlace) {
        this.searchPlace = searchPlace;
    }

    public Pictures getPicture() {
        return picture;
    }

    public void setPicture(Pictures picture) {
        this.picture = picture;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (searchPlacePicturePK != null ? searchPlacePicturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchPlacePicture)) {
            return false;
        }
        SearchPlacePicture other = (SearchPlacePicture) object;
        if ((this.searchPlacePicturePK == null && other.searchPlacePicturePK != null) || (this.searchPlacePicturePK != null && !this.searchPlacePicturePK.equals(
                other.searchPlacePicturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SearchPlacePicture[ searchPlacepicturesPK={0} ]",
                searchPlacePicturePK);
    }
}
