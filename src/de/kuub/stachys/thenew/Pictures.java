/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
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
@Table(schema = "public", name = "`pictures´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pictures.findAll",
            query = "SELECT p FROM Pictures p"),
    @NamedQuery(name = "Pictures.findBySyslogcreatedOn",
            query = "SELECT p FROM Pictures p WHERE p.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "Pictures.findBySyslogcreatedby",
            query = "SELECT p FROM Pictures p WHERE p.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "Pictures.findBySysloglastChangedOn",
            query = "SELECT p FROM Pictures p WHERE p.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "Pictures.findBySysloglastChangedBy",
            query = "SELECT p FROM Pictures p WHERE p.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "Pictures.findByOldid",
            query = "SELECT p FROM Pictures p WHERE p.oldid = :oldid")})
public class Pictures extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[pictureid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID pictureId;

    @Column(nullable = false, columnDefinition = "bytea")
    private byte[] picture;

    private Integer oldid;

    @Basic(optional = false)
    @Column(nullable = false, name = "[MimeType]", length = 50)
    private String mimeType;

    @JoinColumn(name = "[copyrightPersonId]", referencedColumnName = "[persid]")
    @ManyToOne
    private Person copyrightPersonId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mainPicture")
    private Collection<Species> speciesCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pictures")
    private Collection<SpeciesPicture> speciesPictureCollection;

    @Column(length = 100)
    private String comment;

    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "[dataLicense]", referencedColumnName = "[LicenseId]", nullable = true)
    private DataLicense license;

    public Pictures() {
    }

    public Pictures(UUID pictureId) {
        this.pictureId = pictureId;
    }

    public Pictures(UUID pictureId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.pictureId = pictureId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    /**
     * @param license the license to set
     */
    public void setLicense(DataLicense license) {
        this.license = license;
    }

    /**
     * @return the license
     */
    public DataLicense getLicense() {
        return license;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public UUID getPictureId() {
        return pictureId;
    }

    public void setPictureId(UUID pictureId) {
        this.pictureId = pictureId;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    public Person getCopyrightPersonId() {
        return copyrightPersonId;
    }

    public void setCopyrightPersonId(Person copyrightPersonId) {
        this.copyrightPersonId = copyrightPersonId;
    }

    @XmlTransient
    public Collection<Species> getSpeciesCollection() {
        return speciesCollection;
    }

    public void setSpeciesCollection(Collection<Species> speciesCollection) {
        this.speciesCollection = speciesCollection;
    }

    @XmlTransient
    public Collection<SpeciesPicture> getSpeciesPictureCollection() {
        return speciesPictureCollection;
    }

    public void setSpeciesPictureCollection(Collection<SpeciesPicture> speciesPictureCollection) {
        this.speciesPictureCollection = speciesPictureCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pictureId != null ? pictureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pictures)) {
            return false;
        }
        Pictures other = (Pictures) object;
        if ((this.pictureId == null && other.pictureId != null) || (this.pictureId != null && !this.pictureId.equals(
                other.pictureId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.kuub.stachys.thenew.Pictures[ pictureId=" + pictureId + " ]";
    }

    /**
     * @return the mimeType
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * @param mimeType the mimeType to set
     */
    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
