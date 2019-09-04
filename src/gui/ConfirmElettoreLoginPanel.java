package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author dimitrigalli
 *
 */
public class ConfirmElettoreLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	String message = new String("<html><font size=\"4\"><b>• Istruzioni IMPORTANTI su <i>come votare</i></b><br><br>Per esprimere la preferenza <b>SOLO AL PARTITO</b>, è necessario cliccare direttamente su VOTA<br>nel riquardo del partito senza selezionare alcun candidato dalla lista.<br><br>Per esprimere la preferenza <b>AL PARTITO E AD UN SUO CANDIDATO</b>, è necessario prima<br>selezionare il candidato dalla lista e poi cliccare su VOTA nel riquardo del partito.</font></html>");

	public ConfirmElettoreLoginPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONFERMA LOGIN ELETTORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>CONFERMARE LA PROPRIA IDENTITÀ</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel_1.setBounds(0, 60, 940, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center><b><p style='color: red'>DAVIDE SURACI</p></b><br>nata/o il <b>01/01/00</b> presso <b>PAVULLO NEL FRIGNANO (MO)</b><br><br>residente presso <b>PIEVEPELAGO (MO)</b><center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(0, 150, 940, 180);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center><i>Il tuo voto rimarrà ANONIMO. Hai tempo per votare fino alle <b>23:00</b>.</i></center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(0, 315, 940, 50);
		add(lblNewLabel_3);
		
		JButton buttonConfirm = new JButton("<html><center>CONFERMA IDENTITÀ<br>E VOTA</center></html>");
		buttonConfirm.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		buttonConfirm.setBounds(480, 380, 260, 60);
		add(buttonConfirm);
		
		JButton buttonBack = new JButton("Indietro");
		buttonBack.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		buttonBack.setBounds(340, 380, 120, 30);
		add(buttonBack);
		
		buttonConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (JOptionPane.showConfirmDialog(null, "Confermi l'identità?") == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, message);
					CardsPanel cp = new CardsPanel();
					cp.switchPanel(mainPanel, "Card 5");
					}
			}
			
		});
		
		buttonBack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CardsPanel cp = new CardsPanel();
				cp.switchPanel(mainPanel, "Card 3");
			}
			
		});
	}

}
