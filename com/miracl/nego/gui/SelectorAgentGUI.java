package com.miracl.nego.gui;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.miracl.nego.model.ProviderModel;

public class SelectorAgentGUI extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTable table;
	

	/**
	 * Create the panel.
	 */
	public SelectorAgentGUI() {
		
		ProviderModel providerModel = new ProviderModel();
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Demandeur d'information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		add(panel, BorderLayout.NORTH);
		
		JLabel lblNomDemandeur = new JLabel("Nom demandeur :");
		panel.add(lblNomDemandeur);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(20);
		
		JLabel lblIdentifientAgent = new JLabel("  Identifient Agent :");
		panel.add(lblIdentifientAgent);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(20);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Protocole de n\u00E9gociation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.WEST);
		
		JLabel lblNomProtocole = new JLabel("Nom protocole : ");
		panel_4.add(lblNomProtocole);
		
		textField_2 = new JTextField();
		panel_4.add(textField_2);
		textField_2.setColumns(20);
		
		JButton btnRechercher = new JButton("Rechercher");
		panel_4.add(btnRechercher);
		
		JButton btnAnnuler = new JButton("Annuler");
		panel_4.add(btnAnnuler);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Selection des fournisseurs", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_2.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6, BorderLayout.WEST);
		
		table = new JTable();
		table.setToolTipText("");
		table.setModel(providerModel);
		panel_6.add(table);
		
		JPanel panel_7 = new JPanel();
		panel_5.add(panel_7, BorderLayout.NORTH);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLaListeDes = new JLabel("   La liste des fornisseurs s\u00E9l\u00E9ctionn\u00E9s");
		panel_7.add(lblLaListeDes, BorderLayout.NORTH);
		providerModel.doList();

	}
	
	   public static void main(String args[])
	    {
	        JFrame frame=new JFrame();
	        SelectorAgentGUI selectorGUI =new SelectorAgentGUI();
	        frame.getContentPane().add(selectorGUI);
	        frame.setVisible(true);
	    }

}
