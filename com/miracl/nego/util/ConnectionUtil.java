package com.miracl.nego.util;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;


public class ConnectionUtil {

 //private final static String URL_SERVLET="http://localhost:8080/NegoFlowWS/servlet/HelloJavaWorld?param=agent";
	private final static String URL_SERVLET="http://localhost:8180/NegoFlowWS/ws?param=agent";
	public static void send(AWSCLMessage message)
	{
		try {   
			URL aURL = new URL(URL_SERVLET);  
			URLConnection aConnection = aURL.openConnection();  
			aConnection.setDoInput(true);  
			aConnection.setDoOutput(true);  
			aConnection.setUseCaches(false);  
			aConnection.setDefaultUseCaches(false);  
			aConnection.setRequestProperty("Content-Type","application/octet-stream");  
		
			ObjectOutputStream out = new ObjectOutputStream(aConnection.getOutputStream());  
			out.writeObject(message);  
			out.flush();  
			out.close();  
			
			ObjectInputStream in = new ObjectInputStream(aConnection.getInputStream());  
			String text = (String) in.readObject();
			
			} catch (Exception e) {  
			//e.printStackTrace();  
			}  
}  

	public static void main(String[] args) {  
		ConnectionUtil.send(null);
	}	
}
