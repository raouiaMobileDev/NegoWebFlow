package com.miracl.nego.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class EngineWorkflowGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EngineWorkflowGUI window = new EngineWorkflowGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EngineWorkflowGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 919, 582);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnAgents = new JMenu("Agents");
		menuBar.add(mnAgents);
		
		JMenuItem mntmSelectoragent = new JMenuItem("SelectorAgent");
		mntmSelectoragent.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326653842_administrator.png"));
		mntmSelectoragent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectorGUI frame = new SelectorGUI(null);
				frame.setVisible(true);
			
			}
		});
		mnAgents.add(mntmSelectoragent);
		
		JMenu mnResources = new JMenu("Resources");
		menuBar.add(mnResources);
		
		JMenuItem mntmHumaines = new JMenuItem("Humaines");
		mnResources.add(mntmHumaines);
		
		JMenuItem mntmBaseDeDones = new JMenuItem("Base de don\u00E9es");
		mnResources.add(mntmBaseDeDones);
		
		JMenu mnHelp = new JMenu("   Help  ");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JToolBar toolBar = new JToolBar();
		frame.getContentPane().add(toolBar, BorderLayout.NORTH);
		
		JButton btnSelecteur = new JButton("SelectorAgent");
		btnSelecteur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSelecteur.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326653842_administrator.png"));
		toolBar.add(btnSelecteur);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\fond-ecran-48390,informatique.jpg"));
		panel.add(lblNewLabel);
	}

}
