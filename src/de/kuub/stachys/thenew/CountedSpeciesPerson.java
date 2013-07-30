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
@Table(name = "`countedSpecies_persons´", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountedSpeciesPerson.findAll",
            query = "SELECT c FROM CountedSpeciesPerson c"),
    @NamedQuery(name = "CountedSpeciesPerson.findBySyslogcreatedOn",
            query = "SELECT c FROM CountedSpeciesPerson c WHERE c.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "CountedSpeciesPerson.findBySyslogcreatedby",
            query = "SELECT c FROM CountedSpeciesPerson c WHERE c.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "CountedSpeciesPerson.findBySysloglastChangedOn",
            query = "SELECT c FROM CountedSpeciesPerson c WHERE c.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "CountedSpeciesPerson.findBySysloglastChangedBy",
            query = "SELECT c FROM CountedSpeciesPerson c WHERE c.sysloglastChangedBy = :sysloglastChangedBy")})
public class CountedSpeciesPerson extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected CountedSpeciesPersonPK countedSpeciesPersonPK;

    @JoinColumn(name = "[persid]", referencedColumnName = "[persid]", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    @JoinColumn(name = "[zd_id]", referencedColumnName = "[zdid]", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CountedSpecies countedSpecies;

    public CountedSpeciesPerson() {
    }

    public CountedSpeciesPerson(CountedSpeciesPersonPK countedSpeciesPersonPK) {
        this.countedSpeciesPersonPK = countedSpeciesPersonPK;
    }

    public CountedSpeciesPerson(CountedSpeciesPersonPK countedSpeciesPersonPK, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy) {
        this.countedSpeciesPersonPK = countedSpeciesPersonPK;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
    }

    public CountedSpeciesPerson(UUID persid, UUID zdId) {
        this.countedSpeciesPersonPK = new CountedSpeciesPersonPK(persid, zdId);
    }

    public CountedSpeciesPersonPK getCountedSpeciesPersonPK() {
        return countedSpeciesPersonPK;
    }

    public void setCountedSpeciesPersonPK(CountedSpeciesPersonPK countedSpeciesPersonPK) {
        this.countedSpeciesPersonPK = countedSpeciesPersonPK;
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
        hash += (countedSpeciesPersonPK != null ? countedSpeciesPersonPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountedSpeciesPerson)) {
            return false;
        }
        CountedSpeciesPerson other = (CountedSpeciesPerson) object;
        if ((this.countedSpeciesPersonPK == null && other.countedSpeciesPersonPK != null) || (this.countedSpeciesPersonPK != null && !this.countedSpeciesPersonPK.equals(
                other.countedSpeciesPersonPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.CountedSpeciesPerson[ countedSpeciesPersonPK={0} ]",
                countedSpeciesPersonPK);
    }
}
