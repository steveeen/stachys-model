/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

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
@Table(name = "`countedSpecies´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountedSpecies.findAll",
            query = "SELECT c FROM CountedSpecies c"),
    @NamedQuery(name = "CountedSpecies.findBySyslogcreatedOn",
            query = "SELECT c FROM CountedSpecies c WHERE c.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "CountedSpecies.findBySyslogcreatedby",
            query = "SELECT c FROM CountedSpecies c WHERE c.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "CountedSpecies.findBySysloglastChangedOn",
            query = "SELECT c FROM CountedSpecies c WHERE c.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "CountedSpecies.findBySysloglastChangedBy",
            query = "SELECT c FROM CountedSpecies c WHERE c.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "CountedSpecies.findByYearofRecord",
            query = "SELECT c FROM CountedSpecies c WHERE c.yearofRecord = :yearofRecord"),
    @NamedQuery(name = "CountedSpecies.findByCountedUnits",
            query = "SELECT c FROM CountedSpecies c WHERE c.countedUnits = :countedUnits"),
    @NamedQuery(name = "CountedSpecies.findByEstimation",
            query = "SELECT c FROM CountedSpecies c WHERE c.estimation = :estimation"),
    @NamedQuery(name = "CountedSpecies.findByBlooming",
            query = "SELECT c FROM CountedSpecies c WHERE c.blooming = :blooming"),
    @NamedQuery(name = "CountedSpecies.findByComments",
            query = "SELECT c FROM CountedSpecies c WHERE c.comments = :comments"),
    @NamedQuery(name = "CountedSpecies.findByTrusted",
            query = "SELECT c FROM CountedSpecies c WHERE c.trusted = :trusted"),
    @NamedQuery(name = "CountedSpecies.findByOldid",
            query = "SELECT c FROM CountedSpecies c WHERE c.oldid = :oldid")})
public class CountedSpecies extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[zdid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID zdId;

    @Basic(optional = false)
    @Column(name = "[yearofRecord]", nullable = false)
    private short yearofRecord;

    @Basic(optional = false)
    @Column(name = "[countedUnits]", nullable = false)
    private int countedUnits;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean estimation;

    @Column(length = 50)
    private String blooming;

    @Column(length = 1000)
    private String comments;

    private Boolean trusted;

    private Integer oldid;

    @JoinColumn(name = "[speciesid]", referencedColumnName = "[speciesid]", nullable = false)
    @ManyToOne(optional = false)
    private Species speciesId;

    @JoinColumn(name = "[searchPlaceid]", referencedColumnName = "[Areaid]", nullable = false)
    @ManyToOne(optional = false)
    private SearchPlace area;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "[dataLicense]", referencedColumnName = "[LicenseId]", nullable = true)
    private DataLicense license;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countedSpecies")
    private Collection<Mapper> countedSpeciespersonsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "countedSpecies")
    private Collection<CountedSpeciesDataSource> countedSpeciesDataSourceCollection;

    public CountedSpecies() {
    }

    public CountedSpecies(UUID zdId) {
        this.zdId = zdId;
    }

    public CountedSpecies(UUID zdId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, short yearofRecord, int countedUnits, boolean estimation) {
        this.zdId = zdId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.yearofRecord = yearofRecord;
        this.countedUnits = countedUnits;
        this.estimation = estimation;
    }

    /**
     * @param countedSpeciesDataSourceCollection the countedSpeciesDataSourceCollection to set
     */
    public void setCountedSpeciesDataSourceCollection(Collection<CountedSpeciesDataSource> countedSpeciesDataSourceCollection) {
        this.countedSpeciesDataSourceCollection = countedSpeciesDataSourceCollection;
    }

    /**
     * @return the countedSpeciesDataSourceCollection
     */
    public Collection<CountedSpeciesDataSource> getCountedSpeciesDataSourceCollection() {
        return countedSpeciesDataSourceCollection;
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

    public UUID getZdId() {
        return zdId;
    }

    public void setZdId(UUID zdId) {
        this.zdId = zdId;
    }

    public short getYearofRecord() {
        return yearofRecord;
    }

    public void setYearofRecord(short yearofRecord) {
        this.yearofRecord = yearofRecord;
    }

    public int getCountedUnits() {
        return countedUnits;
    }

    public void setCountedUnits(int countedUnits) {
        this.countedUnits = countedUnits;
    }

    public boolean isEstimation() {
        return estimation;
    }

    public void setEstimation(boolean estimation) {
        this.estimation = estimation;
    }

    public String getBlooming() {
        return blooming;
    }

    public void setBlooming(String blooming) {
        this.blooming = blooming;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Boolean getTrusted() {
        return trusted;
    }

    public void setTrusted(Boolean trusted) {
        this.trusted = trusted;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public Species getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Species speciesId) {
        this.speciesId = speciesId;
    }

    public SearchPlace getArea() {
        return area;
    }

    public void setArea(SearchPlace area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<Mapper> getCountedSpeciespersonsCollection() {
        return countedSpeciespersonsCollection;
    }

    public void setCountedSpeciespersonsCollection(Collection<Mapper> countedSpeciespersonsCollection) {
        this.countedSpeciespersonsCollection = countedSpeciespersonsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zdId != null ? zdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountedSpecies)) {
            return false;
        }
        CountedSpecies other = (CountedSpecies) object;
        if ((this.zdId == null && other.zdId != null) || (this.zdId != null && !this.zdId.equals(
                other.zdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.CountedSpecies[ zdId={0} ]", zdId);
    }
}
