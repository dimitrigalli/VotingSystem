package gui;

import java.awt.Color;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import data.Candidato;
import data.Elettore;
import data.Partito;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;

/**
 * @author dimitrigalli
 *
 */
public class PartitoPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private BufferedImage img;
	private String noPreferenza = new String("*nessuna preferenza*");

	public PartitoPanel(Partito partito, CardsPanel mainPanel, ArrayList<Partito> listaPartiti, int index, Elettore elettore) {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		setLayout(null);
		
		JLabel lblNomepartito = new JLabel(partito.getNome());
		lblNomepartito.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomepartito.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblNomepartito.setBounds(5, 5, 300, 20);
		add(lblNomepartito);
		
		try {
			img = ImageIO.read(new File("images"+File.separator+partito.getSimbolo()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error: image SIMBOLO not found\n");
			e.printStackTrace();
		}
		JLabel imgSimboloPartito = new JLabel(new ImageIcon(img));
		imgSimboloPartito.setBounds(28, 25, 80, 80);
		imgSimboloPartito.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		add(imgSimboloPartito);
		
		JLabel lblNewLabel = new JLabel("Preferenza candidato");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.ITALIC, 15));
		lblNewLabel.setBounds(135, 20, 160, 20);
		add(lblNewLabel);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(partito.getListaStringheCandidati(partito.getListaCandidati()).toArray(new String[0])));
		comboBox.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		comboBox.setBounds(135, 40, 175, 30);
		add(comboBox);
		
		JButton btnNewButton = new JButton("VOTA");
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setBounds(160, 80, 120, 30);
		add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String sceltaCandidato = comboBox.getSelectedItem().toString();
				if (sceltaCandidato.equals(noPreferenza)) {
					if (JOptionPane.showConfirmDialog(null, "<html>Confermi il voto al partito <b>"+partito.getNome()+"</b> senza preferenza candidato?</html>") == JOptionPane.YES_OPTION) {
						partito.addVoto();
						System.out.println(partito.getNome() +" *** "+ partito.getNumeroPreferenzePartito());
						listaPartiti.set(index, partito);
						elettore.setHasVoted(true);
						JOptionPane.showMessageDialog(null, "Il tuo voto anonimo è stato inserito! Grazie per aver votato.");
						CardsPanel cp = new CardsPanel();
						cp.switchPanel(mainPanel, "Card 3");
						
					}
				}
				else {
					if (JOptionPane.showConfirmDialog(null, "<html>Confermi il voto al partito <b>"+partito.getNome()+"</b> ed al suo candidato <b>"+sceltaCandidato+"</b>?</html>") == JOptionPane.YES_OPTION) {
						partito.addVoto();
						System.out.println(partito.getNome() +" *** "+ partito.getNumeroPreferenzePartito());
						int count = 0;
						for (Iterator<Candidato> i = partito.getListaCandidati().iterator(); i.hasNext();) {
							Candidato c = i.next();
							if (sceltaCandidato.equals(c.toString())) {
								c.addVotoCandidato();
								partito.getListaCandidati().set(count, c);
								System.out.println(c.toString() +" ... "+ partito.getListaCandidati().get(count).getNumeroPreferenzeCandidato());
							}
							count++;
						}
						comboBox.setSelectedItem(partito.getListaStringheCandidati(partito.getListaCandidati()).get(0));
						listaPartiti.set(index, partito);
						elettore.setHasVoted(true);
						JOptionPane.showMessageDialog(null, "Il tuo voto anonimo è stato inserito! Grazie per aver votato.");
						CardsPanel cp = new CardsPanel();
						cp.switchPanel(mainPanel, "Card 3");
					}
				}
			}
			
		});
	}
}
