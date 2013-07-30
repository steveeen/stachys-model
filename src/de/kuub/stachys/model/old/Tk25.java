/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Entity(name = "Tk25o")
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tk25o.findAll", query = "SELECT t FROM Tk25o t"),
    @NamedQuery(name = "Tk25o.findByTknummer",
            query = "SELECT t FROM Tk25o t WHERE t.tknummer = :tknummer"),
    @NamedQuery(name = "Tk25o.findByTkname",
            query = "SELECT t FROM Tk25o t WHERE t.tkname = :tkname")})
public class Tk25 implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    private Short tknummer;

    @Basic(optional = false)
    private String tkname;

    @Lob
    private Object area;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tkNr")
    private Collection<Dgk5> dgk5Collection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tkNr")
    private Collection<Tk25vqu> tk25vquCollection;

    public Tk25() {
    }

    public Tk25(Short tknummer) {
        this.tknummer = tknummer;
    }

    public Tk25(Short tknummer, String tkname) {
        this.tknummer = tknummer;
        this.tkname = tkname;
    }

    public Short getTknummer() {
        return tknummer;
    }

    public void setTknummer(Short tknummer) {
        this.tknummer = tknummer;
    }

    public String getTkname() {
        return tkname;
    }

    public void setTkname(String tkname) {
        this.tkname = tkname;
    }

    public Object getArea() {
        return area;
    }

    public void setArea(Object area) {
        this.area = area;
    }

    @XmlTransient
    public Collection<Dgk5> getDgk5Collection() {
        return dgk5Collection;
    }

    public void setDgk5Collection(Collection<Dgk5> dgk5Collection) {
        this.dgk5Collection = dgk5Collection;
    }

    @XmlTransient
    public Collection<Tk25vqu> getTk25vquCollection() {
        return tk25vquCollection;
    }

    public void setTk25vquCollection(Collection<Tk25vqu> tk25vquCollection) {
        this.tk25vquCollection = tk25vquCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tknummer != null ? tknummer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tk25)) {
            return false;
        }
        Tk25 other = (Tk25) object;
        if ((this.tknummer == null && other.tknummer != null) || (this.tknummer != null && !this.tknummer.equals(
                other.tknummer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tk25[ tknummer=" + tknummer + " ]";
    }
}
