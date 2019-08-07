package gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author dimitrigalli
 *
 */
public class ElettoreLoginPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private JTextField textField;

	public ElettoreLoginPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ELETTORE");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 600, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Inserire il <b>NUMERO della TESSERA ELETTORALE</b> (<i>9 cifre</i>) e cliccare \"AVANTI\".</center></html>");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(185, 70, 570, 100);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>Numero Tessera Elettorale</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.ITALIC, 18));
		lblNewLabel_2.setBounds(350, 200, 240, 50);
		add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		textField.setBounds(320, 250, 300, 30);
		add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("AVANTI");
		button.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		button.setBounds(410, 300, 120, 30);
		add(button);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>In caso di <b>problemi</b> contattare un responsabile della sezione elettorale.</center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.ITALIC, 16));
		lblNewLabel_3.setBounds(220, 350, 500, 100);
		add(lblNewLabel_3);
	}

}
