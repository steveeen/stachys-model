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
import javax.persistence.Embeddable;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Embeddable
public class DataSourceMediumPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[dataSourceId]")
    private UUID dataSourceId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[mediumId]")
    private UUID mediumId;

    public DataSourceMediumPK() {
    }

    public DataSourceMediumPK(UUID dataSourceId, UUID mediumId) {
        this.dataSourceId = dataSourceId;
        this.mediumId = mediumId;
    }

    public UUID getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(UUID dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public UUID getMediumId() {
        return mediumId;
    }

    public void setMediumId(UUID mediumId) {
        this.mediumId = mediumId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataSourceId != null ? dataSourceId.hashCode() : 0);
        hash += (mediumId != null ? mediumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DataSourceMediumPK)) {
            return false;
        }
        DataSourceMediumPK other = (DataSourceMediumPK) object;
        if ((this.dataSourceId == null && other.dataSourceId != null) || (this.dataSourceId != null && !this.dataSourceId.equals(
                other.dataSourceId))) {
            return false;
        }
        if ((this.mediumId == null && other.mediumId != null) || (this.mediumId != null && !this.mediumId.equals(other.mediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.DatasourceMediumPK[ dataSourceId={0}, mediumId={1} ]", dataSourceId,
                mediumId);
    }
}
