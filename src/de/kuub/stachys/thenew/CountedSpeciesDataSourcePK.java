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
public class CountedSpeciesDataSourcePK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, name = "[countedSpeciesId]")
    private UUID countedSpeciesId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, name = "[dataSourceId]")
    private UUID dataSourceId;

    public CountedSpeciesDataSourcePK() {
    }

    public CountedSpeciesDataSourcePK(UUID countedSpeciesId, UUID dataSourceId) {
        this.countedSpeciesId = countedSpeciesId;
        this.dataSourceId = dataSourceId;
    }

    public UUID getCountedSpeciesId() {
        return countedSpeciesId;
    }

    public void setCountedSpeciesId(UUID countedSpeciesId) {
        this.countedSpeciesId = countedSpeciesId;
    }

    public UUID getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(UUID dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countedSpeciesId != null ? countedSpeciesId.hashCode() : 0);
        hash += (dataSourceId != null ? dataSourceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountedSpeciesDataSourcePK)) {
            return false;
        }
        CountedSpeciesDataSourcePK other = (CountedSpeciesDataSourcePK) object;
        if ((this.countedSpeciesId == null && other.countedSpeciesId != null) || (this.countedSpeciesId != null && !this.countedSpeciesId.equals(
                other.countedSpeciesId))) {
            return false;
        }
        if ((this.dataSourceId == null && other.dataSourceId != null) || (this.dataSourceId != null && !this.dataSourceId.equals(
                other.dataSourceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.CountedSpeciesDataSourcePK[ countedSpeciesId={0}, dataSourceId={1} ]",
                countedSpeciesId, dataSourceId);
    }
}
