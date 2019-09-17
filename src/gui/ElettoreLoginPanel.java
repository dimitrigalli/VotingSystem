package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Admin;
import data.Elettore;

/**
 * @author dimitrigalli
 *
 */
public class ElettoreLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField textField;

	public ElettoreLoginPanel(CardsPanel mainPanel, Admin admin, Elettore elettore) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ELETTORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Inserire il <b>NUMERO della TESSERA ELETTORALE</b> <i>(9 cifre)</i> e cliccare \"AVANTI\".</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(185, 70, 570, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>Numero Tessera Elettorale</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(350, 200, 240, 50);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setBounds(320, 250, 300, 30);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>In caso di <b>problemi</b> contattare un responsabile della sezione elettorale.</center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(220, 350, 500, 100);
		add(lblNewLabel_3);
		
		JButton button = new JButton("AVANTI");
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.setBounds(410, 300, 120, 30);
		add(button);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				elettore.setNumeroTesseraElettorale(textField.getText());
				
				/// CONNESSIONE DB ELETTORE(ADMIN, ELETTORE)!!! SISTEMARE COMMENTI E SYSTEM.PRINT !!!
				/// RICORDATI DI SETTARE IL NUMERO E IL COMUNE DELLA SEZIONE ELETTORALE ALL'ADMIN PER CONTROLLO SEZIONE POI RIMUOVI COMMENTO (RIGA 85-86-87-88)!!!
				/// L'ELETTORE DEVE NON AVERE GIA VOTATO !!!
				
				if (elettore.getNumeroTesseraElettorale().isEmpty()) {
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Attenzione: numero tessera elettorale NON inserito!", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				else if (elettore.getNumeroTesseraElettorale().length() != 9) {
					textField.setText("");
					JOptionPane.showMessageDialog(null, "Attenzione: numero tessera elettorale NON inserito correttamente!", "Errore", JOptionPane.ERROR_MESSAGE);
				}
				//else if (elettore.getNumeroSezioneListaElettorale() != admin.getNumeroSezioneElettorale() || !(elettore.getResidenza().equals(admin.getComuneSezioneElettorale())) ) {
				//	textField.setText("");
				//	JOptionPane.showMessageDialog(null, "Attenzione: il numero e/o il comune della sezione della scheda elettorale inserita non coincidono/coincide con quelli/quello della presente sezione!", "Errore", JOptionPane.ERROR_MESSAGE);
				//}
				//else if (elettore.isHasVoted()) {
				//	textField.setText("");
				//	JOptionPane.showMessageDialog(null, "Attenzione: l'elettore inserito risulta abbia già votato. Non è possibile votare due o più volte!", "Errore", JOptionPane.ERROR_MESSAGE);
				//}
				else {
					textField.setText("");
					if (JOptionPane.showOptionDialog(null, "<html><b><font size=\"5\">CONFERMA LOGIN ELETTORE</font></b><br><br><font size=\"4\"><center><u>• CONFERMARE LA PROPRIA IDENTITÀ</u><br><br><b><p style='color: red'>"+elettore.getNome()+" "+elettore.getCognome()+"</p></b><br>nata/o il <b>"+elettore.getDataDiNascita()+"</b> presso <b>"+elettore.getLuogoDiNascita()+"</b> residente presso <b>"+elettore.getResidenza()+"</b><br><br><u>• LEGGERE ATTENTAMENTE LE ISTRUZIONI SU COME VOTARE</u><br><br>Per esprimere la preferenza <b>SOLO AL PARTITO</b>, è necessario cliccare direttamente su \"VOTA\" nel riquardo del partito<br>senza selezionare alcun candidato dalla lista.<br><br>Per esprimere la preferenza <b>AL PARTITO E AD UN SUO CANDIDATO</b>, è necessario prima selezionare il candidato<br>dalla lista e poi cliccare su \"VOTA\" nel riquardo del partito.<br><br><i>Il tuo voto rimarrà ANONIMO. Hai tempo per votare fino alle <b>23:00</b></i>.</center></font></html>", "ConfirmElettoreLogin", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, null, null) == JOptionPane.OK_OPTION) {
						CardsPanel cp = new CardsPanel(admin, elettore);
						cp.switchPanel(mainPanel, "Card 3");
					}
					else {
						CardsPanel cp = new CardsPanel(admin, elettore);
						cp.switchPanel(mainPanel, "Card 2");
					}
				}
			}
			
		});
	}

}
