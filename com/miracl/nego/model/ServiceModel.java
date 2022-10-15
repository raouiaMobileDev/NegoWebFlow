package com.miracl.nego.model;

import java.util.List;

import javax.swing.DefaultComboBoxModel;

import com.miracl.nego.dao.ProviderDAO;
import com.miracl.nego.entity.Provider;

public class ServiceModel extends DefaultComboBoxModel{
	
	private ProviderDAO dao;
	private List<Provider> providers = null;
	
	/*
	 * 
	 */
	public ServiceModel()
	{
		super();
		dao=new ProviderDAO();
	}
	/*
	 * 
	 */
	public void doList()
	{
		try{
		providers= dao.findService();
		  addElement(providers);
		} catch(Exception e){e.printStackTrace();}
	}
	/*
	 * 
	 */
	 private void addElement(List<Provider> providers) {
		 Object[] ps=providers.toArray();

	        for(int j=0;j<ps.length;j++)
	        {
	             String h=(String)ps[j];
	             this.addElement(h);
					
	        }
	 }

}
