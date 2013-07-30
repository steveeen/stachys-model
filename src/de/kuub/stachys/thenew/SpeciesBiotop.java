/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Date;
import java.util.UUID;
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
@Table(name = "`species_biotop´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpeciesBiotop.findAll",
            query = "SELECT s FROM SpeciesBiotop s"),
    @NamedQuery(name = "SpeciesBiotop.findBySyslogcreatedOn",
            query = "SELECT s FROM SpeciesBiotop s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SpeciesBiotop.findBySyslogcreatedby",
            query = "SELECT s FROM SpeciesBiotop s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SpeciesBiotop.findBySysloglastChangedOn",
            query = "SELECT s FROM SpeciesBiotop s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SpeciesBiotop.findBySysloglastChangedBy",
            query = "SELECT s FROM SpeciesBiotop s WHERE s.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "SpeciesBiotop.findByComment",
            query = "SELECT s FROM SpeciesBiotop s WHERE s.comment = :comment")})
public class SpeciesBiotop extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected SpeciesBiotopPK speciesBiotopPK;

    @Column(length = 100)
    private String comment;

    @JoinColumn(name = "[speciesid]", referencedColumnName = "[speciesid]",
            nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Species species;

    @JoinColumn(name = "[biotopid]", referencedColumnName = "[biotopid]",
            nullable = true, insertable = false, updatable = false)
    @ManyToOne
    private Biotop biotop;

    public SpeciesBiotop() {
    }

    public SpeciesBiotop(SpeciesBiotopPK speciesBiotopPK) {
        this.speciesBiotopPK = speciesBiotopPK;
    }

    public SpeciesBiotop(SpeciesBiotopPK speciesBiotopPK, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.speciesBiotopPK = speciesBiotopPK;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public SpeciesBiotop(UUID biotopId, UUID speciesId) {
        this.speciesBiotopPK = new SpeciesBiotopPK(biotopId, speciesId);
    }

    public SpeciesBiotopPK getSpeciesBiotopPK() {
        return speciesBiotopPK;
    }

    public void setSpeciesBiotopPK(SpeciesBiotopPK speciesBiotopPK) {
        this.speciesBiotopPK = speciesBiotopPK;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public Biotop getBiotop() {
        return biotop;
    }

    public void setBiotop(Biotop biotop) {
        this.biotop = biotop;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesBiotopPK != null ? speciesBiotopPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesBiotop)) {
            return false;
        }
        SpeciesBiotop other = (SpeciesBiotop) object;
        if ((this.speciesBiotopPK == null && other.speciesBiotopPK != null) || (this.speciesBiotopPK != null && !this.speciesBiotopPK.equals(
                other.speciesBiotopPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.SpeciesBiotop[ speciesBiotopPK={0} ]", speciesBiotopPK);
    }
}
