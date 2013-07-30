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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(name = "`dataSource´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataSource.findAll", query = "SELECT d FROM DataSource d"),
    @NamedQuery(name = "DataSource.findBySyslogcreatedOn",
            query = "SELECT d FROM DataSource d WHERE d.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "DataSource.findBySyslogcreatedby",
            query = "SELECT d FROM DataSource d WHERE d.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "DataSource.findBySysloglastChangedOn",
            query = "SELECT d FROM DataSource d WHERE d.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "DataSource.findBySysloglastChangedBy",
            query = "SELECT d FROM DataSource d WHERE d.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "DataSource.findBySrcTitle", query = "SELECT d FROM DataSource d WHERE d.srcTitle = :srcTitle"),
    @NamedQuery(name = "DataSource.findByYear", query = "SELECT d FROM DataSource d WHERE d.year = :year"),
    @NamedQuery(name = "DataSource.findByType", query = "SELECT d FROM DataSource d WHERE d.type = :type"),
    @NamedQuery(name = "DataSource.findByPlace", query = "SELECT d FROM DataSource d WHERE d.place = :place"),
    @NamedQuery(name = "DataSource.findByPublished", query = "SELECT d FROM DataSource d WHERE d.published = :published")})
public class DataSource extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[dataSourceId]")
    private UUID dataSourceId;

    @Basic(optional = false)
    @Column(name = "srcTitle")
    private String srcTitle;

    @Basic(optional = false)
    @Column(name = "year")
    private short year;

    @Basic(optional = false)
    @Column(name = "type")
    private String type;

    @Basic(optional = false)
    @Column(name = "place")
    private String place;

    @Basic(optional = false)
    @Column(name = "published")
    private boolean published;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataSource")
    private Collection<Authors> authorsCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dataSource")
    private Collection<DataSourceMedium> datasourceMediumCollection;

    public DataSource() {
    }

    public DataSource(UUID dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public DataSource(UUID dataSourceId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, long version, String srcTitle, short year, String type, String place, boolean published) {
        this.dataSourceId = dataSourceId;
        this.srcTitle = srcTitle;
        this.year = year;
        this.type = type;
        this.place = place;
        this.published = published;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public UUID getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(UUID dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public String getSrcTitle() {
        return srcTitle;
    }

    public void setSrcTitle(String srcTitle) {
        this.srcTitle = srcTitle;
    }

    public short getYear() {
        return year;
    }

    public void setYear(short year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public boolean getPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @XmlTransient
    public Collection<Authors> getAuthorsCollection() {
        return authorsCollection;
    }

    public void setAuthorsCollection(Collection<Authors> authorsCollection) {
        this.authorsCollection = authorsCollection;
    }

    @XmlTransient
    public Collection<DataSourceMedium> getDatasourceMediumCollection() {
        return datasourceMediumCollection;
    }

    public void setDatasourceMediumCollection(Collection<DataSourceMedium> datasourceMediumCollection) {
        this.datasourceMediumCollection = datasourceMediumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataSourceId != null ? dataSourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSource)) {
            return false;
        }
        DataSource other = (DataSource) object;
        if ((this.dataSourceId == null && other.dataSourceId != null) || (this.dataSourceId != null && !this.dataSourceId.equals(
                other.dataSourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.DataSource[ dataSourceId={0} ]", dataSourceId);
    }
}
