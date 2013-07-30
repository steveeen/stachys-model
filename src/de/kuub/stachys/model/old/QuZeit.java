/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
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
@Table(name = "qu_zeit", catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "QuZeit.findAll", query = "SELECT q FROM QuZeit q"),
    @NamedQuery(name = "QuZeit.findByZeitschriftId",
            query = "SELECT q FROM QuZeit q WHERE q.quZeitPK.zeitschriftId = :zeitschriftId"),
    @NamedQuery(name = "QuZeit.findByQuellId",
            query = "SELECT q FROM QuZeit q WHERE q.quZeitPK.quellId = :quellId"),
    @NamedQuery(name = "QuZeit.findByAusgabe",
            query = "SELECT q FROM QuZeit q WHERE q.ausgabe = :ausgabe")})
public class QuZeit implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected QuZeitPK quZeitPK;

    private String ausgabe;

    @JoinColumn(name = "zeitschrift_id", referencedColumnName = "zeitschrift_id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Zeitschrift zeitschrift;

    @JoinColumn(name = "quell_id", referencedColumnName = "quell_id",
            insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Quelle quelle;

    public QuZeit() {
    }

    public QuZeit(QuZeitPK quZeitPK) {
        this.quZeitPK = quZeitPK;
    }

    public QuZeit(int zeitschriftId, int quellId) {
        this.quZeitPK = new QuZeitPK(zeitschriftId, quellId);
    }

    public QuZeitPK getQuZeitPK() {
        return quZeitPK;
    }

    public void setQuZeitPK(QuZeitPK quZeitPK) {
        this.quZeitPK = quZeitPK;
    }

    public String getAusgabe() {
        return ausgabe;
    }

    public void setAusgabe(String ausgabe) {
        this.ausgabe = ausgabe;
    }

    public Zeitschrift getZeitschrift() {
        return zeitschrift;
    }

    public void setZeitschrift(Zeitschrift zeitschrift) {
        this.zeitschrift = zeitschrift;
    }

    public Quelle getQuelle() {
        return quelle;
    }

    public void setQuelle(Quelle quelle) {
        this.quelle = quelle;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (quZeitPK != null ? quZeitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof QuZeit)) {
            return false;
        }
        QuZeit other = (QuZeit) object;
        if ((this.quZeitPK == null && other.quZeitPK != null) || (this.quZeitPK != null && !this.quZeitPK.equals(
                other.quZeitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.QuZeit[ quZeitPK=" + quZeitPK + " ]";
    }
}
