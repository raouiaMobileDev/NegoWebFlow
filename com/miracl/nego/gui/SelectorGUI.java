package com.miracl.nego.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;

//import com.miracl.nego.entity.Protocol;
import com.miracl.nego.agent.SelectorAgent;
import com.miracl.nego.entity.Provider;
import com.miracl.nego.model.ProviderModel;
import com.miracl.nego.provider.ws.Data;
import com.miracl.nego.util.AWSCLMessage;
import com.miracl.nego.util.ConnectionUtil;
import com.miracl.nego.util.StringUtil;

import javax.swing.border.TitledBorder;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.UIManager;
import java.awt.Dialog.ModalExclusionType;
//import java.awt.Window.Type;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.FlowLayout;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SelectorGUI extends JFrame {

	private SelectorAgent myAgent;
	private JPanel contentPane;
	public static JTextField ttProtocol;
	private JTable tProviders;
	//private  ProviderModel providerModel;
	private JTextField ttRequesterName;
	private JTextField ttPrice;
	private JTextField ttQuality;
	private JTextField ttPeriod;
	private JTextField ttTime;
	private JComboBox cbPerformative;
	//public static String nameProtocol=null;


	
	public SelectorGUI(SelectorAgent a) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rawia\\Pictures\\icones\\1326653842_administrator.png"));
		myAgent=a;
		setTitle("Agent selector");
		setType(Type.POPUP);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		ProviderModel providerModel = new ProviderModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel plReqInfo = new JPanel();
		plReqInfo.setBorder(new TitledBorder(null, "Requester information :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 255)));
		contentPane.add(plReqInfo, BorderLayout.NORTH);
		plReqInfo.setLayout(new BorderLayout(0, 0));
		
		JPanel plReqInfoWest = new JPanel();
		plReqInfo.add(plReqInfoWest, BorderLayout.WEST);
		
		JLabel label = new JLabel("Requester name :");
		plReqInfoWest.add(label);
		
		ttRequesterName = new JTextField();
		ttRequesterName.setColumns(20);
		plReqInfoWest.add(ttRequesterName);
		
		JPanel plSend = new JPanel();
		contentPane.add(plSend, BorderLayout.SOUTH);
		plSend.setLayout(new BorderLayout(0, 0));
		
		JPanel plSendCenter = new JPanel();
		plSendCenter.setBackground(UIManager.getColor("Button.highlight"));
		plSend.add(plSendCenter, BorderLayout.CENTER);
		
		JButton btSend = new JButton("Send");
		btSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doSend();
			}
		});
		btSend.setForeground(new Color(107, 142, 35));
		btSend.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326653075_Forward.png"));
		plSendCenter.add(btSend);
		
		JButton btCancel = new JButton("Cancel");
		btCancel.setForeground(new Color(178, 34, 34));
		btCancel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Close-2-icon.png"));
		plSendCenter.add(btCancel);
		
		JButton btHelp = new JButton("Help");
		btHelp.setForeground(new Color(0, 0, 255));
		btHelp.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\FAQ-icon.png"));
		plSendCenter.add(btHelp);
		
		JPanel plCentext = new JPanel();
		contentPane.add(plCentext, BorderLayout.CENTER);
		plCentext.setLayout(new BorderLayout(0, 0));
		
		JPanel plProtoNego = new JPanel();
		plProtoNego.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Prorocol of negociation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 255)));
		plCentext.add(plProtoNego, BorderLayout.NORTH);
		plProtoNego.setLayout(new BorderLayout(0, 0));
		
		JPanel plProtoNegoWest = new JPanel();
		plProtoNegoWest.setBorder(null);
		plProtoNego.add(plProtoNegoWest, BorderLayout.WEST);
		
		JLabel lblProtocolName = new JLabel("Protocol name :");
		plProtoNegoWest.add(lblProtocolName);
		
		ttProtocol = new JTextField();
		ttProtocol.setColumns(20);
		plProtoNegoWest.add(ttProtocol);
		
		JButton btnSerch = new JButton("Search");
		btnSerch.setForeground(new Color(0, 0, 0));
		btnSerch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProtocolGUI dialog = new ProtocolGUI();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
				//if(ProtocolGUI.nameProtocol !=null)
					//ttProtocol.setText(ProtocolGUI.nameProtocol);
			}
		});
		btnSerch.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652557_Zoom In.png"));
		plProtoNegoWest.add(btnSerch);
		
		JButton btClear = new JButton("Clear");
		btClear.setForeground(new Color(210, 105, 30));
		btClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doClear();
			}
		});
		btClear.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652709_edit-clear.png"));
		plProtoNegoWest.add(btClear);
		
		JLabel lblPerformative = new JLabel("   Performative : ");
		plProtoNegoWest.add(lblPerformative);
		
		cbPerformative = new JComboBox();
		cbPerformative.setModel(new DefaultComboBoxModel(new String[] {"REQUEST", "REFUSE", "PROPOSE", "NOT UNDERSTOOD", "INFORM", "FAILURE", "CONFIRM", "CFP", "CANCEL", "AGREE", "ACCEPT PROPOSAL"}));
		cbPerformative.setSelectedIndex(0);
		plProtoNegoWest.add(cbPerformative);
		
		JPanel plProvNego = new JPanel();
		plProvNego.setBorder(new TitledBorder(null, "Providers list :", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 255)));
		plCentext.add(plProvNego, BorderLayout.CENTER);
		plProvNego.setLayout(new BorderLayout(0, 0));
		
		JPanel plLabelTable = new JPanel();
		plProvNego.add(plLabelTable, BorderLayout.NORTH);
		plLabelTable.setLayout(new BorderLayout(0, 0));
		
		JLabel label_3 = new JLabel("   La liste des fornisseurs s\u00E9l\u00E9ctionn\u00E9s");
		plLabelTable.add(label_3, BorderLayout.NORTH);
		
		JPanel plTable = new JPanel();
		plProvNego.add(plTable, BorderLayout.WEST);
		
		tProviders = new JTable(providerModel);
		tProviders.setBorder(null);
		
		tProviders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tProviders.setPreferredScrollableViewportSize(new Dimension(690, 75));
        tProviders.setFillsViewportHeight(true);
        JScrollPane scrollPane = new JScrollPane(tProviders);
		
		plTable.add(scrollPane);
		plTable.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{scrollPane}));
		
		JPanel plAddDelect = new JPanel();
		plProvNego.add(plAddDelect, BorderLayout.CENTER);
		plAddDelect.setLayout(new BorderLayout(0, 0));
		
		JPanel plAddProv = new JPanel();
		plAddDelect.add(plAddProv, BorderLayout.CENTER);
		plAddProv.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btAdd = new JButton("Add   ");
		btAdd.setForeground(new Color(34, 139, 34));
		btAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProviderGUI dialog = new ProviderGUI(tProviders);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);
			}
		});
		btAdd.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652330_add2-.png"));
		plAddProv.add(btAdd);
		
		JButton btDelete = new JButton("Delete");
		btDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btDelete.setForeground(new Color(220, 20, 60));
		btDelete.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652580_minus.png"));
		plAddProv.add(btDelete);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new TitledBorder(null, "Context of negociation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 153, 255)));
		plProvNego.add(panel_12, BorderLayout.SOUTH);
		panel_12.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JRadioButton rdPrice = new JRadioButton("Price");
		panel_12.add(rdPrice, "2, 2");
		
		ttPrice = new JTextField();
		panel_12.add(ttPrice, "4, 2, fill, default");
		ttPrice.setColumns(10);
		
		JRadioButton rdQuality = new JRadioButton("Quality of service");
		rdQuality.setEnabled(false);
		panel_12.add(rdQuality, "2, 4");
		
		ttQuality = new JTextField();
		ttQuality.setEnabled(false);
		panel_12.add(ttQuality, "4, 4, fill, default");
		ttQuality.setColumns(10);
		
		JRadioButton rdPeriod = new JRadioButton("Period");
		rdPeriod.setEnabled(false);
		panel_12.add(rdPeriod, "2, 6");
		
		ttPeriod = new JTextField();
		ttPeriod.setEnabled(false);
		panel_12.add(ttPeriod, "4, 6, fill, default");
		ttPeriod.setColumns(10);
		
		JRadioButton rdTime = new JRadioButton("Response time");
		panel_12.add(rdTime, "2, 8");
		
		ttTime = new JTextField();
		panel_12.add(ttTime, "4, 8, fill, default");
		ttTime.setColumns(10);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, plReqInfo, plSend, plCentext, plProtoNego, plProtoNegoWest, lblProtocolName, ttProtocol, btnSerch, btClear, plProvNego, plLabelTable, label_3, plTable, scrollPane, tProviders}));
		ttRequesterName.setText(myAgent.getName());
		
		JLabel lblAgentStatut = new JLabel("  Agent Statut : ");
		plReqInfoWest.add(lblAgentStatut);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326735383_Circle_Green.png"));
		plReqInfoWest.add(lblNewLabel);
		
		
	}
	private void doClear()
	{
		ttProtocol.setText("");
	}
	private void doSend()
	{
		AWSCLMessage message= new AWSCLMessage(ttRequesterName.getText(),ttProtocol.getText());
		
		
		ProviderModel model=(ProviderModel)tProviders.getModel();
		int n=model.getRowCount();
		Vector providers= new Vector();
		for(int i=0;i<n; i++)
		{
			
			Provider provider=model.getProviderAt(i);
			providers.addElement(new com.miracl.nego.util.Provider(provider.getContributor(),provider.getEndpoint()));
		}
		message.setService_Name(model.getProviderAt(0).getServiceName());
		message.setPerformative((String)cbPerformative.getSelectedItem());
		message.setProviders(providers);
		Data[] data=null;
		if(!StringUtil.isBlank(ttPrice.getText()) && !StringUtil.isBlank(ttTime.getText()))
		{ 
			data = new Data[]{new Data("Price",ttPrice.getText()),new Data("Time response",ttTime.getText())};
			message.setData(data);
		}
		
		System.out.println(message.getService_Name());
		Vector ps= message.getProviders();
		for(int i=0;i<ps.size();i++)
		{
			com.miracl.nego.util.Provider p=(com.miracl.nego.util.Provider)ps.get(i);
			System.out.println(p.getEndpoint());
		}
		System.out.println("send GUI");
		ConnectionUtil.send(message);
		
	}

	
	
	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectorGUI frame = new SelectorGUI(myAgent);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

}
