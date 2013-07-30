/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.model.old;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Bonke
 */
@Entity
@Table(catalog = "pflanzenorg", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artpics.findAll", query = "SELECT a FROM Artpics a"),
    @NamedQuery(name = "Artpics.findByArtId",
            query = "SELECT a FROM Artpics a WHERE a.artId = :artId"),
    @NamedQuery(name = "Artpics.findByMimetype",
            query = "SELECT a FROM Artpics a WHERE a.mimetype = :mimetype")})
public class Artpics implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "art_id")
    private Integer artId;

    @Basic(optional = false)
    @Lob
    private byte[] bild;

    @Basic(optional = false)
    private String mimetype;

    @JoinColumn(name = "art_id", referencedColumnName = "art_id",
            insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Taxonomisch taxonomisch;

    public Artpics() {
    }

    public Artpics(Integer artId) {
        this.artId = artId;
    }

    public Artpics(Integer artId, byte[] bild, String mimetype) {
        this.artId = artId;
        this.bild = bild;
        this.mimetype = mimetype;
    }

    public Integer getArtId() {
        return artId;
    }

    public void setArtId(Integer artId) {
        this.artId = artId;
    }

    public byte[] getBild() {
        return bild;
    }

    public void setBild(byte[] bild) {
        this.bild = bild;
    }

    public String getMimetype() {
        return mimetype;
    }

    public void setMimetype(String mimetype) {
        this.mimetype = mimetype;
    }

    public Taxonomisch getTaxonomisch() {
        return taxonomisch;
    }

    public void setTaxonomisch(Taxonomisch taxonomisch) {
        this.taxonomisch = taxonomisch;
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
        if (!(object instanceof Artpics)) {
            return false;
        }
        Artpics other = (Artpics) object;
        if ((this.artId == null && other.artId != null) || (this.artId != null && !this.artId.equals(
                other.artId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Artpics[ artId=" + artId + " ]";
    }
}
