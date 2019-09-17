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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Admin;
import data.Elettore;
import db.ConnessioneDBAdmin;
import time.ApplicationTime;

/**
 * @author dimitrigalli, Danilo Finizio
 *
 */
public class AdminLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static String Residenza;
	public static String Username;
	public static String Password;

	public AdminLoginPanel(CardsPanel mainPanel, Admin admin, Elettore elettore) {
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

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (textField.getText().isEmpty() || passwordField.getText().isEmpty()) {
					textField.setText("");//riazzero il campo username
					passwordField.setText("");//riazzero il campo password
					JOptionPane.showMessageDialog(null, "Attenzione: username o password NON inseriti!", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				else {
					admin.setUsername(textField.getText());
					admin.setPassword(passwordField.getText());

					Date currentTime = new Date();
					String formatTimeStr = "kk:mm";
					DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
					String formattedTimeStr = formatTime.format(currentTime);

					try {
						System.out.println("Attenzione: connessione al DBAdmin in corso!");
						ConnessioneDBAdmin cda = new ConnessioneDBAdmin(admin);
						if(cda.isFound()==false) {
							JOptionPane.showMessageDialog(null, "Attenzione: le credenziali inserite non sono corrette!", "Errore", JOptionPane.ERROR_MESSAGE);
							System.out.println("Errore: credenziali amministratore errate!");
							textField.setText("");
							passwordField.setText("");
						}
						else if (JOptionPane.showOptionDialog(null, "<html><b><font size=\"5\">CONFERMA LOGIN AMMINISTRATORE</font></b><br><br><font size=\"4\"><center>Controllare ATTENTAMENTE che tutti i dati riportati sotto siano corretti e coerenti con la presente sezione elettorale.<br><br>In caso di problemi rieffettuare il login cliccando \"Annulla\".<br>Se il problema persiste è OBBLIGATORIO contattare il responsabile dell'ufficio elettorale della sezione.<br><br>SEZIONE ELETTORALE N.<b>"+admin.getNumeroSezioneElettorale()+"</b> DEL COMUNE DI <b>"+admin.getComuneSezioneElettorale()+"</b><br>→ PRESIDENTE DELLA SEZIONE: <font color=\"red\"><b>"+admin.getPresidente().getNome()+" "+admin.getPresidente().getCognome()+"</b></font><br>→ SEGRETARIO DELLA SEZIONE: <b>"+admin.getSegretario().getNome()+" "+admin.getSegretario().getCognome()+"</b><br>→ SCRUTATORE DELLA SEZIONE: <b>"+admin.getScrutatore().getNome()+" "+admin.getScrutatore().getCognome()+"</b><br><br>La sessione di voto verrà aperta alle ore <b>"+formattedTimeStr+"</b> e verrà chiusa alle ore <b>23:00</b>.</center></font<></html>", "ConfirmAdminLogin", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
							new ApplicationTime(mainPanel, admin, elettore);
							CardsPanel cp = new CardsPanel(admin, elettore);
							cp.switchPanel(mainPanel, "Card 2");
							AdminLoginPanel.Username=admin.getUsername();
							AdminLoginPanel.Password=admin.getPassword();
							AdminLoginPanel.Residenza=admin.getComuneSezioneElettorale();
							AdminLoginPanel.Residenza=AdminLoginPanel.Residenza.substring(0, AdminLoginPanel.Residenza.length()-4);
						}
						else {
							textField.setText("");//riazzero il campo username
							passwordField.setText("");//riazzero il campo password
							CardsPanel cp = new CardsPanel(admin, elettore);
							cp.switchPanel(mainPanel, "Card 1");
						}
					}
					catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}
	
}
