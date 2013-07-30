/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(name = "`referenceAreaData´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReferenceAreaData.findAll",
            query = "SELECT r FROM ReferenceAreaData r"),
    @NamedQuery(name = "ReferenceAreaData.findBySyslogcreatedOn",
            query = "SELECT r FROM ReferenceAreaData r WHERE r.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "ReferenceAreaData.findBySyslogcreatedby",
            query = "SELECT r FROM ReferenceAreaData r WHERE r.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "ReferenceAreaData.findBySysloglastChangedOn",
            query = "SELECT r FROM ReferenceAreaData r WHERE r.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "ReferenceAreaData.findBySysloglastChangedBy",
            query = "SELECT r FROM ReferenceAreaData r WHERE r.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "ReferenceAreaData.findByAreaDescription",
            query = "SELECT r FROM ReferenceAreaData r WHERE r.areaDescription = :areaDescription")})
public class ReferenceAreaData extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[AreaId]")
    private UUID areaId;

    @Basic(optional = false)
    @Type(type = "hstore-json")
    @Column(name = "[AreaData]", columnDefinition = "hstore")
    private String areaData;

    @Column(name = "[AreaDescription]")
    private String areaDescription;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "referenceAreaData")
    private ReferenceAreas referenceAreas;

    public ReferenceAreaData() {
    }

    public ReferenceAreaData(UUID areaId) {
        this.areaId = areaId;
    }

    public ReferenceAreaData(UUID areaId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, long version, String areaData) {
        this.areaId = areaId;
        this.areaData = areaData;
    }

    public UUID getAreaId() {
        return areaId;
    }

    public void setAreaId(UUID areaId) {
        this.areaId = areaId;
    }

    public String getAreaData() {
        return areaData;
    }

    public void setAreaData(String areaData) {
        this.areaData = areaData;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public void setAreaDescription(String areaDescription) {
        this.areaDescription = areaDescription;
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
        hash += (areaId != null ? areaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReferenceAreaData)) {
            return false;
        }
        ReferenceAreaData other = (ReferenceAreaData) object;
        if ((this.areaId == null && other.areaId != null) || (this.areaId != null && !this.areaId.equals(other.areaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.ReferenceAreaData[ areaId={0} ]", areaId);
    }
}
