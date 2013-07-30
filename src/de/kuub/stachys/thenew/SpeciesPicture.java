/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
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
@Table(name = "`species_pictures´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpeciesPicture.findAll",
            query = "SELECT s FROM SpeciesPicture s"),
    @NamedQuery(name = "SpeciesPicture.findBySyslogcreatedOn",
            query = "SELECT s FROM SpeciesPicture s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SpeciesPicture.findBySyslogcreatedby",
            query = "SELECT s FROM SpeciesPicture s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SpeciesPicture.findBySysloglastChangedOn",
            query = "SELECT s FROM SpeciesPicture s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SpeciesPicture.findBySysloglastChangedBy",
            query = "SELECT s FROM SpeciesPicture s WHERE s.sysloglastChangedBy = :sysloglastChangedBy")})
public class SpeciesPicture extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SpeciesPicturePK speciesPicturePK;

    @JoinColumn(name = "[speciesid]", referencedColumnName = "[speciesid]",
            nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Species species;

    @JoinColumn(name = "[pictureid]", referencedColumnName = "[pictureid]",
            nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pictures pictures;

    public SpeciesPicture() {
    }

    public SpeciesPicture(SpeciesPicturePK speciesPicturePK) {
        this.speciesPicturePK = speciesPicturePK;
    }

    public SpeciesPicture(SpeciesPicturePK speciesPicturePK, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.speciesPicturePK = speciesPicturePK;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public SpeciesPicture(UUID speciesId, UUID pictureId) {
        this.speciesPicturePK = new SpeciesPicturePK(speciesId, pictureId);
    }

    public SpeciesPicturePK getSpeciesPicturePK() {
        return speciesPicturePK;
    }

    public void setSpeciesPicturePK(SpeciesPicturePK speciesPicturePK) {
        this.speciesPicturePK = speciesPicturePK;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Pictures getPictures() {
        return pictures;
    }

    public void setPictures(Pictures pictures) {
        this.pictures = pictures;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesPicturePK != null ? speciesPicturePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesPicture)) {
            return false;
        }
        SpeciesPicture other = (SpeciesPicture) object;
        if ((this.speciesPicturePK == null && other.speciesPicturePK != null) || (this.speciesPicturePK != null && !this.speciesPicturePK.equals(
                other.speciesPicturePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SpeciesPicture[ speciesPicturePK={0} ]", speciesPicturePK);
    }
}
