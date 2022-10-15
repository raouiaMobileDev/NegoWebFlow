/**
 * Provider1ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miracl.nego.provider.ws;

public class ProviderServiceLocator extends org.apache.axis.client.Service implements com.miracl.nego.provider.ws.ProviderService {

    public ProviderServiceLocator() {
    }


    public ProviderServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ProviderServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Provider1
    private java.lang.String Provider1_address = "http://localhost:8080/NegoProviders/services/Provider1";

    public java.lang.String getProvider1Address() {
        return Provider1_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Provider1WSDDServiceName = "Provider1";

    public java.lang.String getProvider1WSDDServiceName() {
        return Provider1WSDDServiceName;
    }

    public void setProvider1WSDDServiceName(java.lang.String name) {
        Provider1WSDDServiceName = name;
    }

    public com.miracl.nego.provider.ws.Provider getProvider1() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Provider1_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getProvider1(endpoint);
    }

    public com.miracl.nego.provider.ws.Provider getProvider1(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.miracl.nego.provider.ws.ProviderSoapBindingStub _stub = new com.miracl.nego.provider.ws.ProviderSoapBindingStub(portAddress, this);
            _stub.setPortName(getProvider1WSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setProvider1EndpointAddress(java.lang.String address) {
        Provider1_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.miracl.nego.provider.ws.Provider.class.isAssignableFrom(serviceEndpointInterface)) {
                com.miracl.nego.provider.ws.ProviderSoapBindingStub _stub = new com.miracl.nego.provider.ws.ProviderSoapBindingStub(new java.net.URL(Provider1_address), this);
                _stub.setPortName(getProvider1WSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Provider1".equals(inputPortName)) {
            return getProvider1();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.provider.nego.miracl.com", "Provider1Service");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.provider.nego.miracl.com", "Provider1"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Provider1".equals(portName)) {
            setProvider1EndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
