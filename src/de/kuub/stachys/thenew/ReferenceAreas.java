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
import javax.persistence.OneToOne;
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
@Table(schema = "public", name = "`referenceAreas´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenceAreas.findAll", query = "SELECT r FROM ReferenceAreas r"),
    @NamedQuery(name = "ReferenceAreas.findBySyslogcreatedOn",
            query = "SELECT r FROM ReferenceAreas r WHERE r.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "ReferenceAreas.findBySyslogcreatedby",
            query = "SELECT r FROM ReferenceAreas r WHERE r.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "ReferenceAreas.findBySysloglastChangedOn",
            query = "SELECT r FROM ReferenceAreas r WHERE r.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "ReferenceAreas.findBySysloglastChangedBy",
            query = "SELECT r FROM ReferenceAreas r WHERE r.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "ReferenceAreas.findByOldid", query = "SELECT r FROM ReferenceAreas r WHERE r.oldid = :oldid")})
public class ReferenceAreas extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[Areaid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID areaID;

    @Type(type = "org.hibernatespatial.GeometryUserType")
    @Column(nullable = false, name = "[Area]", columnDefinition = "Geometry")
    private Geometry area;

    @Column(unique = true)
    private Integer oldid;

    @JoinColumn(name = "[MainAreaName]", referencedColumnName = "[areanameid]", nullable = false)
    @ManyToOne
    private AreaNames mainAreaName;

    @Basic(optional = false)
    @Column(name = "[AreaType]")
    private String areaType;

    @Basic(optional = false)
    @Column(name = "[AreaKey]")
    private String areaKey;

    @Basic(optional = false)
    @Column(name = "[Copyright]")
    private String copyright;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "referenceAreas")
    private Collection<SearchPlaceReferenceArea> searchPlacesReferenceAreaCollection;

    @JoinColumn(name = "[Areaid]", referencedColumnName = "[AreaId]", insertable = false, updatable = false)
    @OneToOne(optional = true)
    private ReferenceAreaData referenceAreaData;

    @JoinColumn(name = "[LicenseId]", referencedColumnName = "[LicenseId]", nullable = false)
    @ManyToOne
    private DataLicense license;

    public ReferenceAreas() {
    }

    public ReferenceAreas(UUID areaID) {
        this.areaID = areaID;
    }

    public ReferenceAreas(UUID areaID, String areaType, String areaKey, String copyright, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.areaID = areaID;
        this.areaType = areaType;
        this.areaKey = areaKey;
        this.copyright = copyright;

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

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public String getAreaType() {
        return areaType;
    }

    public void setAreaType(String areaType) {
        this.areaType = areaType;
    }

    public String getAreaKey() {
        return areaKey;
    }

    public void setAreaKey(String areaKey) {
        this.areaKey = areaKey;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    @XmlTransient
    public Collection<SearchPlaceReferenceArea> getSearchPlacesReferenceAreaCollection() {
        return searchPlacesReferenceAreaCollection;
    }

    public void setSearchPlacesReferenceAreaCollection(Collection<SearchPlaceReferenceArea> searchPlacesReferenceAreaCollection) {
        this.searchPlacesReferenceAreaCollection = searchPlacesReferenceAreaCollection;
    }

    public ReferenceAreaData getReferenceAreaData() {
        return referenceAreaData;
    }

    public void setReferenceAreaData(ReferenceAreaData referenceAreaData) {
        this.referenceAreaData = referenceAreaData;
    }

    public AreaNames getMainAreaName() {
        return mainAreaName;
    }

    public void setMainAreaName(AreaNames mainAreaName) {
        this.mainAreaName = mainAreaName;
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
        if (!(object instanceof ReferenceAreas)) {
            return false;
        }
        ReferenceAreas other = (ReferenceAreas) object;
        if ((this.areaID == null && other.areaID != null) || (this.areaID != null && !this.areaID.equals(
                other.areaID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.ReferenceAreas[ areaID={0} ]", areaID);
    }
}
