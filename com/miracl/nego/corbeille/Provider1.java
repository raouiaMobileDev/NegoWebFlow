package com.miracl.nego.corbeille;



import javax.jws.*;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService(targetNamespace = "http://nego.miracl.com/ws",
            name="Provider1",
            serviceName="Provider")
@SOAPBinding(style=SOAPBinding.Style.DOCUMENT,
             use=SOAPBinding.Use.LITERAL)
public class Provider1
{
   @WebMethod(operationName="Notify", action="urn:Notify")
   public String Notify(@WebParam(name="message") String a)
   {
      return ("Message : " + a);
   }

   @WebMethod(exclude=true)
   public static void main(String[] args)
   {
      String endpointUri = "http://localhost:8581";
      Endpoint.publish(endpointUri, new Provider1 ());
      System.out.println("Publishing JAX-WS at " + endpointUri);
   }
}