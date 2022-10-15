package com.miracl.nego.moderator.ws;

public class ModeratorProxy implements com.miracl.nego.moderator.ws.Moderator {
  private String _endpoint = null;
  private com.miracl.nego.moderator.ws.Moderator moderator = null;
  
  public ModeratorProxy() {
    _initModeratorProxy();
  }
  
  public ModeratorProxy(String endpoint) {
    _endpoint = endpoint;
    _initModeratorProxy();
  }
  
  private void _initModeratorProxy() {
    try {
      moderator = (new com.miracl.nego.moderator.ws.ModeratorServiceLocator()).getModerator();
      if (moderator != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)moderator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)moderator)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (moderator != null)
      ((javax.xml.rpc.Stub)moderator)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.miracl.nego.moderator.ws.Moderator getModerator() {
    if (moderator == null)
      _initModeratorProxy();
    return moderator;
  }
  
  public int doFirstBestPrice(com.miracl.nego.moderator.ws.ProviderSOAP[] pros) throws java.rmi.RemoteException{
    if (moderator == null)
      _initModeratorProxy();
    return moderator.doFirstBestPrice(pros);
  }
  
  
}