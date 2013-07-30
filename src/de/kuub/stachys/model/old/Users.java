/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Bonke
 */
@Entity(name = "Userso")
@Table(catalog = "pflanzenorg", schema = "public", name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Userso.findAll",
            query = "SELECT u FROM Userso u"),
    @NamedQuery(name = "Userso.findByUserId",
            query = "SELECT u FROM Userso u WHERE u.userId= :userId"),
    @NamedQuery(name = "Userso.findByName",
            query = "SELECT u FROM Userso u WHERE u.name = :name"),
    @NamedQuery(name = "Userso.findByPass",
            query = "SELECT u FROM Userso u WHERE u.pass = :pass"),
    @NamedQuery(name = "Userso.findByRole",
            query = "SELECT u FROM Userso u WHERE u.role = :role"),
    @NamedQuery(name = "Userso.findByTrusted",
            query = "SELECT u FROM Userso u WHERE u.trusted = :trusted"),
    @NamedQuery(name = "Userso.findBySalt",
            query = "SELECT u FROM Userso u WHERE u.salt = :salt")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;

    @Basic(optional = false)
    private String name;

    @Basic(optional = false)
    private String pass;

    private String role;

    @Basic(optional = false)
    private boolean trusted;

    private String salt;

    @Column(name = "trans_id")
    private Integer transId;

    private String pass2;

    @JoinColumn(name = "pers_id", referencedColumnName = "pers_id")
    @ManyToOne
    private Personen persId;

    @OneToMany(mappedBy = "user")
    private Collection<Personen> personenCollection;

    public Users() {
    }

    public Users(Integer userId) {
        this.userId = userId;
    }

    public Users(Integer userId, String name, String pass, boolean trusted) {
        this.userId = userId;
        this.name = name;
        this.pass = pass;
        this.trusted = trusted;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public Integer getTransId() {
        return transId;
    }

    public void setTransId(Integer transId) {
        this.transId = transId;
    }

    public String getPass2() {
        return pass2;
    }

    public void setPass2(String pass2) {
        this.pass2 = pass2;
    }

    public Personen getPersId() {
        return persId;
    }

    public void setPersId(Personen persId) {
        this.persId = persId;
    }

    @XmlTransient
    public Collection<Personen> getPersonenCollection() {
        return personenCollection;
    }

    public void setPersonenCollection(Collection<Personen> personenCollection) {
        this.personenCollection = personenCollection;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(
                other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Users[ userId=" + userId + " ]";
    }
}
