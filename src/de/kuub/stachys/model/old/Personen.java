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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Personen.findAll", query = "SELECT p FROM Personen p"),
    @NamedQuery(name = "Personen.findByPersId",
            query = "SELECT p FROM Personen p WHERE p.persId = :persId"),
    @NamedQuery(name = "Personen.findByName",
            query = "SELECT p FROM Personen p WHERE p.name = :name"),
    @NamedQuery(name = "Personen.findByVname",
            query = "SELECT p FROM Personen p WHERE p.vname = :vname"),
    @NamedQuery(name = "Personen.findByEmail",
            query = "SELECT p FROM Personen p WHERE p.email = :email"),
    @NamedQuery(name = "Personen.findByKartierer",
            query = "SELECT p FROM Personen p WHERE p.kartierer = :kartierer"),
    @NamedQuery(name = "Personen.findByAutor",
            query = "SELECT p FROM Personen p WHERE p.autor = :autor"),
    @NamedQuery(name = "Personen.findByOrt",
            query = "SELECT p FROM Personen p WHERE p.ort = :ort"),
    @NamedQuery(name = "Personen.findBySonstiges",
            query = "SELECT p FROM Personen p WHERE p.sonstiges = :sonstiges"),
    @NamedQuery(name = "Personen.findByRole",
            query = "SELECT p FROM Personen p WHERE p.role = :role")})
public class Personen implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pers_id")
    private Integer persId;

    @Basic(optional = false)
    private String name;

    private String vname;

    private String email;

    @Basic(optional = false)
    private boolean kartierer;

    @Basic(optional = false)
    private boolean autor;

    private String ort;

    private String sonstiges;

    private String role;

    @JoinTable(name = "qu_pers", joinColumns = {
        @JoinColumn(name = "pers_id", referencedColumnName = "pers_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "qu_id", referencedColumnName = "quell_id")})
    @ManyToMany
    private Collection<Quelle> quelleCollection;

    @JoinTable(name = "zd_pers", joinColumns = {
        @JoinColumn(name = "pers_id", referencedColumnName = "pers_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "zd_id", referencedColumnName = "zd_id")})
    @ManyToMany
    private Collection<Zaehldaten> zaehldatenCollection;

    @OneToMany(mappedBy = "persId")
    private Collection<Users> usersCollection;

    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne
    private Users user;

    public Personen() {
    }

    public Personen(Integer persId) {
        this.persId = persId;
    }

    public Personen(Integer persId, String name, boolean kartierer, boolean autor) {
        this.persId = persId;
        this.name = name;
        this.kartierer = kartierer;
        this.autor = autor;
    }

    public Integer getPersId() {
        return persId;
    }

    public void setPersId(Integer persId) {
        this.persId = persId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getKartierer() {
        return kartierer;
    }

    public void setKartierer(boolean kartierer) {
        this.kartierer = kartierer;
    }

    public boolean getAutor() {
        return autor;
    }

    public void setAutor(boolean autor) {
        this.autor = autor;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getSonstiges() {
        return sonstiges;
    }

    public void setSonstiges(String sonstiges) {
        this.sonstiges = sonstiges;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @XmlTransient
    public Collection<Quelle> getQuelleCollection() {
        return quelleCollection;
    }

    public void setQuelleCollection(Collection<Quelle> quelleCollection) {
        this.quelleCollection = quelleCollection;
    }

    @XmlTransient
    public Collection<Zaehldaten> getZaehldatenCollection() {
        return zaehldatenCollection;
    }

    public void setZaehldatenCollection(Collection<Zaehldaten> zaehldatenCollection) {
        this.zaehldatenCollection = zaehldatenCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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
        if (!(object instanceof Personen)) {
            return false;
        }
        Personen other = (Personen) object;
        if ((this.persId == null && other.persId != null) || (this.persId != null && !this.persId.equals(
                other.persId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Personen[ persId=" + persId + " ]";
    }
}
