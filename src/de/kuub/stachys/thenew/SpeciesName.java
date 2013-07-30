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
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(schema = "public", name = "`speciesName´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpeciesName.findAll",
            query = "SELECT s FROM SpeciesName s"),
    @NamedQuery(name = "SpeciesName.findBySyslogcreatedOn",
            query = "SELECT s FROM SpeciesName s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SpeciesName.findBySyslogcreatedby",
            query = "SELECT s FROM SpeciesName s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SpeciesName.findBySysloglastChangedOn",
            query = "SELECT s FROM SpeciesName s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SpeciesName.findBySysloglastChangedBy",
            query = "SELECT s FROM SpeciesName s WHERE s.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "SpeciesName.findBySpeciesname",
            query = "SELECT s FROM SpeciesName s WHERE s.speciesname = :speciesname")})
public class SpeciesName extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesnameid]", nullable = false, unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID speciesNameId;

    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String speciesname;

    @JoinColumn(name = "[speciesid]", referencedColumnName = "[speciesid]", nullable = false)
    @ManyToOne(optional = false)
    private Species species;

    public SpeciesName() {
    }

    public SpeciesName(UUID speciesId) {
        this.speciesNameId = speciesId;
    }

    public SpeciesName(UUID speciesnameid, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, String speciesname) {
        this.speciesNameId = speciesnameid;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.speciesname = speciesname;
    }

    /**
     * @param speciesNameId the speciesNameId to set
     */
    public void setSpeciesNameId(UUID speciesNameId) {
        this.speciesNameId = speciesNameId;
    }

    /**
     * @return the speciesNameId
     */
    public UUID getSpeciesNameId() {
        return speciesNameId;
    }

    public String getSpeciesname() {
        return speciesname;
    }

    public void setSpeciesname(String speciesname) {
        this.speciesname = speciesname;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesNameId != null ? speciesNameId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesName)) {
            return false;
        }
        SpeciesName other = (SpeciesName) object;
        if ((this.speciesNameId == null && other.speciesNameId != null) || (this.speciesNameId != null && !this.speciesNameId.equals(
                other.speciesNameId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SpeciesName[ speciesNameId={0} ]", speciesNameId);
    }
}
