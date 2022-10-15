package com.miracl.nego.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import com.jgoodies.forms.factories.FormFactory;
import com.miracl.nego.entity.Protocol;
import com.miracl.nego.model.ProtocolModel;

import javax.swing.JRadioButton;
import java.awt.Toolkit;
import javax.swing.UIManager;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ProtocolGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tProtocols;
	
	private final String  BEHAVIOR_1 ="Cooperative";
	private final String  BEHAVIOR_2 ="Competitive";
	private final String  PARTNERS_1 ="One";
	private final String  PARTNERS_2 ="Several";
	private final String  ROUNDS_1 ="One";
	private final String  ROUNDS_2 ="Several";
	private final String  ATTRIBUTES_1 ="One";
	private final String ATTRIBUTES_2 ="Several";
	
	private JLabel lbBehavior;
	private JRadioButton rdCooperative;
	private JRadioButton rdCompetitive;
	private ButtonGroup bgBehavior;
	
	private JLabel lbPartners;
	private JRadioButton rd1Partner;
	private JRadioButton rd2Partners;
	private ButtonGroup bgPartners;
	
	private JLabel lbRounds;
	private JRadioButton rd1Round;
	private JRadioButton rd2Rounds;
	private ButtonGroup bgRounds;
	
	private JLabel lbAttributes;
	private JRadioButton rd1Attribute;
	private JRadioButton rd2Attributes;
	private ButtonGroup bgAttributes;
	
	private ProtocolModel protocolModel;
	public static String nameProtocol=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProtocolGUI dialog = new ProtocolGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProtocolGUI() {
		setTitle("Search Protocol");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rawia\\Pictures\\icones\\1326652557_Zoom In.png"));
		protocolModel = new ProtocolModel();
		setBounds(100, 100, 601, 440);
		setLocation(250, 70);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		///{
			JPanel plCaracteristics = new JPanel();
			plCaracteristics.setBorder(new TitledBorder(null, "Protocol's caracleristics", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(plCaracteristics, BorderLayout.NORTH);
			plCaracteristics.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			// Behavior
				lbBehavior = new JLabel("Negociation behavior :");
				plCaracteristics.add(lbBehavior, "4, 2");
			
				rdCooperative = new JRadioButton("Cooperative");
				rdCooperative.setActionCommand(BEHAVIOR_1);
				plCaracteristics.add(rdCooperative, "8, 2");
			
				rdCompetitive = new JRadioButton("Competitive");
				rdCompetitive.setActionCommand(BEHAVIOR_2);
				plCaracteristics.add(rdCompetitive, "12, 2");
			
				bgBehavior = new ButtonGroup();
				bgBehavior.add(rdCooperative);
				bgBehavior.add(rdCompetitive);
				
				
			// Partners
				lbPartners = new JLabel("Number of partners :");
				plCaracteristics.add(lbPartners, "4, 4");
			
				rd1Partner = new JRadioButton("1 Partner");
				rd1Partner.setActionCommand(PARTNERS_1);
				plCaracteristics.add(rd1Partner, "8, 4");
			
				rd2Partners = new JRadioButton("2 or Several partners");
				rd2Partners.setActionCommand(PARTNERS_2);
				plCaracteristics.add(rd2Partners, "12, 4");
				
				bgPartners = new ButtonGroup();
				bgPartners.add(rd1Partner);
				bgPartners.add(rd2Partners);
				
				
				// Rounds
				lbRounds = new JLabel("Number of rounds :");
				plCaracteristics.add(lbRounds, "4, 6");
			
				rd1Round = new JRadioButton("1 Round");
				rd1Round.setActionCommand(ROUNDS_1);
				plCaracteristics.add(rd1Round, "8, 6");
			
				rd2Rounds = new JRadioButton("2 or Several rounds");
				rd2Rounds.setActionCommand(ROUNDS_2);
				plCaracteristics.add(rd2Rounds, "12, 6");
				
				bgRounds = new ButtonGroup();
				bgRounds.add(rd1Round);
				bgRounds.add(rd2Rounds);
				
				
				// Attributes
				lbAttributes = new JLabel("Attributes of negociation :");
				plCaracteristics.add(lbAttributes, "4, 8");
			
				rd1Attribute = new JRadioButton("1 Attribute");
				rd1Attribute.setActionCommand(ATTRIBUTES_1);
				plCaracteristics.add(rd1Attribute, "8, 8");
			
				rd2Attributes = new JRadioButton("2 or Several attributes");
				rd2Attributes.setActionCommand(ATTRIBUTES_2);
				plCaracteristics.add(rd2Attributes, "12, 8");
				
				bgAttributes = new ButtonGroup();
				bgAttributes.add(rd1Attribute);
				bgAttributes.add(rd2Attributes);
			
		///}
		///{
			JPanel plSearch = new JPanel();
			plSearch.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Search mode :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(plSearch, BorderLayout.CENTER);
			plSearch.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,},
				new RowSpec[] {
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,
					FormFactory.RELATED_GAP_ROWSPEC,
					FormFactory.DEFAULT_ROWSPEC,}));
			///{
				JRadioButton rdExact = new JRadioButton("Exact : offer = request");
				plSearch.add(rdExact, "4, 2");
			///}
			///{
				JRadioButton rdPlugin = new JRadioButton("Plug-In : offer >= request");
				plSearch.add(rdPlugin, "6, 2");
			///}
			///{
				JRadioButton rdSubsumes = new JRadioButton("Subsumes : offer <= request");
				plSearch.add(rdSubsumes, "8, 2");
			///}
		///}
		///{
			JPanel SouthPanel = new JPanel();
			SouthPanel.setBorder(null);
			contentPanel.add(SouthPanel, BorderLayout.SOUTH);
			SouthPanel.setLayout(new BorderLayout(0, 0));
			///{
				JPanel plValidate = new JPanel();
				plValidate.setBorder(new LineBorder(Color.LIGHT_GRAY));
				SouthPanel.add(plValidate, BorderLayout.NORTH);
				///{
					JButton btValidate = new JButton("Validate");
					btValidate.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652831_thumb-up.png"));
					btValidate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							doValidate();
						}
					});
					plValidate.add(btValidate);
				///}
				///{
					JButton btClear = new JButton("Clear");
					btClear.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652709_edit-clear.png"));
					btClear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							doClear();
						}
					});
					plValidate.add(btClear);
				///}
				///{
					JButton btHelp = new JButton("Help");
					btHelp.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\FAQ-icon.png"));
					plValidate.add(btHelp);
				///}
			///}
			///{
				JPanel plTable = new JPanel();
				SouthPanel.add(plTable, BorderLayout.CENTER);
			///	{
					tProtocols = new JTable(protocolModel);
					tProtocols.setBorder(null);
					
					tProtocols.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					tProtocols.setPreferredScrollableViewportSize(new Dimension(490, 75));
			        tProtocols.setFillsViewportHeight(true);
			        JScrollPane scrollPane = new JScrollPane(tProtocols);
					
					plTable.add(scrollPane);
				///}
			///}
		///}
		///{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			///{
				JButton btOK = new JButton("OK");
				btOK.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Check-icon.png"));
				btOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Protocol p= doOK();
						 nameProtocol = p.getProtocolName();
						SelectorGUI.ttProtocol.setText(nameProtocol);
						setVisible(false);
					}
				});
				btOK.setActionCommand("OK");
				buttonPane.add(btOK);
				getRootPane().setDefaultButton(btOK);
			///}
			///{
				JButton btCancel = new JButton("Cancel");
				btCancel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Close-2-icon.png"));
				btCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btCancel.setActionCommand("Cancel");
				buttonPane.add(btCancel);
				///}
				///}
		//protocolModel.doList();
		
	}
	
	private  void doValidate()
	{
		String behavior=null;
		String partners=null;
		String rounds=null;
		String attributes=null;
	
		if(rdCooperative.isSelected())
			behavior=rdCooperative.getActionCommand();
		else if(rdCompetitive.isSelected())
			behavior=rdCompetitive.getActionCommand();
		if(rd1Partner.isSelected())
			partners=rd1Partner.getActionCommand();
		else if(rd2Partners.isSelected())
			partners=rd2Partners.getActionCommand();
		if(rd1Round.isSelected())
			rounds=rd1Round.getActionCommand();
		else if(rd2Rounds.isSelected())
			rounds=rd2Rounds.getActionCommand();
		if(rd1Attribute.isSelected())
			attributes=rd1Attribute.getActionCommand(); 
		else if(rd2Attributes.isSelected())
			attributes=rd2Attributes.getActionCommand(); 
		
		if(behavior!=null && partners!=null && rounds != null && attributes!= null)
		{
			protocolModel.doLisByALL(behavior, partners, rounds, attributes);
			System.out.println(behavior+" "+ partners+ " "+ rounds+" "+ attributes);
		}
		else if(behavior!=null && partners!=null && rounds != null)
			protocolModel.doListByBehaviorAndPartnersAndRounds(behavior, partners, rounds);
		else if (behavior!=null && partners!=null && rounds == null && attributes== null )
			protocolModel.doListByBehaviorAndPartners(behavior, partners);
		else if (behavior!=null && partners==null && rounds == null && attributes== null)
			protocolModel.doListByBehavior(behavior);

		System.out.println(behavior+" "+ " "+ partners+ " "+ rounds+" "+ attributes);
	}
	
	private void doClear()
	{
		bgBehavior.clearSelection();
		bgPartners.clearSelection();
		bgRounds.clearSelection();
		bgAttributes.clearSelection();
	}
	private Protocol doOK()
	{
		int selectedRow = tProtocols.getSelectedRow();
	    if (selectedRow >= 0) {
	        Protocol p = protocolModel.getProtocolAt(selectedRow);
	        return p;
	    }
	    else return null;
	}

}
