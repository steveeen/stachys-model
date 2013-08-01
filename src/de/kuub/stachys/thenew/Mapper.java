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
@Table(name = "`mappers´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mapper.findAll",
            query = "SELECT c FROM Mapper c"),
    @NamedQuery(name = "Mapper.findBySyslogcreatedOn",
            query = "SELECT c FROM Mapper c WHERE c.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "Mapper.findBySyslogcreatedby",
            query = "SELECT c FROM Mapper c WHERE c.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "Mapper.findBySysloglastChangedOn",
            query = "SELECT c FROM Mapper c WHERE c.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "Mapper.findBySysloglastChangedBy",
            query = "SELECT c FROM Mapper c WHERE c.sysloglastChangedBy = :sysloglastChangedBy")})
public class Mapper extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected MapperPK mapperPK;

    @JoinColumn(name = "[persid]", referencedColumnName = "[persid]", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    @JoinColumn(name = "[zd_id]", referencedColumnName = "[zdid]", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CountedSpecies countedSpecies;

    public Mapper() {
    }

    public Mapper(MapperPK mapperPK) {
        this.mapperPK = mapperPK;
    }

    public Mapper(MapperPK mapperPK, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.mapperPK = mapperPK;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public Mapper(UUID persid, UUID zdId) {
        this.mapperPK = new MapperPK(persid, zdId);
    }

    public MapperPK getMapperPK() {
        return mapperPK;
    }

    public void setMapperPK(MapperPK mapperPK) {
        this.mapperPK = mapperPK;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public CountedSpecies getCountedSpecies() {
        return countedSpecies;
    }

    public void setCountedSpecies(CountedSpecies countedSpecies) {
        this.countedSpecies = countedSpecies;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mapperPK != null ? mapperPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mapper)) {
            return false;
        }
        Mapper other = (Mapper) object;
        if ((this.mapperPK == null && other.mapperPK != null) || (this.mapperPK != null && !this.mapperPK.equals(
                other.mapperPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.Mapper[ MapperPK={0} ]",
                mapperPK);
    }
}
