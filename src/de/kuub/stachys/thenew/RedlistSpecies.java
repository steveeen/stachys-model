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
@Table(name = "`redlist_species´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedlistSpecies.findAll",
            query = "SELECT r FROM RedlistSpecies r"),
    @NamedQuery(name = "RedlistSpecies.findBySyslogcreatedOn",
            query = "SELECT r FROM RedlistSpecies r WHERE r.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "RedlistSpecies.findBySyslogcreatedby",
            query = "SELECT r FROM RedlistSpecies r WHERE r.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "RedlistSpecies.findBySysloglastChangedOn",
            query = "SELECT r FROM RedlistSpecies r WHERE r.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "RedlistSpecies.findBySysloglastChangedBy",
            query = "SELECT r FROM RedlistSpecies r WHERE r.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "RedlistSpecies.findByValue",
            query = "SELECT r FROM RedlistSpecies r WHERE r.value = :value")})
public class RedlistSpecies extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected RedlistSpeciesPK redlistSpeciesPK;

    @Basic(optional = false)
    @Column(nullable = false, length = 10)
    private String value;

    @JoinColumn(name = "[speciesid]", referencedColumnName = "[speciesid]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private Species species;

    @JoinColumn(name = "[redlistid]", referencedColumnName = "[redlistid]", nullable = false, insertable = false,
            updatable = false)
    @ManyToOne(optional = false)
    private RedList redList;

    public RedlistSpecies() {
    }

    public RedlistSpecies(RedlistSpeciesPK redlistSpeciesPK) {
        this.redlistSpeciesPK = redlistSpeciesPK;
    }

    public RedlistSpecies(RedlistSpeciesPK redlistSpeciesPK, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, String value) {
        this.redlistSpeciesPK = redlistSpeciesPK;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.value = value;
    }

    public RedlistSpecies(UUID speciesId, UUID redListId, String Value) {
        this.redlistSpeciesPK = new RedlistSpeciesPK(speciesId, redListId);
        this.value = Value;
    }

    public RedlistSpecies(UUID speciesId, UUID redListId) {
        this.redlistSpeciesPK = new RedlistSpeciesPK(speciesId, redListId);
    }

    public RedlistSpeciesPK getRedlistSpeciesPK() {
        return redlistSpeciesPK;
    }

    public void setRedlistSpeciesPK(RedlistSpeciesPK redlistSpeciesPK) {
        this.redlistSpeciesPK = redlistSpeciesPK;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public RedList getRedList() {
        return redList;
    }

    public void setRedList(RedList redList) {
        this.redList = redList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redlistSpeciesPK != null ? redlistSpeciesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedlistSpecies)) {
            return false;
        }
        RedlistSpecies other = (RedlistSpecies) object;
        if ((this.redlistSpeciesPK == null && other.redlistSpeciesPK != null) || (this.redlistSpeciesPK != null && !this.redlistSpeciesPK.equals(
                other.redlistSpeciesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.RedlistSpecies[ redlistSpeciesPK={0} ]", redlistSpeciesPK);
    }
}
