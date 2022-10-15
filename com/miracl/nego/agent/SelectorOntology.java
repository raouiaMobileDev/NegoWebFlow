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

import jade.content.onto.BasicOntology;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.schema.AgentActionSchema;
import jade.content.schema.ObjectSchema;
import jade.content.schema.PrimitiveSchema;


public class SelectorOntology extends Ontology implements SelectorVocabulary{

	private final static Ontology theInstance = new SelectorOntology();

	public final static Ontology getInstance() {
		return theInstance;
	}

	/**
	 * Constructor
	 */
	public SelectorOntology() {
		super(ONTOLOGY_NAME, BasicOntology.getInstance());

		try {
			add(new AgentActionSchema(NOTIFY), Notify.class);
			add(new AgentActionSchema(INVOKE), Invoke.class);
			
			

			AgentActionSchema as = (AgentActionSchema) getSchema(NOTIFY);
			as.add(FIRST_ELEMENT, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(SECOND_ELEMENT, (PrimitiveSchema) getSchema(BasicOntology.STRING), ObjectSchema.OPTIONAL);
			as.setResult((PrimitiveSchema)getSchema(BasicOntology.STRING));
			
			as = (AgentActionSchema) getSchema(INVOKE);
			as.add(PROVIDER, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(SERVICE_NAME, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(CONTRIBUTOR, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(PROTOCOL, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(PERFORMATIVE, (PrimitiveSchema) getSchema(BasicOntology.STRING));
			as.add(DATA, (PrimitiveSchema) getSchema(BasicOntology.STRING), 2, ObjectSchema.UNLIMITED);
			as.setResult((PrimitiveSchema)getSchema(BasicOntology.STRING));
			
		} catch (OntologyException oe) {
			oe.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
