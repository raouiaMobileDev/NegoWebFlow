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

public interface SelectorVocabulary {
	
	public static final String ONTOLOGY_NAME = "selector-ontology";
	
	public static final String COMPLEX = "complex";
	public static final String RESULT = "result";
	public static final String AGENTINFO = "agentInfo";
	
	public static final String FIRST_ELEMENT = "firstElement";
    public static final String SECOND_ELEMENT = "secondElement";
	public static final String FIRST_COMPLEX_ELEMENT = "firstComplexElement";
    public static final String SECOND_COMPLEX_ELEMENT = "secondComplexElement";
	public static final String NUMBERS = "numbers";
	
	public static final String PROVIDER = "provider";
    public static final String SERVICE_NAME = "serviceName";
	public static final String CONTRIBUTOR = "contributor";
    public static final String PROTOCOL = "protocol";
	public static final String PERFORMATIVE = "performative";
	public static final String DATA = "data";
    
    //Actions
    public static final String NOTIFY = "notify";
    public static final String INVOKE = "invoke";

}
