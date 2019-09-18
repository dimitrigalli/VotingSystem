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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import data.Admin;
import data.Candidato;
import data.Elettore;
import data.Partito;

/**
 * @author dimitrigalli
 *
 */
public class ClosingPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private int numeroTotaleVotanti = 0;
	
	public ClosingPanel(CardsPanel mainPanel, VotingPanel vp, Admin admin, Elettore elettore) {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("RISULTATI E CHIUSURA DELLA SESSIONE DI VOTO");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setBounds(15, 15, 775, 30);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("<html><center>Tutti i voti sono stati correttamente inviati al <b>MINISTERO DELL'INTERNO - DIPARTIMENTO PER GLI AFFARI INTERNI E TERRITORIALI</b>.</center></html>");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(100, 100, 740, 50);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("<html><center>• Per creare e visualizzare il documento illustrativo contenente i risultati parziali della sessione di voto del seggio registrato, l'<i><u>amministratore</u></i> clicchi il <b>link</b> sottostante e successivamente inserisca username e password.</center></html>");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(100, 155, 740, 80);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("<html><center>• Per chiudere definitivamente l'applicazione, l'<i><u>amministratore</u></i> clicchi il <b>link</b> sottostante e successivamente inserisca username e password.</center></html>");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(100, 260, 740, 80);
		add(lblNewLabel_3);
		
		JLabel link1 = new JLabel("<html><body><a href=\\\"\\\">crea e visualizza documento↗︎</a></body></html>");
		link1.setLocation(0, 235);
		link1.setSize(940, 40);
		link1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		link1.setHorizontalAlignment(SwingConstants.CENTER);
		link1.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		add(link1);
		JLabel link2 = new JLabel("<html><body><a href=\\\"\\\">chiudi definitivamente applicazione↗︎</a></body></html>");
		link2.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		link2.setLocation(0, 330);
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
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, panel, "Finestra - Crea e visualizza documento", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					if (username.getText().equals(AdminLoginPanel.Username)==true && password.getText().equals(AdminLoginPanel.Password) == true) {
						username.setText("");
						password.setText("");
						PrintWriter out;
						try {
							out = new PrintWriter("risultati.txt");
							out.println("********** .......... RISULTATI SESSIONE DI VOTO .......... **********");
							out.println("");
							for (Iterator<Partito> i = vp.getListaPartiti().iterator(); i.hasNext();) {
								Partito p = i.next();
								out.println(p.getNome() + "\t" + "*****" + "\t" + p.getNumeroPreferenzePartito());
								numeroTotaleVotanti = numeroTotaleVotanti + p.getNumeroPreferenzePartito();
								for (Iterator<Candidato> j = p.getListaCandidati().iterator(); j.hasNext();) {
									Candidato c = j.next();
									out.println(c.toString() + "\t" + "....." + "\t" + c.getNumeroPreferenzeCandidato());
								}
								out.println("");
							}
							numeroTotaleVotanti = numeroTotaleVotanti + vp.getSchedeBianche().getNumeroSchedeBianche();
							out.println("NUMERO SCHEDE BIANCHE\t" + vp.getSchedeBianche().getNumeroSchedeBianche() + " --- " + "NUMERO TOTALE VOTANTI (COMPRESE SCHEDE BIANCHE)\t" + numeroTotaleVotanti);
							out.close();
							Desktop.getDesktop().open(new File("risultati.txt"));
						} catch (FileNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					else {
						username.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "Attenzione: username e/o password inseriti NON CORRETTI!", "Errore", JOptionPane.ERROR_MESSAGE);
					}
			    }
			}
		});
		link2.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				if (JOptionPane.showConfirmDialog(null, panel, "Finestra - chiudi definitivamente applicazione", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
					if (username.getText().equals(AdminLoginPanel.Username)==true && password.getText().equals(AdminLoginPanel.Password) == true) {
						username.setText("");
						password.setText("");
						System.out.println("Sessione di voto conclusa. L'applicazione è terminata.");
						System.exit(0);
					}
					else {
						username.setText("");
						password.setText("");
						JOptionPane.showMessageDialog(null, "Attenzione: username e/o password inseriti NON CORRETTI!", "Errore", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});		
	}

}
