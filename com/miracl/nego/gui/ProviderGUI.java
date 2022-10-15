package com.miracl.nego.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.miracl.nego.dao.ProviderDAO;
import com.miracl.nego.entity.Provider;
import com.miracl.nego.model.ContributorModel;
import com.miracl.nego.model.ProviderModel;
import com.miracl.nego.model.ServiceModel;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ImageIcon;

public class ProviderGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tProviders;
	private ProviderModel model;
	
	private JRadioButton rdSelectByService;
	private JComboBox cbSelectByService;

	private JRadioButton rdSelectByContributor;
	private JComboBox cbSelectByContributor;
	protected ProviderDAO providerDAO;
	private ButtonGroup bgContributor ;
	private ButtonGroup bgService;
	//private JTable table;
	/**
	 * Launch the application.
	
	public static void main(String[] args) {
		try {
			ProviderGUI dialog = new ProviderGUI(JTable table);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 */

	/**
	 * Create the dialog.
	 */
	public ProviderGUI( final JTable table) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Rawia\\Pictures\\icones\\1326653842_administrator.png"));
		setTitle("Select provider");
		model = new ProviderModel();
		providerDAO = new ProviderDAO();
		setBounds(100, 100, 587, 359);
		setLocation(250, 70);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
	//	{
			JPanel plSelectProvider = new JPanel();
			plSelectProvider.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Select provider :", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(plSelectProvider, BorderLayout.NORTH);
			plSelectProvider.setLayout(new FormLayout(new ColumnSpec[] {
					FormFactory.RELATED_GAP_COLSPEC,
					FormFactory.DEFAULT_COLSPEC,
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
					FormFactory.DEFAULT_ROWSPEC,}));
		
				rdSelectByService = new JRadioButton("Select by service name :");
				bgService = new ButtonGroup();
				bgService.add(rdSelectByService);
				rdSelectByService.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbSelectByService.setEnabled(true);
						ServiceModel model =new ServiceModel();
						cbSelectByService.setModel(model);
						model.doList();
					}
				});
				plSelectProvider.add(rdSelectByService, "6, 2");

				cbSelectByService = new JComboBox();
				cbSelectByService.setEnabled(false);
				plSelectProvider.add(cbSelectByService, "8, 2, fill, default");

				rdSelectByContributor = new JRadioButton("Select by contributor :");
				bgContributor = new ButtonGroup();
				bgContributor.add(rdSelectByContributor );
				rdSelectByContributor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cbSelectByContributor.setEnabled(true);
						ContributorModel model =new ContributorModel();
						cbSelectByContributor.setModel(model);
						model.doList();
					}});
				
				plSelectProvider.add(rdSelectByContributor, "6, 4");
				cbSelectByContributor = new JComboBox();
				cbSelectByContributor.setEnabled(false);
				plSelectProvider.add(cbSelectByContributor, "8, 4, fill, default");
			JPanel plTable = new JPanel();
			contentPanel.add(plTable, BorderLayout.CENTER);
			plTable.setLayout(new BorderLayout(0, 0));
				tProviders = new JTable(model);
				tProviders.setBorder(null);
				tProviders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				//tProvider.setPreferredScrollableViewportSize(new Dimension(490, 75));
				tProviders.setFillsViewportHeight(true);
		        JScrollPane scrollPane = new JScrollPane(tProviders);
				
				plTable.add(scrollPane);
				JPanel plValidate = new JPanel();
				plValidate.setBorder(new LineBorder(Color.LIGHT_GRAY));
				plTable.add(plValidate, BorderLayout.NORTH);

					JButton btValidate = new JButton("Validate");
					btValidate.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652831_thumb-up.png"));
					btValidate.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							fillTable();
							
						}
					});
					plValidate.add(btValidate);

					JButton btClear = new JButton("Clear");
					btClear.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\1326652709_edit-clear.png"));
					btClear.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							doClear();
						}
					});
					plValidate.add(btClear);

			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

				JButton btOK = new JButton("OK");
				btOK.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Check-icon.png"));
				btOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						table.setModel(model);
						setVisible(false);
					}
				});
				btOK.setActionCommand("OK");
				buttonPane.add(btOK);
				getRootPane().setDefaultButton(btOK);

				JButton btCancel = new JButton("Cancel");
				btCancel.setIcon(new ImageIcon("C:\\Users\\Rawia\\Pictures\\icones\\Close-2-icon.png"));
				btCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				btCancel.setActionCommand("Cancel");
				buttonPane.add(btCancel);
	}
	private void fillTable()
	{
		if(rdSelectByService.isSelected() && !rdSelectByContributor.isSelected())
		{
			
			String serviceName=(String)cbSelectByService.getSelectedItem();
			model.doListService(serviceName);
			
		}
		if(rdSelectByService.isSelected() && rdSelectByContributor.isSelected())
		{
			
			String serviceName=(String)cbSelectByService.getSelectedItem();
			String contributor=(String)cbSelectByContributor.getSelectedItem();
			model.doListServiceAndContributor(serviceName, contributor);
			
		}
		if(!rdSelectByService.isSelected() && rdSelectByContributor.isSelected())
		{
			String contributor=(String)cbSelectByContributor.getSelectedItem();
			model.doListContributor(contributor);
		}
			
	}
	
	
	private void doClear()
	{
		bgService.clearSelection();
		bgContributor.clearSelection();
		rdSelectByContributor.removeAll();
		rdSelectByService.removeAll();
		cbSelectByContributor.setEnabled(false);
		cbSelectByService.setEnabled(false);
		
	}

}
