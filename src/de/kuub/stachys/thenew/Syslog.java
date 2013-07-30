/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.kuub.stachys.thenew;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 *
 * @author Bonke
 */
@MappedSuperclass
public class Syslog implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "[Syslog_createdOn]", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date syslogcreatedOn;

    @Basic(optional = false)
    @Column(name = "[Syslog_createdby]", nullable = false, length = 100)
    private String syslogcreatedby;

    @Basic(optional = false)
    @Column(name = "[Syslog_lastChangedOn]", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date sysloglastChangedOn;

    @Basic(optional = false)
    @Column(name = "[Syslog_lastChangedBy]", nullable = false, length = 100)
    private String sysloglastChangedBy;

    @Basic(optional = false)
    @Column(name = "[Version]")
    @Version
    private long version;

    /**
     * @param version the version to set
     */
    public void setVersion(long version) {
        this.version = version;
    }

    /**
     * @return the version
     */
    public long getVersion() {
        return version;
    }

    public Date getSyslogcreatedOn() {
        return syslogcreatedOn;
    }

    public void setSyslogcreatedOn(Date syslogcreatedOn) {
        this.syslogcreatedOn = syslogcreatedOn;
    }

    public String getSyslogcreatedby() {
        return syslogcreatedby;
    }

    public void setSyslogcreatedby(String syslogcreatedby) {
        this.syslogcreatedby = syslogcreatedby;
    }

    public Date getSysloglastChangedOn() {
        return sysloglastChangedOn;
    }

    public void setSysloglastChangedOn(Date sysloglastChangedOn) {
        this.sysloglastChangedOn = sysloglastChangedOn;
    }

    public String getSysloglastChangedBy() {
        return sysloglastChangedBy;
    }

    public void setSysloglastChangedBy(String sysloglastChangedBy) {
        this.sysloglastChangedBy = sysloglastChangedBy;
    }
}
