package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author dimitrigalli
 *
 */
public class ConfirmAdminLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConfirmAdminLoginPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFERMA LOGIN AMMINISTRATORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Controllare ATTENTAMENTE che tutti i dati riportati sotto siano corretti e coerenti con la presente sezione elettorale.</center></html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(120, 30, 700, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>In caso di problemi rieffettuare il login cliccando \"Indietro\". Se il problema persiste è OBBLIGATORIO contattare il responsabile dell'ufficio elettorale della sezione.</center></html>");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(120, 90, 700, 100);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>SEZIONE ELETTORALE N.<b>1</b> DEL COMUNE DI <b>PIEVEPELAGO (MO)</b><br>→ PRESIDENTE DELLA SEZIONE: <b>Luca Rossi</b><br>→ SEGRETARIO DELLA SEZIONE: <b>Luca Rossi</b><br>→ SCRUTATORE DELLA SEZIONE: <b>Luca Rossi</b><br>La sessione di voto verrà aperta alle ore <b>07:00</b> e verrà chiusa alle ore <b>23:00</b></center></html>");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(100, 160, 740, 200);
		add(lblNewLabel_3);
		
		JButton buttonConfirm = new JButton("<html><center>CONFERMA APERTURA<br>SESSIONE VOTO</center></html>");
		buttonConfirm.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		buttonConfirm.setBounds(480, 360, 260, 60);
		buttonConfirm.setBackground(Color.DARK_GRAY);
		buttonConfirm.setOpaque(true);
		add(buttonConfirm);
		
		JButton buttonBack = new JButton("Indietro");
		buttonBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buttonBack.setBounds(340, 360, 120, 30);
		add(buttonBack);
		
		buttonConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Sessione di voto avviata!");
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 3");
			}
			
		});
		
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 1");
			}
			
		});
	}

}
