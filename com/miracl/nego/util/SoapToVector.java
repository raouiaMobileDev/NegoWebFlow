package com.miracl.nego.util;

import jade.content.schema.ObjectSchema;

import java.io.StringReader;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.axis.Message;
import org.apache.log4j.Logger;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

import com.tilab.wsig.soap.SoapToJade;
import com.tilab.wsig.store.ActionBuilder;
import com.tilab.wsig.store.ParameterInfo;
import com.tilab.wsig.store.WSIGService;

public class SoapToVector extends DefaultHandler {
	
private static final int PARAMETERS_LEVEL = 3;
	
	private static Logger log = Logger.getLogger(SoapToJade.class.getName());
	private XMLReader xmlParser = null;
	private int level = 0;
	private StringBuffer elementValue = new StringBuffer();;
	private Vector<Vector<ParameterInfo>> parametersByLevel = new Vector<Vector<ParameterInfo>>();
	private Vector<ObjectSchema> schemaByLevel = new Vector<ObjectSchema>();
	private Map<String, ObjectSchema> parametersSchemaMap;
	
public SoapToVector() {
		
		// Get xml parser
	    try { 
	    	String parserName = getSaxParserName();
	    	
			xmlParser = (XMLReader)Class.forName(parserName).newInstance();
			xmlParser.setContentHandler(this);
			xmlParser.setErrorHandler(this);
		}
	    catch(Exception e) {
			log.error("Unable to create XML parser", e);
		}
	}

private static String getSaxParserName() throws Exception {
	
	String saxFactory = System.getProperty( "org.xml.sax.driver" );
	if( saxFactory != null ) {
		// SAXParser specified by means of the org.xml.sax.driver Java option
		return saxFactory;
	}
	else {
		// Use the JVM default SAX Parser
		SAXParserFactory newInstance = SAXParserFactory.newInstance();
		SAXParser newSAXParser = newInstance.newSAXParser();
		XMLReader reader = newSAXParser.getXMLReader();
		String name = reader.getClass().getName();
		return name;
	}
}


public  Vector<ParameterInfo> convert(Message soapRequest, WSIGService wsigService, String operationName) throws Exception {

	Object actionObj = null;
	String soapBodyMessage = soapRequest.getSOAPBody().toString();
	
	// Verify if parser is ready
	if (xmlParser == null) {
		log.error("XML parser not initialized");
		throw new Exception("XML parser not initialized");
	}

	// Get action builder
	ActionBuilder actionBuilder = wsigService.getActionBuilder(operationName);
	if (actionBuilder == null) {
		log.error("Operation "+operationName+" not present in service "+wsigService.getServiceName());
		throw new Exception("Operation "+operationName+" not present in service "+wsigService.getServiceName()); 
	}
	
	// Get parameters schema map
	parametersSchemaMap = actionBuilder.getParametersMap();
	
	// Parse soap to extract parameters value
	xmlParser.parse(new InputSource(new StringReader(soapBodyMessage)));

	// Get parameter values
	Vector<ParameterInfo> params = getParameterValues();
	for(int i=0;i<params.size();i++)
	{
		log.info("les params name : "+params.get(i).getName());
		log.info("les params getValue : "+params.get(i).getValue());
	}
 return params;
}

private Vector<ParameterInfo> getParameterValues() {
	
	log.debug("Begin parameters list");
	Vector<ParameterInfo> params = null;
	if (parametersByLevel.size() >= 1) {
		params = parametersByLevel.get(0);
		if (log.isDebugEnabled()) {
			for (ParameterInfo param : params) {
				log.debug("   "+param.getName()+"= "+param.getValue());
			}
		}
	} else {
		log.debug("   No parameters");
	}
	log.debug("End parameters list");
	
	return params;
}

}
