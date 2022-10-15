package com.miracl.nego.agent;


import java.util.Iterator;

import jade.content.AgentAction;
import jade.content.onto.annotations.AggregateSlot;
import jade.content.onto.annotations.Result;
import jade.util.leap.List;

@Result(type=String.class)
public class Invoke implements AgentAction {

	private List data;
	private String provider;
	private String serviceName;
	private String contributor;
	private String protocol;
	private String performative;
	
	
	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getContributor() {
		return contributor;
	}

	public void setContributor(String contributor) {
		this.contributor = contributor;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getPerformative() {
		return performative;
	}

	public void setPerformative(String performative) {
		this.performative = performative;
	}

	
	@AggregateSlot(type=float.class, cardMin=2)
	public List getData() {
		return data;
	}

	public void setData(List data) {
		this.data = data;
	}

	@Override
	public String toString() {
		String s = "Multiplication (";
		Iterator it = data.iterator();
		boolean first = true;
		while(it.hasNext()) {
			if (!first) {
				s += ",";
			}
			first = false;
			s += it.next();
		}
		s += ")";
		return s;
	}
}
