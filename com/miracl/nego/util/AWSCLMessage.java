package com.miracl.nego.util;

import java.io.Serializable;
import java.util.Vector;
import com.miracl.nego.provider.ws.Data;

public class AWSCLMessage implements Serializable {
	private String requester;
	private String protocol;
	private String service_Name;
	private String performative;
	private Vector providers;
	private Data[] data;
	
	
	public AWSCLMessage (String requester, String protocol, Vector providers)
	{
		this.requester=requester;
		this.protocol=protocol;
		this.providers=providers;
	}
	
	public AWSCLMessage (String requester, String protocol)
	{
		this.requester=requester;
		this.protocol=protocol;
	}
	
	public AWSCLMessage ()
	{
	}
	
	public void setRequester(String requester)
	{
		this.requester=requester;
	}
	
	public String getPerformative() {
		return performative;
	}

	public void setPerformative(String performative) {
		this.performative = performative;
	}

	public void setProtocol(String protocol)
	{
		this.protocol=protocol;
	}
	public String getProtocol()
	{
		return protocol;
	}
	
	public String getRequester() {
		return requester;
	}

	public Data[] getData() {
		return data;
	}

	public String getService_Name() {
		return service_Name;
	}

	public void setService_Name(String service_Name) {
		this.service_Name = service_Name;
	}
	
	public void setProviders(Vector providers)
	{
		this.providers=providers;
	}
	public Vector getProviders()
	{
		return providers;
	}
	
	public void setData( Data[]data)
	{
		this.data=data;
	}
	

}
