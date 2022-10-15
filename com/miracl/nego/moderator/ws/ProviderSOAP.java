/**
 * ProviderSOAP.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miracl.nego.moderator.ws;

public class ProviderSOAP  implements java.io.Serializable {
    private java.lang.String contributor;

    private java.lang.String data;

    private java.lang.String performative;

    private java.lang.String protocol;

    private java.lang.String provider;

    private java.lang.String serviceName;

    public ProviderSOAP() {
    }

    public ProviderSOAP(
           java.lang.String contributor,
           java.lang.String data,
           java.lang.String performative,
           java.lang.String protocol,
           java.lang.String provider,
           java.lang.String serviceName) {
           this.contributor = contributor;
           this.data = data;
           this.performative = performative;
           this.protocol = protocol;
           this.provider = provider;
           this.serviceName = serviceName;
    }


    /**
     * Gets the contributor value for this ProviderSOAP.
     * 
     * @return contributor
     */
    public java.lang.String getContributor() {
        return contributor;
    }


    /**
     * Sets the contributor value for this ProviderSOAP.
     * 
     * @param contributor
     */
    public void setContributor(java.lang.String contributor) {
        this.contributor = contributor;
    }


    /**
     * Gets the data value for this ProviderSOAP.
     * 
     * @return data
     */
    public java.lang.String getData() {
        return data;
    }


    /**
     * Sets the data value for this ProviderSOAP.
     * 
     * @param data
     */
    public void setData(java.lang.String data) {
        this.data = data;
    }


    /**
     * Gets the performative value for this ProviderSOAP.
     * 
     * @return performative
     */
    public java.lang.String getPerformative() {
        return performative;
    }


    /**
     * Sets the performative value for this ProviderSOAP.
     * 
     * @param performative
     */
    public void setPerformative(java.lang.String performative) {
        this.performative = performative;
    }


    /**
     * Gets the protocol value for this ProviderSOAP.
     * 
     * @return protocol
     */
    public java.lang.String getProtocol() {
        return protocol;
    }


    /**
     * Sets the protocol value for this ProviderSOAP.
     * 
     * @param protocol
     */
    public void setProtocol(java.lang.String protocol) {
        this.protocol = protocol;
    }


    /**
     * Gets the provider value for this ProviderSOAP.
     * 
     * @return provider
     */
    public java.lang.String getProvider() {
        return provider;
    }


    /**
     * Sets the provider value for this ProviderSOAP.
     * 
     * @param provider
     */
    public void setProvider(java.lang.String provider) {
        this.provider = provider;
    }


    /**
     * Gets the serviceName value for this ProviderSOAP.
     * 
     * @return serviceName
     */
    public java.lang.String getServiceName() {
        return serviceName;
    }


    /**
     * Sets the serviceName value for this ProviderSOAP.
     * 
     * @param serviceName
     */
    public void setServiceName(java.lang.String serviceName) {
        this.serviceName = serviceName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ProviderSOAP)) return false;
        ProviderSOAP other = (ProviderSOAP) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contributor==null && other.getContributor()==null) || 
             (this.contributor!=null &&
              this.contributor.equals(other.getContributor()))) &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.performative==null && other.getPerformative()==null) || 
             (this.performative!=null &&
              this.performative.equals(other.getPerformative()))) &&
            ((this.protocol==null && other.getProtocol()==null) || 
             (this.protocol!=null &&
              this.protocol.equals(other.getProtocol()))) &&
            ((this.provider==null && other.getProvider()==null) || 
             (this.provider!=null &&
              this.provider.equals(other.getProvider()))) &&
            ((this.serviceName==null && other.getServiceName()==null) || 
             (this.serviceName!=null &&
              this.serviceName.equals(other.getServiceName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getContributor() != null) {
            _hashCode += getContributor().hashCode();
        }
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getPerformative() != null) {
            _hashCode += getPerformative().hashCode();
        }
        if (getProtocol() != null) {
            _hashCode += getProtocol().hashCode();
        }
        if (getProvider() != null) {
            _hashCode += getProvider().hashCode();
        }
        if (getServiceName() != null) {
            _hashCode += getServiceName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ProviderSOAP.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "ProviderSOAP"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contributor");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "contributor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("performative");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "performative"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("protocol");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "protocol"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("provider");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "provider"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "serviceName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
