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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
    @NamedQuery(name = "Zaehldaten.findAll",
            query = "SELECT z FROM Zaehldaten z"),
    @NamedQuery(name = "Zaehldaten.findByZdId",
            query = "SELECT z FROM Zaehldaten z WHERE z.zdId = :zdId"),
    @NamedQuery(name = "Zaehldaten.findByAufnahmejahr",
            query = "SELECT z FROM Zaehldaten z WHERE z.aufnahmejahr = :aufnahmejahr"),
    @NamedQuery(name = "Zaehldaten.findByAnzahlabs",
            query = "SELECT z FROM Zaehldaten z WHERE z.anzahlabs = :anzahlabs"),
    @NamedQuery(name = "Zaehldaten.findByZaehleinheit",
            query = "SELECT z FROM Zaehldaten z WHERE z.zaehleinheit = :zaehleinheit"),
    @NamedQuery(name = "Zaehldaten.findBySchaetzwert",
            query = "SELECT z FROM Zaehldaten z WHERE z.schaetzwert = :schaetzwert"),
    @NamedQuery(name = "Zaehldaten.findByBNb",
            query = "SELECT z FROM Zaehldaten z WHERE z.bNb = :bNb"),
    @NamedQuery(name = "Zaehldaten.findByErgaenzung",
            query = "SELECT z FROM Zaehldaten z WHERE z.ergaenzung = :ergaenzung"),
    @NamedQuery(name = "Zaehldaten.findByTrusteduser",
            query = "SELECT z FROM Zaehldaten z WHERE z.trusteduser = :trusteduser")})
public class Zaehldaten implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zd_id")
    private Integer zdId;

    @Basic(optional = false)
    private short aufnahmejahr;

    @Basic(optional = false)
    private int anzahlabs;

    @Basic(optional = false)
    private String zaehleinheit;

    @Basic(optional = false)
    private boolean schaetzwert;

    @Column(name = "b_nb")
    private String bNb;

    private String ergaenzung;

    @Basic(optional = false)
    private boolean trusteduser;

    @ManyToMany(mappedBy = "zaehldatenCollection")
    private Collection<Personen> personenCollection;

    @ManyToMany(mappedBy = "zaehldatenCollection")
    private Collection<Quelle> quelleCollection;

    @JoinColumn(name = "art_id", referencedColumnName = "art_id")
    @ManyToOne(optional = false)
    private Taxonomisch artId;

    @JoinColumn(name = "fo_id", referencedColumnName = "fo_id")
    @ManyToOne(optional = false)
    private Fundort foId;

    public Zaehldaten() {
    }

    public Zaehldaten(Integer zdId) {
        this.zdId = zdId;
    }

    public Zaehldaten(Integer zdId, short aufnahmejahr, int anzahlabs, String zaehleinheit, boolean schaetzwert, boolean trusteduser) {
        this.zdId = zdId;
        this.aufnahmejahr = aufnahmejahr;
        this.anzahlabs = anzahlabs;
        this.zaehleinheit = zaehleinheit;
        this.schaetzwert = schaetzwert;
        this.trusteduser = trusteduser;
    }

    public Integer getZdId() {
        return zdId;
    }

    public void setZdId(Integer zdId) {
        this.zdId = zdId;
    }

    public short getAufnahmejahr() {
        return aufnahmejahr;
    }

    public void setAufnahmejahr(short aufnahmejahr) {
        this.aufnahmejahr = aufnahmejahr;
    }

    public int getAnzahlabs() {
        return anzahlabs;
    }

    public void setAnzahlabs(int anzahlabs) {
        this.anzahlabs = anzahlabs;
    }

    public String getZaehleinheit() {
        return zaehleinheit;
    }

    public void setZaehleinheit(String zaehleinheit) {
        this.zaehleinheit = zaehleinheit;
    }

    public boolean getSchaetzwert() {
        return schaetzwert;
    }

    public void setSchaetzwert(boolean schaetzwert) {
        this.schaetzwert = schaetzwert;
    }

    public String getBNb() {
        return bNb;
    }

    public void setBNb(String bNb) {
        this.bNb = bNb;
    }

    public String getErgaenzung() {
        return ergaenzung;
    }

    public void setErgaenzung(String ergaenzung) {
        this.ergaenzung = ergaenzung;
    }

    public boolean getTrusteduser() {
        return trusteduser;
    }

    public void setTrusteduser(boolean trusteduser) {
        this.trusteduser = trusteduser;
    }

    @XmlTransient
    public Collection<Personen> getPersonenCollection() {
        return personenCollection;
    }

    public void setPersonenCollection(Collection<Personen> personenCollection) {
        this.personenCollection = personenCollection;
    }

    @XmlTransient
    public Collection<Quelle> getQuelleCollection() {
        return quelleCollection;
    }

    public void setQuelleCollection(Collection<Quelle> quelleCollection) {
        this.quelleCollection = quelleCollection;
    }

    public Taxonomisch getArtId() {
        return artId;
    }

    public void setArtId(Taxonomisch artId) {
        this.artId = artId;
    }

    public Fundort getFoId() {
        return foId;
    }

    public void setFoId(Fundort foId) {
        this.foId = foId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zdId != null ? zdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zaehldaten)) {
            return false;
        }
        Zaehldaten other = (Zaehldaten) object;
        if ((this.zdId == null && other.zdId != null) || (this.zdId != null && !this.zdId.equals(
                other.zdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Zaehldaten[ zdId=" + zdId + " ]";
    }
}
