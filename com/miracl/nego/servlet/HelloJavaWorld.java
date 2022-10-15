package com.miracl.nego.servlet;

import java.io.*;
import java.util.List;
import java.util.Vector;

import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.log4j.Logger;

import com.miracl.nego.provider.ws.ProviderProxy;
import com.miracl.nego.util.AWSCLMessage;
import com.tilab.wsig.servlet.WSIGServlet;
public class HelloJavaWorld extends HttpServlet {

	private static Logger log = Logger.getLogger(HelloJavaWorld.class.getName());
	
    protected void doPost( HttpServletRequest request, HttpServletResponse response )
        throws ServletException, IOException {
    	//PrintWriter out = response.getWriter(); 
    	// out.println("start");
    	log.info("---start servlet");
    	if(request.getParameter("param").equals("agent"))
    			{
    	 doSendProviders(request,response);
    	 return;
    			}
    	/*
    	String x=request.getParameter("param");
		log.info("---x"+x);
		System.out.println("param"+x);
		if(x.equals("agent")){
			log.info("---WSIG Send Provider");
		doSendProviders(request,response);
		return;
		}
		*/
    	}     
    	
         /*
       
        response.setContentType("text/html");
        
        String value2= request.getParameter("name");
       
        out.println("value2:"+value2);
        out.println("username:"+username);
        if(value.equals("agent"))
        out.println("Call Web service?"+PARAM);
        out.println(request.getContentType());
        
        out.println("servlet");
        ObjectInputStream resultStream = null;  
        ObjectOutputStream sendStream = null;  
        List results = null;  
        try {  
        resultStream = new ObjectInputStream(request.getInputStream());  
       // results = (List) resultStream.readObject();  
        String x=(String)resultStream.readObject();
        resultStream.close();  
        sendStream = new ObjectOutputStream(response.getOutputStream());  
        //sendStream.writeObject(String.valueOf(results.size()));  
        sendStream.flush();  
        sendStream.close();  
        } catch (IOException e) {  
        e.printStackTrace();   
        } catch (ClassNotFoundException e) {  
        e.printStackTrace();  
        }  
        */
    private void doSendProviders(HttpServletRequest request, HttpServletResponse response ){
    	
    	ObjectInputStream resultStream = null;  
    	ObjectOutputStream sendStream = null;  
    	AWSCLMessage message = null;  
    	try {  
    		//log.info("Starting send...");
    		//PrintWriter out = response.getWriter(); 
    		//out.println("Starting send...");
    	resultStream = new ObjectInputStream(request.getInputStream());  
    	//results = (List) resultStream.readObject();  
    	message = (AWSCLMessage) resultStream.readObject();
    	//out.println("Service name:"+message.getService_Name());
    	Vector ps = message.getProviders();
    	
    	for(int i=0; i< ps.size() ;i++)
    	{
    		com.miracl.nego.util.Provider p=(com.miracl.nego.util.Provider)ps.get(i);
    		ProviderProxy	provider =new ProviderProxy();
    		provider.setEndpoint(p.getEndpoint());
    		log.info("provider EndPoint"+p.getEndpoint());
    		//out.println("provider EndPoint"+p.getEndpoint());
    		provider.invoke(message.getRequester(), message.getService_Name(),p.getContributor(), message.getProtocol(), message.getPerformative(),null);
    	}
    	resultStream.close();  
    	sendStream = new ObjectOutputStream(response.getOutputStream());  
    	sendStream.writeObject((String)message.getService_Name());  
    	com.miracl.nego.util.Provider p=(com.miracl.nego.util.Provider) message.getProviders().get(0);
    	sendStream.writeObject(p.getEndpoint());
    	sendStream.flush();  
    	sendStream.close();  
    	} catch (IOException e) {  
    	e.printStackTrace();   
    	} catch (ClassNotFoundException e) {  
    	e.printStackTrace();  
    	}  
    	}    	
     
    protected void doGet( HttpServletRequest request, HttpServletResponse response )
     throws ServletException, IOException {
    	doPost( request,response);
    }
    
}