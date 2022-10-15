package com.miracl.nego.util;

import java.io.Serializable;

public class Provider implements Serializable {
	private String contributor;
	private String  endpoint;
	
	public Provider(String contributor, String  endpoint)
	{
		this.contributor= contributor;
		this.endpoint= endpoint;
	}
	public String getContributor() {
		return contributor;
	}
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	public String getEndpoint() {
		return endpoint;
	}
	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}
	

}
