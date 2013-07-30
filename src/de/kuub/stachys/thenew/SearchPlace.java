/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(schema = "public", name = "`searchPlaces´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SearchPlace.findAll",
            query = "SELECT s FROM SearchPlace s"),
    @NamedQuery(name = "SearchPlace.findBySyslogcreatedOn",
            query = "SELECT s FROM SearchPlace s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SearchPlace.findBySyslogcreatedby",
            query = "SELECT s FROM SearchPlace s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SearchPlace.findBySysloglastChangedOn",
            query = "SELECT s FROM SearchPlace s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SearchPlace.findBySysloglastChangedBy",
            query = "SELECT s FROM SearchPlace s WHERE s.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "SearchPlace.findByRaster",
            query = "SELECT s FROM SearchPlace s WHERE s.raster = :raster"),
    @NamedQuery(name = "SearchPlace.findByOldid",
            query = "SELECT s FROM SearchPlace s WHERE s.oldid = :oldid")})
public class SearchPlace extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[Areaid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID areaID;

    @Column(nullable = false, name = "[Area]", columnDefinition = "Geometry")
    @Type(type = "org.hibernatespatial.GeometryUserType")
    private Geometry area;

    @Basic(optional = false)
    @Column(nullable = false)
    private Integer raster;

    @Column(nullable = true, name = "[areahull]", columnDefinition = "Geometry")
    @Type(type = "org.hibernatespatial.GeometryUserType")
    private Geometry areahull;

    @Basic(optional = true)
    private Integer oldid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "area")
    private Collection<CountedSpecies> countedSpeciesCollection;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "[dataLicense]", referencedColumnName = "[LicenseId]", nullable = true)
    private DataLicense license;

    public SearchPlace() {
    }

    public SearchPlace(UUID areaID) {
        this.areaID = areaID;
    }

    public SearchPlace(UUID areaID, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, Geometry areahull, Geometry area) {
        this.areaID = areaID;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.areahull = areahull;
        this.area = area;
    }

    /**
     * @param license the license to set
     */
    public void setLicense(DataLicense license) {
        this.license = license;
    }

    /**
     * @return the license
     */
    public DataLicense getLicense() {
        return license;
    }

    public UUID getAreaID() {
        return areaID;
    }

    public void setAreaID(UUID areaID) {
        this.areaID = areaID;
    }

    public Geometry getArea() {
        return area;
    }

    public void setArea(Geometry area) {
        this.area = area;
    }

    public Integer getRaster() {
        return raster;
    }

    public void setRaster(Integer raster) {
        this.raster = raster;
    }

    public Geometry getAreahull() {
        return areahull;
    }

    public void setAreahull(Geometry areahull) {
        this.areahull = areahull;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    @XmlTransient
    public Collection<CountedSpecies> getCountedSpeciesCollection() {
        return countedSpeciesCollection;
    }

    public void setCountedSpeciesCollection(Collection<CountedSpecies> countedSpeciesCollection) {
        this.countedSpeciesCollection = countedSpeciesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areaID != null ? areaID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SearchPlace)) {
            return false;
        }
        SearchPlace other = (SearchPlace) object;
        if ((this.areaID == null && other.areaID != null) || (this.areaID != null && !this.areaID.equals(
                other.areaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SearchPlace[ areaID={0} ]", areaID);
    }
}
