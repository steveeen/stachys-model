/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.text.MessageFormat;
import java.util.UUID;
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
@Table(name = "authors", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Authors.findAll", query = "SELECT a FROM Authors a"),
    @NamedQuery(name = "Authors.findBySyslogcreatedOn",
            query = "SELECT a FROM Authors a WHERE a.syslogcreatedOn = :syslogcreatedOn"),
    @NamedQuery(name = "Authors.findBySyslogcreatedby",
            query = "SELECT a FROM Authors a WHERE a.syslogcreatedby = :syslogcreatedby"),
    @NamedQuery(name = "Authors.findBySysloglastChangedOn",
            query = "SELECT a FROM Authors a WHERE a.sysloglastChangedOn = :sysloglastChangedOn"),
    @NamedQuery(name = "Authors.findBySysloglastChangedBy",
            query = "SELECT a FROM Authors a WHERE a.sysloglastChangedBy = :sysloglastChangedBy")
})
public class Authors extends Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    protected AuthorsPK authorsPK;

    @JoinColumn(name = "[personId]", referencedColumnName = "[persid]", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Person person;

    @JoinColumn(name = "[dataSourceId]", referencedColumnName = "[dataSourceId]", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private DataSource dataSource;

    public Authors() {
    }

    public Authors(AuthorsPK authorsPK) {
        this.authorsPK = authorsPK;
    }

    public Authors(AuthorsPK authorsPK, Person person, DataSource datasource) {
        this.authorsPK = authorsPK;
        this.person = person;
        this.dataSource = datasource;
    }

    public Authors(UUID dataSourceId, UUID personId) {
        this.authorsPK = new AuthorsPK(dataSourceId, personId);
    }

    public AuthorsPK getAuthorsPK() {
        return authorsPK;
    }

    public void setAuthorsPK(AuthorsPK authorsPK) {
        this.authorsPK = authorsPK;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (authorsPK != null ? authorsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Authors)) {
            return false;
        }
        Authors other = (Authors) object;
        if ((this.authorsPK == null && other.authorsPK != null) || (this.authorsPK != null && !this.authorsPK.equals(
                other.authorsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return MessageFormat.format("de.kuub.stachys.thenew.Authors[ authorsPK=%s ]", authorsPK);
    }
}
