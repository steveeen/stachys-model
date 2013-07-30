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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(name = "`species´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Species.findAll", query = "SELECT s FROM Species s"),
    @NamedQuery(name = "Species.findBySyslogcreatedOn",
            query = "SELECT s FROM Species s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "Species.findBySyslogcreatedby",
            query = "SELECT s FROM Species s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "Species.findBySysloglastChangedOn",
            query = "SELECT s FROM Species s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "Species.findBySysloglastChangedBy",
            query = "SELECT s FROM Species s WHERE s.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "Species.findByOldid",
            query = "SELECT s FROM Species s WHERE s.oldid = :oldid")})
public class Species extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesid]", nullable = false, unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID speciesId;

    private Integer oldid;

    @JoinColumn(nullable = true, name = "[mainPicture]", referencedColumnName = "[pictureId]")
    @ManyToOne
    private Pictures mainPicture;

    @JoinColumn(name = "[mainsciencenameid]", referencedColumnName = "[speciesscnameid]")
    @ManyToOne
    private SpeciesScienceName mainScienceName;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciesId")
    private Collection<CountedSpecies> countedSpeciesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species")
    private Collection<SpeciesName> speciesNameCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "speciesRef")
    private Collection<SpeciesScienceName> speciesScienceNameCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species")
    private Collection<SpeciesPicture> speciesPictureCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species")
    private Collection<SpeciesBiotop> speciesBiotopCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "species")
    private Collection<RedlistSpecies> redlistSpeciesCollection;

    public Species() {
    }

    public Species(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public Species(UUID speciesId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.speciesId = speciesId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public UUID getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(UUID speciesId) {
        this.speciesId = speciesId;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public Pictures getMainPicture() {
        return mainPicture;
    }

    public void setMainPicture(Pictures mainPicture) {
        this.mainPicture = mainPicture;
    }

    @XmlTransient
    public Collection<CountedSpecies> getCountedSpeciesCollection() {
        return countedSpeciesCollection;
    }

    public void setCountedSpeciesCollection(Collection<CountedSpecies> countedSpeciesCollection) {
        this.countedSpeciesCollection = countedSpeciesCollection;
    }

    public Collection<SpeciesName> getSpeciesNameCollection() {
        return speciesNameCollection;
    }

    public void setSpeciesNameCollection(Collection<SpeciesName> speciesName) {
        this.speciesNameCollection = speciesName;
    }

    @XmlTransient
    public Collection<SpeciesPicture> getSpeciesPictureCollection() {
        return speciesPictureCollection;
    }

    public void setSpeciesPictureCollection(Collection<SpeciesPicture> speciesPictureCollection) {
        this.speciesPictureCollection = speciesPictureCollection;
    }

    @XmlTransient
    public Collection<SpeciesBiotop> getSpeciesBiotopCollection() {
        return speciesBiotopCollection;
    }

    public void setSpeciesBiotopCollection(Collection<SpeciesBiotop> speciesBiotopCollection) {
        this.speciesBiotopCollection = speciesBiotopCollection;
    }

    @XmlTransient
    public Collection<RedlistSpecies> getRedlistSpeciesCollection() {
        return redlistSpeciesCollection;
    }

    public void setRedlistSpeciesCollection(Collection<RedlistSpecies> redlistSpeciesCollection) {
        this.redlistSpeciesCollection = redlistSpeciesCollection;
    }

    /**
     * @return the speciesScienceNameCollection
     */
    public Collection<SpeciesScienceName> getSpeciesScienceNameCollection() {
        return speciesScienceNameCollection;
    }

    /**
     * @param speciesScienceNameCollection the speciesScienceNameCollection to set
     */
    public void setSpeciesScienceNameCollection(Collection<SpeciesScienceName> speciesScienceName) {
        this.speciesScienceNameCollection = speciesScienceName;
    }

    /**
     * @return the mainScienceName
     */
    public SpeciesScienceName getMainScienceName() {
        return mainScienceName;
    }

    /**
     * @param mainScienceName the mainScienceName to set
     */
    public void setMainScienceName(SpeciesScienceName mainScienceName) {
        this.mainScienceName = mainScienceName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesId != null ? speciesId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Species)) {
            return false;
        }
        Species other = (Species) object;
        if ((this.speciesId == null && other.speciesId != null) || (this.speciesId != null && !this.speciesId.equals(
                other.speciesId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.Species[ speciesId={0} ]", speciesId);
    }
}
