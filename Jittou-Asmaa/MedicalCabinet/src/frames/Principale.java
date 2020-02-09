package frames;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import classes.Client;
import classes.Medecin;
import models.ClientModel;
import models.MedecinModels;

import java.awt.SystemColor;
import javax.swing.UIManager;

public class Principale extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;
	private JTextField textFieldId;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTable table_3;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principale frame = new Principale();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principale() {
		setBackground(UIManager.getColor("controlHighlight"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 694, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
       MedecinModels medecinmd = new MedecinModels();
		ClientModel clientmd = new ClientModel() ;
		ArrayList<Medecin> listeMedecins = medecinmd.listeDesMedecins();
		ArrayList<Client> listeClients = clientmd.listeDesclients();
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(49, 33, 586, 283);
		contentPane.add(tabbedPane);
		JPanel gclient = new JPanel();
		tabbedPane.addTab("Gestion des Clients", null, gclient, null);
		gclient.setLayout(null);
		JTable table_2 = new JTable();
		table_2.setFont(new Font("Sakkal Majalla", Font.BOLD, 15));
		table_2.setBounds(290, 26, 291, 158);
		gclient.add(table_2);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(290, 11, 59, 14);
		gclient.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Version");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(350, 11, 46, 14);
		gclient.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Titre");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(406, 11, 46, 14);
		gclient.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nom");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(465, 11, 46, 14);
		gclient.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Prenom");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(521, 11, 46, 14);
		gclient.add(lblNewLabel_4);
		textFieldId = new JTextField();
		textFieldId.setBounds(99, 22, 86, 20);
		gclient.add(textFieldId);
		textFieldId.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(99, 62, 86, 20);
		gclient.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(99, 101, 86, 20);
		gclient.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(99, 136, 86, 20);
		gclient.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(99, 168, 86, 20);
		gclient.add(textField_4);
		
		
		DefaultTableModel model2 = null;
		
		JButton btnNewButton = new JButton("Afficher");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

String col[] = {"Id", "Version", "Titre", "Nom", "Prenom"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		for(Client client : listeClients) {
			int id = client.getId();
			int version = client.getVersion();
			String titre = client.getTitre();
			String nom = client.getNom();
			String prenom = client.getPrenom();
			Object[] data = {id , version, titre, nom , prenom};
		   tableModel.addRow(data);
		   
		}
		
				table_2.setModel(tableModel);
			}
		});
		
		
		btnNewButton.setBounds(10, 206, 106, 23);
		
		gclient.add(btnNewButton);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(134, 206, 106, 23);
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//int version = Integer.parseInt(textField_1.getText());
				String titre = textField_2.getText();
				String nom = textField_3.getText();
				String prenom = textField_4.getText();
				Client client = new Client(2, titre,nom,prenom);
				try {
					clientmd.addClient(client);
					JOptionPane.showMessageDialog(null,"votre client est bien ajouté !!!");
				
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null,"Ereur ");
				}	
				
				
			}
		});
		gclient.add(btnAjouter);
		
		JButton btnModifier = new JButton("Actualiser");
		btnModifier.setBounds(272, 206, 106, 23);
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		gclient.add(btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(422, 206, 106, 23);
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id =  Integer.parseInt(textFieldId.getText());
				clientmd.supprimerClient(id);
				JOptionPane.showMessageDialog(null,"votre client est supprimé !!!");
			}
		});
		
		gclient.add(btnSupprimer);
		
		JLabel lblNewLabel_5 = new JLabel("Id");
		lblNewLabel_5.setFont(new Font("Chiller", Font.BOLD, 16));
		lblNewLabel_5.setBounds(10, 25, 46, 14);
		gclient.add(lblNewLabel_5);
		
		
		
		JLabel lblVersion = new JLabel("Version");
		lblVersion.setFont(new Font("Chiller", Font.BOLD, 16));
		lblVersion.setBounds(10, 64, 46, 14);
		gclient.add(lblVersion);
		
		JLabel lblTitre = new JLabel("Titre");
		lblTitre.setFont(new Font("Chiller", Font.BOLD, 16));
		lblTitre.setBounds(10, 103, 46, 14);
		gclient.add(lblTitre);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Chiller", Font.BOLD, 16));
		lblNom.setBounds(10, 138, 46, 14);
		gclient.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom");
		lblPrenom.setFont(new Font("Chiller", Font.BOLD, 16));
		lblPrenom.setBounds(10, 170, 46, 14);
		gclient.add(lblPrenom);
		
		JButton btnNewButton_1 = new JButton("D\u00E9connecter");
		btnNewButton_1.setBounds(465, 232, 116, 23);
		gclient.add(btnNewButton_1);
		
	
		/*JComboBox comrech = new JComboBox();
		  comrech.setBackground(new java.awt.Color(51, 255, 255));
		  comrech.setBounds(11, 11, 504, 179);
	        comrech.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Version", "Titre", "Nom", "Prenom" }));
	      
	        
		
		gclient.add(comrech);*/
	        
		
		JPanel gmedecin = new JPanel();
		tabbedPane.addTab("Gestion des Medecins", null, gmedecin, null);
		gmedecin.setLayout(null);
		
		JLabel label = new JLabel("Id");
		label.setBounds(290, 21, 59, 14);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		gmedecin.add(label);
		
		JLabel label_1 = new JLabel("Version");
		label_1.setBounds(350, 21, 46, 14);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		gmedecin.add(label_1);
		
		JLabel label_2 = new JLabel("Titre");
		label_2.setBounds(406, 21, 46, 14);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		gmedecin.add(label_2);
		
		JLabel label_3 = new JLabel("Nom");
		label_3.setBounds(465, 21, 46, 14);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		gmedecin.add(label_3);
		
		JLabel label_4 = new JLabel("Prenom");
		label_4.setBounds(521, 21, 46, 14);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		gmedecin.add(label_4);
		
		JLabel label_5 = new JLabel("Id");
		label_5.setBounds(10, 34, 46, 14);
		label_5.setFont(new Font("Chiller", Font.BOLD, 16));
		gmedecin.add(label_5);
		
		JLabel label_6 = new JLabel("Version");
		label_6.setBounds(10, 73, 46, 14);
		label_6.setFont(new Font("Chiller", Font.BOLD, 16));
		gmedecin.add(label_6);
		
		JLabel label_7 = new JLabel("Titre");
		label_7.setBounds(10, 112, 46, 14);
		label_7.setFont(new Font("Chiller", Font.BOLD, 16));
		gmedecin.add(label_7);
		
		JLabel label_8 = new JLabel("Nom");
		label_8.setBounds(10, 147, 46, 14);
		label_8.setFont(new Font("Chiller", Font.BOLD, 16));
		gmedecin.add(label_8);
		
		JLabel label_9 = new JLabel("Prenom");
		label_9.setBounds(10, 179, 46, 14);
		label_9.setFont(new Font("Chiller", Font.BOLD, 16));
		gmedecin.add(label_9);
		
		textField_5 = new JTextField();
		textField_5.setBounds(103, 34, 86, 20);
		textField_5.setColumns(10);
		gmedecin.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setBounds(103, 74, 86, 20);
		textField_6.setColumns(10);
		gmedecin.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setBounds(103, 113, 86, 20);
		textField_7.setColumns(10);
		gmedecin.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(103, 148, 86, 20);
		textField_8.setColumns(10);
		gmedecin.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(103, 180, 86, 20);
		textField_9.setColumns(10);
		gmedecin.add(textField_9);
		
		JButton button = new JButton("Afficher");
		button.setBounds(10, 221, 102, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String col2[] = {"Id", "Version", "Titre", "Nom", "Prenom"};
				DefaultTableModel tableModel1 = new DefaultTableModel(col2, 0);
				for(Medecin client : listeMedecins) {
					int id = client.getId();
					int version = client.getVersion();
					String titre = client.getTitre();
					String nom = client.getNom();
					String prenom = client.getPrenom();
					Object[] data = {id , version, titre, nom , prenom};
				   tableModel1.addRow(data);
				   
				}
				
						table_3.setModel(tableModel1);
					}
			
			
		});
		gmedecin.add(button);
		
		JButton button_1 = new JButton("Ajouter");
		button_1.setBounds(134, 221, 102, 23);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//int version = Integer.parseInt(textField_1.getText());
				String titre = textField_7.getText();
				String nom = textField_8.getText();
				String prenom = textField_9.getText();
				Medecin medecin = new Medecin(2, titre,nom,prenom);
				try {
					medecinmd.addMedecin(medecin);
					JOptionPane.showMessageDialog(null,"votre Medecin  est bien ajouté !!!");
				
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"Ereur ");
				}	
			}
		});
		gmedecin.add(button_1);
		
		JButton button_2 = new JButton("Actualiser");
		button_2.setBounds(272, 221, 102, 23);
		gmedecin.add(button_2);
		
		JButton button_3 = new JButton("Supprimer");
		button_3.setBounds(422, 221, 102, 23);
		gmedecin.add(button_3);
		
		table_3 = new JTable();
		table_3.setBounds(290, 35, 291, 158);
		table_3.setFont(new Font("Sakkal Majalla", Font.BOLD, 15));
		gmedecin.add(table_3);
		
		JPanel grv = new JPanel();
		tabbedPane.addTab("Gestion des rendez-vous", null, grv, null);
		grv.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(98, 59, 109, 23);
		grv.add(rdbtnNewRadioButton);
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
