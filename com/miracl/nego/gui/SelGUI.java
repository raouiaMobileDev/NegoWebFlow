package com.miracl.nego.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.EtchedBorder;
import javax.swing.BoxLayout;


import com.miracl.nego.agent.SelectorAgent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class SelGUI extends JFrame {

	private SelectorAgent myAgent;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel_2;
	private JButton btnSend;
	private JButton btnCancel;
	private JPanel panel_1;
	private JLabel lblServiceName;
	private JTextField serviceName;
	private JLabel lblDescription;
	private JTextPane serviceDescription;

	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PingGUI frame = new PingGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
 */
	/**
	 * Create the frame.
	 */
	public SelGUI(SelectorAgent a)
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rawia\\Pictures\\icones\\Alarm-Tick-icon2.png"));
		myAgent=a;
		setTitle("Selector N\u00E9gociation ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 523, 312);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLUE);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Agent Requester Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblRequesterName = new JLabel("Requester Name");
		
		textField = new JTextField();
		textField.setColumns(15);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel.add(lblRequesterName);
		panel.add(textField);
		
		JLabel lblIda = new JLabel("    IDA");
		panel.add(lblIda);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(15);
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = serviceName.getText();
					String Description = serviceDescription.getText();
					myAgent.callService(name, Description);
					serviceName.setText("");
					serviceDescription.setText("");
					setVisible(false);
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(SelGUI.this, "Invalid values. "+ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		});
		btnSend.setForeground(new Color(34, 139, 34));
		btnSend.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Alarm-Tick-icon2.png"));
		panel_2.add(btnSend);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setForeground(new Color(255, 0, 0));
		btnCancel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Alarm-Error-icon.png"));
		panel_2.add(btnCancel);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Service Requester", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(102, 153, 204)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));
		
		lblServiceName = new JLabel("ENDPOINT");
		panel_1.add(lblServiceName, "4, 2, right, default");
		
		serviceName = new JTextField();
		serviceName.setText("http://");
		panel_1.add(serviceName, "6, 2, fill, default");
		serviceName.setColumns(10);
		
		lblDescription = new JLabel("Description");
		panel_1.add(lblDescription, "4, 4");
		
		serviceDescription = new JTextPane();
		panel_1.add(serviceDescription, "6, 4, fill, fill");
	}

}
