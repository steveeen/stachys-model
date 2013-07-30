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
@Entity()
@Table(schema = "public", name = "redlist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RedList.findAll", query = "SELECT r FROM RedList r"),
    @NamedQuery(name = "RedList.findBySyslogcreatedOn",
            query = "SELECT r FROM RedList r WHERE r.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "RedList.findBySyslogcreatedby",
            query = "SELECT r FROM RedList r WHERE r.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "RedList.findBySysloglastChangedOn",
            query = "SELECT r FROM RedList r WHERE r.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "RedList.findBySysloglastChangedBy",
            query = "SELECT r FROM RedList r WHERE r.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "RedList.findByYearPublication",
            query = "SELECT r FROM RedList r WHERE r.yearPublication = :yearPublication"),
    @NamedQuery(name = "RedList.findByCountry",
            query = "SELECT r FROM RedList r WHERE r.country = :country"),
    @NamedQuery(name = "RedList.findByOldid",
            query = "SELECT r FROM RedList r WHERE r.oldid = :oldid")})
public class RedList extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[redlistid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID redListId;

    @Column(name = "[yearPublication]")
    private Short yearPublication;

    @Column(length = 120)
    private String country;

    private Integer oldid;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "redList")
    private Collection<RedlistSpecies> redlistSpeciesCollection;

    public RedList() {
    }

    public RedList(UUID redListId) {
        this.redListId = redListId;
    }

    public RedList(UUID redListId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.redListId = redListId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public UUID getRedListId() {
        return redListId;
    }

    public void setRedListId(UUID redListId) {
        this.redListId = redListId;
    }

    public Short getYearPublication() {
        return yearPublication;
    }

    public void setYearPublication(Short yearPublication) {
        this.yearPublication = yearPublication;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    @XmlTransient
    public Collection<RedlistSpecies> getRedlistSpeciesCollection() {
        return redlistSpeciesCollection;
    }

    public void setRedlistSpeciesCollection(Collection<RedlistSpecies> redlistSpeciesCollection) {
        this.redlistSpeciesCollection = redlistSpeciesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (redListId != null ? redListId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RedList)) {
            return false;
        }
        RedList other = (RedList) object;
        if ((this.redListId == null && other.redListId != null) || (this.redListId != null && !this.redListId.equals(
                other.redListId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "de.kuub.stachys.thenew.RedList[ redListId=" + redListId + " ]";
    }
}
