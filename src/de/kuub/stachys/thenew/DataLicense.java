/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(schema = "public", name = "`dataLicense´")
@XmlRootElement
public class DataLicense extends Syslog implements Serializable {

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[Licenseid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID licenseid;

    @Basic(optional = false)
    @Column(nullable = false, length = 100, name = "[LicenseName]")
    private String licenseName;

    @Basic(optional = false)
    @Column(nullable = false, name = "[LicenseActive]")
    private boolean licenseActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "license")
    private Collection<CountedSpecies> countedSpeciesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "license")
    private Collection<SearchPlace> searchPlaceCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "license")
    private Collection<ReferenceAreas> referenceAreasCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "license")
    private Collection<Pictures> pictureCollection;

    /**
     * @param pictureCollection the pictureCollection to set
     */
    public void setPictureCollection(Collection<Pictures> pictureCollection) {
        this.pictureCollection = pictureCollection;
    }

    /**
     * @return the pictureCollection
     */
    public Collection<Pictures> getPictureCollection() {
        return pictureCollection;
    }

    /**
     * @param searchPlaceCollection the searchPlaceCollection to set
     */
    public void setSearchPlaceCollection(Collection<SearchPlace> searchPlaceCollection) {
        this.searchPlaceCollection = searchPlaceCollection;
    }

    /**
     * @param countedSpeciesCollection the countedSpeciesCollection to set
     */
    public void setCountedSpeciesCollection(Collection<CountedSpecies> countedSpeciesCollection) {
        this.countedSpeciesCollection = countedSpeciesCollection;
    }

    /**
     * @param referenceAreasCollection the referenceAreasCollection to set
     */
    public void setReferenceAreasCollection(Collection<ReferenceAreas> referenceAreasCollection) {
        this.referenceAreasCollection = referenceAreasCollection;
    }

    /**
     * @return the referenceAreasCollection
     */
    public Collection<ReferenceAreas> getReferenceAreasCollection() {
        return referenceAreasCollection;
    }

    /**
     * @return the searchPlaceCollection
     */
    public Collection<SearchPlace> getSearchPlaceCollection() {
        return searchPlaceCollection;
    }

    /**
     * @return the countedSpeciesCollection
     */
    public Collection<CountedSpecies> getCountedSpeciesCollection() {
        return countedSpeciesCollection;
    }

    /**
     * @param licenseActive the licenseActive to set
     */
    public void setLicenseActive(boolean licenseActive) {
        this.licenseActive = licenseActive;
    }

    /**
     * @return the licenseActive
     */
    public boolean isLicenseActive() {
        return licenseActive;
    }

    /**
     * @param licenseName the licenseName to set
     */
    public void setLicenseName(String licenseName) {
        this.licenseName = licenseName;
    }

    /**
     * @return the licenseName
     */
    public String getLicenseName() {
        return licenseName;
    }

    /**
     * @param licenseid the licenseid to set
     */
    public void setLicenseid(UUID licenseid) {
        this.licenseid = licenseid;
    }

    /**
     * @return the licenseid
     */
    public UUID getLicenseid() {
        return licenseid;
    }
}
