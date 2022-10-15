/**
 * ModeratorServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miracl.nego.moderator.ws;

public class ModeratorServiceLocator extends org.apache.axis.client.Service implements com.miracl.nego.moderator.ws.ModeratorService {

    public ModeratorServiceLocator() {
    }


    public ModeratorServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ModeratorServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Moderator
    private java.lang.String Moderator_address = "http://localhost:8080/NegoInfrastructure/services/Moderator";

    public java.lang.String getModeratorAddress() {
        return Moderator_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ModeratorWSDDServiceName = "Moderator";

    public java.lang.String getModeratorWSDDServiceName() {
        return ModeratorWSDDServiceName;
    }

    public void setModeratorWSDDServiceName(java.lang.String name) {
        ModeratorWSDDServiceName = name;
    }

    public com.miracl.nego.moderator.ws.Moderator getModerator() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Moderator_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getModerator(endpoint);
    }

    public com.miracl.nego.moderator.ws.Moderator getModerator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.miracl.nego.moderator.ws.ModeratorSoapBindingStub _stub = new com.miracl.nego.moderator.ws.ModeratorSoapBindingStub(portAddress, this);
            _stub.setPortName(getModeratorWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setModeratorEndpointAddress(java.lang.String address) {
        Moderator_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.miracl.nego.moderator.ws.Moderator.class.isAssignableFrom(serviceEndpointInterface)) {
                com.miracl.nego.moderator.ws.ModeratorSoapBindingStub _stub = new com.miracl.nego.moderator.ws.ModeratorSoapBindingStub(new java.net.URL(Moderator_address), this);
                _stub.setPortName(getModeratorWSDDServiceName());
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
        if ("Moderator".equals(inputPortName)) {
            return getModerator();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "ModeratorService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.moderator.nego.miracl.com", "Moderator"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Moderator".equals(portName)) {
            setModeratorEndpointAddress(address);
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
