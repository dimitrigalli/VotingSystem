package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AdminLoginPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField textField_1;
	private JButton btnAvanti;
	public AdminLoginPanel() {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setSize(400, 450);
		setLocation(510, 30);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN AMMINISTRATORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 20, 230, 20);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html>L'amministratore effettui il login attraverso i dati di username e password riportati sul plico telematico della sezione.</html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 50, 320, 60);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html>Si ricorda che cliccando su \"Avanti\" la sessione di voto NON verrà ancora avviata.</html>");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 115, 320, 50);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html>In caso di problemi è OBBLIGATORIO contattare il responsabile dell'ufficio elettorale della sezione.");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(40, 175, 320, 50);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Username");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(40, 240, 320, 20);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Password");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(40, 300, 320, 20);
		add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(110, 260, 180, 30);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JPasswordField();
		textField_1.setBounds(110, 320, 180, 30);
		add(textField_1);
		textField_1.setColumns(10);
		
		btnAvanti = new JButton("Avanti");
		btnAvanti.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnAvanti.setBounds(140, 400, 120, 30);
		add(btnAvanti);
		
		btnAvanti.addActionListener(this);
	}

/*
 *@author Danilo Finizio 
 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		System.out.println("ci siamo");
		String name;
		String passwd;

		if(e.getSource()==btnAvanti ) {
//			System.out.println("ci siamo");
			name=textField.getText();
			passwd=textField_1.getText();
			if(name.isEmpty() || passwd.isEmpty()) {
				System.out.println("Errore. Nome utente o password mancanti");
				textField.setText("");//riazzero il campo username
				textField_1.setText("");//riazzero il campo password
				JOptionPane.showMessageDialog(null, "Errore. Nome utente o password mancanti");
			}			
			else {

				System.out.println(name +", " + passwd);//only for debugging

				//mi collego al database e verifico che le credenziali siano esatte
				try {
					if(Connessione_database.getConnection(name, passwd)==true) {
						JOptionPane.showMessageDialog(null,  "Accesso eseguito!");
						System.exit(0);//chiudo la finestra di login
					}
					JOptionPane.showMessageDialog(null,  "Credenziali errate!");
					textField.setText("");//riazzero il campo username
					textField_1.setText("");//riazzero il campo password
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
