package com.miracl.nego.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rawia BOUABDELLAH - MIRACL
 */
@Entity
@Table(name = "protocols")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Protocol.findAll", query = "SELECT p FROM Protocol p"),
    @NamedQuery(name = "Protocol.findByProtocolName", query = "SELECT p FROM Protocol p WHERE p.protocolName = :protocolName"),
    @NamedQuery(name = "Protocol.findByBehavior", query = "SELECT p FROM Protocol p WHERE p.behavior = :behavior"),
    @NamedQuery(name = "Protocol.findByPartnersNumber", query = "SELECT p FROM Protocol p WHERE p.partnersNumber = :partnersNumber"),
    @NamedQuery(name = "Protocol.findByRoundsNumbers", query = "SELECT p FROM Protocol p WHERE p.roundsNumbers = :roundsNumbers"),
    @NamedQuery(name = "Protocol.findByAttributesNumber", query = "SELECT p FROM Protocol p WHERE p.attributesNumber = :attributesNumber"),
    @NamedQuery(name = "Protocol.findByALL", query = "SELECT p FROM Protocol p WHERE p.behavior = :behavior and p.partnersNumber = :partnersNumber and p.roundsNumbers = :roundsNumbers and p.attributesNumber = :attributesNumber")})
public class Protocol implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "PROTOCOL_NAME")
    private String protocolName;
    @Basic(optional = false)
    @Column(name = "BEHAVIOR")
    private String behavior;
    @Basic(optional = false)
    @Column(name = "PARTNERS_NUMBER")
    private String partnersNumber;
    @Basic(optional = false)
    @Column(name = "ROUNDS_NUMBERS")
    private String roundsNumbers;
    @Basic(optional = false)
    @Column(name = "ATTRIBUTES_NUMBER")
    private String attributesNumber;

    public Protocol() {
    }

    public Protocol(String protocolName) {
        this.protocolName = protocolName;
    }

    public Protocol(String protocolName, String behavior, String partnersNumber, String roundsNumbers, String attributesNumber) {
        this.protocolName = protocolName;
        this.behavior = behavior;
        this.partnersNumber = partnersNumber;
        this.roundsNumbers = roundsNumbers;
        this.attributesNumber = attributesNumber;
    }

    public String getProtocolName() {
        return protocolName;
    }

    public void setProtocolName(String protocolName) {
        this.protocolName = protocolName;
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }

    public String getPartnersNumber() {
        return partnersNumber;
    }

    public void setPartnersNumber(String partnersNumber) {
        this.partnersNumber = partnersNumber;
    }

    public String getRoundsNumbers() {
        return roundsNumbers;
    }

    public void setRoundsNumbers(String roundsNumbers) {
        this.roundsNumbers = roundsNumbers;
    }

    public String getAttributesNumber() {
        return attributesNumber;
    }

    public void setAttributesNumber(String attributesNumber) {
        this.attributesNumber = attributesNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (protocolName != null ? protocolName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Protocol)) {
            return false;
        }
        Protocol other = (Protocol) object;
        if ((this.protocolName == null && other.protocolName != null) || (this.protocolName != null && !this.protocolName.equals(other.protocolName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miracl.jpa.entity.Protocol[ protocolName=" + protocolName + " ]";
    }
    
}
