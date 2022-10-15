package com.miracl.nego.gui;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Vector;

import com.miracl.nego.util.AWSCLMessage;
import com.miracl.nego.util.VectorMessage;

public class HelloJavaWorldMessage {
	
public HelloJavaWorldMessage()
{
	URLConnection servletConnection=null;
	try {
	URL ticketservlet = new URL( "http://localhost:8080/NegoFlowWS/servlet/HelloJavaWorld?param=agent"); 
	servletConnection = ticketservlet.openConnection();
	 
	// inform the connection that we will send output and accept input 
	servletConnection.setDoInput(true); 
	servletConnection.setDoOutput(true); 

	// Don't use a cached version of URL connection. 
	servletConnection.setUseCaches (false); 
	servletConnection.setDefaultUseCaches (false); 

	// Specify the content type that we will send binary data 
	servletConnection.setRequestProperty ("Content-Type", "application/octet-stream"); 

	// send the student object to the servlet using serialization 
	ObjectOutputStream ticketOutputToServlet;
	
		ticketOutputToServlet = new ObjectOutputStream(servletConnection.getOutputStream());
	

	// serialize the object , and sending it to servlet , ticketData should implement Serializable interface.
	//AWSCLMessage message= new AWSCLMessage("adi","contratnet");
VectorMessage v= new VectorMessage();
v.add("contractnet");
		ticketOutputToServlet .writeObject(v);
	
	
	ticketOutputToServlet .flush(); 
	ticketOutputToServlet .close();
	System.out.println("send message");
	
	
	//reading back data from servlet
	System.out.println(servletConnection.getInputStream());
	ObjectInputStream inputFromServlet = new ObjectInputStream(servletConnection.getInputStream()); 
	System.out.println("send message2");
	Vector resultantData = (Vector) inputFromServlet.readObject();
	String filename = (String) resultantData.elementAt(0);
	System.out.println(filename);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
	//Showing the newly created page from Applet
	//getAppletContext().showDocument(new URL("http://www.jcom.com/profiles/" + filename));
}

public static void main (String args[])
{
	HelloJavaWorldMessage message= new HelloJavaWorldMessage();
}
}
