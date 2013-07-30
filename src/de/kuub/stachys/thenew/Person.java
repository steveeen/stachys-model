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
@Table(schema = "public", name = "`persons´")
//@TypeDef(name = "uuid-custom", typeClass = PersistentUUID.class)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p"),
    @NamedQuery(name = "Person.findByLastname",
            query = "SELECT p FROM Person p WHERE p.lastname = :lastname"),
    @NamedQuery(name = "Person.findByFirstname",
            query = "SELECT p FROM Person p WHERE p.firstname = :firstname"),
    @NamedQuery(name = "Person.findByEmail",
            query = "SELECT p FROM Person p WHERE p.email = :email"),
    @NamedQuery(name = "Person.findByRole",
            query = "SELECT p FROM Person p WHERE p.role = :role"),
    @NamedQuery(name = "Person.findByOldpid",
            query = "SELECT p FROM Person p WHERE p.oldpid = :oldpid"),
    @NamedQuery(name = "Person.findByOlduid",
            query = "SELECT p FROM Person p WHERE p.olduid = :olduid")})
public class Person extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(name = "[persid]", nullable = false, unique = true)
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID persId;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String lastname;

    @Column(length = 60)
    private String firstname;

    @Basic(optional = true)
    @Column(nullable = true, length = 120)
    private String email;

    @Column(length = 120)
    private String location;

    @Column(length = 300)
    private String miscellaneous;

    @Column(length = 50)
    private String role;

    private Integer oldpid;

    private Integer olduid;

    @OneToMany(mappedBy = "copyrightPersonId")
    private Collection<Pictures> PictureCollection;

    @JoinColumn(name = "[userid]", referencedColumnName = "[userid]")
    @ManyToOne
    private User userId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "person")
    private Collection<CountedSpeciesPerson> countedSpeciesPersonsCollection;

    public Person() {
    }

    public Person(UUID persId) {
        this.persId = persId;
    }

    public Person(UUID persId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, String lastname, String email) {
        this.persId = persId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.lastname = lastname;
        this.email = email;
    }

    public UUID getPersId() {
        return persId;
    }

    public void setPersId(UUID persId) {
        this.persId = persId;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getOldpid() {
        return oldpid;
    }

    public void setOldpid(Integer oldpid) {
        this.oldpid = oldpid;
    }

    public Integer getOlduid() {
        return olduid;
    }

    public void setOlduid(Integer olduid) {
        this.olduid = olduid;
    }

    @XmlTransient
    public Collection<Pictures> getSpeciesPictureCollection() {
        return PictureCollection;
    }

    public void setPictureCollection(Collection<Pictures> PictureCollection) {
        this.PictureCollection = PictureCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    /**
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the miscellaneous
     */
    public String getMiscellaneous() {
        return miscellaneous;
    }

    /**
     * @param miscellaneous the miscellaneous to set
     */
    public void setMiscellaneous(String miscellaneous) {
        this.miscellaneous = miscellaneous;
    }

    @XmlTransient
    public Collection<CountedSpeciesPerson> getCountedSpeciesPersonsCollection() {
        return countedSpeciesPersonsCollection;
    }

    public void setCountedSpeciesPersonsCollection(Collection<CountedSpeciesPerson> countedSpeciesPersonsCollection) {
        this.countedSpeciesPersonsCollection = countedSpeciesPersonsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (persId != null ? persId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(
                other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.Persons[ persId={0} ]", persId);
    }
}
