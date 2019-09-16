package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Admin;
import time.ApplicationTime;

/**
 * @author dimitrigalli
 *
 */
public class ConfirmAdminLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConfirmAdminLoginPanel(CardsPanel mainPanel, Admin admin) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFERMA LOGIN AMMINISTRATORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Controllare ATTENTAMENTE che tutti i dati riportati sotto siano corretti e coerenti con la presente sezione elettorale.</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 30, 740, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>In caso di problemi rieffettuare il login cliccando \"Indietro\". Se il problema persiste è OBBLIGATORIO contattare il responsabile dell'ufficio elettorale della sezione.</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(100, 80, 740, 100);
		add(lblNewLabel_2);
		
		Date currentTime = new Date();
		String formatTimeStr = "kk:mm";
		DateFormat formatTime = new SimpleDateFormat(formatTimeStr);
		String formattedTimeStr = formatTime.format(currentTime);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>SEZIONE ELETTORALE N.<b>"+admin.getNumeroSezioneElettorale()+"</b> DEL COMUNE DI <b>"+admin.getComuneSezioneElettorale()+"</b><br>→ PRESIDENTE DELLA SEZIONE: <font color=\"red\"><b>"+admin.getPresidente().getNome()+" "+admin.getPresidente().getCognome()+"</b></font><br>→ SEGRETARIO DELLA SEZIONE: <b>"+admin.getSegretario().getNome()+" "+admin.getSegretario().getCognome()+"</b><br>→ SCRUTATORE DELLA SEZIONE: <b>"+admin.getScrutatore().getNome()+" "+admin.getScrutatore().getCognome()+"</b><br>La sessione di voto verrà aperta alle ore "+"<b>"+formattedTimeStr+"</b>"+" e verrà chiusa alle ore <b>23:00</b></center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(100, 160, 740, 200);
		add(lblNewLabel_3);
		
		JButton buttonConfirm = new JButton("<html><center>CONFERMA APERTURA<br>SESSIONE VOTO</center></html>");
		buttonConfirm.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		buttonConfirm.setBounds(480, 360, 260, 60);
		add(buttonConfirm);
		
		JButton buttonBack = new JButton("Indietro");
		buttonBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buttonBack.setBounds(340, 360, 120, 30);
		add(buttonBack);
		
		buttonConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Confermi l'apertura della sessione di voto?") == JOptionPane.YES_OPTION) {
				new ApplicationTime(mainPanel);
				JOptionPane.showMessageDialog(null, "Sessione di voto avviata!");
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 3");
				}
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
