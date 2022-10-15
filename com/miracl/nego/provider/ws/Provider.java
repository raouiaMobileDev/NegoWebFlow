/**
 * Provider1.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miracl.nego.provider.ws;

public interface Provider extends java.rmi.Remote {
    public void invoke(java.lang.String requester, java.lang.String service_Name, java.lang.String contributor, java.lang.String protocol, java.lang.String performative, com.miracl.nego.provider.ws.Data[] data) throws java.rmi.RemoteException;
}
