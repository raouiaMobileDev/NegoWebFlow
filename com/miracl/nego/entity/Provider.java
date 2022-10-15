package com.miracl.nego.entity;


import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rawia BOUABDELLAH-MIRACL
 */
@Entity
@Table(name = "providers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Provider.findAll", query = "SELECT p FROM Provider p"),
    @NamedQuery(name = "Provider.findByIdProvider", query = "SELECT p FROM Provider p WHERE p.idProvider = :idProvider"),
    @NamedQuery(name = "Provider.findByServiceName", query = "SELECT p FROM Provider p WHERE p.serviceName = :serviceName"),
    @NamedQuery(name = "Provider.findByTrainingName", query = "SELECT p FROM Provider p WHERE p.trainingName = :trainingName"),
    @NamedQuery(name = "Provider.findByContributor", query = "SELECT p FROM Provider p WHERE p.contributor = :contributor"),
    @NamedQuery(name = "Provider.findByHours", query = "SELECT p FROM Provider p WHERE p.hours = :hours"),
    @NamedQuery(name = "Provider.findByPrice", query = "SELECT p FROM Provider p WHERE p.price = :price"),
    @NamedQuery(name = "Provider.findByCertificate", query = "SELECT p FROM Provider p WHERE p.certificate = :certificate"),
    @NamedQuery(name = "Provider.findByOrganizationName", query = "SELECT p FROM Provider p WHERE p.organizationName = :organizationName"),
    @NamedQuery(name = "Provider.findByEndpoint", query = "SELECT p FROM Provider p WHERE p.endpoint = :endpoint")})
public class Provider implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROVIDER")
    private Integer idProvider;
    @Basic(optional = false)
    @Column(name = "SERVICE_NAME")
    private String serviceName;
    @Basic(optional = false)
    @Column(name = "TRAINING_NAME")
    private String trainingName;
    @Basic(optional = false)
    @Column(name = "CONTRIBUTOR")
    private String contributor;
    @Basic(optional = false)
    @Column(name = "HOURS")
    private int hours;
    @Basic(optional = false)
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @Column(name = "CERTIFICATE")
    private boolean certificate;
    @Basic(optional = false)
    @Column(name = "ORGANIZATION_NAME")
    private String organizationName;
    @Basic(optional = false)
    @Column(name = "ENDPOINT")
    private String endpoint;

    public Provider() {
    }

    public Provider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public Provider(Integer idProvider, String serviceName, String trainingName, String contributor, int hours, int price, boolean certificate, String organizationName, String endpoint) {
        this.idProvider = idProvider;
        this.serviceName = serviceName;
        this.trainingName = trainingName;
        this.contributor = contributor;
        this.hours = hours;
        this.price = price;
        this.certificate = certificate;
        this.organizationName = organizationName;
        this.endpoint = endpoint;
    }

    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean getCertificate() {
        return certificate;
    }

    public void setCertificate(boolean certificate) {
        this.certificate = certificate;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProvider != null ? idProvider.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Provider)) {
            return false;
        }
        Provider other = (Provider) object;
        if ((this.idProvider == null && other.idProvider != null) || (this.idProvider != null && !this.idProvider.equals(other.idProvider))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.miracl.jpa.entity.Provider[ idProvider=" + idProvider + " ]";
    }
    
}
