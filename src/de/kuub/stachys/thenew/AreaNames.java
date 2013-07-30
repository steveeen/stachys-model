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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(schema = "public", name = "`areaNames´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AreaNames.findAll", query = "SELECT a FROM AreaNames a"),
    @NamedQuery(name = "AreaNames.findByName",
            query = "SELECT a FROM AreaNames a WHERE a.name = :name")})
public class AreaNames extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "[languageCode]")
    private String languageCode;

    @OneToMany(mappedBy = "mainAreaName")
    private Collection<ReferenceAreas> referenceAreasCollection;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[areanameid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID areanameid;

    @Basic(optional = false)
    @Column(nullable = false, length = 500, name = "[name]")
    private String name;

    @Basic(optional = false)
    // @Type(type = "org.hibernatespatial.GeometryUserType")
    @Column(nullable = false, name = "[referencedArea]", columnDefinition = "Geometry")
    private Geometry referencedArea;

    public AreaNames() {
    }

    public AreaNames(UUID areanameid) {
        this.areanameid = areanameid;
    }

    public AreaNames(UUID areanameid, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, String name, Geometry referencedArea) {
        this.areanameid = areanameid;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.name = name;
        this.referencedArea = referencedArea;
    }

    public UUID getAreanameid() {
        return areanameid;
    }

    public void setAreanameid(UUID areanameid) {
        this.areanameid = areanameid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Geometry getReferencedArea() {
        return referencedArea;
    }

    public void setReferencedArea(Geometry referencedArea) {
        this.referencedArea = referencedArea;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    @XmlTransient
    public Collection<ReferenceAreas> getReferenceAreasCollection() {
        return referenceAreasCollection;
    }

    public void setReferenceAreasCollection(Collection<ReferenceAreas> referenceAreasCollection) {
        this.referenceAreasCollection = referenceAreasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (areanameid != null ? areanameid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AreaNames)) {
            return false;
        }
        AreaNames other = (AreaNames) object;
        if ((this.areanameid == null && other.areanameid != null) || (this.areanameid != null && !this.areanameid.equals(
                other.areanameid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.AreaNames[ areanameid={0} ]", areanameid);
    }
}
