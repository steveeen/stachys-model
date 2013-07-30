/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
    @NamedQuery(name = "Quelle.findAll", query = "SELECT q FROM Quelle q"),
    @NamedQuery(name = "Quelle.findByQuellId",
            query = "SELECT q FROM Quelle q WHERE q.quellId = :quellId"),
    @NamedQuery(name = "Quelle.findByTitel",
            query = "SELECT q FROM Quelle q WHERE q.titel = :titel"),
    @NamedQuery(name = "Quelle.findByJahr",
            query = "SELECT q FROM Quelle q WHERE q.jahr = :jahr"),
    @NamedQuery(name = "Quelle.findByQuellart",
            query = "SELECT q FROM Quelle q WHERE q.quellart = :quellart"),
    @NamedQuery(name = "Quelle.findByOrt",
            query = "SELECT q FROM Quelle q WHERE q.ort = :ort"),
    @NamedQuery(name = "Quelle.findByPublikation",
            query = "SELECT q FROM Quelle q WHERE q.publikation = :publikation")})
public class Quelle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "quell_id")
    private Integer quellId;

    @Basic(optional = false)
    private String titel;

    @Basic(optional = false)
    private short jahr;

    @Basic(optional = false)
    private String quellart;

    @Basic(optional = false)
    private String ort;

    private Boolean publikation;

    @ManyToMany(mappedBy = "quelleCollection")
    private Collection<Personen> personenCollection;

    @JoinTable(name = "zd_qu", joinColumns = {
        @JoinColumn(name = "quell_id", referencedColumnName = "quell_id")},
            inverseJoinColumns = {
        @JoinColumn(name = "zd_id", referencedColumnName = "zd_id")})
    @ManyToMany
    private Collection<Zaehldaten> zaehldatenCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "quelle")
    private Collection<QuZeit> quZeitCollection;

    public Quelle() {
    }

    public Quelle(Integer quellId) {
        this.quellId = quellId;
    }

    public Quelle(Integer quellId, String titel, short jahr, String quellart, String ort) {
        this.quellId = quellId;
        this.titel = titel;
        this.jahr = jahr;
        this.quellart = quellart;
        this.ort = ort;
    }

    public Integer getQuellId() {
        return quellId;
    }

    public void setQuellId(Integer quellId) {
        this.quellId = quellId;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public short getJahr() {
        return jahr;
    }

    public void setJahr(short jahr) {
        this.jahr = jahr;
    }

    public String getQuellart() {
        return quellart;
    }

    public void setQuellart(String quellart) {
        this.quellart = quellart;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public Boolean getPublikation() {
        return publikation;
    }

    public void setPublikation(Boolean publikation) {
        this.publikation = publikation;
    }

    @XmlTransient
    public Collection<Personen> getPersonenCollection() {
        return personenCollection;
    }

    public void setPersonenCollection(Collection<Personen> personenCollection) {
        this.personenCollection = personenCollection;
    }

    @XmlTransient
    public Collection<Zaehldaten> getZaehldatenCollection() {
        return zaehldatenCollection;
    }

    public void setZaehldatenCollection(Collection<Zaehldaten> zaehldatenCollection) {
        this.zaehldatenCollection = zaehldatenCollection;
    }

    @XmlTransient
    public Collection<QuZeit> getQuZeitCollection() {
        return quZeitCollection;
    }

    public void setQuZeitCollection(Collection<QuZeit> quZeitCollection) {
        this.quZeitCollection = quZeitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quellId != null ? quellId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Quelle)) {
            return false;
        }
        Quelle other = (Quelle) object;
        if ((this.quellId == null && other.quellId != null) || (this.quellId != null && !this.quellId.equals(
                other.quellId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Quelle[ quellId=" + quellId + " ]";
    }
}
