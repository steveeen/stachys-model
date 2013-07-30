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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
    @NamedQuery(name = "Taxonomisch.findAll",
            query = "SELECT t FROM Taxonomisch t"),
    @NamedQuery(name = "Taxonomisch.findByArtId",
            query = "SELECT t FROM Taxonomisch t WHERE t.artId = :artId"),
    @NamedQuery(name = "Taxonomisch.findBySciencename",
            query = "SELECT t FROM Taxonomisch t WHERE t.sciencename = :sciencename"),
    @NamedQuery(name = "Taxonomisch.findByDeutschername",
            query = "SELECT t FROM Taxonomisch t WHERE t.deutschername = :deutschername"),
    @NamedQuery(name = "Taxonomisch.findByRlBrd",
            query = "SELECT t FROM Taxonomisch t WHERE t.rlBrd = :rlBrd"),
    @NamedQuery(name = "Taxonomisch.findByRlNrw",
            query = "SELECT t FROM Taxonomisch t WHERE t.rlNrw = :rlNrw"),
    @NamedQuery(name = "Taxonomisch.findByFsuffix",
            query = "SELECT t FROM Taxonomisch t WHERE t.fsuffix = :fsuffix")})
public class Taxonomisch implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "art_id")
    private Integer artId;

    @Basic(optional = false)
    private String sciencename;

    @Basic(optional = false)
    private String deutschername;

    @Basic(optional = false)
    @Column(name = "rl_brd")
    private String rlBrd;

    @Basic(optional = false)
    @Column(name = "rl_nrw")
    private String rlNrw;

    @Column(name = "artbild", nullable = false, columnDefinition = "bytea")
    private byte[] artbild;

    private String fsuffix;

    @ManyToMany(mappedBy = "taxonomischCollection")
    private Collection<Biotop> biotopCollection;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "taxonomisch")
    private Artpics artpics;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxonomisch")
    private Collection<TaxRl> taxRlCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artId")
    private Collection<Zaehldaten> zaehldatenCollection;

    public Taxonomisch() {
    }

    public Taxonomisch(Integer artId) {
        this.artId = artId;
    }

    public Taxonomisch(Integer artId, String sciencename, String deutschername, String rlBrd, String rlNrw) {
        this.artId = artId;
        this.sciencename = sciencename;
        this.deutschername = deutschername;
        this.rlBrd = rlBrd;
        this.rlNrw = rlNrw;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public String getSciencename() {
        return sciencename;
    }

    public String GetGattung() {
        String[] tmp = sciencename.split(" ");
        return tmp[0];
    }

    public String GetSpezies() {
        String[] tmp = sciencename.split(" ");
        return tmp[1];
    }

    public String GetSubSpezies() {
        if (sciencename.indexOf(" subsp. ") == -1) {
            return "";
        }
        String[] tmp = sciencename.split(" subsp. ");
        return tmp[tmp.length - 1];
    }

    public String GetVarianz() {
        if (sciencename.indexOf(" var. ") == -1) {
            return "";
        }
        String[] tmp = sciencename.split(" var. ");
        return tmp[tmp.length - 1];
    }

    public void setSciencename(String sciencename) {
        this.sciencename = sciencename;
    }

    public String getDeutschername() {
        return deutschername;
    }

    public void setDeutschername(String deutschername) {
        this.deutschername = deutschername;
    }

    public String getScienceNameToString() {
        return GetGattung() + " | " + GetSpezies() + " | " + GetSubSpezies() + " | " + GetVarianz();
    }

    public String getRlBrd() {
        return rlBrd;
    }

    public void setRlBrd(String rlBrd) {
        this.rlBrd = rlBrd;
    }

    public String getRlNrw() {
        return rlNrw;
    }

    public void setRlNrw(String rlNrw) {
        this.rlNrw = rlNrw;
    }

    public byte[] getArtbild() {
        return artbild;
    }

    public boolean hasArtbild() {
        return artbild != null && artbild.length > 0;
    }

    public void setArtbild(byte[] artbild) {
        this.artbild = artbild;
    }

    public String getFsuffix() {
        return fsuffix;
    }

    public void setFsuffix(String fsuffix) {
        this.fsuffix = fsuffix;
    }

    @XmlTransient
    public Collection<Biotop> getBiotopCollection() {
        return biotopCollection;
    }

    public void setBiotopCollection(Collection<Biotop> biotopCollection) {
        this.biotopCollection = biotopCollection;
    }

    public Artpics getArtpics() {
        return artpics;
    }

    public void setArtpics(Artpics artpics) {
        this.artpics = artpics;
    }

    @XmlTransient
    public Collection<TaxRl> getTaxRlCollection() {
        return taxRlCollection;
    }

    public void setTaxRlCollection(Collection<TaxRl> taxRlCollection) {
        this.taxRlCollection = taxRlCollection;
    }

    @XmlTransient
    public Collection<Zaehldaten> getZaehldatenCollection() {
        return zaehldatenCollection;
    }

    public void setZaehldatenCollection(Collection<Zaehldaten> zaehldatenCollection) {
        this.zaehldatenCollection = zaehldatenCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artId != null ? artId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Taxonomisch)) {
            return false;
        }
        Taxonomisch other = (Taxonomisch) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(
                other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Taxonomisch[ artId=" + artId + " ]";
    }
}
