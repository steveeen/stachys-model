/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

/**
 *
 * @author Bonke
 */
@Entity
@Table(name = "`speciesScienceName´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SpeciesScienceName.findAll",
            query = "SELECT s FROM SpeciesScienceName s"),
    @NamedQuery(name = "SpeciesScienceName.findBySyslogcreatedOn",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "SpeciesScienceName.findBySyslogcreatedby",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "SpeciesScienceName.findBySysloglastChangedOn",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "SpeciesScienceName.findBySysloglastChangedBy",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "SpeciesScienceName.findByNamesource",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.namesource = :namesource"),
    @NamedQuery(name = "SpeciesScienceName.findByTaxomType",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.taxomType = :taxomType"),
    @NamedQuery(name = "SpeciesScienceName.findByFamily",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.family = :family"),
    @NamedQuery(name = "SpeciesScienceName.findBySpecies",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.species = :species"),
    @NamedQuery(name = "SpeciesScienceName.findBySubspecies",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.subspecies = :subspecies"),
    @NamedQuery(name = "SpeciesScienceName.findByVariation",
            query = "SELECT s FROM SpeciesScienceName s WHERE s.variation = :variation")})
public class SpeciesScienceName extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String PROP_SPECIESREF = "PROP_SPECIESREF";

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[speciesscnameid]", nullable = false, unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID speciesscnameid;

    @Column(length = 200)
    private String namesource;

    @Column(name = "[taxomType]", length = 100)
    private String taxomType;

    @Column(length = 100)
    private String family;

    @Column(length = 100)
    private String species;

    @Column(length = 100)
    private String subspecies;

    @Column(length = 100)
    private String variation;

    @Column(length = 100)
    private String speciesnameorginal;

    @JoinColumn(name = "[speciesId]", referencedColumnName = "[speciesid]", nullable = false)
    @ManyToOne(optional = false)
    private Species speciesRef;

    @OneToMany(mappedBy = "mainScienceName")
    private Collection<Species> speciesCollection;

    public SpeciesScienceName() {
    }

    public SpeciesScienceName(UUID speciesscnameid) {
        this.speciesscnameid = speciesscnameid;
    }

    /**
     * @param speciesCollection the speciesCollection to set
     */
    public void setSpeciesCollection(Collection<Species> speciesCollection) {
        this.speciesCollection = speciesCollection;
    }

    /**
     * @return the speciesCollection
     */
    public Collection<Species> getSpeciesCollection() {
        return speciesCollection;
    }

    public UUID getSpeciesscnameid() {
        return speciesscnameid;
    }

    public void setSpeciesscnameid(UUID speciesscnameid) {
        this.speciesscnameid = speciesscnameid;
    }

    public String getNamesource() {
        return namesource;
    }

    public void setNamesource(String namesource) {
        this.namesource = namesource;
    }

    public String getTaxomType() {
        return taxomType;
    }

    public void setTaxomType(String taxomType) {
        this.taxomType = taxomType;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSubspecies() {
        return subspecies;
    }

    public void setSubspecies(String subspecies) {
        this.subspecies = subspecies;
    }

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    /**
     * @return the speciesRef
     */
    public Species getSpeciesRef() {
        return speciesRef;
    }

    /**
     * @param speciesRef the speciesRef to set
     */
    public void setSpeciesRef(Species speciesRef) {
        this.speciesRef = speciesRef;
    }

    /**
     * @return the species orginal name
     */
    public String getSpeciesnameorginal() {
        return speciesnameorginal;
    }

    /**
     * @param speciesnameorginal the speciesnameorginal to set
     */
    public void setSpeciesnameorginal(String speciesnameorginal) {
        this.speciesnameorginal = speciesnameorginal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (speciesscnameid != null ? speciesscnameid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SpeciesScienceName)) {
            return false;
        }
        SpeciesScienceName other = (SpeciesScienceName) object;
        if ((this.speciesscnameid == null && other.speciesscnameid != null) || (this.speciesscnameid != null && !this.speciesscnameid.equals(
                other.speciesscnameid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.SpeciesScienceName[ speciesscnameid={0} ]", speciesscnameid);
    }
}
