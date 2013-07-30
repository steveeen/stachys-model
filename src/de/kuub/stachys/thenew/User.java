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
@Table(schema = "public", name = "`users´")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll",
            query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findBySyslogcreatedOn",
            query = "SELECT u FROM User u WHERE u.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "User.findBySyslogcreatedby",
            query = "SELECT u FROM User u WHERE u.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "User.findBySysloglastChangedOn",
            query = "SELECT u FROM User u WHERE u.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "User.findBySysloglastChangedBy",
            query = "SELECT u FROM User u WHERE u.sysloglastChangedBy = :sysloglastChangedBy"),
    @NamedQuery(name = "User.findByUsername",
            query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByPassword",
            query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByTrusted",
            query = "SELECT u FROM User u WHERE u.trusted = :trusted"),
    @NamedQuery(name = "User.findBySalt",
            query = "SELECT u FROM User u WHERE u.salt = :salt"),
    @NamedQuery(name = "User.findByPermakey",
            query = "SELECT u FROM User u WHERE u.permakey = :permakey"),
    @NamedQuery(name = "User.findByOldid",
            query = "SELECT u FROM User u WHERE u.oldid = :oldid")})
public class User extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Type(type = "uuid-custom")
    @Column(nullable = false, unique = true, name = "[userid]")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private UUID userId;

    @Basic(optional = false)
    @Column(nullable = false, length = 30)
    private String username;

    @Basic(optional = false)
    @Column(nullable = false, length = 240)
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    private boolean trusted;

    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String salt;

    @Column(length = 200)
    private String permakey;

    private Integer oldid;

    @OneToMany(mappedBy = "userId")
    private Collection<Person> personsCollection;

    public User() {
    }

    public User(UUID userId) {
        this.userId = userId;
    }

    public User(UUID userId, Date syslogcreatedOn, String syslogcreatedby, Date sysloglastChangedOn, String sysloglastChangedBy, String username, String password, boolean trusted, String salt) {
        this.userId = userId;
        this.setSyslogcreatedOn(syslogcreatedOn);
        this.setSyslogcreatedby(syslogcreatedby);
        this.setSysloglastChangedOn(sysloglastChangedOn);
        this.setSysloglastChangedBy(sysloglastChangedBy);
        this.username = username;
        this.password = password;
        this.trusted = trusted;
        this.salt = salt;
    }

    public Object getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getTrusted() {
        return trusted;
    }

    public void setTrusted(boolean trusted) {
        this.trusted = trusted;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPermakey() {
        return permakey;
    }

    public void setPermakey(String permakey) {
        this.permakey = permakey;
    }

    public Integer getOldid() {
        return oldid;
    }

    public void setOldid(Integer oldid) {
        this.oldid = oldid;
    }

    @XmlTransient
    public Collection<Person> getPersonsCollection() {
        return personsCollection;
    }

    public void setPersonsCollection(Collection<Person> personsCollection) {
        this.personsCollection = personsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(
                other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}[ userId={1} ]", this.getClass().getName(), userId);
    }
}
