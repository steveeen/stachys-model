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
public class AuthorsPK implements Serializable {

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[dataSourceId]", nullable = false)
    private UUID dataSourceId;

    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[personId]", nullable = false)
    private UUID personId;

    public AuthorsPK() {
    }

    public AuthorsPK(UUID dataSourceId, UUID personId) {
        this.dataSourceId = dataSourceId;
        this.personId = personId;
    }

    public UUID getDataSourceId() {
        return dataSourceId;
    }

    public void setDataSourceId(UUID dataSourceId) {
        this.dataSourceId = dataSourceId;
    }

    public UUID getPersonId() {
        return personId;
    }

    public void setPersonId(UUID personId) {
        this.personId = personId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dataSourceId != null ? dataSourceId.hashCode() : 0);
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AuthorsPK)) {
            return false;
        }
        AuthorsPK other = (AuthorsPK) object;
        if ((this.dataSourceId == null && other.dataSourceId != null) || (this.dataSourceId != null && !this.dataSourceId.equals(
                other.dataSourceId))) {
            return false;
        }
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.AuthorsPK[ dataSourceId={0}, personId={1} ]", dataSourceId, personId);
    }
}
