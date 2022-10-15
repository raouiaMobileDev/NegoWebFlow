package com.miracl.nego.provider.ws;

import java.io.File;
import java.io.FileWriter;
import java.rmi.RemoteException;

import com.miracl.nego.provider.ws.ProviderProxy;

public class Client1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try {
			//FileWriter fw = new FileWriter("D:/RequesterP1.html", true);
			 ProviderProxy	provider1 =new ProviderProxy();
			 
			 provider1.setEndpoint("http://localhost:8080/NegoProviders/services/Provider1");
			 Data[] data= new Data[]{new Data("Pirce","200"),new Data("time","200")};
			 
			  provider1.invoke("toto", "web service", "Rawia", "contracnet", "request", data);
			 ProviderProxy	provider2 =new ProviderProxy();
			 provider2.setEndpoint("http://localhost:8080/NegoProviders/services/Provider2");
	
			provider2.invoke("AGENT", "J2EE","Imen", "contracnet","accept",data );
			//File fw = new File("RequesterP1.html");
			//System.out.println(b);

		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}