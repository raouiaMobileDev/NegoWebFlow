/*****************************************************************
JADE - Java Agent DEvelopment Framework is a framework to develop 
multi-agent systems in compliance with the FIPA specifications.
Copyright (C) 2002 TILAB

GNU Lesser General Public License

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation, 
version 2.1 of the License. 

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the
Free Software Foundation, Inc., 59 Temple Place - Suite 330,
Boston, MA  02111-1307, USA.
*****************************************************************/

package com.miracl.nego.agent;

import java.util.List;

import com.tilab.wsig.store.OperationName;
import com.tilab.wsig.store.SuppressOperation;

public class SelectorOntologyMapper {
	

	// The web service operation corresponding to the sum ontology action will be called add
	@OperationName(name="notify")
	public Notify toNotify(String firstElement, String secondElement){
		Notify notify = new Notify();
		notify.setFirstElement(firstElement);
		notify.setSecondElement(secondElement);
		return notify;
	}
	
	
	public Invoke toInvoke( String provider, String serviceName, String contributor, String protocol, String performative,  List data1)
	{	
		jade.util.leap.List data = new jade.util.leap.ArrayList();
		
		for (Object o : data1) {
			data.add((String)o);
		}
		
		Invoke invoke = new Invoke();
		invoke.setProvider(provider);
		invoke.setServiceName(serviceName);
		invoke.setContributor(contributor);
		invoke.setProtocol(protocol);
		invoke.setPerformative(performative);
		invoke.setData(data);
		return invoke;
	}

}
