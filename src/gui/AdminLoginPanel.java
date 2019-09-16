package gui;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Admin;

/**
 * @author dimitrigalli
 *
 */
public class AdminLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JPasswordField passwordField;

	public AdminLoginPanel(CardsPanel mainPanel, Admin admin) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN AMMINISTRATORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 400, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>L'amministratore effettui il login attraverso i dati di username e password riportati sul plico telematico della sezione.</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(120, 40, 700, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>Si ricorda che cliccando su \"AVANTI\" la sessione di voto NON verrà ancora avviata.</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(120, 100, 700, 100);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>In caso di problemi è OBBLIGATORIO contattare il responsabile dell'ufficio elettorale della sezione.</center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(120, 160, 700, 100);
		add(lblNewLabel_3);
		
		JLabel username = new JLabel("<html><center>Username</center></html>");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		username.setBounds(425, 250, 90, 30);
		add(username);
		
		JLabel password = new JLabel("<html><center>Password</center></html>");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		password.setBounds(425, 320, 90, 30);
		add(password);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setBounds(320, 285, 300, 30);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		passwordField.setBounds(320, 355, 300, 30);
		add(passwordField);
		passwordField.setColumns(10);
		
		JButton button = new JButton("AVANTI");
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.setBounds(410, 410, 120, 30);
		add(button);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				admin.setUsername(textField.getText());
				admin.setPassword(password.getText());
				
				//Chiamata al costruttore ConnessioneDBAdmin passando come UNICO PARAMETRO admin!!! In ConnessioneDBAdmin cerco l'
				//amministratore e se lo trovo inizializzo con set gli attributi di admin; se non lo trovo devo generare messaggio
				//di errore indicando che l'admin non è presente nel DB!
				
				if (admin.getUsername().isEmpty() || admin.getPassword().isEmpty()) {
					textField.setText("");//riazzero il campo username
					passwordField.setText("");//riazzero il campo password
					JOptionPane.showMessageDialog(null, "Attenzione: username o password NON inseriti!", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				else {
				textField.setText("");//riazzero il campo username
				passwordField.setText("");//riazzero il campo password
				JOptionPane.showMessageDialog(null, "Accesso eseguito correttamente!");
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 2");
				}
			}
			
		});
	}
}
