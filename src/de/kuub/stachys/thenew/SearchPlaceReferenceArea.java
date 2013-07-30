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
@Table(name = "`searchPlaces_referenceArea´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchPlaceReferenceArea.findAll",
            query = "SELECT s FROM SearchPlaceReferenceArea s"),
    @NamedQuery(name = "SearchPlaceReferenceArea.findBySyslogcreatedOn",
            query = "SELECT s FROM SearchPlaceReferenceArea s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SearchPlaceReferenceArea.findBySyslogcreatedby",
            query = "SELECT s FROM SearchPlaceReferenceArea s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SearchPlaceReferenceArea.findBySysloglastChangedOn",
            query = "SELECT s FROM SearchPlaceReferenceArea s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SearchPlaceReferenceArea.findBySysloglastChangedBy",
            query = "SELECT s FROM SearchPlaceReferenceArea s WHERE s.sysloglastChangedBy = :sysloglastChangedBy")
})
public class SearchPlaceReferenceArea extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SearchPlaceReferenceAreaPK searchPlaceReferenceAreaPK;

    @JoinColumn(name = "[SearchPlaceAreaId]", referencedColumnName = "[Areaid]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private SearchPlace searchPlaceArea;

    @JoinColumn(name = "[ReferenceAreaId]", referencedColumnName = "[Areaid]", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ReferenceAreas referenceAreas;

    public SearchPlaceReferenceArea() {
    }

    public SearchPlaceReferenceArea(SearchPlaceReferenceAreaPK searchPlaceReferenceAreaPK) {
        this.searchPlaceReferenceAreaPK = searchPlaceReferenceAreaPK;
    }

    public SearchPlaceReferenceArea(SearchPlaceReferenceAreaPK searchPlaceReferenceAreaPK, SearchPlace searchPlaceArea) {
        this.searchPlaceReferenceAreaPK = searchPlaceReferenceAreaPK;
        this.searchPlaceArea = searchPlaceArea;
    }

    public SearchPlaceReferenceArea(UUID searchPlaceAreaId, UUID referenceAreaId) {
        this.searchPlaceReferenceAreaPK = new SearchPlaceReferenceAreaPK(searchPlaceAreaId, referenceAreaId);
    }

    public SearchPlaceReferenceAreaPK getSearchPlacesreferenceAreaPK() {
        return searchPlaceReferenceAreaPK;
    }

    public void setSearchPlacesreferenceAreaPK(SearchPlaceReferenceAreaPK searchPlacesreferenceAreaPK) {
        this.searchPlaceReferenceAreaPK = searchPlacesreferenceAreaPK;
    }

    public SearchPlace getSearchPlaceArea() {
        return searchPlaceArea;
    }

    public void setSearchPlaceArea(SearchPlace searchPlaceArea) {
        this.searchPlaceArea = searchPlaceArea;
    }

    public ReferenceAreas getReferenceAreas() {
        return referenceAreas;
    }

    public void setReferenceAreas(ReferenceAreas referenceAreas) {
        this.referenceAreas = referenceAreas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (searchPlaceReferenceAreaPK != null ? searchPlaceReferenceAreaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchPlaceReferenceArea)) {
            return false;
        }
        SearchPlaceReferenceArea other = (SearchPlaceReferenceArea) object;
        if ((this.searchPlaceReferenceAreaPK == null && other.searchPlaceReferenceAreaPK != null) || (this.searchPlaceReferenceAreaPK != null && !this.searchPlaceReferenceAreaPK.equals(
                other.searchPlaceReferenceAreaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SearchPlaceReferenceArea[ searchPlaceReferenceAreaPK={0} ]",
                searchPlaceReferenceAreaPK);
    }
}
