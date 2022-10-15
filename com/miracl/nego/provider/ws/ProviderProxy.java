package com.miracl.nego.provider.ws;

public class ProviderProxy implements com.miracl.nego.provider.ws.Provider {
  private String _endpoint = null;
  private com.miracl.nego.provider.ws.Provider provider1 = null;
  
  public ProviderProxy() {
    _initProvider1Proxy();
  }
  
  public ProviderProxy(String endpoint) {
    _endpoint = endpoint;
    _initProvider1Proxy();
  }
  
  private void _initProvider1Proxy() {
    try {
      provider1 = (new com.miracl.nego.provider.ws.ProviderServiceLocator()).getProvider1();
      if (provider1 != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)provider1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)provider1)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (provider1 != null)
      ((javax.xml.rpc.Stub)provider1)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.miracl.nego.provider.ws.Provider getProvider1() {
    if (provider1 == null)
      _initProvider1Proxy();
    return provider1;
  }
  
  public void invoke(java.lang.String requester, java.lang.String service_Name, java.lang.String contributor, java.lang.String protocol, java.lang.String performative, com.miracl.nego.provider.ws.Data[] data) throws java.rmi.RemoteException{
    if (provider1 == null)
      _initProvider1Proxy();
    provider1.invoke(requester, service_Name, contributor, protocol, performative, data);
  }
  
  
}