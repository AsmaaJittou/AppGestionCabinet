package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Admin;
import models.AdminModels;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField emailF;
	private JTextField passwordF;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setFont(new Font("Jokerman", Font.BOLD, 11));
		lblNewLabel.setBounds(81, 102, 46, 14);
		lblNewLabel.setBackground(Color.PINK);
		contentPane.add(lblNewLabel);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Jokerman", Font.BOLD, 11));
		lblMotDePasse.setBounds(81, 143, 86, 14);
		contentPane.add(lblMotDePasse);
		emailF = new JTextField();
		emailF.setBounds(189, 99, 182, 20);
		contentPane.add(emailF);
		emailF.setColumns(10);
		
		passwordF = new JTextField();
		passwordF.setBounds(189, 140, 182, 20);
		passwordF.setColumns(10);
		contentPane.add(passwordF);
		
		JLabel titlLogin = new JLabel();
		titlLogin.setBounds(127, 11, 135, 53);
		titlLogin.setBackground(new java.awt.Color(0, 204, 204));
		titlLogin.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); 
		titlLogin.setForeground(Color.BLACK);
		titlLogin.setText("Login");
		contentPane.add(titlLogin);
		
		JButton btnNewButton = new JButton("Connecter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  String password = passwordF.getText();
			        String email = emailF.getText();
			        
			        
			    
			       AdminModels admin= new AdminModels();
			       
			         if ( email.isEmpty() || password.isEmpty() )
			           {
			               JOptionPane.showMessageDialog(null," vous devez remplir tout les champs ");
			           }else 
			            if ( password==admin.login(email))
			       {  
			           JOptionPane.showMessageDialog(null,"Bienvenue"); 
			       }else 
			       {
			          
			           JOptionPane.showMessageDialog(null,"Incorrect !!!");
			       
			       }
			           
			}
		});
		btnNewButton.setBounds(155, 198, 89, 23);
		contentPane.add(btnNewButton);
	}
}
