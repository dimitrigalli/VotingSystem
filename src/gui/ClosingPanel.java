package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author dimitrigalli
 *
 */
public class ClosingPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ClosingPanel(CardsPanel mainPanel) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RISULTATI E CHIUSURA DELLA SESSIONE DI VOTO");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 775, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Tutti i voti sono stati correttamente inviati al <b>MINISTERO DELL'INTERNO - DIPARTIMENTO PER GLI AFFARI INTERNI E TERRITORIALI</b>.</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 70, 740, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>• Per creare e visualizzare il documento illustrativo contenente i risultati parziali della sessione di voto del seggio registrato, l'<i><u>amministratore</u></i> clicchi il <b>link</b> sottostante e successivamente inserisca username e password.</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(100, 125, 740, 80);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>• Per chiudere definitivamente l'applicazione, l'<i><u>amministratore</u></i> clicchi il <b>link</b> sottostante e successivamente inserisca username e password.</center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(100, 230, 740, 80);
		add(lblNewLabel_3);
		
		JLabel link1 = new JLabel("<html><body><a href=\\\"\\\">crea e visualizza documento↗︎</a></body></html>");
		link1.setLocation(0, 205);
		link1.setSize(940, 40);
		link1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		link1.setHorizontalAlignment(SwingConstants.CENTER);
		link1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(link1);
		JLabel link2 = new JLabel("<html><body><a href=\\\"\\\">chiudi definitivamente applicazione↗︎</a></body></html>");
		link2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		link2.setLocation(0, 300);
		link2.setSize(940, 40);
		link2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		link2.setHorizontalAlignment(SwingConstants.CENTER);
		link1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(link2);
		
		JPanel panel = new JPanel(new BorderLayout(8, 8));
		panel.setPreferredSize(new Dimension(300, 70));
		
		JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
	    label.add(new JLabel("Username", SwingConstants.CENTER));
	    label.add(new JLabel("Password", SwingConstants.CENTER));
	    panel.add(label, BorderLayout.WEST);

	    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
	    JTextField username = new JTextField();
	    controls.add(username);
	    JPasswordField password = new JPasswordField();
	    controls.add(password);
	    panel.add(controls, BorderLayout.CENTER);
		
		link1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
			    if (JOptionPane.showConfirmDialog(null, panel, "Finestra - Crea e visualizza documento", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
			    	username.setText("");
			    	password.setText("");
			    	try {
						Desktop.getDesktop().open(new File("documento.txt"));
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			}
		});
		link2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, panel, "Finestra - chiudi definitivamente applicazione", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					username.setText("");
					password.setText("");
					System.exit(0);
				}
			}
		});		
	}

}
