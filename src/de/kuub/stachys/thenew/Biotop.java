/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
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
@Entity(name = "Biotopo")
@Table(schema = "public", name = "`biotop´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Biotopo.findAll", query = "SELECT b FROM Biotopo b"),
    @NamedQuery(name = "Biotopo.findBySyslogcreatedOn",
            query = "SELECT b FROM Biotopo b WHERE b.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "Biotopo.findBySyslogcreatedby",
            query = "SELECT b FROM Biotopo b WHERE b.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "Biotopo.findBySysloglastChangedOn",
            query = "SELECT b FROM Biotopo b WHERE b.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "Biotopo.findBySysloglastChangedBy",
            query = "SELECT b FROM Biotopo b WHERE b.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "Biotopo.findByBiotoptyp",
            query = "SELECT b FROM Biotopo b WHERE b.biotoptyp = :biotoptyp"),
    @NamedQuery(name = "Biotopo.findByOldid",
            query = "SELECT b FROM Biotopo b WHERE b.oldid = :oldid")})
public class Biotop extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[biotopid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID biotopId;

    @Column(length = 100)
    private String biotoptyp;

    private Integer oldid;

    @Column(nullable = true)
    @OneToMany(mappedBy = "biotop", cascade = CascadeType.ALL)
    private Collection<SpeciesBiotop> speciesBiotopCollection = new ArrayList<>();

    public Biotop() {
    }

    public Biotop(UUID biotopId) {
        this.biotopId = biotopId;
    }

    public Biotop(UUID biotopId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.biotopId = biotopId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public UUID getBiotopId() {
        return biotopId;
    }

    public void setBiotopId(UUID biotopId) {
        this.biotopId = biotopId;
    }

    public String getBiotoptyp() {
        return biotoptyp;
    }

    public void setBiotoptyp(String biotoptyp) {
        this.biotoptyp = biotoptyp;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    @XmlTransient
    public Collection<SpeciesBiotop> getSpeciesBiotopCollection() {
        return speciesBiotopCollection;
    }

    public void setSpeciesBiotopCollection(Collection<SpeciesBiotop> speciesBiotopCollection) {
        this.speciesBiotopCollection = speciesBiotopCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (biotopId != null ? biotopId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Biotop)) {
            return false;
        }
        Biotop other = (Biotop) object;
        if ((this.biotopId == null && other.biotopId != null) || (this.biotopId != null && !this.biotopId.equals(
                other.biotopId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.Biotop[ biotopId={0} ]", biotopId);
    }
}
