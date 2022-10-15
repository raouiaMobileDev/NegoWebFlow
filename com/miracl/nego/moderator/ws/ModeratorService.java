/**
 * ModeratorService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.miracl.nego.moderator.ws;

public interface ModeratorService extends javax.xml.rpc.Service {
    public java.lang.String getModeratorAddress();

    public com.miracl.nego.moderator.ws.Moderator getModerator() throws javax.xml.rpc.ServiceException;

    public com.miracl.nego.moderator.ws.Moderator getModerator(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
