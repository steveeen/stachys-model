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
@Table(name = "`datasource_medium´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataSourceMedium.findAll",
            query = "SELECT d FROM DataSourceMedium d"),
    @NamedQuery(name = "DataSourceMedium.findBySyslogcreatedOn",
            query = "SELECT d FROM DataSourceMedium d WHERE d.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "DataSourceMedium.findBySyslogcreatedby",
            query = "SELECT d FROM DataSourceMedium d WHERE d.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "DataSourceMedium.findBySysloglastChangedOn",
            query = "SELECT d FROM DataSourceMedium d WHERE d.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "DataSourceMedium.findBySysloglastChangedBy",
            query = "SELECT d FROM DataSourceMedium d WHERE d.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "DataSourceMedium.findByMediumValue",
            query = "SELECT d FROM DataSourceMedium d WHERE d.mediumValue = :mediumValue")})
public class DataSourceMedium extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @EmbeddedId
    protected DataSourceMediumPK datasourceMediumPK;

    @Basic(optional = false)
    @Column(name = "[mediumValue]")
    private String mediumValue;

    @JoinColumn(name = "[mediumId]", referencedColumnName = "[publicationMediumId]", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private PublicationMedium publicationMedium;

    @JoinColumn(name = "[dataSourceId]", referencedColumnName = "[dataSourceId]", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DataSource dataSource;

    public DataSourceMedium() {
    }

    public DataSourceMedium(DataSourceMediumPK datasourceMediumPK) {
        this.datasourceMediumPK = datasourceMediumPK;
    }

    public DataSourceMedium(DataSourceMediumPK datasourceMediumPK, String mediumValue) {
        this.datasourceMediumPK = datasourceMediumPK;
        this.mediumValue = mediumValue;
    }

    public DataSourceMedium(UUID dataSourceId, UUID mediumId) {
        this.datasourceMediumPK = new DataSourceMediumPK(dataSourceId, mediumId);
    }

    public DataSourceMediumPK getDatasourceMediumPK() {
        return datasourceMediumPK;
    }

    public void setDatasourceMediumPK(DataSourceMediumPK datasourceMediumPK) {
        this.datasourceMediumPK = datasourceMediumPK;
    }

    public String getMediumValue() {
        return mediumValue;
    }

    public void setMediumValue(String mediumValue) {
        this.mediumValue = mediumValue;
    }

    public PublicationMedium getPublicationMedium() {
        return publicationMedium;
    }

    public void setPublicationMedium(PublicationMedium publicationMedium) {
        this.publicationMedium = publicationMedium;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datasourceMediumPK != null ? datasourceMediumPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSourceMedium)) {
            return false;
        }
        DataSourceMedium other = (DataSourceMedium) object;
        if ((this.datasourceMediumPK == null && other.datasourceMediumPK != null) || (this.datasourceMediumPK != null && !this.datasourceMediumPK.equals(
                other.datasourceMediumPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.DatasourceMedium[ datasourceMediumPK={0} ]", datasourceMediumPK);
    }
}
