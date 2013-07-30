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
@Table(name = "`publicationMedium´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PublicationMedium.findAll", query = "SELECT p FROM PublicationMedium p"),
    @NamedQuery(name = "PublicationMedium.findBySyslogcreatedOn",
            query = "SELECT p FROM PublicationMedium p WHERE p.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "PublicationMedium.findBySyslogcreatedby",
            query = "SELECT p FROM PublicationMedium p WHERE p.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "PublicationMedium.findBySysloglastChangedOn",
            query = "SELECT p FROM PublicationMedium p WHERE p.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "PublicationMedium.findBySysloglastChangedBy",
            query = "SELECT p FROM PublicationMedium p WHERE p.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "PublicationMedium.findByPMediumTitle",
            query = "SELECT p FROM PublicationMedium p WHERE p.pMediumTitle = :pMediumTitle"),
    @NamedQuery(name = "PublicationMedium.findByPMediumReference",
            query = "SELECT p FROM PublicationMedium p WHERE p.pMediumReference = :pMediumReference")})
public class PublicationMedium extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[publicationMediumId]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID publicationMediumId;

    @Basic(optional = false)
    @Column(name = "[pMediumTitle]")
    private String pMediumTitle;

    @Column(name = "[pMediumReference]")
    private String pMediumReference;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publicationMedium")
    private Collection<DataSourceMedium> datasourceMediumCollection;

    public PublicationMedium() {
    }

    public PublicationMedium(UUID publicationMediumId) {
        this.publicationMediumId = publicationMediumId;
    }

    public PublicationMedium(UUID publicationMediumId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, long version, String pMediumTitle) {
        this.publicationMediumId = publicationMediumId;
        this.pMediumTitle = pMediumTitle;
    }

    public UUID getPublicationMediumId() {
        return publicationMediumId;
    }

    public void setPublicationMediumId(UUID publicationMediumId) {
        this.publicationMediumId = publicationMediumId;
    }

    public String getPMediumTitle() {
        return pMediumTitle;
    }

    public void setPMediumTitle(String pMediumTitle) {
        this.pMediumTitle = pMediumTitle;
    }

    public String getPMediumReference() {
        return pMediumReference;
    }

    public void setPMediumReference(String pMediumReference) {
        this.pMediumReference = pMediumReference;
    }

    @XmlTransient
    public Collection<DataSourceMedium> getDatasourceMediumCollection() {
        return datasourceMediumCollection;
    }

    public void setDatasourceMediumCollection(Collection<DataSourceMedium> datasourceMediumCollection) {
        this.datasourceMediumCollection = datasourceMediumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (publicationMediumId != null ? publicationMediumId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PublicationMedium)) {
            return false;
        }
        PublicationMedium other = (PublicationMedium) object;
        if ((this.publicationMediumId == null && other.publicationMediumId != null) || (this.publicationMediumId != null && !this.publicationMediumId.equals(
                other.publicationMediumId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.PublicationMedium[ publicationMediumId={0} ]", publicationMediumId);
    }
}
