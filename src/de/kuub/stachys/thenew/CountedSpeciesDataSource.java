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
@Table(name = "`countedSpecies_dataSource´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountedSpeciesDataSource.findAll",
            query = "SELECT c FROM CountedSpeciesDataSource c"),
    @NamedQuery(name = "CountedSpeciesDataSource.findBySyslogcreatedOn",
            query = "SELECT c FROM CountedSpeciesDataSource c WHERE c.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "CountedSpeciesDataSource.findBySyslogcreatedby",
            query = "SELECT c FROM CountedSpeciesDataSource c WHERE c.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "CountedSpeciesDataSource.findBySysloglastChangedOn",
            query = "SELECT c FROM CountedSpeciesDataSource c WHERE c.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "CountedSpeciesDataSource.findBySysloglastChangedBy",
            query = "SELECT c FROM CountedSpeciesDataSource c WHERE c.sysloglastChangedBy = :sysloglastChangedBy")
})
public class CountedSpeciesDataSource extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CountedSpeciesDataSourcePK countedSpeciesDataSourcePK;

    @JoinColumn(name = "[dataSourceId]", referencedColumnName = "[dataSourceId]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private DataSource dataSource;

    @JoinColumn(name = "[countedSpeciesId]", nullable = false, referencedColumnName = "[zdid]", insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private CountedSpecies countedSpecies;

    public CountedSpeciesDataSource() {
    }

    public CountedSpeciesDataSource(CountedSpeciesDataSourcePK countedSpeciesDataSourcePK) {
        this.countedSpeciesDataSourcePK = countedSpeciesDataSourcePK;
    }

    public CountedSpeciesDataSource(CountedSpeciesDataSourcePK countedSpeciesDataSourcePK, DataSource dataSource, CountedSpecies countedSpecies) {
        this.countedSpeciesDataSourcePK = countedSpeciesDataSourcePK;
        this.dataSource = dataSource;
        this.countedSpecies = countedSpecies;
    }

    public CountedSpeciesDataSource(UUID countedSpeciesId, UUID dataSourceId) {
        this.countedSpeciesDataSourcePK = new CountedSpeciesDataSourcePK(countedSpeciesId, dataSourceId);
    }

    public CountedSpeciesDataSourcePK getCountedSpeciesDataSourcePK() {
        return countedSpeciesDataSourcePK;
    }

    public void setCountedSpeciesDataSourcePK(CountedSpeciesDataSourcePK countedSpeciesDataSourcePK) {
        this.countedSpeciesDataSourcePK = countedSpeciesDataSourcePK;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSourceId1(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public CountedSpecies getCountedSpecies() {
        return countedSpecies;
    }

    public void setCountedSpecies(CountedSpecies countedSpecies) {
        this.countedSpecies = countedSpecies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countedSpeciesDataSourcePK != null ? countedSpeciesDataSourcePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountedSpeciesDataSource)) {
            return false;
        }
        CountedSpeciesDataSource other = (CountedSpeciesDataSource) object;
        if ((this.countedSpeciesDataSourcePK == null && other.countedSpeciesDataSourcePK != null) || (this.countedSpeciesDataSourcePK != null && !this.countedSpeciesDataSourcePK.equals(
                other.countedSpeciesDataSourcePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.CountedSpeciesDataSource[ countedSpeciesDataSourcePK={0} ]",
                countedSpeciesDataSourcePK);
    }
}
